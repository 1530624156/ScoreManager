package com.mavis.controller;

import com.mavis.entity.Student;
import com.mavis.logic.StudentLogic;
import com.mavis.service.StudentService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * StudentController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:01
 */
@Slf4j
@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    private StudentLogic studentLogic;

    /**
     * 获取所有学生信息
     * @return
     */
    @GetMapping("getallstudent")
    public RestResult getAllStudent(){
        List<Student> students = studentService.list();
        return RestResult.success(students);
    }




}
