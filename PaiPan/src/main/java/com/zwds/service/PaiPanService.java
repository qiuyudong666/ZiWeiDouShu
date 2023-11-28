package com.zwds.service;

import com.zwds.pojo.Gong;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public interface PaiPanService {

    LinkedHashMap<String, Gong> OtherStars(LinkedHashMap<String, Gong> map, String ii,int it, String shen,int or);
    LinkedHashMap<String, Gong> initGong();
    String mingGongIndex(int month,int day);

    String shenGongIndex(int month,int day);

    String getWuXingJu(int gong,int niangan);

    String getTianGan(int gong,int niangan);

    String getZiWei(int gong,int niangan);

    LinkedHashMap<String, Gong> getZiWeiZhuXing(LinkedHashMap<String, Gong> map,int ii);
    LinkedHashMap<String, Gong> getTianFuZhuXing(LinkedHashMap<String, Gong> map,int ii);
    LinkedHashMap<String, Gong> getHuoLing(LinkedHashMap<String, Gong> map,int ii,int ok);
    LinkedHashMap<String, Gong> getYueXing(LinkedHashMap<String, Gong> map,int ii, int it);

    LinkedHashMap<String, Gong> getGanXing(LinkedHashMap<String, Gong> map,int ii);

    LinkedHashMap<String, Gong> getZhiXing(LinkedHashMap<String, Gong> map,int ii);
    LinkedHashMap<String, Gong> getJiangQian(LinkedHashMap<String, Gong> map,int ii);
    LinkedHashMap<String, Gong> getSuiQian(LinkedHashMap<String, Gong> map,int ii);
    LinkedHashMap<String, Gong> getChangSheng(LinkedHashMap<String, Gong> map,int ii,int or);
    LinkedHashMap<String, Gong> getXiaoXian(LinkedHashMap<String, Gong> map,int ii,String or);
    LinkedHashMap<String, Gong> getBoShi(LinkedHashMap<String, Gong> map,int ii,int or);
    int getIndex(String str);
    String getZhitoIndex(int index);
    String getYinYangIndex(String str,String sex);

    public Map<String, String> getZhuStarIndex(String idx);
}
