package com.mavis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Admin
 *
 * @author Mavis郭逸轩
 * @since 2024/5/9 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("admin")
public class Admin {
    @TableField("adminname")
    private String adminName;
    @TableField("adminpassword")
    private String adminPassword;
}
