package com.mavis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mavis.entity.Admin;

import java.util.HashMap;

/**
 * AdminMapper
 *
 * @author Mavis郭逸轩
 * @since 2024/5/9 10:18
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin adminLogin(HashMap paramap);
}
