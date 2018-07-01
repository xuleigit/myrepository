package com.jsict.common.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jsict.common.VO.PlatformDevice;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.http.HttpResponse;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@EnableCaching
@Slf4j
public class DXPlatformUtils {

	HttpsUtil httpsUtil = new HttpsUtil();

	private static Object locker = new Object();

	String appId;
	String secret;
	String baseUrl;
	String callbakeUrl;
	public DXPlatformUtils(String baseUrl, String appId, String secret, String callbakeUrl) {
		try {
			httpsUtil.initSSLConfigForTwoWay();
			this.appId=appId;
			this.secret=secret;
			this.baseUrl=baseUrl;
			this.callbakeUrl=callbakeUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public String login(){
        try {
			String urlLogin = this.baseUrl+ HttpConstant.APP_AUTH;
			Map<String, String> paramLogin = new HashMap<>();
			paramLogin.put("appId", this.appId);
			paramLogin.put("secret", this.secret);
			StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);
			Map<String, String> data = new HashMap<>();
			data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
			return data.get("accessToken");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

	public String getToken(CacheManager cacheManager){
		String token = get(cacheManager,"60SecondsCache", "dx_platform_token");
		if (token==null) {
			token=login();
			put(cacheManager,"60SecondsCache", "dx_platform_token", token);
		}
		return token;
	}

	public StreamClosedHttpResponse regist(String accessToken, String name, String imei, String manufacturerId, String manufacturerName, String deviceType, String model, String protocolType){
		String urlReg = this.baseUrl+ HttpConstant.REGISTER_DEVICE;

		String verifyCode = imei;
		String nodeId = verifyCode;
		Integer timeout = 0;

		Map<String, Object> paramReg = new HashMap<>();
		paramReg.put("verifyCode", verifyCode.toUpperCase());
		paramReg.put("nodeId", nodeId.toUpperCase());
		paramReg.put("timeout", timeout);

		String jsonRequest = JsonUtil.jsonObj2Sting(paramReg);

		Map<String, String> header = new HashMap<>();
		header.put(HttpConstant.HEADER_APP_KEY, appId);
		header.put(HttpConstant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

		StreamClosedHttpResponse responseReg = httpsUtil.doPostJsonGetStatusLine(urlReg, header, jsonRequest);
		if (200==responseReg.getStatusLine().getStatusCode()&&"OK".equals(responseReg.getStatusLine().getReasonPhrase())) {
			PlatformDevice device = JsonUtil.jsonString2SimpleObj(responseReg.getContent(), PlatformDevice.class);
			if (device!=null&&device.getDeviceId()!=null) {
				modifyDevice(accessToken,verifyCode,device.getDeviceId(), manufacturerId, manufacturerName, deviceType, model, protocolType);
			}
		}
		return responseReg;
	}
	public boolean modifyDevice(String accessToken,String verifyCode,String deviceId,String manufacturerId,String manufacturerName,String deviceType,String model,String protocolType){
		try {
			String urlModifyDeviceInfo = this.baseUrl+ HttpConstant.MODIFY_DEVICE_INFO + "/" + deviceId;

			String name=verifyCode;

			Map<String, Object> paramModifyDeviceInfo = new HashMap<>();
			paramModifyDeviceInfo.put("timezone", "GMT+08:00");
			paramModifyDeviceInfo.put("manufacturerId", manufacturerId);
			paramModifyDeviceInfo.put("manufacturerName", manufacturerName);
			paramModifyDeviceInfo.put("deviceType", deviceType);
			paramModifyDeviceInfo.put("model", model);
			paramModifyDeviceInfo.put("protocolType", protocolType);
			paramModifyDeviceInfo.put("name", name);
			
			String jsonRequest = JsonUtil.jsonObj2Sting(paramModifyDeviceInfo);

			Map<String, String> header = new HashMap<>();
			header.put(HttpConstant.HEADER_APP_KEY, appId);
			header.put(HttpConstant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

			StreamClosedHttpResponse responseModifyDeviceInfo = httpsUtil.doPutJsonGetStatusLine(urlModifyDeviceInfo,header, jsonRequest);
			if (responseModifyDeviceInfo.getStatusLine().getStatusCode()==204) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//删除IoT平台设备
	public String deleteDevice(String accessToken,String deviceId){
    	try {
			String urlDelete =this.baseUrl+ HttpConstant.DELETE_DEVICE + "/" +deviceId;
			        
			Map<String, String> header = new HashMap<>();
			header.put(HttpConstant.HEADER_APP_KEY, this.appId);
			header.put(HttpConstant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
			
			StreamClosedHttpResponse responseDelete = httpsUtil.doDeleteGetStatusLine(urlDelete, header);

			System.out.println(responseDelete.getContent());
			if(responseDelete.getStatusLine().getStatusCode()==204){
				return null;
			}else{
				return "平台设备删除失败！请重新注册！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "发生异常，操作失败！";
		}
    }
	 
	public String postCmd(String accessToken,String serviceId,String method,String paraStr,String iotDeviceId){
		String status = "";
		try {
			String urlPostAsynCmd =this.baseUrl+ HttpConstant.POST_ASYN_CMD;
			log.info("下发指令调用地址:"+urlPostAsynCmd);
			Map<String, Object> paramCommand = new HashMap<>();
			ObjectNode paras = JsonUtil.convertObject2ObjectNode(paraStr);
			String callbackUrl = this.callbakeUrl+ HttpConstant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL;
			log.info("下发指令回调地址:"+callbackUrl);
			paramCommand.put("serviceId", serviceId);
			paramCommand.put("method", method);
			paramCommand.put("paras", paras);   
			Map<String, Object> paramPostAsynCmd = new HashMap<>();
			paramPostAsynCmd.put("deviceId", iotDeviceId);
			paramPostAsynCmd.put("command", paramCommand);
			paramPostAsynCmd.put("callbackUrl", callbackUrl);
			String jsonRequest = JsonUtil.jsonObj2Sting(paramPostAsynCmd);
			
			Map<String, String> header = new HashMap<>();
			header.put(HttpConstant.HEADER_APP_KEY, appId);
			header.put(HttpConstant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
			
			HttpResponse responsePostAsynCmd = httpsUtil.doPostJson(urlPostAsynCmd, header, jsonRequest);
			String responseBody = httpsUtil.getHttpResponseBody(responsePostAsynCmd);
			Map<String,Object> responseBody_map = JSON.parseObject(responseBody,Map.class);
			status = (String)responseBody_map.get("status");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	public Cache getOrAddCache(CacheManager cacheManager,String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache == null) {
			Object var2 = locker;
			synchronized(locker) {
				cache = cacheManager.getCache(cacheName);
				if(cache == null) {
					log.warn("Could not find cache config [" + cacheName + "], using default.");
					cacheManager.addCacheIfAbsent(cacheName);
					cache = cacheManager.getCache(cacheName);
					log.debug("Cache [" + cacheName + "] started.");
				}
			}
		}

		return cache;
	}

	public String get(CacheManager cacheManager,String cacheName, String key) {
		Element element = getOrAddCache(cacheManager,cacheName).get(key);
		return element != null?(String)element.getObjectValue():null;
	}
	public  void put(CacheManager cacheManager,String cacheName, Object key, Object value) {
		getOrAddCache(cacheManager,cacheName).put(new Element(key, value));
	}
}
