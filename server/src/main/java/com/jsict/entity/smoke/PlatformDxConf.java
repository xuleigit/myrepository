package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class PlatformDxConf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer platformId;

	private String appId;

	private String secret;

	private String callbackBaseUrl;

	private String protocal;

	private String deviceModel;

	private String deviceType;

	private String manufacturerId;

	private String manufacturerName;

	private String cmdServiceId;

	private String cmdName;

	private String cmdParaFrequen;

	private String cmdParaImei;

	private String configCmdPageName;


}
