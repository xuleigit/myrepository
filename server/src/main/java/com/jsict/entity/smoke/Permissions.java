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
public class Permissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PID")
	private Integer pId;

	private String permission;

	private String permissionName;

	private String linkUrl;

	private String iconcls;

	@Column(name="FPID")
	private Integer fpId;

	private Integer fpermission;

	private String fpermissionName;

	private Integer hasCPermission;

	private Integer isMeun;

	private Integer isTree;

	private Integer isPermission;

	private Integer permissionLevel;

	private String description;

	private String tableId;

	private String divId;

}
