package com.jsict.entity.protocol;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class AlarmEventBO implements Serializable{

	private static final long serialVersionUID = -7250935950999691760L;

	private String event_id;

	private String aid;

	private Integer event_type;

	private String event_on;

	@Override
	public String toString() {
		return "AlarmEvent [event_id=" + event_id + ", aid=" + aid
				+ ", event_type=" + event_type + ", event_on=" + event_on + "]";
	}
}
