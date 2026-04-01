/**
 * 智能客服 API
 */

// 发送消息获取 AI 回复
async function chatSendApi(params) {
    const userId = JSON.parse(sessionStorage.getItem('user')).id;
    return request({
        url: '/chat/send',
        method: 'post',
        data: params,
        headers: {
            'userId': userId
        }
    })
}

// 获取聊天记录
async function chatHistoryApi(params) {
    return request({
        url: '/chat/history',
        method: 'get',
        params: params
    })
}
