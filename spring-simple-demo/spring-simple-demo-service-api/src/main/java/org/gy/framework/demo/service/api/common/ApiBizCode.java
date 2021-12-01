package org.gy.framework.demo.service.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gy.framework.core.exception.ErrorCodeI;

/**
 * 异常码定义
 * @author gy
 */
@AllArgsConstructor
@Getter
public enum ApiBizCode implements ErrorCodeI {

    /**
     *
     */
    USER_STATUS_ERROR(1000, "请登录"),
    USER_STATUS_BANNED(1001, "账号被封禁"),
    INNER_DATA_INVALID(1002, "内部数据不合法"),
    OPERATE_INVALID(1003, "网络繁忙，请稍后重试"),
    OTHER_SERVICE_RETURN_ERROR(1004, "依赖服务出现错误"),
    INNER_SERVICE_ERROR(1005, "内部工具处理异常"),
    XSS_ERROR(9000, "存在XSS风险"),
    CSRF_ERROR(9001, "请求校验不通过");

    private final int error;
    private final String msg;

}
