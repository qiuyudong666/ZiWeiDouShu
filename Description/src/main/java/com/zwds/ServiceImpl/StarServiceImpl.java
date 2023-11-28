package com.zwds.ServiceImpl;

import com.zwds.mapper.StarMapper;
import com.zwds.pojo.Star;
import com.zwds.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper starMapper;

    @Override
    public List<Star> selectAllStar() {
        return starMapper.selectAllStar();
    }
}
