#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.admin;

import ${package}.common.CommonConfig;
import ${package}.dao.DaoCommon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses = {DaoCommon.class, CommonConfig.class,
    AdminJavaApplication.class}, exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
public class AdminJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminJavaApplication.class, args);
    }

}
