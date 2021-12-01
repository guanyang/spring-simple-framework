package org.gy.framework.demo.dao.enums;

import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum implements StdEnum {

    //正常枚举
    NO(0, "正常"),
    //删除枚举
    YES(1, "删除");

    private final Integer code;

    private final String desc;

    public static DeletedEnum codeOf(Integer code, DeletedEnum defaultType) {
        return Stream.of(values()).filter(item -> item.code.equals(code)).findFirst().orElse(defaultType);
    }


}
