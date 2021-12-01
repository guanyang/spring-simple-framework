package org.gy.framework.demo.service.api.common;


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
public class ApiBizException extends CommonException {

    private static final long serialVersionUID = 2536155274038760187L;


    public ApiBizException(ErrorCodeI errorCodeI) {
        super(errorCodeI);
    }

    public ApiBizException(ErrorCodeI errorCodeI, String msg) {
        super(errorCodeI, msg);
    }

    public ApiBizException(ErrorCodeI errorCodeI, Throwable e) {
        super(errorCodeI, e);
    }

    public ApiBizException(ErrorCodeI errorCodeI, String msg, Throwable e) {
        super(errorCodeI, msg, e);
    }

    public ApiBizException(int error, String msg) {
        super(error, msg);
    }
}
