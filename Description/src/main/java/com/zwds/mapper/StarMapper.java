package com.zwds.mapper;

import com.zwds.pojo.Star;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StarMapper {
    public List<Star> selectAllStar();
}
