### spring-simple-demo

#### 依赖说明

模块序号 | 模块定义 | 模块说明 | 依赖序号 | 备注
--- | --- | --- | --- | ---
1 | spring-simple-demo-util | 业务工具组件| ~ | 【非必须】工具精炼抽象，多处使用
2 | spring-simple-demo-dao | 业务db操作组件 | ~ | 【建议添加】只有db相关操作
3 | spring-simple-demo-common | 外围依赖服务聚合组件 | 1 | 【建议添加】方便抽象成SDK
4 | spring-simple-demo-admin-api | 后台服务接口契约定义 | ~ | 【非必须】方便扩展rpc
5 | spring-simple-demo-service-api | 对外服务接口契约定义| ~ | 【建议添加】方便扩展rpc
6 | spring-simple-demo-service-java| 对外服务应用 | 1，2，3，5 | 【建议添加】应用服务进程
7 | spring-simple-demo-admin-java | 后台服务应用 | 1，2，3，4 | 【非必须】管理后台，跟对外服务应用隔离

> spring-simple-demo-admin-java应用可选，根据业务规模决策是否需要隔离部署，小应用可以将admin和service合并

#### maven依赖管理
- 【强制】所有依赖包版本管理定义在parent工程<dependencyManagement>模块中，避免版本多处定义出现不一致的情况
- 【强制】parent工程不要直接定义<dependencies>模块，避免所有子模块都会依赖，增加包体积