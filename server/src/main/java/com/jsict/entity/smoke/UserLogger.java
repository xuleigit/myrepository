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
public class UserLogger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOGGERID")
	private Integer loggerId;

	@Column(name="OPERATEDUSERID")
	private Integer operatedUserId;

	@Column(name="OPERATEDUSERNAME")
	private String operatedUserName;

	private String action;

	private String detail;

	private String ip;

	@Column(name="CREATEDUSERID")
	private Integer createUserId;

	@Column(name="CREATEDTIME")
	private Date createTime;

}
