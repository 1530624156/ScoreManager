package com.mavis.controller;

import com.mavis.entity.Score;
import com.mavis.logic.ScoreLogic;
import com.mavis.service.ScoreService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ScoreController
 *
 * @author Mavis郭逸轩
 * @since 2024/5/6 10:00
 */
@Slf4j
@RestController
@RequestMapping("score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;
    @Resource
    private ScoreLogic scoreLogic;

    /**
     * 获取所有成绩
     * @return
     */
    @GetMapping("getallscore")
    public RestResult getAllScore(){
        List<Score> scores = scoreService.list();
        return RestResult.success(scores);
    }
}
