/*
 * File Name: com.huawei.utils.Constant.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.jsict.common.utils;


public class HttpConstant {
    //Paths of certificates.
    public static String SELFCERTPATH = "cert/outgoing.CertwithKey.pkcs12";
    public static String TRUSTCAPATH = "cert/ca.jks";

    //Password of certificates.
    public static String SELFCERTPWD = "IoM@1234";
    public static String TRUSTCAPWD = "Huawei@123";
    /*
     * complete callback url：
     * please replace uri, when you use the demo.
     */
    public static final String DEVICE_ADDED_CALLBACK_URL = "/subscribe/deviceAdd";
    public static final String DEVICE_INFO_CHANGED_CALLBACK_URL = "/subscribe/deviceChange";
    public static final String DEVICE_DATA_CHANGED_CALLBACK_URL = "/subscribe/updateDeviceData";
    public static final String DEVICE_DELETED_CALLBACK_URL = "/subscribe/deletedDevice";
    public static final String MESSAGE_CONFIRM_CALLBACK_URL = "/subscribe/commandConfirmData";
    public static final String SERVICE_INFO_CHANGED_CALLBACK_URL = "/subscribe/updateServiceInfo";
    public static final String COMMAND_RSP_CALLBACK_URL = "/subscribe/commandRspData";
    public static final String DEVICE_EVENT_CALLBACK_URL = "/subscribe/DeviceEvent";
    public static final String RULE_EVENT_CALLBACK_URL = "/subscribe/RulEevent";
    public static final String DEVICE_DATAS_CHANGED_CALLBACK_URL = "/subscribe/updateDeviceDatas";

    /*
     * Specifies the callback URL for the command execution result notification.
     * For details about the execution result notification definition.
     *
     * please replace uri, when you use the demo.
     */
//    public static final String REPORT_CMD_EXEC_RESULT_CALLBACK_URL = "/na/iocm/devNotify/v1.1.0/reportCmdExecResult";
    public static final String REPORT_CMD_EXEC_RESULT_CALLBACK_URL = "/subscribe/reportCmdExecResult";

    //*************************** The following constants do not need to be modified *********************************//

    /*
     * request header
     * 1. HEADER_APP_KEY
     * 2. HEADER_APP_AUTH
     */
    public static final String HEADER_APP_KEY = "app_key";
    public static final String HEADER_APP_AUTH = "Authorization";
    
    /*
     * Application Access Security:
     * 1. APP_AUTH
     * 2. REFRESH_TOKEN
     */
    public static final String APP_AUTH = "/iocm/app/sec/v1.1.0/login";
    public static final String REFRESH_TOKEN = "/iocm/app/sec/v1.1.0/refreshToken";
    

    /*
     * Device Management:
     * 1. REGISTER_DEVICE
     * 2. MODIFY_DEVICE_INFO
     * 3. QUERY_DEVICE_ACTIVATION_STATUS
     * 4. DELETE_DEVICE
     * 5. DISCOVER_INDIRECT_DEVICE
     * 6. REMOVE_INDIRECT_DEVICE
     */
    public static final String REGISTER_DEVICE = "/iocm/app/reg/v1.1.0/devices";
    public static final String MODIFY_DEVICE_INFO = "/iocm/app/dm/v1.1.0/devices";
    public static final String QUERY_DEVICE_ACTIVATION_STATUS = "/iocm/app/reg/v1.1.0/devices";
    public static final String DELETE_DEVICE = "/iocm/app/dm/v1.1.0/devices";
    public static final String DISCOVER_INDIRECT_DEVICE = "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    public static final String REMOVE_INDIRECT_DEVICE = "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";

    /*
     * Data Collection:
     * 1. QUERY_DEVICES
     * 2. QUERY_DEVICE_DATA
     * 3. QUERY_DEVICE_HISTORY_DATA
     * 4. QUERY_DEVICE_CAPABILITIES
     * 5. SUBSCRIBE_NOTIFYCATION
     */
    public static final String QUERY_DEVICES = "/iocm/app/dm/v1.3.0/devices";
    public static final String QUERY_DEVICE_DATA = "/iocm/app/dm/v1.3.0/devices";
    public static final String QUERY_DEVICE_HISTORY_DATA = "/iocm/app/data/v1.1.0/deviceDataHistory";
    public static final String QUERY_DEVICE_CAPABILITIES = "/iocm/app/data/v1.1.0/deviceCapabilities";
    public static final String SUBSCRIBE_NOTIFYCATION = "/iocm/app/sub/v1.1.0/subscribe";
    
    
    /*
     * Signaling Delivery：
     * 1. POST_ASYN_CMD
     * 2. QUERY_DEVICE_CMD
     * 3. UPDATE_ASYN_COMMAND
     * 4. CREATE_DEVICECMD_CANCEL_TASK
     * 5. QUERY_DEVICECMD_CANCEL_TASK
     *
     */
    public static final String POST_ASYN_CMD = "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static final String QUERY_DEVICE_CMD = "/iocm/app/cmd/v1.4.0/deviceCommands";
    public static final String UPDATE_ASYN_COMMAND = "/iocm/app/cmd/v1.4.0/deviceCommands/%s";
    public static final String CREATE_DEVICECMD_CANCEL_TASK = "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";
    public static final String QUERY_DEVICECMD_CANCEL_TASK = "/iocm/app/cmd/v1.4.0/deviceCommandCancelTasks";


    /*
     * notify Type
     * serviceInfoChanged|deviceInfoChanged|LocationChanged|deviceDataChanged|deviceDatasChanged
     * deviceAdded|deviceDeleted|messageConfirm|commandRsp|deviceEvent|ruleEvent
     */
    public static final String DEVICE_ADDED = "deviceAdded";
    public static final String DEVICE_INFO_CHANGED = "deviceInfoChanged";
    public static final String DEVICE_DATA_CHANGED = "deviceDataChanged";
    public static final String DEVICE_DELETED = "deviceDeleted";
    public static final String MESSAGE_CONFIRM = "messageConfirm";
    public static final String SERVICE_INFO_CHANGED = "serviceInfoChanged";
    public static final String COMMAND_RSP = "commandRsp";
    public static final String DEVICE_EVENT = "deviceEvent";
    public static final String RULE_EVENT = "ruleEvent";
    public static final String DEVICE_DATAS_CHANGED = "deviceDatasChanged";

}
