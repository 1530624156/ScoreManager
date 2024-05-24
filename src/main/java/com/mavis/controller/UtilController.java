package com.mavis.controller;

import com.mavis.utils.HttpUtils;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UtilController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/24 20:47
 */
@Slf4j
@RestController
@RequestMapping("util")
public class UtilController {
    @Resource
    private HttpUtils httpUtils;
    @PostMapping("sendEmail")
    public RestResult sendEmail(String mailReceive, String mailTitle, String mailContent ,boolean isHtml) {
        Boolean b = httpUtils.sendEmailApi(mailReceive, mailTitle, mailContent, isHtml);
        return RestResult.neutrality(b);
    }
}
