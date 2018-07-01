package com.jsict.entity.protocol;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class HeartBeatBO implements Serializable{

	private static final long serialVersionUID = 658182998493992683L;

	private String HB_REQ;

	private String HB_RES;

	@Override
	public String toString() {
		return "HeartBeatBO [HB_REQ=" + HB_REQ + ", HB_RES=" + HB_RES + "]";
	}

}
