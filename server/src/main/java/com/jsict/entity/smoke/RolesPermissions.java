package com.jsict.entity.smoke;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
@Entity
public class RolesPermissions{
	
	@Id
	private Integer id;

	private Integer roleId;

	private String pIds;


}
