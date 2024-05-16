package com.mavis.logic;

import com.mavis.entity.Admin;
import com.mavis.mapper.AdminMapper;
import com.mavis.service.AdminService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * AdminLogic
 * 管理员逻辑
 * @author Mavis郭逸轩
 * @since 2024/5/9 10:20
 */
@Component
public class AdminLogic {

    @Resource
    private AdminService adminService;
    @Resource
    private AdminMapper adminMapper;

    public Admin adminLogin(HashMap<String, String> paramap) {
        Admin admin = adminMapper.adminLogin(paramap);
        return admin;
    }
}
