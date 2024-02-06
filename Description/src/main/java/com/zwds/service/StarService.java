package com.zwds.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwds.pojo.Star;

import java.util.List;

public interface StarService extends IService<Star>{
    public List<Star> selectAllStar();
}
