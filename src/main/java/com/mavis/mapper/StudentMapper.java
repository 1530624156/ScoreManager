package com.mavis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mavis.entity.Student;

import java.util.HashMap;

/**
 * StudentMapper
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:03
 */
public interface StudentMapper extends BaseMapper<Student> {

    Student studentLogin(HashMap paramap);
}
