#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.gy.framework.core.exception.Assert;
import org.gy.framework.core.support.IStdEnum;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum implements IStdEnum<Integer> {

    //正常枚举
    NO(0, "正常"),
    //删除枚举
    YES(1, "删除");

    private final Integer code;

    private final String desc;

    public static DeletedEnum codeOf(Integer code, DeletedEnum defaultType) {
        return IStdEnum.codeOf(DeletedEnum.class, code, defaultType);
    }

    public static DeletedEnum codeOf(Integer code) {
        DeletedEnum deletedEnum = codeOf(code, null);
        Assert.notNull(deletedEnum, "unknown DeletedEnum code:" + code);
        return deletedEnum;
    }


}
