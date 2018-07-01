package com.jsict.repository;


import com.jsict.entity.smoke.AlarmData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface AlarmDataRepository extends JpaRepository<AlarmData, String> {

}
