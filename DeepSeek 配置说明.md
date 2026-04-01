# DeepSeek AI 智能客服配置说明

## ✅ 已完成配置

### 1. API 配置信息
- **API Key**: sk-e40988c271424dd0af781a40a59fffea
- **API URL**: https://api.deepseek.com/v1/chat/completions
- **模型**: deepseek-chat
- **状态**: 已启用 (enabled: true)

### 2. 配置文件位置
`src/main/resources/application.yml`

### 3. 主要修改内容
```yaml
reggie:
  ai:
    enabled: true  # 启用 AI 大模型
    api-key: sk-e40988c271424dd0af781a40a59fffea  # DeepSeek API Key
    api-url: https://api.deepseek.com/v1/chat/completions  # DeepSeek API 地址
    model: deepseek-chat  # DeepSeek 对话模型
    system-prompt: 你是一个外卖系统的智能客服助手...
```

## 🚀 启动步骤

### 方式一：使用 PowerShell 脚本（推荐）
```powershell
.\启动智能客服.ps1
```

### 方式二：手动启动
```bash
# 1. 编译项目
mvn clean install -DskipTests

# 2. 启动应用
mvn spring-boot:run
```

### 方式三：IDE 直接运行
在 IDE 中运行 `ReggieApplication.java`

## 📝 测试方法

### 1. 访问前端页面
浏览器打开：http://localhost:8080/front/index.html

### 2. 进入客服聊天
- 登录系统
- 点击右上角用户头像
- 选择"联系客服"

### 3. 测试问题示例
```
配送费多少钱？
有什么优惠活动？
推荐几个招牌菜
如何申请退款？
你们的营业时间是什么？
```

## 🔍 验证 API 是否工作

### 查看日志
启动后，当你发送消息时，应该能看到类似日志：
```
调用 AI API: https://api.deepseek.com/v1/chat/completions
AI API 响应状态码：200
AI API 回复：[DeepSeek 的回复内容]
```

### 常见问题排查

#### 1. API Key 无效
- 检查 API Key 是否正确复制
- 确认 API Key 是否有余额
- 访问 DeepSeek 控制台查看密钥状态

#### 2. 网络连接问题
- 检查是否能访问 https://api.deepseek.com
- 确认防火墙设置
- 尝试使用代理（如果需要）

#### 3. API 调用失败
查看控制台错误信息，可能的原因：
- API Key 余额不足
- 请求格式错误
- 网络超时

## 💡 DeepSeek API 特点

### 支持的参数
- **temperature**: 0.7 (控制回复创造性，范围 0-2)
- **max_tokens**: 1000 (最大输出长度)
- **messages**: 对话历史（包含 system 和 user 角色）

### 响应格式
```json
{
  "choices": [
    {
      "message": {
        "role": "assistant",
        "content": "回复内容"
      }
    }
  ]
}
```

## 🎯 优化建议

### 1. 调整回复风格
修改 `application.yml` 中的 `system-prompt`：
```yaml
system-prompt: |
  你是一个专业的外卖系统客服，请：
  1. 使用友好、热情的语气
  2. 回答简洁明了，不超过 200 字
  3. 优先推荐店内活动
  4. 引导用户下单
```

### 2. 调整回复长度
修改 `max_tokens` 参数：
```java
requestBody.put("max_tokens", 500); // 减少或增加回复长度
```

### 3. 调整创造性
修改 `temperature` 参数：
```java
requestBody.put("temperature", 0.5); // 更稳定但较死板
requestBody.put("temperature", 1.0); // 更有创意但不稳定
```

## 📊 监控用量

### DeepSeek 用量查询
访问 DeepSeek 官网控制台查看：
- 剩余余额
- 调用次数
- Token 使用量

### 本地日志监控
查看控制台输出的 API 调用日志，了解调用频率

## ⚠️ 注意事项

1. **API 余额**: 定期检查余额，避免欠费
2. **调用频率**: 注意 API 调用限制
3. **错误处理**: 代码已实现降级方案，API 失败时自动切换到本地回复
4. **日志记录**: 所有对话都会保存到数据库 chat_record 表

## 🎉 完成！

现在你的智能客服已经接入 DeepSeek 大模型，可以开始测试了！

如有问题，请查看控制台日志或联系开发者。
