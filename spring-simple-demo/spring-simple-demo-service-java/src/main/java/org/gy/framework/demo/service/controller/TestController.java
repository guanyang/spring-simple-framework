package org.gy.framework.demo.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.gy.framework.core.dto.Response;
import org.gy.framework.demo.service.api.dto.TestRequestDTO;
import org.gy.framework.demo.service.api.dto.TestResponseDTO;
import org.gy.framework.demo.service.api.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/api")
    public Response test(TestRequestDTO dto) {
        return testService.test(dto);
    }

}
