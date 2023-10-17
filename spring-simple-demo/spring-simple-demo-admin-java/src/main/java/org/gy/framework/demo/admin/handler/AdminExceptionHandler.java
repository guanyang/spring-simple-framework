package org.gy.framework.demo.admin.handler;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.gy.framework.core.dto.Response;
import org.gy.framework.core.exception.CommonException;
import org.gy.framework.demo.util.exception.BizCode;
import org.gy.framework.demo.util.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理
 * @author gy
 */
@RestControllerAdvice
@Slf4j
public class AdminExceptionHandler {

    /**
     * 处理一般异常。
     */
    @ExceptionHandler(Exception.class)
    public Response handle(Exception e) {
        log.error("全局异常处理：", e);
        return Response.asError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "网络繁忙，请稍后重试!");
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public Response handle(HttpClientErrorException e) {
        log.error("依赖服务调用失败：", e);
        return Response.asError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器繁忙，请稍后重试!");
    }


    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Response handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> errSet = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder("");
        for (ConstraintViolation constraintViolation : errSet) {
            strBuilder.append(constraintViolation.getMessage());
        }
        String msg = strBuilder.toString();
        log.info("接口数据验证异常: {}", msg);

        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), msg);

    }

    /**
     * 消息体解析异常返回处理
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public Response handleJsonParseException(HttpMessageConversionException e) {
        String msg = "解析消息体出现异常，请检查输入是否合法";
        log.info(msg + " : {}", e.getMessage());
        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), msg);
    }


    /**
     * 参数绑定异常返回处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleConstraintViolationException(MethodArgumentNotValidException e) {
        String msg = buildErrMsg(e.getBindingResult());
        log.info("参数绑定异常: {}", msg);
        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), msg);
    }

    /**
     * 处理参数类型不匹配异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response handleConstraintViolationException(MethodArgumentTypeMismatchException e) {
        String msg = String.format("参数类型不匹配: %s", e.getMessage());
        log.info("[MethodArgumentTypeMismatch]" + msg);
        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), BizCode.BAD_REQUEST_PARAM.getMsg());
    }

    /**
     * 错误处理：缺少请求参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.info(String.format("缺少请求参数: %s", e.getMessage()));
        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), BizCode.BAD_REQUEST_PARAM.getMsg());
    }

    /**
     * 参数绑定异常返回处理
     */
    @ExceptionHandler(BindException.class)
    public Response handleBindException(BindException e) {
        String msg = buildErrMsg(e.getBindingResult());
        log.info("参数绑定异常: {}", msg);
        return Response.asError(BizCode.BAD_REQUEST_PARAM.getError(), msg);
    }

    /**
     * METHOD_NOT_ALLOWED异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Response handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return Response.asError(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }

    /**
     * HttpMediaTypeException异常
     */
    @ExceptionHandler(HttpMediaTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleHttpMediaTypeException(HttpMediaTypeException e) {
        return Response.asError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 业务异常处理
     */
    @ExceptionHandler(BizException.class)
    public Response handleBizException(BizException e) {
        log.info("业务异常捕获: code={},msg={}", e.getError(), e.getMsg());
        return Response.asError(e.getError(), e.getMsg());
    }

    /**
     * 业务异常处理
     */
    @ExceptionHandler(CommonException.class)
    public Response handleCommonException(CommonException e) {
        log.info("[CommonException]业务异常捕获: code={},msg={}", e.getError(), e.getMsg());
        return Response.asError(e.getError(), e.getMsg());
    }

    private String buildErrMsg(BindingResult br) {
        List<ObjectError> errList = br.getAllErrors();
        StringBuilder strBuilder = new StringBuilder();

        for (ObjectError error : errList) {
            if (strBuilder.length() > 0) {
                strBuilder.append(" | ");
            }
            if (error instanceof FieldError) {
                strBuilder.append(((FieldError) error).getField());
            }
            strBuilder.append(error.getDefaultMessage());

        }

        if (strBuilder.length() > 90) {
            return "请求参数格式错误";
        }
        return strBuilder.toString();
    }
}
