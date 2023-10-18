## spring-simple-framework架构

### 概述
- SSF(spring simple framework)架构的宗旨是：**简单**、**快速**、**稳定**。
- 好的应用架构，都遵循一些共同模式，不管是六边形架构、洋葱圈架构、整洁架构、还是COLA架构，都提倡以业务为核心，解耦外部依赖，分离业务复杂度和技术复杂度等。

### SSF架构目标
1. 基于工程命名不够规范的现状，制定工程命名规约，提升识别性。
2. 规范技术架构定义，方便后续可读性、维护性及扩展性。
3. 规范模块结构定义，方便新人快速理解上手。
4. 降低架构初始化及常用组件的接入成本，提升研发效率。
5. 基于命令行快速创建标准化应用模块，简单高效。

### SSF框架能力
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

### SSF架构源码
- Github源码：https://github.com/guanyang/spring-simple-framework

### 模块说明
- spring-archetype-parent：archetype模板工程，用来创建后端服务的`archetype`
- spring-simiple-demo：archetype模板源码，基于源码可以优化升级模板工程

### 应用架构
![应用架构](doc/系统架构图.png)

### 依赖组件
- 当前工程依赖了一些常用组件，避免重复造轮子，代码结构更统一，可以提升研发效率
- 组件源码参考：[guanyang/spring-base-parent](https://github.com/guanyang/spring-base-parent)

| 组件模块(artifactId)  | 说明          | 备注                                                     |
|-------------------|-------------|--------------------------------------------------------|
| spring-base-core  | 基础核心定义      | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-util  | 常用工具类合集     | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-csrf  | csrf组件      | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-sign  | 接口签名组件      | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-xss   | 接口参数xss校验组件 | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-lock  | 分布式锁组件      | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-log   | 日志组件        | [参考文档](https://github.com/guanyang/spring-base-parent) |
| spring-base-limit | 限流组件        | [参考文档](https://github.com/guanyang/spring-base-parent) |


### 快速使用指南
#### 环境配置
- JDK 11+
- Spring Boot 2.7.16+
- Mybatis Plus 3.5.3.1+

#### 应用工程架构

![应用工程架构](doc/系统依赖图.png)

#### 模块定义说明

| 模块序号 | 模块定义              | 模块说明       | 依赖序号    | 备注                  |
|------|-------------------|------------|---------|---------------------|
| 1    | demo-util         | 业务工具组件     | ~       | 【非必须】工具精炼抽象，多处使用    |
| 2    | demo-dao          | 业务db操作组件   | ~       | 【建议添加】只有db相关操作      |
| 3    | demo-common       | 外围依赖服务聚合组件 | 1       | 【建议添加】方便抽象成SDK      |
| 4    | admin-api         | 后台服务接口契约定义 | ~       | 【非必须】方便扩展rpc        |
| 5    | demo-service-api  | 对外服务接口契约定义 | ~       | 【建议添加】方便扩展rpc       |
| 6    | demo-service-java | 对外服务应用     | 1，2，3，5 | 【建议添加】应用服务进程        |
| 7    | demo-admin-java   | 后台服务应用     | 1，2，3，4 | 【非必须】管理后台，跟对外服务应用隔离 |

> demo-admin-java应用可选，根据业务规模决策是否需要隔离部署，小应用可以将admin和service合并

#### 相关依赖
- 本工程依赖[guanyang/spring-base-parent](https://github.com/guanyang/spring-base-parent) 相关组件
- 将`spring-base-parent`下载到本地，执行`mvn clean install -Dmaven.test.skip=true`，将相关组件生成到本地

#### 基于模板创建应用
- 将archetype模板生成到本地
```
mvn clean install -Dmaven.test.skip=true
```
- 基于archetype模板创建工程，命令如下：

``` 
mvn archetype:generate  \
    -DgroupId=org.gy.framework \					//替换成自定义groupId
    -DartifactId=spring-demo-01 \					//替换成自定义artifactId
    -Dversion=1.0.0-SNAPSHOT \					//替换成自定义version				
    -Dpackage=org.gy.framework.demo \			//替换成自定义package路径
    -DarchetypeArtifactId=spring-archetype-service \		//该模板已经上传私服，直接使用
    -DarchetypeGroupId=org.gy.framework \
    -DarchetypeVersion=1.0.0-SNAPSHOT
``` 
#### 本地调试开发
- 初次启动【xxx-service-java】，需要调整数据源配置，否则启动报错
  - 数据源配置路径：xxx-service-java/src/main/resources/application-live.yml
- 该框架已经默认引入`mybatis plus`中间件，支持代码自动生成及数据源常用配置
  - 代码自动生成入口：xxx-dao/src/test/java/${package}.dao/MybatisAutoGeneratorHelper.java
  - mybatis-plus常用配置入口：xxx-service-java/src/main/resources/application.yml，一般不需要修改，默认即可
- 代码自动生成使用说明，只需要调整以下变量即可，其他可以保持不变，入口类：`MybatisAutoGeneratorHelper`
  - url：数据源地址
  - username：数据库用户名
  - password：数据库密码
  - author：代码生成者名字，仅作标识而已，可随意指定
  - tableNames：要生成的数据库表名，可以指定多个

### 后续规划
- 常用中间件引入（redis、RocketMQ、apollo、sentinel）

### 相关文档
- [Maven Archetype搭建模板工程](https://note.xcloudapi.com/2021/11/22/Maven-Archetype%E6%90%AD%E5%BB%BA%E6%A8%A1%E6%9D%BF%E5%B7%A5%E7%A8%8B/)
- [Alibaba COLA](https://github.com/alibaba/COLA)