### srping-simple-framework模块介绍

#### 模块说明
- spring-archetype-parent：archetype模板工程
- spring-simiple-demo：archetype模板源码

#### 目标
1. 基于工程命名不够规范，制定工程命名规约，提升识别性
2. 规范技术架构定义，方便后续可读性、维护性及扩展性
3. 规范模块结构定义，方便新人快速理解上手
4. 降低架构初始化及常用组件的接入成本，提升研发效率

#### 相关文档
- [Maven Archetype搭建模板工程](https://note.xcloudapi.com/2021/11/22/Maven-Archetype%E6%90%AD%E5%BB%BA%E6%A8%A1%E6%9D%BF%E5%B7%A5%E7%A8%8B/)

#### 相关依赖
- 本工程依赖https://github.com/guanyang/spring-base-parent相关组件
- 将依赖工程clone到本地，执行`mvn clean install`，将相关组件生成到本地

#### 基于模板创建应用
- 将archetype模板生成到本地
```
mvn clean install
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

#### Change Log
##### 1.0.0-SNAPSHOT
- 统一架构分层结构定义，方便扩展及治理
- API统一异常、错误码规范定义，参考ApiBizException
- 统一全局异常处理器，参考ServiceExceptionHandler
- 引入`mybatis plus`中间件，支持代码自动生成及数据源常用配置，代码自动生成参考`MybatisAutoGeneratorHelper`
- 支持csrf、xss安全加固，参考示例`TestController`