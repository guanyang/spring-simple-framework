#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.mapper;

import ${package}.dao.entity.HelloWorld;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 简单演示表 Mapper 接口
 * </p>
 *
 * @author gy
 * @since 2021-11-29
 */
public interface HelloWorldMapper extends BaseMapper<HelloWorld> {

}
