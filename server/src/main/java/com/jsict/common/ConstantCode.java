package com.jsict.common;

public class ConstantCode {
	public static final int USERONLINESTATUS=1;//用户在线
	public static final int USEROFFLINESTATUS=0;//用户离线
	public static final int THIRTYDAYSCOOKIE=30*24*60*60;//30天的cookie时长
	public static final int DEFUALTCOOKIETIME=30*60;//默认cookie时长
	
	public static final int DIVICE_EVENT=1;//设备事件，改为对应event表中的event_type,1报警，2不报警
	public static final int SERVICE_EVENT=2;//业务事件，改为对应event表中的event_type,1报警，2不报警
	
	public static final int EVENT_TYPE_CALL=1;//事件中对应的语音
	public static final int EVENT_TYPE_NO=2;//事件中对应的不通知
	public static final int EVENT_TYPE_CALL_MES=3;//事件中对应的语音和短信
	public static final int EVENT_TYPE_MES=4;//事件中对应的短信

	public static final int ALARM_WAY_NO=0;//通知方式不通知
	public static final int ALARM_WAY_MES=1;//通知方式短信
	public static final int ALARM_WAY_CALL=2;//通知方式电话
	public static final int ALARM_WAY_CALL_MES=3;//通知方式电话加短信
	
	public static final int NOTIFI_STATUS_NO=0;//通知状态0未通知
	public static final int NOTIFI_STATUS_SEND=1;//1通知到达
	public static final int NOTIFI_STATUS_SEND_NOT_ARRIVE=2;//2通知未到达
	public static final int NOTIFI_STATUS_NOTIFING=3;//3通知中
	public static final int NOTIFI_STATUS_NONOTIFI = 4; //不通知
	
	public static final long NOTIFIINTERVAL=60;//通知间隔时间，单位秒,追后一次通知时间大于间隔时间再通知
	public static final long NOTIFINUM=3;//通知次数，大于3次放弃通知
	public static final int VOL_EVENT_ID=11;//电量不足id

	public static final int REMOVE_ALARM_WAY_DEVICE_AUTO = 1;//设备自动解除
	public static final int REMOVE_ALARM_WAY_PLATFORM = 2;//平台解除
	public static final int REMOVE_ALARAM_WAY_WEIXIN =3; //微信解除
	
	public static final int EVENT_SMOKE = 3; //烟雾
	public static final int EVENT_FIRE = 4; //火警
	public static final int EVENT_BATTERY_LOW = 6; //烟感电量低
	public static final int EVENT_MODULE_BATTERY_LOW = 11; //模组电量低
	
	public static final int EVENT_NEED_NOTIFI=1;//事件需要通知
	public static final int EVENT_NONEED_NOTIFI=0;//事件不需要需要通知
	
	public static final int EVENT_NEED_PUSH=1;//事件需要推送
	public static final int EVENT_NONEED_NOPUSH=0;//事件不需要需要推送
	
	public static final int ALRAM_NOTIFI_NO = 0; //报警未通知
	public static final int ALRAM_NOTIFI_COMPELED = 1; //报警通知到达
	public static final int ALRAM_NOTIFI_PROCESSING = 2; //报警通知未到达
	public static final int ALRAM_NOTIFI_ING = 3; //报警通知中
	public static final int ALRAM_NOTIFI_NONOTIFI = 4; //报警通知中

	//应用平台
	public static final int PLATFORM_DIANXIN_ID=1;
	public static final int PLATFORM_QIYU_ID=2;
	public static final int PLATFORM_HUAWEI_ID=3;
	public static final int PLATFORM_YIDONG_ID=5;

	public static final String CONFIG_NAME = "smoke";

	public static final String DEVICE_IS_OFFLINE="来自设备的消息，设备失联了。";
	public static final String DEVICE_IS_EXCEPTION="来自设备的消息，设备发生异常，可能无法通讯。";
	public static final String DEVICE_IS_LOWPOWER="来自设备的消息，设备电量低，请更换电池。";
	public static final String DEVICE_IS_FAULT="来自设备的消息，设备发生故障，可能无法通讯。";

}
