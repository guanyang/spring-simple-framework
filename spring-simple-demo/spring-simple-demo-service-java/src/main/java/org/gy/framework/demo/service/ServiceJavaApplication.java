package org.gy.framework.demo.service;

import org.gy.framework.demo.common.CommonConfig;
import org.gy.framework.demo.dao.DaoCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {DaoCommon.class, CommonConfig.class,
    ServiceJavaApplication.class}, exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class ServiceJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJavaApplication.class, args);
    }

}
