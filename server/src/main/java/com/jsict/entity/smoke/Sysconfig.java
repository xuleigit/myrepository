package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Sysconfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SYSID")
	private Integer sysId;

	private Integer status;

	private Integer isCanSendMes;

	private Integer isCanDoCall;

	private Integer unitId;

	private Integer eventId;

	private Integer notifiWay;

	private Integer eventFoldTime;

	private Integer volNotifiWay;

	private Double volThresholdValue;

}
