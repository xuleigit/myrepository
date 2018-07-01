package com.jsict.repository;

import com.jsict.entity.smoke.Devices;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface DevicesRepository extends JpaRepository<Devices, String> {

    Devices findByAid(String aid);

}
