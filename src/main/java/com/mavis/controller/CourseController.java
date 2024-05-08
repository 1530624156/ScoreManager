package com.mavis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mavis.entity.Course;
import com.mavis.logic.CourseLogic;
import com.mavis.service.CourseService;
import com.mavis.service.ScoreService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 根据cid获取课程信息
     * @param cid
     * @return
     */
    @GetMapping("getcoursebycid")
    public RestResult getCourseByCid(String cid){
        if (StringUtils.isBlank(cid)){
            return RestResult.fail("传入参数不能为空");
        }
        Course course = courseService.getById(cid);
        return RestResult.success(course);
    }


    /**
     * 添加课程信息
     * @param course
     * @return
     */
    @PostMapping("addcourse")
    public RestResult addCourse(Course course){
        if (course == null){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = courseService.save(course);
        return RestResult.neutrality(result);

    }

    /**
     * 根据cid删除课程信息
     * @param cid
     * @return
     */
    @PostMapping("deletecoursebycid")
    public RestResult deleteCoreseByCid(String cid){
        if (StringUtils.isBlank(cid)){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = courseService.removeById(cid);
        return RestResult.neutrality(result);
    }

    /**
     * 更新课程信息
     * @param course
     * @return
     */
    @PostMapping("updatecourse")
    public RestResult updateCourse(Course course){
        if (course == null){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = courseService.updateById(course);
        return RestResult.neutrality(result);
    }

}
