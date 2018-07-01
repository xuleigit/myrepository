package com.jsict.repository.formybatis;


import com.jsict.entity.smoke.Platform;

import java.util.List;

/**
 * Created by zjy
 * 2018-06-11 21:29
 */
public interface PlatformRepositoryForMyBatis {

    Platform testQueryByMybatis(Integer platformId);

    List<Platform> testQueryListByMybatis();

}
