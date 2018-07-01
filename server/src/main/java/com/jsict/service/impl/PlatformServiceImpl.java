package com.jsict.service.impl;

import com.jsict.entity.smoke.Platform;
import com.jsict.repository.PlatformRepository;
import com.jsict.repository.formybatis.PlatformRepositoryForMyBatis;
import com.jsict.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zjy on 2018/6/11.
 */
@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private PlatformRepositoryForMyBatis platformRepositoryForMyBatis;

    @Override
    public Platform findPlatformByPlatformId(Integer platformId) {
        Platform platform = platformRepository.findByPlatformId(platformId);
        return platform;
    }

    @Override
    public Platform testQueryByMybatis(Integer platformId) {
        Platform platform = platformRepositoryForMyBatis.testQueryByMybatis(platformId);
        return platform;
    }

    @Override
    public List<Platform> testQueryListByMybatis() {
        return platformRepositoryForMyBatis.testQueryListByMybatis();
    }

    @Override
    public Platform saveOrUpdate(Platform platform) {
        return platformRepository.save(platform);
    }
}
