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
public class AlarmNotifiRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer alarmId;

	private Date notifiTime;

	private Date notifiSuccessTime;

	private Date lastNotifiTime;

	private Integer notifiStatus;

	private Integer notifiWay;

	private Integer notifiToWho;

	private String notifiPhone;

	private String notifiDescribe;

	private Integer isBackup;

	private Integer notifiNum;

	private Integer isMainUser;

	private String callSid;

	private Integer isSendedMes;

}
