package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Devices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deviceId;

	private String aid;

	private String typeName;

	private String address;

	private String position;

	private String teles;

	private Integer status;

	private Date installTime;

	private Date offlineTime;

	private Date lastReportTime;

	private String remake;

}
