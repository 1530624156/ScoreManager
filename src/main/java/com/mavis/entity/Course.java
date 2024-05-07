package com.mavis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Course
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 9:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("course")
public class Course {
    //课程编号
    @TableId("cid")
    private String cid;
    //课程名
    @TableField("cname")
    private String cname;
    //学年
    @TableField("schoolyear")
    private String schoolyear;
    //学期
    @TableField("semester")
    private String semester;
    //学分
    @TableField("credit")
    private Float credit;

}
