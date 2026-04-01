package com.cc.reggie.controller;

import com.cc.reggie.common.R;
import com.cc.reggie.dto.ChatRequest;
import com.cc.reggie.dto.ChatResponse;
import com.cc.reggie.entity.ChatRecord;
import com.cc.reggie.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 智能客服控制器
 */
@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    /**
     * 发送消息获取 AI 回复
     */
    @PostMapping("/send")
    public R<ChatResponse> send(@RequestBody ChatRequest chatRequest,
                                 @RequestHeader(value = "userId", required = false) Long userId) {
        try {
            log.info("用户 {} 发送消息：{}", userId, chatRequest.getQuestion());
            
            if (userId == null) {
                userId = 1L; // 默认用户 ID
            }
            
            String sessionId = chatRequest.getSessionId();
            if (sessionId == null || sessionId.trim().isEmpty()) {
                sessionId = "session_" + userId + "_" + System.currentTimeMillis();
            }
            
            ChatResponse response = chatService.chat(userId, sessionId, chatRequest.getQuestion());
            return R.success(response);
        } catch (Exception e) {
            log.error("发送消息失败", e);
            return R.error("系统异常：" + e.getMessage());
        }
    }

    /**
     * 获取聊天记录
     */
    @GetMapping("/history")
    public R<List<ChatRecord>> getHistory(@RequestParam String sessionId) {
        log.info("获取会话 {} 的聊天记录", sessionId);
        List<ChatRecord> history = chatService.getChatHistory(sessionId);
        return R.success(history);
    }
}
