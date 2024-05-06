package com.mavis.controller;

import com.mavis.logic.ScoreLogic;
import com.mavis.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
