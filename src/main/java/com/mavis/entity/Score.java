package com.mavis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Score
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 9:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("score")
public class Score {
    @TableId("uuid")
    private String uuid;
    @TableField("sid")
    private String sid;
    @TableField("cid")
    private String cid;
    @TableField("score")
    private Float score;

    public Score(String sid, String cid, Float score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }
}