package top.zrwang.week03.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zrwang.week03.service.impl.SmsService;

/**
 * @author Lenovo
 * @date
 * @description
 */
@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @GetMapping("/send")
    public String sendSms(@RequestParam String phone) {
        return smsService.sendSms(phone);
    }
}