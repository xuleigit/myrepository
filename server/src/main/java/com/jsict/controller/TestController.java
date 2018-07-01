package com.jsict.controller;

import com.jsict.entity.protocol.TelesBO;
import com.jsict.entity.smoke.Platform;
import com.jsict.entity.smoke.PlatformConf;
import com.jsict.service.PlatformConfigService;
import com.jsict.service.PlatformService;
import com.jsict.common.utils.*;
import net.sf.ehcache.CacheManager;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjy on 2018/6/7.
 */
@RefreshScope
@Controller
@RequestMapping("/test")
public class TestController {

    @Value("${env}")
    private String env;

    @Autowired
    private PlatformService platformService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return env;
    }

    @GetMapping("/testPlatformService")
    @ResponseBody
    public List<Platform> findPlatformByPlatformId(){
        List<Platform> list = platformService.testQueryListByMybatis();
        return list;
    }


}
