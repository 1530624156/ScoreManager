package com.mavis.entity.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("scoreinfo")
public class Scoreinfo implements Serializable {
    @TableField("uuid")
    private String uuid;
    @TableField("sid")
    private String sid;
    @TableField("cid")
    private String cid;
    @TableField("score")
    private Double score;
    @TableField("name")
    private String name;
    @TableField("cname")
    private String cname;
    @TableField("credit")
    private Double credit;
    @TableField("xnxq")
    private String xnxq;
}