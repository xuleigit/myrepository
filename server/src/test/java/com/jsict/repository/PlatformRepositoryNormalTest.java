package com.jsict.repository;

import com.jsict.entity.smoke.Platform;
import com.jsict.repository.formybatis.PlatformRepositoryForMyBatis;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zjy on 2018/6/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PlatformRepositoryNormalTest {

    @Autowired
    PlatformRepository platformRepository;


    @Autowired
    PlatformRepositoryForMyBatis platformRepositoryForMyBatis;


    @Test
    public void testPlatFormMybatis() throws Exception {
        Platform p = platformRepositoryForMyBatis.testQueryByMybatis(1);
        log.info("查到的结果为: {}",p);
    }

}