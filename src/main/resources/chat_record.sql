-- 智能客服聊天记录表
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
