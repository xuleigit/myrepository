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
public class IpAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IPADDRESSID")
	private Integer ipAddressId;

	@Column(name = "IPADDRESS")
	private String ipAddress;

	@Column(name = "CREATEUSERID")
	private Integer createUserId;

	@Column(name = "CREATETIME")
	private Date createTime;

}
