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
public class WeixinUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer weixinUserId;

	private String openid;

	private String nickname;

	private Integer sex;

	private String name;

	private String phone;

	private String country;

	private String province;

	private String city;

	private String unionid;

	private String headimgurl;

	private Date createTime;

	private String remark;


}
