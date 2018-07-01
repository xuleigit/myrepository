package com.jsict.common.config.mybatisconfig;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by zjy on 2018/6/12.
 */
@Configuration
public class SessionFactoryConfiguration {

    /**
     * mybatis-config.xml 配置文件位置
     */
    @Value("${mybatis_config_file}")
    private String myBatisConfigFilePath;

    /**
     * mybatis mapper 文件位置
     */
    @Value("${mapper_path}")
    private String mapperPath;

    /**
     * 实体类所在的package
     */
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean SqlSessionFactoryBean = new SqlSessionFactoryBean();
        SqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigFilePath));

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSerchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        SqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSerchPath));
        SqlSessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return SqlSessionFactoryBean;

    }



}
