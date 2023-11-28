package com.zwds.controller;

import com.zwds.pojo.Star;
import com.zwds.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class StarController {
    @Autowired
    private StarService starService;

    @GetMapping("/test")
    public List<Star> only(){
        return starService.selectAllStar();

    }

    @GetMapping("/test/api")
    public String only1(){
        return "hello";

    }
}
