package org.gy.framework.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 简单演示表
 * </p>
 *
 * @author gy
 * @since 2021-11-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hello_world")
public class HelloWorld extends Model<HelloWorld> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 版本号
     */
    @Version
    private Integer version;

    /**
     * 删除状态，0正常 1删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 编辑人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String VERSION = "version";

    public static final String DELETED = "deleted";

    public static final String CREATE_BY = "create_by";

    public static final String UPDATE_BY = "update_by";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
