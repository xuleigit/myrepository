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
public class ProjectConf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PCID")
	private Integer pcId;

	private Integer projectId;

	private Integer eventId;

	private Integer notifiWay;

	private Integer eventFoldTime;

	private Integer deviceUpFrequency;

	private Integer volNotifiWay;

	private Double volThresholdValue;

}
