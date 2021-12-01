#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.api.service;

import org.gy.framework.core.dto.Response;
import ${package}.service.api.dto.TestRequestDTO;
import ${package}.service.api.dto.TestResponseDTO;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
public interface TestService {

    Response<TestResponseDTO> test(TestRequestDTO dto);

}
