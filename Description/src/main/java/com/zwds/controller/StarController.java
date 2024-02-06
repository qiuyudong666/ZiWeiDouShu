package com.zwds.controller;

import com.zwds.pojo.Star;
import com.zwds.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StarController {
    @Autowired
    private StarService starService;

    @GetMapping("/api/test")
    public List<Star> only(){
        return starService.selectAllStar();

    }

    @PostMapping ("/api/save")
    public void save(@RequestBody Star star){
        star.setId(UUID.randomUUID().toString());
        starService.save(star);

    }
}
