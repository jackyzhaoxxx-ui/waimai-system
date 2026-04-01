package com.cc.reggie.dto;

import lombok.Data;

/**
 * 聊天请求 DTO
 */
@Data
public class ChatRequest {
    
    /**
     * 用户问题
     */
    private String question;
    
    /**
     * 会话 ID
     */
    private String sessionId;
}
