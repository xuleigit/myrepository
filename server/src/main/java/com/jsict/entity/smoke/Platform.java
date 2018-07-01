package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Platform {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer platformId;

	private String name;

	private Integer status;

}
