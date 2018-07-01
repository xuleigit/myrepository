package com.jsict.entity.protocol;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by zjy
 * 2018-06-08 09:27
 */
@Data
public class NotificationDataBO implements Serializable{

	private static final long serialVersionUID = 5721649379900570468L;

	private String event_id;

	private Integer notification_state;

	private TelesBO[] teles;


}
