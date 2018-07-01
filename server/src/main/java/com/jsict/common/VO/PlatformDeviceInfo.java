package com.jsict.common.VO;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class PlatformDeviceInfo implements Serializable{

	private static final long serialVersionUID = -4719549146174774565L;
	
	private String nodeId;

	private String name;

	private String description;

	private String manufacturerId;

	private String manufacturerName;

	private String mac;

	private String location;

	private String deviceType;

	private String model;

	private String swVersion;

	private String fwVersion;

	private String hwVersion;

	private String protocolType;

	private String bridgeId;

	private String status;

	private String statusDetail;

	private String mute;

	private String supportedSecurity;

	private String isSecurity;

	private String signalStrength;

	private String sigVersion;

	private String serialNumber;

	private String batteryLevel;


	@Override
	public String toString() {
		return "DeviceInfo [nodeId=" + nodeId + ", name=" + name
				+ ", description=" + description + ", manufacturerId="
				+ manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", mac=" + mac + ", location=" + location + ", deviceType="
				+ deviceType + ", model=" + model + ", swVersion=" + swVersion
				+ ", fwVersion=" + fwVersion + ", hwVersion=" + hwVersion
				+ ", protocolType=" + protocolType + ", bridgeId=" + bridgeId
				+ ", status=" + status + ", statusDetail=" + statusDetail
				+ ", mute=" + mute + ", supportedSecurity=" + supportedSecurity
				+ ", isSecurity=" + isSecurity + ", signalStrength="
				+ signalStrength + ", sigVersion=" + sigVersion
				+ ", serialNumber=" + serialNumber + ", batteryLevel="
				+ batteryLevel + "]";
	}

}
