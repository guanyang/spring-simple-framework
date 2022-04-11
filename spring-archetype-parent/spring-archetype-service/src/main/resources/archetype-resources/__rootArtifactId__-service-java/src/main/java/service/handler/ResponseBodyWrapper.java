#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.handler;

import java.util.Objects;
import org.gy.framework.core.dto.BaseResponse;
import org.gy.framework.core.dto.Response;
import ${package}.service.ServiceJavaApplication;
import ${package}.service.annotation.Primitive;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回结果统一包装处理
 *
 * @author gy
 * @version 1.0.0
 */
@RestControllerAdvice(basePackageClasses = ServiceJavaApplication.class)
public class ResponseBodyWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return Objects.requireNonNull(returnType.getMethod()).getAnnotation(Primitive.class) == null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
        Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        if (body instanceof BaseResponse) {
            return body;
        }
        return Response.asSuccess(body);
    }
}