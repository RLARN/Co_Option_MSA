package com.cooption.taskService.service;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        // PathMatchingResourcePatternResolver를 사용하여 매퍼 XML 파일을 로드합니다.
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mapper/*.xml");

        for (Resource resource : resources) {
            System.out.println("Found resource: " + resource.getFilename());
        }

        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        // TypeAlias 설정
        //factoryBean.setTypeAliasesPackage("com.cooption.userservice.vo");

        return factoryBean.getObject();
    }
}