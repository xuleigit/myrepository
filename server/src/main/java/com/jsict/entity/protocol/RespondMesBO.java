package com.jsict.entity.protocol;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class RespondMesBO implements Serializable{

	private static final long serialVersionUID = -7500186176327137916L;

	private boolean success;

	private int error_code;

	private String error_msg;

	@Override
	public String toString() {
		return "RespondMesBO [success=" + success + ", error_code="
				+ error_code + ", error_msg=" + error_msg + "]";
	}


}
