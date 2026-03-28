package top.zrwang.week03.service.impl;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.zrwang.week03.config.SmsConfig;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Lenovo
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final SmsConfig smsConfig;

    @Override
    public String sendSms(String phone) {
        // 1. 生成 4 位验证码
        String code = String.valueOf(new Random().nextInt(9000) + 1000);
        log.info("生成验证码：{}，手机号：{}", code, phone);

        try {
            // 2. 初始化容联云 SDK（全部硬编码）
            CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
            restAPI.init("app.cloopen.com", "8883"); // 服务器地址+端口
            restAPI.setAccount(
                    "2c94811c9ac8c114019d055bc5532907", // 你的 accountSid
                    "24b6fa04203f4386882b2a250577a70c"  // 你的 accountToken
            );
            restAPI.setAppId("2c94811c9ac8c114019d055bc5c9290e"); // 你的 appId

            // 3. 发送模板短信（修正参数格式）
            HashMap<String, Object> result = restAPI.sendTemplateSMS(
                    phone,
                    "1", // 你的模板 ID
                    new String[]{code, "5"} // 验证码 + 有效期（均为 1-4 位数字）
            );

            // 4. 解析结果
            String statusCode = (String) result.get("statusCode");
            if ("000000".equals(statusCode)) {
                log.info("短信发送成功，手机号：{}", phone);
                return code;
            } else {
                log.error("短信发送失败，错误码：{}，错误信息：{}", statusCode, result.get("statusMsg"));
                throw new RuntimeException("短信发送失败：" + result.get("statusMsg"));
            }
        } catch (Exception e) {
            log.error("短信发送异常：", e);
            throw new RuntimeException("短信发送异常：" + e.getMessage());
        }
    }
}