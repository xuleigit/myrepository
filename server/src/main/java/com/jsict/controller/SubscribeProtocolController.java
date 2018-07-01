package com.jsict.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jsict.common.ConstantCode;
import com.jsict.common.utils.DateUtil;
import com.jsict.common.utils.IPUtil;
import com.jsict.common.utils.StringUtil;
import com.jsict.entity.smoke.*;
import com.jsict.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: XL
 * @Date: Created in 2018/6/28
 * @Description: 订阅消息
 */
@RefreshScope
@RestController
/*@RequestMapping("/NBIotLock")*/
@RequestMapping("/dianxin/subscribe")
@Slf4j
public class SubscribeProtocolController {

    @Value("${pushMesUrl}")
    private String pushMesUrl;

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
    LockRecordService lrs;



    @PostMapping("/deviceInfoChanged")
    public void deviceInfoChanged() {
        String remoteIp = IPUtil.getRemoteIp(request);
        String readData = StringUtil.readData(request);
        log.info("设备信息变化回调成功----------------------"+new Date());
        log.info("电信订阅收到地址"+remoteIp+"[deviceInfoChanged]数据>>>>>"+readData);

        Map<String,Object> deviceInfoChanged_map = JSON.parseObject(readData,Map.class);
        String iot_device_id=(String)deviceInfoChanged_map.get("deviceId");
        Devices device = ds.findDevicesByIotDeviceId(iot_device_id);
        if(device != null){
            Map deviceInfo_map = JSON.parseObject(JSON.toJSONString(deviceInfoChanged_map.get("deviceInfo")), Map.class);
            if (deviceInfo_map != null) {
                String status = (String) deviceInfo_map.get("status");
                //1在线，2离线，3通信中,4不正常
                if ("ONLINE".equals(status)) {
                    device.setStatus(1);
                } else if ("OFFLINE".equals(status)) {
                    device.setStatus(2);
                } else if ("INBOX".equals(status)) {
                    device.setStatus(3);
                } else if ("ABNORMAL".equals(status)) {
                    device.setStatus(4);
                } else {
                    device.setStatus(2);//status = null
                }
                device.setLastReportTime(new Date());
                ds.saveOrUpdate(device);
                log.info("设备号["+device.getAid()+"]当前状态["+device.getStatus()+"]");
            }
        }else{
            log.info("设备没查到 iotDeviceId："+iot_device_id);
        }
    }

    @PostMapping("/deviceBind")
    public void deviceBind() {
        String remoteIp = IPUtil.getRemoteIp(request);
        String readData = StringUtil.readData(request);
        log.info("设备绑定回调成功----------------------"+new Date());
        log.info("电信订阅收到地址"+remoteIp+"[deviceBind]数据>>>>>"+readData);

        Map<String,Object> deviceBind_map = JSON.parseObject(readData,Map.class);
        Map<String,Object> deviceBind_deviceInfo_map = JSON.parseObject(JSON.toJSONString(deviceBind_map.get("deviceInfo")),Map.class);
        String aid=(String)deviceBind_deviceInfo_map.get("nodeId");
        Devices device = ds.findByAid(aid);
        if (device!=null) {
            device.setStatus(1);
            device.setLastReportTime(new Date());
            ds.saveOrUpdate(device);
        }
    }



    @PostMapping("/deviceAdd")
    public void deviceAdd() {
        log.info("设备增加回调成功----------------------"+new Date());
    }

    @PostMapping("/deletedDevice")
    public void deletedDevice() {
        log.info("设备删除回调成功----------------------"+new Date());
    }

    @PostMapping("/commandConfirmData")
    public void commandConfirmData() {
        log.info("消息确认回调成功----------------------"+new Date());
    }

    @PostMapping("/commandRspData")
    public void commandRspData() {
        log.info("设备命令响应回调成功----------------------"+new Date());
    }



    @PostMapping("/reportCmdExecResult")
    public void reportCmdExecResult() {
        String remoteIp = IPUtil.getRemoteIp(request);
        String readData = StringUtil.readData(request);
        log.info("设备执行命令结果回调成功----------------------"+new Date());
        log.info("电信订阅收到地址"+remoteIp+"[reportCmdExecResult]数据>>>>>"+readData);

        Map<String,Object> reportCmdExecResult_map= JSON.parseObject(readData,Map.class);
        String iot_device_id=(String)reportCmdExecResult_map.get("deviceId");
        DevicesInfo devicesInfo = dis.findByIotDeviceId(iot_device_id);
        if (devicesInfo != null){
            Map<String,Object> reportCmdExecResult_result_map = JSON.parseObject(JSON.toJSONString(reportCmdExecResult_map.get("result")),Map.class);
            String resultCode = (String)reportCmdExecResult_result_map.get("resultCode");
            log.info("下发指令执行结果["+resultCode+"]");
            //更新开锁记录
            LockRecord lockRecord = lrs.findByDeviceId(devicesInfo.getDeviceId());
        }
    }

    @PostMapping("/updateDeviceDatas")
    public void updateDeviceDatas() {
        String remoteIp = IPUtil.getRemoteIp(request);
        String readData = StringUtil.readData(request);
        log.info("批量设备数据变化回调成功----------------------"+new Date());
        log.info("电信订阅收到地址"+remoteIp+"[updateDeviceDatas]数据>>>>>"+readData);

        Map<String,Object> updateDeviceDatas_map = JSON.parseObject(readData,Map.class);
        String iot_device_id=(String)updateDeviceDatas_map.get("deviceId");
        Devices device = ds.findDevicesByIotDeviceId(iot_device_id);
        log.info("设备查到没:"+ device);

        if (device !=null && "NBIotLock".equals(device.getTypeName())) {
            log.info("设备查到是东陆设备");
            String dateStr = "";
            Date eventTime = new Date();//上报时间
            Integer cmd = 0;            //命令字,区分上报下发所有报文类型 (2正常上报 4开关锁命令返回 5开关锁事件上报 12报警)
            String battery = "";        //电量百分比
            Integer signal = 0;         //信号强度
            Integer lockState = 0;      //锁状态 (1开 0关)
            Integer isOpenAction = 0;   //是否是开锁事件 (1是 0不是)
            Integer openCloseType = 0;  //开关锁方式 (0命令 1钥匙 2指纹 3IC卡 4密码)

            Integer alarmType = 1;      //报警类型 (1低电压报警 2错误次数报警 3防撬报警)
            Integer eventId = 0;        //事件id

            //services集合
            List updateDeviceDatas_lsit = (List) JSON.parseObject(JSON.toJSONString(updateDeviceDatas_map.get("services")), List.class);
            if (updateDeviceDatas_lsit != null) {
                for (int i = 0; i < updateDeviceDatas_lsit.size(); i++) {
                    Map map2 = (Map) JSON.parseObject(JSON.toJSONString(updateDeviceDatas_lsit.get(i)), Map.class);
                    //1.正常上传
                    if ("UpStatus".equals(map2.get("serviceId"))) {
                        dateStr = (String) map2.get("eventTime");
                        eventTime = DateUtil.UTCToCST(dateStr, "yyyyMMdd'T'HHmmss'Z'");
                        //解析data
                        Map data_map = (Map) JSON.parseObject(JSON.toJSONString(map2.get("data")), Map.class);
                        cmd = (Integer) data_map.get("CMD");
                        battery = (String) data_map.get("BATERRY") + "%";
                        signal = (Integer) data_map.get("SIGNAL");
                        lockState = (Integer) data_map.get("OPEN");
                    }
                    //2.报警
                    if ("UpWring".equals(map2.get("serviceId"))) {
                        dateStr = (String) map2.get("eventTime");
                        eventTime = DateUtil.UTCToCST(dateStr, "yyyyMMdd'T'HHmmss'Z'");
                        //解析data
                        Map data_map = (Map) JSON.parseObject(JSON.toJSONString(map2.get("data")), Map.class);
                        cmd = (Integer) data_map.get("CMD");
                        alarmType = (Integer) data_map.get("TYPE");
                        if (alarmType == 1) {
                            log.info("alarmType:低电压报警");
                        } else if (alarmType == 2) {
                            log.info("alarmType:错误次数报警");
                        } else if (alarmType == 3) {
                            log.info("alarmType:防撬报警");
                        }
                        //保存报警记录
                        AlarmData alarmData = new AlarmData();
                        alarmData.setAlarmStatus(0);//未处理
                        alarmData.setAlarmType(alarmType);
                        alarmData.setDeviceId(device.getDeviceId());
                        alarmData.setLocation(device.getAddress());
                        alarmData.setOccursTime(eventTime);
                        alarmData.setRemoveAlarmTime(new Date(0));
                        ads.saveOrUpdate(alarmData);
                    }
                    //3.开关锁命令返回
                    if ("RemoteAck".equals(map2.get("serviceId"))) {
                        dateStr = (String) map2.get("eventTime");
                        eventTime = DateUtil.UTCToCST(dateStr, "yyyyMMdd'T'HHmmss'Z'");
                        //解析data
                        Map data_map = (Map) JSON.parseObject(JSON.toJSONString(map2.get("data")), Map.class);
                        cmd = (Integer) data_map.get("CMD");
                        lockState = (Integer) data_map.get("STATE");
                    }
                    //4.开关锁事件上报
                    if ("OpenCloseEvent".equals(map2.get("serviceId"))) {
                        dateStr = (String) map2.get("eventTime");
                        eventTime = DateUtil.UTCToCST(dateStr, "yyyyMMdd'T'HHmmss'Z'");
                        //解析data
                        Map data_map = (Map) JSON.parseObject(JSON.toJSONString(map2.get("data")), Map.class);
                        cmd = (Integer) data_map.get("CMD");
                        isOpenAction = (Integer) data_map.get("STATE");
                        openCloseType = (Integer) data_map.get("TYPE");
                    }
                }

                //更新设备状态,最后上报时间
                device.setStatus(1);
                device.setLastReportTime(eventTime);
                ds.saveOrUpdate(device);
                //更新设备信息
                DevicesInfo deviceInfo = dis.findDevicesInfoByAid(device.getAid());
                if (deviceInfo == null) {
                    deviceInfo = new DevicesInfo();
                }
                deviceInfo.setDeviceId(device.getDeviceId());
                deviceInfo.setAid(device.getAid());
                deviceInfo.setRsrp(String.valueOf(signal));
                deviceInfo.setVol(battery);
                dis.saveOrUpdate(deviceInfo);
                log.info("门锁设备号["+device.getAid()+"] 电压[" + deviceInfo.getVol()+"] 信号强度["+deviceInfo.getRsrp()+"]");
            }
        }else{
            log.info("设备没查到 iotDeviceId："+iot_device_id);
        }
    }

}
