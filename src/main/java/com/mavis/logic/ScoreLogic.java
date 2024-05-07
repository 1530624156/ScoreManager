package com.mavis.logic;

import com.mavis.entity.Score;
import com.mavis.mapper.ScoreMapper;
import com.mavis.service.ScoreService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ScoreLogic
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:26
 */
@Component
public class ScoreLogic {
    @Resource
    private ScoreService scoreService;
    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 添加成绩
     * @param score
     * @return
     */
    public Boolean addScore(Score score){
        String uuid = UUID.randomUUID().toString();
        score.setUuid(uuid);
        boolean result = scoreService.save(score);
        return result;
    }
}
