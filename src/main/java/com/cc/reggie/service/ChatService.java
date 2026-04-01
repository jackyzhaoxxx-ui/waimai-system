package com.cc.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.reggie.dto.ChatRequest;
import com.cc.reggie.dto.ChatResponse;
import com.cc.reggie.entity.ChatRecord;

import java.util.List;

/**
 * 智能客服服务
 */
public interface ChatService extends IService<ChatRecord> {
    
    /**
     * 发送消息并获取 AI 回复
     * @param userId 用户 ID
     * @param sessionId 会话 ID
     * @param question 用户问题
     * @return AI 回复
     */
    ChatResponse chat(Long userId, String sessionId, String question);
    
    /**
     * 获取用户的聊天记录
     * @param sessionId 会话 ID
     * @return 聊天记录列表
     */
    List<ChatRecord> getChatHistory(String sessionId);
}
