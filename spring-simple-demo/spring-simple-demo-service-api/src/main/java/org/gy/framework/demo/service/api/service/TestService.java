package org.gy.framework.demo.service.api.service;

import org.gy.framework.core.dto.Response;
import org.gy.framework.demo.service.api.dto.TestRequestDTO;
import org.gy.framework.demo.service.api.dto.TestResponseDTO;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
public interface TestService {

    Response<TestResponseDTO> test(TestRequestDTO dto);

}
