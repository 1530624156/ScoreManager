package com.mavis.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mavis.entity.Course;
import com.mavis.mapper.CourseMapper;
import com.mavis.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * CourseServiceImpl
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:06
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
