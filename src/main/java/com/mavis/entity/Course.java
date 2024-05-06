package com.mavis.entity;

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
public class Course {
    String cid;
    String cname;
    //学年
    String schoolYear;
    //学期
    String semester;
    //学分
    Float credit;

}
