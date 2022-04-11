package org.gy.framework.demo.admin.controller;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping(value = {"/api/test/ping", "/hello"})
    public Map<String, Object> ping() {
        Map<String, Object> res = Maps.newHashMap();
        res.put("code", "SUCCESS");
        res.put("time", System.currentTimeMillis());
        return res;
    }

    @GetMapping(value = "/time")
    public String time() {
        return String.valueOf(System.currentTimeMillis());
    }
}
