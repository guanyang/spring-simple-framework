package org.gy.framework.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.Optional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.gy.framework.core.dto.Response;
import org.gy.framework.demo.dao.entity.HelloWorld;
import org.gy.framework.demo.dao.service.IHelloWorldService;
import org.gy.framework.demo.service.api.dto.TestRequestDTO;
import org.gy.framework.demo.service.api.dto.TestResponseDTO;
import org.gy.framework.demo.service.api.service.TestService;
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
