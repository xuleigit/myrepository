package com.jsict.repository;

import com.jsict.entity.smoke.LockRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: XL
 * @Date: Created in 2018/6/29
 * @Description:
 */
public interface LockRecordRepository extends JpaRepository<LockRecord,String> {

    LockRecord findByDeviceId(Integer deviceId);
}
