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
public class UsersPermissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer userId;

	@Column(name="PIDS")
	private String pIds;


}
