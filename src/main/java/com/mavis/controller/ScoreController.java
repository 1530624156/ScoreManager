package com.mavis.controller;

import com.mavis.entity.Score;
import com.mavis.entity.vo.Scoreinfo;
import com.mavis.logic.ScoreLogic;
import com.mavis.mapper.ScoreMapper;
import com.mavis.mapper.ScoreinfoMapper;
import com.mavis.service.ScoreService;
import com.mavis.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
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
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private ScoreinfoMapper scoreinfoMapper;

    /**
     * 获取所有成绩
     * @return
     */
    @GetMapping("getallscore")
    public RestResult getAllScore(){
        List<Score> scores = scoreService.list();
        return RestResult.success(scores);
    }

    /**
     * 根据uuid获取成绩信息
     * @param uuid
     * @return
     */
    @GetMapping("getscorebyuuid")
    public RestResult getScoreByUuid(String uuid){
        if (uuid == null){
            return RestResult.fail("传入参数不能为空");
        }
        Score score = scoreService.getById(uuid);
        return RestResult.success(score);
    }

    /**
     * 添加成绩
     * @param score
     * @return
     */
    @PostMapping("addscore")
    public RestResult addScore(Score score){
        if (score == null){
            return RestResult.fail("传入参数不能为空");
        }
        Boolean result = scoreLogic.addScore(score);
        return RestResult.neutrality(result);
    }

    /**
     * 根据成绩uuid删除成绩
     * @param uuid
     * @return
     */
    @PostMapping("deletescorebyuuid")
    public RestResult deleteScoreByUuid(String uuid){
        if (uuid == null){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = scoreService.removeById(uuid);
        return RestResult.success(result);
    }

    /**
     * 根据uuid修改成绩信息
     * @param score
     * @return
     */
    @PostMapping("updatescore")
    public RestResult updateScore(Score score){
        if (score == null){
            return RestResult.fail("传入参数不能为空");
        }
        boolean result = scoreService.updateById(score);
        return RestResult.success(result);
    }

    /**
     * 根据学号获取成绩列表
     * @param sid 学号
     * @return 成绩列表
     */
    @GetMapping("getscorebysid")
    public RestResult getScoreBySid(String sid){
        HashMap<String, String> map = new HashMap<>();
        map.put("sid",sid);
        List<Scoreinfo> scores = scoreinfoMapper.getScoreInfoBySid(map);
        return RestResult.success(scores);
    }


}
