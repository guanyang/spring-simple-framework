${rootArtifactId}
====

依赖说明
----

模块序号 | 模块定义 | 模块说明 | 依赖序号 | 备注
--- | --- | --- | --- | ---
1 | ${rootArtifactId}-util | 业务工具组件| ~ | 【非必须】工具精炼抽象，多处使用
2 | ${rootArtifactId}-dao | 业务db操作组件 | ~ | 【建议添加】只有db相关操作
3 | ${rootArtifactId}-common | 外围依赖服务聚合组件 | 1 | 【建议添加】方便抽象成SDK
4 | ${rootArtifactId}-admin-api | 后台服务接口契约定义 | ~ | 【非必须】方便扩展rpc
5 | ${rootArtifactId}-service-api | 对外服务接口契约定义| ~ | 【建议添加】方便扩展rpc
6 | ${rootArtifactId}-service-java| 对外服务应用 | 1，2，3，5 | 【建议添加】应用服务进程
7 | ${rootArtifactId}-admin-java | 后台服务应用 | 1，2，3，4 | 【非必须】管理后台，跟对外服务应用隔离

> ${rootArtifactId}-admin-java应用可选，根据业务规模决策是否需要隔离部署，小应用可以将admin和service合并

maven依赖管理
----
- 【强制】所有依赖包版本管理定义在parent工程<dependencyManagement>模块中，避免版本多处定义出现不一致的情况
- 【强制】parent工程不要直接定义<dependencies>模块，避免所有子模块都会依赖，增加包体积

功能说明
----
- 统一架构分层结构定义，方便扩展及治理
- 统一返回对象定义，让API更专业优雅，参考`Response`
- API统一异常、错误码规范定义，更方便识别错误及管理，参考`ApiBizException`
- 统一全局异常处理器，参考`ServiceExceptionHandler`
- 引入`mybatis plus`中间件，支持代码自动生成及数据源常用配置，代码自动生成参考`MybatisAutoGeneratorHelper`
  - 支持`hikari`连接池，优化数据库连接属性配置
  - 支持乐观锁、逻辑删除及读写分离配置
- 支持csrf、xss安全加固，参考示例`TestController`
  - 在需要csrf验证的Controller方法加上`@CsrfCheck`注解
  - 请求对象需要添加`@Valid`或者`@Validated`注解才会进行xss校验
- 支持traceid和日志切面记录方法调用日志，参考示例`TestController`
  - 标准化日志输出，记录调用者IP、服务器IP、入参出参，方便快速定位问题
  - 日志`@LogTrace`支持类、方法层级定义

快速使用指南【重点】
----
- 初次启动【${rootArtifactId}-service-java】，需要调整数据源配置，否则启动报错，后台admin工程类似
  - 初始化示例SQL: ${rootArtifactId}-dao/src/test/resources/test-init.sql，将其导入数据库进行调试【可选】
  - 数据源配置路径：${rootArtifactId}-service-java/src/main/resources/application-live.yml
- 该框架已经默认引入`mybatis plus`中间件，支持代码自动生成及数据源常用配置
  - 代码自动生成入口：${rootArtifactId}-dao/src/test/java/${package}.dao/MybatisAutoGeneratorHelper.java
  - mybatis-plus常用配置入口：${rootArtifactId}-dao/src/main/resources/application.yml，一般不需要修改，默认即可
- 代码自动生成使用说明，只需要调整以下变量即可，其他可以保持不变，入口类：`MybatisAutoGeneratorHelper`
  - url：数据源地址
  - username：数据库用户名
  - password：数据库密码
  - author：代码生成者名字，仅作标识而已，可随意指定
  - tableNames：要生成的数据库表名，可以指定多个