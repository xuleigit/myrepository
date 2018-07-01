package com.jsict.common.VO;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class PlatformDevice implements Serializable{

	private static final long serialVersionUID = -1731450194909605771L;

	private String deviceId;

	private String verifyCode;

	private String psk;

	private String notifyType;

	private String gatewayId;

	private String nodeType;

	private PlatformDeviceInfo platformDeviceInfo;


	@Override
	public String toString() {
		return "Divice [deviceId=" + deviceId + ", verifyCode=" + verifyCode
				+ ", psk=" + psk + ", notifyType=" + notifyType
				+ ", gatewayId=" + gatewayId + ", nodeType=" + nodeType
				+ ", deviceInfo=" + platformDeviceInfo + "]";
	}

}
