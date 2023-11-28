package com.zwds.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Gong {

    private String name;
    private String nickname;
    private String tianGan;
    private String diZhi;
    private String changsheng;
//    private String shengong;
    private List<String> zhuxing;
    private List<String> yuexing;
    private List<String> rixing;
    private List<String> shixing;

    private List<String> ganxing;
    private List<String> zhixing;
    private String boshixing;
    private String jiangqian;
    private String suiqian;
    private String daxian;
    private String xiaoxian;

}
