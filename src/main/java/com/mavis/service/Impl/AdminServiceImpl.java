package com.mavis.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mavis.entity.Admin;
import com.mavis.mapper.AdminMapper;
import com.mavis.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * AdminServiceImpl
 *
 * @author Mavis郭逸轩
 * @since 2024/5/9 10:19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
