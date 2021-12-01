#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.service;

import ${package}.dao.entity.HelloWorld;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 简单演示表 服务类
 * </p>
 *
 * @author gy
 * @since 2021-11-29
 */
public interface IHelloWorldService extends IService<HelloWorld> {

}
