### spring-archetype-parent

#### 目标
1. 基于工程命名不够规范，制定工程命名规约，提升识别性
2. 规范技术架构定义，方便后续可读性、维护性及扩展性
3. 规范模块结构定义，方便新人快速理解上手
4. 降低架构初始化及常用组件的接入成本，提升研发效率

#### 相关文档
- [Maven Archetype搭建模板工程](https://note.xcloudapi.com/2021/11/22/Maven-Archetype%E6%90%AD%E5%BB%BA%E6%A8%A1%E6%9D%BF%E5%B7%A5%E7%A8%8B/)

#### 基于模板创建应用
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
```
初始化版本
```