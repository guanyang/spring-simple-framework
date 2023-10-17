package org.gy.framework.demo.service.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Data
public class TestRequestDTO implements Serializable {

    private static final long serialVersionUID = 6414947705434436435L;

    @NotNull(message = "name不能为空")
    @Length(min = 2, max = 32, message = "name字符数只能介于2~32之间")
    private String name;

}
