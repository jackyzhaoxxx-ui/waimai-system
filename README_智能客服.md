# 🤖 外卖系统 - 智能客服模块

> 一个基于 Spring Boot + Vue.js 的智能客服系统，专为后端面试设计

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.4.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Vue.js](https://img.shields.io/badge/Vue.js-2.x-green.svg)](https://vuejs.org/)
[![MyBatis-Plus](https://img.shields.io/badge/MyBatis--Plus-3.4.2-blue.svg)](https://baomidou.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📖 项目简介

这是一个为外卖系统添加的智能客服模块，可以作为 Spring AI 应用示范项目，非常适合用于后端岗位面试。

### 核心功能

✅ **智能问答** - 基于关键词匹配的 AI 智能回复  
✅ **聊天历史** - 自动保存聊天记录，支持查看历史对话  
✅ **快捷问题** - 预设常见问题，一键快速提问  
✅ **友好界面** - 现代化的聊天界面，实时消息展示  

## 🚀 快速开始

### 方式一：使用启动脚本（推荐）

```powershell
# 在 PowerShell 中执行
.\启动智能客服.ps1
```

### 方式二：手动启动

#### 1. 创建数据库表

```sql
-- 执行以下 SQL 创建聊天记录表
CREATE TABLE IF NOT EXISTS `chat_record` (
    `id` bigint(20) NOT NULL COMMENT '主键 ID',
    `user_id` bigint(20) DEFAULT NULL COMMENT '用户 ID',
    `question` text COMMENT '用户问题',
    `answer` text COMMENT 'AI 回答',
    `session_id` varchar(100) DEFAULT NULL COMMENT '会话 ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `deleted` int(11) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    KEY `idx_session_id` (`session_id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='智能客服聊天记录';
```

#### 2. 编译项目

```bash
mvn clean install -DskipTests
```

#### 3. 启动应用

```bash
mvn spring-boot:run
```

或在 IDE 中运行 `ReggieApplication.java`

#### 4. 访问系统

浏览器访问：http://localhost:8080/front/index.html

## 📋 使用流程

1. **登录系统** → 使用已有账号或注册新账号
2. **进入个人中心** → 点击右上角用户头像
3. **点击"联系客服"** → 进入聊天界面
4. **开始对话** → 输入问题或点击快捷问题

### 测试示例

| 提问 | 预期回复 |
|------|----------|
| 配送费多少钱？ | 配送费为 6 元，满 50 元免配送费哦！ |
| 有什么优惠活动？ | 新用户注册即送 18 元红包！每日签到也可领取优惠券... |
| 推荐几个招牌菜 | 我们的招牌菜有：宫保鸡丁、鱼香肉丝、麻婆豆腐... |
| 如何申请退款？ | 如需退款，请在订单页面申请退款，我们会在 1-3 个工作日内处理。 |

## 🏗️ 技术架构

### 后端技术栈

- **Spring Boot 2.4.5** - 核心框架
- **MyBatis-Plus 3.4.2** - ORM 框架
- **MySQL** - 数据库
- **Spring AI** - AI 集成（模拟实现，可扩展）

### 前端技术栈

- **Vue.js 2.x** - 渐进式 JavaScript 框架
- **Vant UI** - 移动端组件库
- **Axios** - HTTP 客户端

### 项目结构

```
waimai program/
├── src/main/java/com/cc/reggie/
│   ├── entity/              # 实体类
│   │   └── ChatRecord.java
│   ├── mapper/              # 数据访问层
│   │   └── ChatRecordMapper.java
│   ├── dto/                 # 数据传输对象
│   │   ├── ChatRequest.java
│   │   └── ChatResponse.java
│   ├── service/             # 业务逻辑层
│   │   ├── ChatService.java
│   │   └── impl/ChatServiceImpl.java
│   └── controller/          # 控制器
│       └── ChatController.java
├── src/main/resources/
│   ├── front/
│   │   ├── page/chat.html   # 聊天页面
│   │   └── api/chat.js      # 聊天 API
│   └── chat_record.sql      # 建表脚本
├── pom.xml                  # Maven 配置
└── application.yml          # 应用配置
```

## 📚 文档说明

| 文档名称 | 说明 |
|---------|------|
| [智能客服说明.md](智能客服说明.md) | 完整的功能说明和部署指南 |
| [智能客服测试指南.md](智能客服测试指南.md) | 详细的测试步骤和问题排查 |
| [智能客服项目总结.md](智能客服项目总结.md) | 项目总结和面试要点 |

## 💡 面试加分点

### 技术能力展示

- ✅ Spring Boot 整合能力
- ✅ MyBatis-Plus 使用
- ✅ MySQL 数据库设计
- ✅ Vue.js 前端开发
- ✅ RESTful API 设计
- ✅ AI 应用集成概念

### 工程化思维

- ✅ 代码分层清晰
- ✅ 注释规范详细
- ✅ 异常处理完善
- ✅ 日志记录合理
- ✅ 文档齐全

### 产品思维

- ✅ 用户体验优先
- ✅ 快捷问题设计
- ✅ 降级方案完备
- ✅ 可扩展性强

## 🔧 扩展升级

### 集成真实 AI 服务

当前使用的是模拟 AI 回复，可以轻松替换为真实的 AI 服务：

```java
// 在 ChatServiceImpl.java 中
@Autowired
private ChatClient chatClient; // Spring AI 的 ChatClient

public ChatResponse chat(Long userId, String sessionId, String question) {
    String answer = chatClient.prompt()
            .system(systemPrompt)
            .user(question)
            .call()
            .content();
    return new ChatResponse(answer, sessionId);
}
```

### 可配置 API Key

在 `application.yml` 中配置：

```yaml
reggie:
  ai:
    openai:
      api-key: your-api-key-here
      base-url: https://api.openai.com/v1
```

## ❓ 常见问题

### Q1: 依赖下载失败怎么办？

A: Spring AI 依赖可能下载失败，可以暂时注释掉，因为当前使用的是模拟 AI 回复。

```xml
<!-- 可以暂时注释 -->
<!--
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-openai</artifactId>
    <version>1.0.0-M4</version>
</dependency>
-->
```

### Q2: 端口被占用怎么办？

A: 在 `application.yml` 中修改端口号：

```yaml
server:
  port: 8081  # 改为其他端口
```

### Q3: 如何清除聊天记录？

A: 执行 SQL 清空表：

```sql
TRUNCATE TABLE chat_record;
```

### Q4: 面试时如何演示？

A: 建议流程：
1. 介绍功能（1 分钟）
2. 现场演示对话（2 分钟）
3. 讲解技术架构（2 分钟）
4. 说明扩展方向（1 分钟）

详细请参考 [智能客服测试指南.md](智能客服测试指南.md#面试演示建议)

## 🎯 适用场景

- ✅ 后端岗位面试项目
- ✅ Spring Boot 学习实践
- ✅ 全栈开发练习
- ✅ AI 应用 demo
- ✅ 毕业设计项目模块

## 📝 更新日志

### v1.0.0 (2026-03-31)

- ✅ 初始版本发布
- ✅ 完整的智能客服功能
- ✅ 前后端分离架构
- ✅ 详细的文档说明
- ✅ 快速启动脚本

## 🤝 贡献指南

如果你有任何建议或问题，欢迎提 Issue 或 Pull Request。

## 📄 License

本项目采用 MIT 协议开源。

---

## 🌟 最后的话

这个项目展示了从需求分析、技术选型、系统设计到编码实现的完整过程。虽然目前使用的是模拟 AI，但它提供了一个可扩展的架构，可以轻松集成真实的 AI 服务。

**祝你面试顺利，拿到理想的 Offer！🎉**

---

**开发者**: AI Assistant  
**完成时间**: 2026-03-31  
**版本**: v1.0.0
