package com.mavis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mavis.entity.Student;
import com.mavis.logic.StudentLogic;
import com.mavis.service.StudentService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
//@SessionAttributes("student")
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

    /**
     * 学生登录
     * @param sid 学号
     * @param password 密码
     * @return
     */
    @PostMapping("login")
    public RestResult studentLogin(String sid, String password, HttpSession session){
        if (StringUtils.isBlank(sid) || StringUtils.isBlank(password)){
            return RestResult.fail("学号和密码均不能为空");
        }
        Student student = studentLogic.studentLogin(sid, password);
        if (student != null){
            session.setAttribute("student", student);
            return RestResult.success(student);
        }else {
            return RestResult.fail("登录失败");
        }
    }

}
