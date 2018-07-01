package com.jsict.entity.protocol;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class AuthTokenBO {

	private int code;

	private String token;

	private int expiresTime;

	private String message;



}
