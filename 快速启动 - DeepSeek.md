s# 🚀 DeepSeek AI 智能客服 - 快速启动指南

## ✅ 配置状态

| 项目 | 状态 | 值 |
|------|------|-----|
| API Key | ✅ 已配置 | `sk-e40988c271424dd0af781a40a59fffea` |
| API URL | ✅ 已配置 | `https://api.deepseek.com/v1/chat/completions` |
| 模型 | ✅ 已配置 | `deepseek-chat` |
| AI 功能 | ✅ 已启用 | `enabled: true` |
| 余额 | ℹ️ 约 | 3 元 |

---

## 🔥 三步启动（IDE 方式）

### Step 1: 打开 IDE
```
IntelliJ IDEA → File → Open → 选择项目根目录
```

### Step 2: 等待依赖下载
```
等待 Maven 下载完成（右下角进度条结束）
```

### Step 3: 运行应用
```
找到 ReggieApplication.java → 右键 Run
```

**访问**: http://localhost:8080/front/index.html

---

## 📱 测试流程

```
登录系统 → 点击右上角头像 → 联系客服 → 发送消息
```

### 推荐测试问题

```
1. 配送费多少钱？
2. 有什么优惠活动？
3. 推荐几个招牌菜
4. 如何申请退款？
5. 你们的营业时间是什么？
```

---

## 🔍 验证成功

### 查看日志输出

成功的日志应该包含：
```
✓ 调用 AI API: https://api.deepseek.com/v1/chat/completions
✓ AI API 响应状态码：200
✓ AI API 回复：[DeepSeek 的回复内容]
```

### 检查数据库

```sql
SELECT * FROM chat_record ORDER BY create_time DESC LIMIT 5;
```

---

## ⚠️ 环境问题解决

### 如果提示 "No compiler is provided"

**原因**: Maven 使用的是 JRE 而不是 JDK

**解决方案**:

#### 方案 A: 使用 IDE（最简单）
直接在 IntelliJ IDEA 或 Eclipse 中运行

#### 方案 B: 配置环境变量（永久解决）

以管理员身份运行 PowerShell：

```powershell
# 1. 设置 JAVA_HOME
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk1.8.0_202", "Machine")

# 2. 更新 PATH
$currentPath = [System.Environment]::GetEnvironmentVariable("PATH", "Machine")
[System.Environment]::SetEnvironmentVariable("PATH", "$currentPath;%JAVA_HOME%\bin", "Machine")
```

**重启终端**后再次运行启动脚本

---

## 💡 核心代码位置

| 文件 | 作用 | 路径 |
|------|------|------|
| application.yml | AI 配置 | `src/main/resources/` |
| ChatServiceImpl.java | 服务实现 | `src/main/java/com/cc/reggie/service/impl/` |
| ChatController.java | 控制器 | `src/main/java/com/cc/reggie/controller/` |
| ChatRecord.java | 实体类 | `src/main/java/com/cc/reggie/entity/` |

---

## 🎯 关键配置说明

### application.yml 配置项

```yaml
reggie:
  ai:
    enabled: true          # true=启用 AI, false=本地关键词匹配
    api-key: sk-xxx        # DeepSeek API Key
    api-url: https://...   # API 地址
    model: deepseek-chat   # 模型名称
    system-prompt: xxx     # 系统提示词（人设）
```

### ChatServiceImpl.java 参数

```java
requestBody.put("temperature", 0.7);    // 创造性：0-2，默认 0.7
requestBody.put("max_tokens", 1000);    // 最大长度限制
```

---

## 🛠️ 故障排查速查表

| 现象 | 可能原因 | 解决方案 |
|------|----------|----------|
| 编译失败 | 使用 JRE 而非 JDK | 在 IDE 中运行或配置 JAVA_HOME |
| API 调用失败 | 网络问题 | 检查网络连接，确认能访问 deepseek.com |
| 端口被占用 | 8080 已被使用 | 修改 application.yml 中的 port |
| 数据库连接失败 | MySQL 未启动 | 启动 MySQL 服务 |
| 回复都是本地答案 | AI 未启用 | 检查 enabled 是否为 true |

---

## 📊 监控建议

### 1. DeepSeek 用量
- 定期查看官网控制台
- 关注余额和 Token 消耗

### 2. 本地日志
- 查看 API 调用频率
- 监控错误信息

### 3. 数据库记录
- 聊天记录自动保存
- 可以分析用户常见问题

---

## 🎨 自定义优化

### 修改客服人设

编辑 `application.yml`:

```yaml
system-prompt: |
  你是一个热情专业的外卖客服，名叫"小智"。
  你的任务是帮助用户解决点餐、配送、优惠等问题。
  回答要求：
  - 语气亲切友好
  - 使用 emoji 表情 😊🍜🚀
  - 推荐招牌菜品
  - 引导用户下单
```

### 调整回复风格

编辑 `ChatServiceImpl.java`:

```java
// 更稳定的回复
requestBody.put("temperature", 0.3);

// 更有创意的回复  
requestBody.put("temperature", 1.2);
```

---

## 📞 技术支持

遇到问题时的检查顺序：

1. ✅ 检查 Java 环境 → `java -version`
2. ✅ 检查 Maven 环境 → `mvn -version`
3. ✅ 检查 MySQL 服务 → 服务管理器
4. ✅ 查看配置文件 → `application.yml`
5. ✅ 查看控制台日志 → 错误信息

---

## 🎉 完成！

一切准备就绪，现在就开始体验 DeepSeek AI 智能客服吧！

**祝你使用愉快！** 🚀
