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
public class PlatformConf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer platformConfId;

	private Integer platformId;

	private String platformAppName;

	private String baseUrl;

	private String appId;

	private String secret;

	private String baseCallbackUrl;

	private Integer deviceModelId;

	private String deviceModelName;

	private String profilePath;

	private Integer status;

}
