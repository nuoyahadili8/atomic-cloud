<p align="center">
  <img src="https://img.shields.io/badge/Avue-1.5.4-green.svg" alt="Build Status">
  <img src="https://img.shields.io/badge/Spring%20Cloud-EdgwareSR4-orange.svg" alt="Coverage Status">
  <img src="https://img.shields.io/badge/Spring%20Boot-1.5.15-blue.svg" alt="Downloads">
  <img src="https://img.shields.io/npm/v/npm.svg" alt="Version">
  <img src="https://img.shields.io/npm/l/vue.svg" alt="License">
</p>

# Atomic Microservice Architecture
---
**项目基于Spring Cloud、OAuth2.0、Vue的前后端分离的权限管理系统，其中将注册中心、配置中心统一使用zookeeper。**

 ### 模块说明
``` lua
atomic
├── pig-auth -- 授权服务提供[3000]
├── pig-common -- 系统公共模块 
├── pig-gateway -- ZUUL网关[9999]
├── pig-modules -- 微服务模块
     ├── pig-upms-service -- 权限管理提供[4000]
     └── 
```
### 功能列表
- 完善登录：账号密码模式、短信验证码模式、社交账号模式均整合Spring security oAuth
- 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 机构管理：配置系统组织机构，树结构展现，可随意调整上下级。
- 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- 动态路由：基于zuul实现动态路由，后端可配置化。
- 终端管理：动态配置oauth终端，后端可配置化。
- 字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否等。
- 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- 服务限流：多种维度的流量控制（服务、IP、用户等）
- 消息总线：配置动态实时刷新
- 分库分表：shardingdbc分库分表策略
- 数据权限: 使用mybatis对原查询做增强，业务代码不用控制，即可实现。
- 消息中心：短信、邮件模板发送，几行代码实现发送
- 聚合文档：基于zuul实现 swagger各个模块的实现
- 代码生成：前后端代码的生成，支持Vue
- 缓存管理：基于Cache Cloud 保证Redis 的高可用
- 服务监控: Spring Boot Admin

### 项目实施
- 依赖环境：MySQL、Redis、RabbitMQ、Zookeeper
- 配置文件：atomic-common → resources → config
- 刷新zk配置：执行com.github.atomic.common.zkConfig.RefreshZkConfig
- 获取token：http://localhost:9999/auth/oauth/token?username=admin&password=123456&grant_type=password&scope=server&client_id=atomic&client_secret=atomic
- 项目启动顺序：atomic-auth（AuthApplication） → atomic-upms-service（AtomicAdminApplication）→ atomic-gateway（AtomicGatewayApplication）
- 自动代码生成工具类：com.github.atomic.admin.common.util.AtomicResourcesGenerator，注意修改对应的数据库信息。
- 服务发布：如果不走前端发布，需要在sys_zuul_route表中增加对应的服务模块，同时在sys_menu中增加/demo/api/**的相关记录。如果觉得麻烦就注释掉：PermissionServiceImpl中的urls.stream().filter()代码段。
