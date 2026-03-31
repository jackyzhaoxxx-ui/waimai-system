package com.cc.reggie.utils;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SMSUtils {

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret)
                .setEndpoint("dysmsapi.aliyuncs.com");
        // 访问的域名
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    /**
     * 发送短信
     *
     * @param phoneNumbers
     * @param param
     * @throws Exception
     */
    public static void sendMessage(String phoneNumbers, String param) throws Exception {
        // 使用环境变量或配置文件中的凭证，不要硬编码
        String accessKeyId = System.getenv("ALIYUN_ACCESS_KEY_ID");
        String accessKeySecret = System.getenv("ALIYUN_ACCESS_KEY_SECRET");
        com.aliyun.dysmsapi20170525.Client client = SMSUtils
                .createClient(accessKeyId, accessKeySecret);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phoneNumbers) //目标手机号
                .setSignName("传智播客") //签名名称
                .setTemplateCode("SMS_204761533") //短信模板code
                .setTemplateParam("{\"code\":\"" + param + "\"}");//模板中变量替换
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody();
        // code = OK 代表成功
        System.out.println(body.getCode() + "  " + body.getMessage());
    }

    /**
     * 测试方法
     *
     * @param args_
     * @throws Exception
     */
    public static void main(String[] args_) throws Exception {
        sendMessage("13531201154", "666888");
    }
}