package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class AlarmData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alarmId;

	private Integer deviceId;

	private Integer alarmType;

	private String location;

	private Date occursTime;

	private Date removeAlarmTime;

	private Integer notificationState;

	private Integer alarmStatus;

	private Integer confirmStatus;

	private String remark;

	private Integer removeAlarmWay;

}
