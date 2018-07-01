package com.jsict.entity.protocol;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class AuthBO {

	private String api_key;

	private String api_secret;

	private String token;

	private Long time;

	@Override
	public String toString() {
		return "AuthBO [api_key=" + api_key + ", api_secret=" + api_secret
				+ ", token=" + token + "]";
	}
	
}
