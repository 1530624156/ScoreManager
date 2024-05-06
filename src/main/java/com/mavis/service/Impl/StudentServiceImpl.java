package com.mavis.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mavis.entity.Student;
import com.mavis.mapper.StudentMapper;
import com.mavis.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * StudentServiceImpl
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:02
 */
@Service
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService{

}
