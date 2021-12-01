package org.gy.framework.demo.service.api.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
@Data
public class TestRequestDTO implements Serializable {

    private static final long serialVersionUID = 6414947705434436435L;
    
    private String name;

}
