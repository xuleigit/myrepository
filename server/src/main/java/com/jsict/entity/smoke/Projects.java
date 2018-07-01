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
public class Projects{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	private Integer platformId;

	private Integer platformConfId;

	private String contractNumbe;

	private String projectName;

	private Date projectCreateTime;

	private Integer status;

	private Integer projectType;

	private Integer unitId;

	private Integer customerId;

	private Integer deviceEventAlarmWay;

	private Integer serviceEventAlarmWay;

	private String managerName;

	private String managerContactPhone;

	private String linkMan;

	private String linkPhone;

	private String remark;

	private String province;

	private String city;

	private String area;

	private String town;

	@Column(name = "TOWNNUM")
	private String townNum;

	private String address;
	

}
