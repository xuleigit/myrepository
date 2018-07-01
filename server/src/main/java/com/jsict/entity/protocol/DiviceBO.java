package com.jsict.entity.protocol;

import java.io.Serializable;
import java.util.Arrays;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class DiviceBO implements Serializable{

	private static final long serialVersionUID = 2075224814967053828L;

	private String aid;

	private String aid2;

	private String imsi;

	private String type_name;

	private String address;

	private String position;

	private TelesBO[] teles;

	private String lng;

	private String lat;


	@Override
	public String toString() {
		return "DiviceBO [aid=" + aid + ", aid2=" + aid2 + ", imsi=" + imsi
				+ ", type_name=" + type_name + ", address=" + address
				+ ", position=" + position + ", teles="
				+ Arrays.toString(teles) + ", lng=" + lng + ", lat=" + lat
				+ "]";
	}

}
