package com.mavis.entity;

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
public class Score {
    String sid;
    String cid;
    Float score;
}
