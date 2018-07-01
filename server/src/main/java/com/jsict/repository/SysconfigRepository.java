package com.jsict.repository;

import com.jsict.entity.smoke.Sysconfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface SysconfigRepository extends JpaRepository<Sysconfig, String> {

    Sysconfig findByUnitIdAndEventId(Integer unitId,Integer eventId);

}
