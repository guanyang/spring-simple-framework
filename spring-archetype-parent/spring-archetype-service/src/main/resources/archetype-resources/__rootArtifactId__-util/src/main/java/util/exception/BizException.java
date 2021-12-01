#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util.exception;


import lombok.Getter;
import org.gy.framework.core.exception.CommonException;
import org.gy.framework.core.exception.ErrorCodeI;

/**
 * 功能描述：业务异常定义
 *
 * @author gy
 * @version 1.0.0
 */
@Getter
public class BizException extends CommonException {

    private static final long serialVersionUID = 8062627211396897571L;

    public BizException(ErrorCodeI errorCodeI) {
        super(errorCodeI);
    }

    public BizException(ErrorCodeI errorCodeI, String msg) {
        super(errorCodeI, msg);
    }

    public BizException(ErrorCodeI errorCodeI, Throwable e) {
        super(errorCodeI, e);
    }

    public BizException(ErrorCodeI errorCodeI, String msg, Throwable e) {
        super(errorCodeI, msg, e);
    }

    public BizException(int error, String msg) {
        super(error, msg);
    }
}
