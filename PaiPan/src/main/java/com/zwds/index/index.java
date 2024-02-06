package com.zwds.index;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class index {

    public String getYinYang(String tg) {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("甲", "阳");
        hashMap.put("乙", "阴");
        hashMap.put("丙", "阳");
        hashMap.put("丁", "阴");
        hashMap.put("戊", "阳");
        hashMap.put("己", "阴");
        hashMap.put("庚", "阳");
        hashMap.put("辛", "阴");
        hashMap.put("壬", "阳");
        hashMap.put("癸", "阴");
        return hashMap.get(tg);

    }
    public Integer getTianGanIndex(String tg) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("甲", 0);
        hashMap.put("乙", 1);
        hashMap.put("丙", 2);
        hashMap.put("丁", 3);
        hashMap.put("戊", 4);
        hashMap.put("己", 5);
        hashMap.put("庚", 6);
        hashMap.put("辛", 7);
        hashMap.put("壬", 8);
        hashMap.put("癸", 9);
        return hashMap.get(tg);

    }

    public Integer getTianGanIndexWXJ(String tg) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("甲", 0);
        hashMap.put("乙", 1);
        hashMap.put("丙", 2);
        hashMap.put("丁", 3);
        hashMap.put("戊", 4);
        hashMap.put("己", 0);
        hashMap.put("庚", 1);
        hashMap.put("辛", 2);
        hashMap.put("壬", 3);
        hashMap.put("癸", 4);
        return hashMap.get(tg);

    }



    public Integer getDiZhiIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("子", 0);
        hashMap.put("丑", 1);
        hashMap.put("寅", 2);
        hashMap.put("卯", 3);
        hashMap.put("辰", 4);
        hashMap.put("巳", 5);
        hashMap.put("午", 6);
        hashMap.put("未", 7);
        hashMap.put("申", 8);
        hashMap.put("酉", 9);
        hashMap.put("戌", 10);
        hashMap.put("亥", 11);
        return hashMap.get(dz);

    }

    public Integer getDiZhiIndexWXJ(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("子", 0);
        hashMap.put("丑", 0);
        hashMap.put("寅", 1);
        hashMap.put("卯", 1);
        hashMap.put("辰", 2);
        hashMap.put("巳", 2);
        hashMap.put("午", 3);
        hashMap.put("未", 3);
        hashMap.put("申", 4);
        hashMap.put("酉", 4);
        hashMap.put("戌", 5);
        hashMap.put("亥", 5);
        return hashMap.get(dz);

    }

    public Integer getYueIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("正月", 0);
        hashMap.put("二月", 1);
        hashMap.put("三月", 2);
        hashMap.put("四月", 3);
        hashMap.put("五月", 4);
        hashMap.put("六月", 5);
        hashMap.put("七月", 6);
        hashMap.put("八月", 7);
        hashMap.put("九月", 8);
        hashMap.put("十月", 9);
        hashMap.put("十一月", 10);
        hashMap.put("十二月", 11);
        return hashMap.get(dz);

    }

    public Integer getWuXingJuIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("水二局", 0);
        hashMap.put("木三局", 1);
        hashMap.put("金四局", 2);
        hashMap.put("土五局", 3);
        hashMap.put("火六局", 4);
        return hashMap.get(dz);

    }

    public Integer getDayIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("初一", 0);
        hashMap.put("初二", 1);
        hashMap.put("初三", 2);
        hashMap.put("初四", 3);
        hashMap.put("初五", 4);
        hashMap.put("初六", 5);
        hashMap.put("初七", 6);
        hashMap.put("初八", 7);
        hashMap.put("初九", 8);
        hashMap.put("初十", 9);
        hashMap.put("十一", 10);
        hashMap.put("十二", 11);
        hashMap.put("十三", 12);
        hashMap.put("十四", 13);
        hashMap.put("十五", 14);
        hashMap.put("十六", 15);
        hashMap.put("十七", 16);
        hashMap.put("十八", 17);
        hashMap.put("十九", 18);
        hashMap.put("二十", 19);
        hashMap.put("二一", 20);
        hashMap.put("二二", 21);
        hashMap.put("二三", 22);
        hashMap.put("二四", 23);
        hashMap.put("二五", 24);
        hashMap.put("二六", 25);
        hashMap.put("二七", 26);
        hashMap.put("二八", 27);
        hashMap.put("二九", 28);
        hashMap.put("三十", 29);
        return hashMap.get(dz);

    }

    public Integer getStarIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("紫微", 0);
        hashMap.put("天机", 1);
        hashMap.put("太阳", 2);
        hashMap.put("武曲", 3);
        hashMap.put("天同", 4);
        hashMap.put("廉贞", 5);
        hashMap.put("天府", 6);
        hashMap.put("太阴", 7);
        hashMap.put("贪狼", 8);
        hashMap.put("巨门", 9);
        hashMap.put("天相", 10);
        hashMap.put("天梁", 11);
        hashMap.put("七杀", 12);
        hashMap.put("破军", 13);
        hashMap.put("文昌", 14);
        hashMap.put("文曲", 15);
        hashMap.put("禄存", 16);
        hashMap.put("擎羊", 17);
        hashMap.put("陀罗", 18);
        hashMap.put("火星", 19);
        hashMap.put("铃星", 20);
        hashMap.put("左辅", 21);
        hashMap.put("右弼", 22);
        return hashMap.get(dz);

    }

    public Map<String, Integer> getStarIndex1() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("紫微", 0);
        hashMap.put("天机", 1);
        hashMap.put("太阳", 2);
        hashMap.put("武曲", 3);
        hashMap.put("天同", 4);
        hashMap.put("廉贞", 5);
        hashMap.put("天府", 6);
        hashMap.put("太阴", 7);
        hashMap.put("贪狼", 8);
        hashMap.put("巨门", 9);
        hashMap.put("天相", 10);
        hashMap.put("天梁", 11);
        hashMap.put("七杀", 12);
        hashMap.put("破军", 13);
        return hashMap;

    }

    public Integer getSexofYinYang(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("阳男", 0);
        hashMap.put("阴女", 0);
        hashMap.put("阴男", 1);
        hashMap.put("阳女", 1);

        return hashMap.get(dz);

    }

    public Integer getSex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("男", 0);
        hashMap.put("女", 1);

        return hashMap.get(dz);

    }
    public Integer getSanHeIndex(String dz) {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("寅", 0);
        hashMap.put("午", 0);
        hashMap.put("戌", 0);

        hashMap.put("申", 1);
        hashMap.put("子", 1);
        hashMap.put("辰", 1);

        hashMap.put("巳", 2);
        hashMap.put("酉", 2);
        hashMap.put("丑", 2);

        hashMap.put("亥", 3);
        hashMap.put("卯", 3);
        hashMap.put("未", 3);

        return hashMap.get(dz);

    }

    public Integer getHuoAndLing(String dz) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("火星", 0);
        hashMap.put("铃星", 1);
        return hashMap.get(dz);
    }

    public Map<String, Integer> getWuXingChangShengIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("长生", 0);
        hashMap.put("沐浴", 1);
        hashMap.put("冠带", 2);
        hashMap.put("临官", 3);
        hashMap.put("帝旺", 4);
        hashMap.put("衰", 5);
        hashMap.put("病", 6);
        hashMap.put("死", 7);
        hashMap.put("病", 8);
        hashMap.put("绝", 9);
        hashMap.put("胎", 10);
        hashMap.put("养", 11);

        return hashMap;

    }

    public Map<String, Integer> getZhiXingIndex() {

        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("天马", 0);
        hashMap.put("解神", 1);
        hashMap.put("天哭", 2);
        hashMap.put("天虚", 3);
        hashMap.put("龙池", 4);
        hashMap.put("凤阁", 5);
        hashMap.put("红鸾", 6);
        hashMap.put("天喜", 7);
        hashMap.put("孤辰", 8);
        hashMap.put("寡宿", 9);
        hashMap.put("蜚廉", 10);
        hashMap.put("破碎", 11);
        hashMap.put("天空", 12);
        hashMap.put("月德", 13);

        return hashMap;

    }

    public Map<String, Integer>  getGanXingIndex() {

        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("禄存", 0);
        hashMap.put("擎羊", 1);
        hashMap.put("陀罗", 2);
        hashMap.put("天魁", 3);
        hashMap.put("天钺", 4);
        hashMap.put("天官", 5);
        hashMap.put("天福", 6);
        hashMap.put("天厨", 7);

        return hashMap;

    }

    public Map<String, Integer> getShiXingIndex() {

        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("文昌", 0);
        hashMap.put("文曲", 1);
        hashMap.put("地劫", 2);
        hashMap.put("地空", 3);
        hashMap.put("台辅", 4);
        hashMap.put("封皓", 5);

        return hashMap;

    }

    public Map<String, Integer> getYueXingIndex() {

        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("左辅", 0);
        hashMap.put("右弼", 1);
        hashMap.put("天刑", 2);
        hashMap.put("天姚", 3);
        hashMap.put("天巫", 4);
        hashMap.put("天月", 5);
        hashMap.put("阴煞", 6);

        return hashMap;

    }

    public Map<String, Integer> getJiangQianIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("将星", 0);
        hashMap.put("攀鞍", 1);
        hashMap.put("岁驿", 2);
        hashMap.put("息神", 3);
        hashMap.put("华盖", 4);
        hashMap.put("劫煞", 5);
        hashMap.put("灾煞", 6);
        hashMap.put("天煞", 7);
        hashMap.put("指背", 8);
        hashMap.put("咸池", 9);
        hashMap.put("月煞", 10);
        hashMap.put("亡神", 11);

        return hashMap;

    }

    public Map<String, Integer> getSuiQianIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("岁建", 0);
        hashMap.put("晦气", 1);
        hashMap.put("丧门", 2);
        hashMap.put("贯索", 3);
        hashMap.put("官符", 4);
        hashMap.put("小耗", 5);
        hashMap.put("大耗", 6);
        hashMap.put("龙德", 7);
        hashMap.put("白虎", 8);
        hashMap.put("天德", 9);
        hashMap.put("吊客", 10);
        hashMap.put("病符", 11);

        return hashMap;

    }

    public Map<String, Integer> getBoShiIndex() {

        Map<String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("博士", 0);
        hashMap.put("力士", 1);
        hashMap.put("青龙", 2);
        hashMap.put("小耗", 3);
        hashMap.put("将军", 4);
        hashMap.put("奏书", 5);
        hashMap.put("飞廉", 6);
        hashMap.put("喜神", 7);
        hashMap.put("病符", 8);
        hashMap.put("大耗", 9);
        hashMap.put("伏兵", 10);
        hashMap.put("官符", 11);

        return hashMap;

    }

    public String getMingZhuIndex(String dz) {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("子", "贪狼");
        hashMap.put("丑", "巨门");
        hashMap.put("寅", "禄存");
        hashMap.put("卯", "文曲");
        hashMap.put("辰", "廉贞");
        hashMap.put("巳", "武曲");
        hashMap.put("午", "破军");
        hashMap.put("未", "武曲");
        hashMap.put("申", "廉贞");
        hashMap.put("酉", "文曲");
        hashMap.put("戌", "禄存");
        hashMap.put("亥", "巨门");

        return hashMap.get(dz);

    }

    public String getShenZhuIndex(String dz) {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("子", "火星");
        hashMap.put("丑", "天相");
        hashMap.put("寅", "天梁");
        hashMap.put("卯", "天同");
        hashMap.put("辰", "文昌");
        hashMap.put("巳", "天机");
        hashMap.put("午", "火星");
        hashMap.put("未", "天相");
        hashMap.put("申", "天梁");
        hashMap.put("酉", "天同");
        hashMap.put("戌", "文昌");
        hashMap.put("亥", "天机");

        return hashMap.get(dz);

    }

    public Map<String, Integer> getDaXianIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("命宫", 0);
        hashMap.put("兄弟宫", 1);
        hashMap.put("夫妻宫", 2);
        hashMap.put("子女宫", 3);
        hashMap.put("财帛宫", 4);
        hashMap.put("疾厄宫", 5);
        hashMap.put("迁移宫", 6);
        hashMap.put("交友宫", 7);
        hashMap.put("事业宫", 8);
        hashMap.put("田宅宫", 9);
        hashMap.put("福德宫", 10);
        hashMap.put("父母宫", 11);

        return hashMap;

    }

    public Map<String, Integer> getXiaoXianIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1,13,25,37,49,61,73,85,97,109", 0);
        hashMap.put("2,14,26,38,50,62,74,86,98,110", 1);
        hashMap.put("3,15,27,38,51,63,75,87,99,111", 2);
        hashMap.put("4,16,28,40,52,64,76,88,100,112",3);
        hashMap.put("5,17,29,41,53,65,77,89,101,113",4);
        hashMap.put("6,18,30,42,54,66,78,90,102,114",5);
        hashMap.put("7,19,31,43,55,67,79,91,103,115",6);
        hashMap.put("8,20,32,44,56,68,80,92,104,116",7);
        hashMap.put("9,21,33,45,57,69,81,93,105,117",8);
        hashMap.put("10,22,34,46,58,70,82,94,106,118",9);
        hashMap.put("11,23,35,47,59,71,83,95,107,119",10);
        hashMap.put("12,24,36,48,60,72,84,96,108,120",11);

        return hashMap;

    }

    public Map<String, Integer> getXunKongIndex() {

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1,13,25,37,49,61,73,85,97,109", 0);
        hashMap.put("2,14,26,38,50,62,74,86,98,110", 1);
        hashMap.put("3,15,27,38,51,63,75,87,99,111", 2);
        hashMap.put("4,16,28,40,52,64,76,88,100,112",3);
        hashMap.put("5,17,29,41,53,65,77,89,101,113",4);
        hashMap.put("6,18,30,42,54,66,78,90,102,114",5);
        hashMap.put("7,19,31,43,55,67,79,91,103,115",6);
        hashMap.put("8,20,32,44,56,68,80,92,104,116",7);
        hashMap.put("9,21,33,45,57,69,81,93,105,117",8);
        hashMap.put("10,22,34,46,58,70,82,94,106,118",9);
        hashMap.put("11,23,35,47,59,71,83,95,107,119",10);
        hashMap.put("12,24,36,48,60,72,84,96,108,120",11);

        return hashMap;

    }




}
