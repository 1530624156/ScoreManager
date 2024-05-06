package com.mavis.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mavis.entity.Score;
import com.mavis.mapper.ScoreMapper;
import com.mavis.service.ScoreService;
import org.springframework.stereotype.Service;

/**
 * ScoreServiceImpl
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:05
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
}
