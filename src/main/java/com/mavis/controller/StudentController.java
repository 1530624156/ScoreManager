package com.mavis.controller;

import com.alibaba.fastjson.JSONObject;
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
        Long count = (long) students.size();
        return RestResult.success(students,count,null,0);
    }

    /**
     * 根据学号获取学生信息
     * @param sid 学号
     * @return
     */
    @GetMapping("getstudentbysid")
    public RestResult getStudentBySid(String sid) {
        if(StringUtils.isBlank(sid)){
            return RestResult.fail("学号不能为空");
        }
        Student student = studentService.getById(sid);
        return RestResult.success(student);
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

    /**
     * 学生登出
     * @param session
     * @return
     */
    @PostMapping("logout")
    public RestResult studentLogout(HttpSession session){
        if (session == null) {
            return RestResult.fail("会话不存在或已失效");
        }
        session.removeAttribute("student");
        session.removeAttribute("admin");
        session.removeAttribute("sid");
        return RestResult.success("学生登出成功");
    }

    /**
     * 添加学生
     * @param student 学生
     * @return
     */
    @PostMapping("addstudent")
    public RestResult addStudent(Student student){
        if (student == null){
            return RestResult.fail("传入参数不能为空");
        }
        try {
            boolean b = studentService.save(student);
            return RestResult.neutrality(b);
        }catch(Exception e){
            return RestResult.fail("添加失败");
        }

    }

    /**
     * 根据学号删除学生
     * @param sid 学号
     * @return
     */
    @PostMapping("deletestudentbysid")
    public RestResult deleteStudentBySid(String sid){
        boolean b = StringUtils.isBlank(sid);
        if (b){
            return RestResult.fail("传入学号不能为空");
        }
        boolean result = studentService.removeById(sid);
        return RestResult.neutrality(result);
    }

    /**
     * 更新学生信息
     * @param student 学生实体
     * @return
     */
    @PostMapping("updatestudent")
    public RestResult updateStudent(Student student){
        if (student == null){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = studentService.updateById(student);
        return RestResult.neutrality(result);
    }

}
