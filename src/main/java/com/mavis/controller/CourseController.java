package com.mavis.controller;

import com.mavis.entity.Course;
import com.mavis.logic.CourseLogic;
import com.mavis.service.CourseService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * CourseController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:00
 */
@Slf4j
@RestController
@RequestMapping("course")
public class CourseController {

    @Resource
    private CourseService courseService;
    @Resource
    private CourseLogic courseLogic;

    /**
     * 获取所有课程信息
     * @return
     */
    @GetMapping("getallcourse")
    public RestResult getAllCourse(){
        List<Course> courses = courseService.list();
        return RestResult.success(courses);
    }





}
