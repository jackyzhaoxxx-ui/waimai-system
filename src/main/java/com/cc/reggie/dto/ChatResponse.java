package com.cc.reggie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 聊天响应 DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
    
    /**
     * AI 回复内容
     */
    private String answer;
    
    /**
     * 会话 ID
     */
    private String sessionId;
}
