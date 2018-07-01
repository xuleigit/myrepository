package com.jsict.entity.smoke;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: XL
 * @Date: Created in 2018/6/28
 * @Description: 开关锁记录,记录锁状态及变更时间
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class LockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String deviceId;//锁id

    private String location;//锁位置

    private Integer openCloseType;//开关锁方式 0命令 1机械

    private String userId;       //开关锁用户id 0命令时

    private String commandState;//命令送达状态 0命令时

    private Date occursTime;//变更时间

    private String commandContent;//命令内容


}
