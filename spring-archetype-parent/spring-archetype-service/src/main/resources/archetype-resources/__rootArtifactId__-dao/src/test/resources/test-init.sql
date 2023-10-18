CREATE TABLE `hello_world` (
   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
   `version` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '版本号',
   `deleted` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '删除状态，0正常 1删除',
   `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
   `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '编辑人',
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='演示表';