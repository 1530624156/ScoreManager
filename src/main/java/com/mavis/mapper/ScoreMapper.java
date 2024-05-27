package com.mavis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mavis.entity.Score;

import java.util.HashMap;
import java.util.List;

/**
 * ScoreMapper
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:05
 */
public interface ScoreMapper extends BaseMapper<Score> {
    List<Score> getScoreBySid(HashMap paramap);
}
