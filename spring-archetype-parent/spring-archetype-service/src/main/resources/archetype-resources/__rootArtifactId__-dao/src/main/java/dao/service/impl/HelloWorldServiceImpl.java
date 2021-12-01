#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.service.impl;

import ${package}.dao.entity.HelloWorld;
import ${package}.dao.mapper.HelloWorldMapper;
import ${package}.dao.service.IHelloWorldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简单演示表 服务实现类
 * </p>
 *
 * @author gy
 * @since 2021-11-29
 */
@Service
public class HelloWorldServiceImpl extends ServiceImpl<HelloWorldMapper, HelloWorld> implements IHelloWorldService {

}
