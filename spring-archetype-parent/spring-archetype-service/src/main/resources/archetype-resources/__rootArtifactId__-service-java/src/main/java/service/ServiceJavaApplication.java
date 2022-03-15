#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.common.CommonConfig;
import ${package}.dao.DaoCommon;
import org.gy.framework.xss.annotation.EnableXss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableXss
@SpringBootApplication(scanBasePackageClasses = {DaoCommon.class, CommonConfig.class,
    ServiceJavaApplication.class}, exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class ServiceJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJavaApplication.class, args);
    }

}
