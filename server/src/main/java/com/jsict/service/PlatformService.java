package com.jsict.service;

import com.jsict.entity.smoke.Platform;

import java.util.List;

/**
 * Created by zjy on 2018/6/11.
 */
public interface PlatformService {

    public Platform findPlatformByPlatformId(Integer platformId);

    public Platform testQueryByMybatis(Integer platformId);

    public List<Platform> testQueryListByMybatis();

    public Platform saveOrUpdate(Platform platform);





}
