#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.Optional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.gy.framework.core.dto.Response;
import ${package}.dao.entity.HelloWorld;
import ${package}.dao.service.IHelloWorldService;
import ${package}.service.api.dto.TestRequestDTO;
import ${package}.service.api.dto.TestResponseDTO;
import ${package}.service.api.service.TestService;
import org.springframework.stereotype.Service;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private IHelloWorldService helloWorldService;

    @Override
    public Response<TestResponseDTO> test(TestRequestDTO dto) {
        TestResponseDTO responseDTO = new TestResponseDTO();
        LambdaQueryWrapper<HelloWorld> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(HelloWorld::getName, dto.getName());
        HelloWorld entity = helloWorldService.getOne(wrapper);
        responseDTO.setName(Optional.ofNullable(entity).map(HelloWorld::getName).orElse(null));
        responseDTO.setTime(System.currentTimeMillis());
        return Response.asSuccess(responseDTO);
    }

}
