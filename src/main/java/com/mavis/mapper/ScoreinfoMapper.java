package com.mavis.mapper;

import com.mavis.entity.vo.Scoreinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
* @author Administrator
* @description 针对表【scoreinfo】的数据库操作Mapper
* @createDate 2024-05-27 15:34:33
* @Entity com.mavis.entity.vo.Scoreinfo
*/
public interface ScoreinfoMapper extends BaseMapper<Scoreinfo> {

    List<Scoreinfo> getScoreInfoBySid(HashMap paramap);

}




