package com.jsict.repository;

import com.jsict.entity.smoke.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface IpAddressRepository extends JpaRepository<IpAddress, String> {

}
