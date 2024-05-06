package com.mavis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Student
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 9:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("student")
public class Student {
    @TableId("sid")
    String sid;
    @TableField("password")
    String password;
    @TableField("name")
    String name;
    @TableField("college")
    String college;
    @TableField("profession")
    String profession;
    @TableField("grade")
    String grade;

}
