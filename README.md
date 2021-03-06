
# TinyURL

## 项目简介

TinyURL 项目是一个短网址服务，主要功能是将长网址转成短网址，方便在社交网络上传播。

从需求上来讲，粗略来看是一个很简单的项目，但是在不同用户场景下，却不是那么简单。做这个项目的初衷是为了找一个简单的业务来练习构建一个高并发高性能的SAAS服务，其中需要将微服务、分布式、云原生、CI/CD等技术应用进去；从这个层面来讲，我要构建的是一个能应对百万级并发甚至更高并发的系统，而不是一个玩偶项目。

短链接服务的主要功能：
1. 短链接生成功能：给定一个长链接生成一个非常短的可访问链接（短链接是否过期作为优化特性）
2. 短链接跳转功能：在访问短链接时可以跳转到原地址
3. 短链接反查功能：使用短链接可以查询出原链接
4. 访问分析功能：网址缩短可对来源网站、IP、浏览器等许多信息进行收集和统计（http://tongji.rrd.me/etpxR，https://www.ft12.com/）
5. 风控功能：可以针对有害网站进行跳转前的过滤和警告（自建网址黑名单，恶意网址检测等）
6. API 开放接口
7. Web端访问

## 技术选型

- Gradle 构建工具
- Spring Boot
- Spring REST
- Spring Data JPA
- MySql
- ReactJs + Redux
- Docker Compose
- Kubernetes

## 本地构建

开发环境本地构建说明

## 领域对象

核心领域模型

## 测试策略

单元测试、集成测试(组件测试)、API测试等如何处理

## 技术架构

技术架构图

模块划分：

```
-/
  - links-api
  - links-svc
  - analysis-api
  - analysis-svc
  - tiny-bootstrap
  - frontend/
    - app
```

## 部署架构

部署架构图

## 外部依赖

列出项目所依赖的其他系统，比如订单系统依赖于会员系统。

## 环境信息

列出各个环境的访问方式，数据库连接等。

## 编码实践

常用的公共编码方式

#### 小工具

- [adr-tools](https://github.com/npryce/adr-tools/blob/master/INSTALL.md) [轻量级架构决策记录](https://www.thoughtworks.com/radar/techniques/lightweight-architecture-decision-records)工具
- 文档自动生成

文档分为两类：API文档和类库文档。
1. API文档的自动生成代表是 Swagger, apidoc 等，这些工具可以直接嵌入到项目的代码中，代码和文档一起维护
2. 类库文档可以选择 Javadoc，需要遵守一定的规范
3. sphinx 文档工具，这个常用在Python项目中

## FAQ

常见问题列表

- 如何做好迭代0？

请参考:
1. [开发实践-开发者的迭代0](https://insights.thoughtworks.cn/backend-development-iteration0/)
2. [迭代0：启动开发之前你应该准备什么](https://time.geekbang.org/column/article/77294)
3. [一个好的项目自动化应该是什么样子的](https://time.geekbang.org/column/article/86561)

代码仓库模版参考：
1. [geektime-zero](https://github.com/dreamhead/geektime-zero)
2. [ecommerce-order-service](https://github.com/e-commerce-sample/ecommerce-order-service)
