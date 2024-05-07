package com.mavis.logic;

import com.mavis.entity.Student;
import com.mavis.mapper.StudentMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * StudentLogic
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:22
 */

@Component
public class StudentLogic {

    @Resource
    private StudentMapper studentMapper;

    //学生登录逻辑
    public Student studentLogin(String sid, String password){
        HashMap<String, String> paramap = new HashMap<>();
        paramap.put("sid", sid);
        paramap.put("password", password);
        Student student = studentMapper.studentLogin(paramap);
        return student;
    }
}
