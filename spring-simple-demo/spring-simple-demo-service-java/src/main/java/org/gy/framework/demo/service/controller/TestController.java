package org.gy.framework.demo.service.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.gy.framework.core.dto.Response;
import org.gy.framework.csrf.annotation.CsrfCheck;
import org.gy.framework.demo.service.api.dto.TestRequestDTO;
import org.gy.framework.demo.service.api.dto.TestResponseDTO;
import org.gy.framework.demo.service.api.service.TestService;
import org.gy.framework.log.annotation.LogTrace;
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
@LogTrace
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/api")
    @CsrfCheck
    public Response test(@Valid TestRequestDTO dto) {
        return testService.test(dto);
    }

    @GetMapping("/log")
    @LogTrace(fieldName = "dto", desc = "测试日志")
    public Response log(@Valid TestRequestDTO dto) {
        return testService.test(dto);
    }

}
