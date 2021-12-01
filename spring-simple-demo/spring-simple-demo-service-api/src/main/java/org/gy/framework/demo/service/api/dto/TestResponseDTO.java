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
public class TestResponseDTO implements Serializable {

    private static final long serialVersionUID = -868368237208324028L;

    private String name;

    private Long time;

}
