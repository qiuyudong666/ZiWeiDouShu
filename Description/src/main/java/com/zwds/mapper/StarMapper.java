package com.zwds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwds.pojo.Star;

import java.util.List;


public interface StarMapper extends BaseMapper<Star> {
    public List<Star> selectAllStar();
}
