#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gy.framework.core.exception.ErrorCodeI;

/**
 * 异常码定义
 */
@AllArgsConstructor
@Getter
public enum BizCode implements ErrorCodeI {

    /**
     *
     */
    USER_STATUS_ERROR(300, "请登录"),
    USER_STATUS_BANNED(300, "账号被封禁"),
    MOBILE_USER_STATUS_ERROR(902, "登录状态错误"),
    XSS_ERROR(9000, "存在XSS风险"),
    CSRF_ERROR(9001, "请求校验不通过"),
    BAD_REQUEST_PARAM(1000, "输入的查询条件错误"),
    OBJECT_NOT_EXIST(1001, "对象不存在"),
    INNER_DATA_INVALID(1002, "内部数据不合法"),
    OPERATE_INVALID(1003, "网络繁忙，请稍后重试"),
    OTHER_SERVICE_RETURN_ERROR(1004, "依赖服务出现错误"),
    INNER_SERVICE_ERROR(1005, "内部工具处理异常"),
    GET_LOCK_FAIL(1006, "您点击的太快了，请稍后重试~"),
    CONFIG_ERROR(1007, "后台配置有误"),
    PARAM_ERROR(1008, "参数有误");

    private final int error;
    private final String msg;

}
