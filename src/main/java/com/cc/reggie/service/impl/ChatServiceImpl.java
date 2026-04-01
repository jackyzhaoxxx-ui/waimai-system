package com.cc.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.reggie.common.CustomException;
import com.cc.reggie.dto.ChatResponse;
import com.cc.reggie.entity.ChatRecord;
import com.cc.reggie.mapper.ChatRecordMapper;
import com.cc.reggie.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 智能客服服务实现
 */
@Slf4j
@Service
public class ChatServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements ChatService {

    @Value("${reggie.ai.system-prompt:你是一个外卖系统的智能客服助手}")
    private String systemPrompt;

    @Value("${reggie.ai.enabled:false}")
    private boolean aiEnabled;

    @Value("${reggie.ai.api-key:}")
    private String apiKey;

    @Value("${reggie.ai.api-url:}")
    private String apiUrl;

    @Value("${reggie.ai.model:Qwen/Qwen2.5-Coder-32B-Instruct}")
    private String model;

    // 预设的常见问题回复
    private static final Map<String, String> FAQ_MAP = new HashMap<>();
    
    static {
        FAQ_MAP.put("配送", "我们的配送时间一般为 30-45 分钟，具体取决于您的距离和订单量。高峰期可能略有延迟，敬请谅解！");
        FAQ_MAP.put("运费", "配送费为 6 元，满 50 元免配送费哦！");
        FAQ_MAP.put("支付", "我们支持微信支付、支付宝等多种支付方式，您可以在下单时选择。");
        FAQ_MAP.put("退款", "如需退款，请在订单页面申请退款，我们会在 1-3 个工作日内处理。");
        FAQ_MAP.put("优惠", "新用户注册即送 18 元红包！每日签到也可领取优惠券。关注我们的公众号还有更多惊喜活动！");
        FAQ_MAP.put("推荐", "我们的招牌菜有：宫保鸡丁、鱼香肉丝、麻婆豆腐，都是顾客们的好评菜品哦！");
        FAQ_MAP.put("营业", "我们的营业时间为每天 10:00-22:00，欢迎您光临！");
        FAQ_MAP.put("电话", "我们的客服电话是 400-123-4567，工作时间为 9:00-21:00。");
        FAQ_MAP.put("地址", "我们的店铺地址位于 XX 路 XX 号，欢迎您到店品尝！");
        FAQ_MAP.put("发票", "您可以在订单完成后申请开具电子发票，发票将发送到您的邮箱。");
    }

    @Override
    public ChatResponse chat(Long userId, String sessionId, String question) {
        if (userId == null || question == null || question.trim().isEmpty()) {
            throw new CustomException("参数错误");
        }

        try {
            String answer;
            // 如果启用了 AI 大模型，则调用 API
            if (aiEnabled && apiKey != null && !apiKey.isEmpty()) {
                answer = callAiApi(question);
            } else {
                // 否则使用本地关键词匹配
                answer = getSmartAnswer(question);
            }

            // 保存聊天记录
            try {
                ChatRecord record = new ChatRecord();
                record.setUserId(userId);
                record.setSessionId(sessionId);
                record.setQuestion(question);
                record.setAnswer(answer);
                this.save(record);
            } catch (Exception e) {
                log.warn("保存聊天记录失败：{}", e.getMessage());
                // 保存失败不影响返回结果
            }

            return new ChatResponse(answer, sessionId);
        } catch (Exception e) {
            log.error("AI 回复失败", e);
            // 异常时的默认回复
            String fallbackAnswer = "您好，我是智能客服助手，暂时无法回答您的问题。如有紧急问题，请拨打客服电话：400-123-4567";
            
            return new ChatResponse(fallbackAnswer, sessionId);
        }
    }

    /**
     * 获取智能回复（模拟 AI）
     * 实际项目中可以集成真实的 AI 服务如 OpenAI、通义千问等
     */
    private String getSmartAnswer(String question) {
        String lowerQuestion = question.toLowerCase();
        
        // 匹配关键词
        for (Map.Entry<String, String> entry : FAQ_MAP.entrySet()) {
            if (lowerQuestion.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        
        // 通用回复
        return getRandomGeneralAnswer(question);
    }

    /**
     * 调用 AI 大模型 API
     * 支持 DeepSeek、OpenAI、通义千问等兼容 OpenAI 格式的 API
     */
    private String callAiApi(String question) {
        try {
            // 构建请求体
            java.util.Map<String, Object> requestBody = new java.util.HashMap<>();
            requestBody.put("model", model);
            
            // 构建消息列表
            java.util.List<java.util.Map<String, String>> messages = new java.util.ArrayList<>();
            
            // 系统消息
            java.util.Map<String, String> systemMsg = new java.util.HashMap<>();
            systemMsg.put("role", "system");
            systemMsg.put("content", systemPrompt);
            messages.add(systemMsg);
            
            // 用户消息
            java.util.Map<String, String> userMsg = new java.util.HashMap<>();
            userMsg.put("role", "user");
            userMsg.put("content", question);
            messages.add(userMsg);
            
            requestBody.put("messages", messages);
            requestBody.put("temperature", 0.7); // 温度参数，控制回复的创造性
            requestBody.put("max_tokens", 1000); // 最大 token 数
            
            // 设置请求头
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Authorization", "Bearer " + apiKey);
            
            // 创建 HTTP 请求实体
            org.springframework.http.HttpEntity<java.util.Map<String, Object>> entity = 
                new org.springframework.http.HttpEntity<>(requestBody, headers);
            
            // 创建 RestTemplate
            org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
            
            log.info("调用 AI API: {}", apiUrl);
            
            // 发送 POST 请求
            org.springframework.http.ResponseEntity<Map> responseEntity = 
                restTemplate.postForEntity(apiUrl, entity, Map.class);
            
            Map response = responseEntity.getBody();
            log.info("AI API 响应状态码：{}", responseEntity.getStatusCode());
            
            if (response != null) {
                // 解析响应
                if (response.containsKey("choices") && !((java.util.List) response.get("choices")).isEmpty()) {
                    java.util.List choices = (java.util.List) response.get("choices");
                    Map firstChoice = (Map) choices.get(0);
                    Map message = (Map) firstChoice.get("message");
                    
                    if (message != null && message.containsKey("content")) {
                        String answer = (String) message.get("content");
                        log.info("AI API 回复：{}", answer);
                        return answer;
                    }
                }
                
                // 检查是否有错误信息
                if (response.containsKey("error")) {
                    Map error = (Map) response.get("error");
                    String errorMsg = error.containsKey("message") ? (String) error.get("message") : "未知错误";
                    log.error("AI API 返回错误：{}", errorMsg);
                    throw new CustomException("AI 服务异常：" + errorMsg);
                }
            }
            
            log.warn("无法解析 AI API 响应，使用本地回复");
            return getSmartAnswer(question);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            log.error("调用 AI API 失败：{}", e.getMessage(), e);
            // 失败时返回本地回复
            return getSmartAnswer(question);
        }
    }

    /**
     * 获取通用回复
     */
    private String getRandomGeneralAnswer(String question) {
        String[] answers = {
            "感谢您的咨询！我已经记录了您的问题，会尽快为您解答。请问还有其他可以帮助您的吗？",
            "您好！关于这个问题，建议您查看我们的帮助中心，里面有详细的使用说明。当然，如果您需要人工客服，也可以告诉我哦！",
            "收到您的问题啦！我正在努力学习中，希望能给您更准确的回答。目前可以先参考一下我们的常见问题解答哦！",
            "非常抱歉，我还没有完全理解您的问题。您可以换个方式描述一下，或者联系我们的客服热线：400-123-4567"
        };
        Random random = new Random();
        return answers[random.nextInt(answers.length)];
    }

    @Override
    public List<ChatRecord> getChatHistory(String sessionId) {
        LambdaQueryWrapper<ChatRecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ChatRecord::getSessionId, sessionId)
                .orderByAsc(ChatRecord::getCreateTime);
        return this.list(queryWrapper);
    }
}
