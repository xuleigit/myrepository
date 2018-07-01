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
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String userName;

	private String nickName;

	private String password;

	private String phone;

	private Date userAddTime;

	private Integer loginStatus;

	private Date lastLoginTime;

	private String lastLoginIp;

	private String useSurface;

	private String use_language;

	private String use_logo;

	private Integer userUnitId;

	private String userUnitName;

	private Integer userStatus;

	@Column(name=" ISADMIN")
	private Integer isAdmin;

	private Date passwordTime;

	@Column(name="ISLOCKED")
	private Boolean isLocked;

	private Date lockedTime;

	private Integer failLoginTimes;

}
