package com.mavis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * SessionController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/24 14:19
 */
@Slf4j
@RestController
public class SessionController {

    @RequestMapping("SetSession")
    public Boolean setSession(String key, String data, HttpServletRequest request) {
        request.getSession().setAttribute(key,data);
        return true;
    }

    @RequestMapping("GetSession")
    public String getSession(String key, HttpServletRequest request) {
        String data = (String) request.getSession().getAttribute(key);
        return data;
    }
}
