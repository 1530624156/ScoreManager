package com.mavis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mavis.entity.Admin;
import com.mavis.logic.AdminLogic;
import com.mavis.mapper.AdminMapper;
import com.mavis.service.AdminService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * AdminController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/9 10:11
 */
@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController{
    @Resource
    private AdminService adminService;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private AdminLogic adminLogic;

    /**
     * 管理员登录
     * @param adminname
     * @param adminpassword
     * @return
     */
    @PostMapping("login")
    public RestResult adminLogin(String adminname, String adminpassword, HttpSession session){
        if (StringUtils.isBlank(adminname) || StringUtils.isBlank(adminpassword)){
            return RestResult.fail("用户名或密码不能为空");
        }
        HashMap<String, String> paramap = new HashMap<>();
        paramap.put("adminname", adminname);
        paramap.put("adminpassword", adminpassword);
        Admin admin = adminLogic.adminLogin(paramap);
        if (admin == null){
            return RestResult.fail("登录失败");
        }else {
            session.setAttribute("admin", admin);
            return RestResult.success(admin);
        }
    }

    /**
     * 管理员登出
     * @param session
     * @return
     */
    @PostMapping("logout")
    public RestResult adminLogout(HttpSession session){
        if(session == null){
            // 可以选择抛出异常或返回错误信息
            return RestResult.fail("会话已失效或不存在");
        }
        session.removeAttribute("admin");
        return RestResult.success("登出成功");
    }






}
