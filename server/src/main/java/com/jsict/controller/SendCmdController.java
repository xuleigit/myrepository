package com.jsict.controller;

import com.alibaba.fastjson.JSON;
import com.jsict.common.utils.*;
import com.jsict.entity.smoke.AlarmData;
import com.jsict.entity.smoke.Devices;
import com.jsict.entity.smoke.DevicesInfo;
import com.jsict.entity.smoke.LockRecord;
import com.jsict.service.*;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: XL
 * @Date: Created in 2018/6/29
 * @Description: 下发指令
 */
@RefreshScope
@RestController
/*@RequestMapping("/NBIotLock")*/
@RequestMapping("/cmd")
@Slf4j
public class SendCmdController {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${baseCallBackUrl}")
    private String baseCallBackUrl;

    @Value("${appId}")
    private String appId;

    @Value("${secret}")
    private String secret;

    @Autowired
    DevicesService ds;

    @Autowired
    AlarmDataService ads;

    @Autowired
    DevicesInfoService dis;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private ApplicationContext context;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    LockRecordService lrs;


    @PostMapping("/openOrClose")
    public String openOrClose() {
        log.info("配置文件内容:baseUrl["+baseUrl+"] baseCallBackUrl["+baseCallBackUrl+"]");
        String message = "";
        String userId = request.getParameter("userId");
        String aid = request.getParameter("aid");
        Integer act = Integer.parseInt(request.getParameter("act"));//0关 1开 2开并延时自动关
        Integer autoCloseDelay = null;
        if (act == 2) {
            autoCloseDelay = Integer.parseInt(request.getParameter("autoCloseDelay"));
        }
        Devices device = ds.findByAid(aid);
        DevicesInfo devicesInfo = dis.findDevicesInfoByAid(aid);
        if (device != null) {
            try {
                log.info("下发指令给[设备型号:"+device.getTypeName()+"][设备号:"+device.getAid()+"]");
                String serviceId ="RomteCtl";
                String method ="LockCtl";

                Map<String, Object> paraMap = new HashMap<String, Object>();
                paraMap.put("LEN", 3);
                paraMap.put("STX", 2);
                if (act == 2) {
                    paraMap.put("AUTO_CLOSE_DELAY", autoCloseDelay);
                }
                paraMap.put("CMD", 3);
                paraMap.put("LRC", 1);
                paraMap.put("SEQ", 1);
                paraMap.put("OPEN", act);
                String paraStr = JsonUtil.toJson(paraMap);

                DXPlatformUtils platformUtils = new DXPlatformUtils(baseUrl, appId, secret, baseCallBackUrl);
                String accessToken = platformUtils.getToken(cacheManager);
                log.info("accessToken:"+accessToken);
                if (accessToken != null) {
                    //下发指令,pString为paras
                    String status = platformUtils.postCmd(accessToken, serviceId, method, paraStr, devicesInfo.getIotDeviceId());
                    if (status != null) {
                        log.info("下发指令返回status:"+status);
                        message = "下发指令创建成功";
                        //命令生成开关锁记录
                        LockRecord lockRecord = new LockRecord();
                        lockRecord.setDeviceId(device.getAid());
                        lockRecord.setLocation(device.getAddress());
                        lockRecord.setOpenCloseType(0);
                        lockRecord.setUserId(userId);
                        lockRecord.setCommandState(convertStatus(status));
                        lrs.saveOrUpdate(lockRecord);
                    }
                }else {
                    message = "下发指令失败[accessToken为null]";
                }
            } catch (Exception e) {
                log.error("下发指令异常[openOrClose exception]",e);
            }
        } else {
            message = "该设备号对应设备不存在!";
        }
        return message;
    }


    //IoT返回状态对应
    public static String convertStatus(String status){
        if ("PENDING".equals(status)) {
            status = "等待";
        } else if ("FAILED".equals(status)) {
            status = "失败";
        } else if ("SENT".equals(status)) {
            status = "已发送";
        } else if ("DELIVERED".equals(status)) {
            status = "已送达";
        }
        return status;
    }

}
