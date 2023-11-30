package com.zwds.controller;

import com.zwds.pojo.Gong;
import com.zwds.pojo.Information;
import com.zwds.pojo.Star;
import com.zwds.pojo.User;
import com.zwds.service.PaiPanService;
import com.zwds.serviceImpl.PaiPanServiceImpl;
import com.zwds.utils.IndexUtils;
import com.zwds.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class PaiPanController {

    @Autowired
    private PaiPanServiceImpl paiPanService;

    @Autowired
    private Utils util;
    @Autowired
    private IndexUtils indexutil;

//    @GetMapping("/test/{id}")
//    public Information only(@PathVariable String id){
//        String[] i=id.split("-");
//        Information Information=new Information();
//        LinkedHashMap<String, Gong> map =paiPanService.initGong();
//        int inn=paiPanService.getIndex(i[3]);
//
//
//        String ming=paiPanService.mingGongIndex(Integer.parseInt (i[0])-1,Integer.parseInt (i[1])-1);
//
//        String shen=paiPanService.shenGongIndex(Integer.parseInt (i[0])-1,Integer.parseInt (i[1])-1);
////        map.get(shen).setShengong("身宫");
////        Information.setGong(paiPanService.OtherStars(map,paiPanService.mingGongIndex(Integer.parseInt (i[0]),Integer.parseInt (i[1]))));
//
//
//        int in=paiPanService.getIndex(ming);
//        int it=paiPanService.getIndex(i[2]);
//
//
//        String wxj=paiPanService.getWuXingJu(it,in);
//        int intt=paiPanService.getIndex(wxj);
//        String ok =paiPanService.getZiWei(intt,inn);
//
//        Information.setWuxingju(wxj);
//        paiPanService.getZiWeiZhuXing(map,paiPanService.getIndex(ok));
//        paiPanService.getTianFuZhuXing(map,paiPanService.getIndex(ok));
//        System.out.println(in+"-"+it+"-"+shen+"-"+paiPanService.getIndex(ok));
//        paiPanService.getHuoLing(map,Integer.parseInt (i[1])-1,"丑");
//        paiPanService.getYueXing(map,Integer.parseInt (i[0])-1);
//        paiPanService.getGanXing(map,it);
//        paiPanService.getZhiXing(map,1);
//        paiPanService.getChangSheng(map,intt,1);
//        Information.setGong(paiPanService.OtherStars(map,ming,shen));
//        return Information;
//    }

    @PostMapping("/test1")
    public Information only(@RequestBody User user){

        //获取天干years[0]地支years[1]年i[0]月i[1]日i[2]时i[3]
        String[] i=user.getNongli().split("-");
        String year=util.jiSuan(Integer.parseInt (i[0]));
        user.setNongli(year+i[1]+i[2]+i[3]);
        String[] years=year.split("-");

        LinkedHashMap<String, Gong> map =paiPanService.initGong();//        初始化宫

        int TGindex=paiPanService.getIndex(years[0]);//获取天干索引
        int DZindex=paiPanService.getIndex(years[1]);//获取地支索引
        int ok=indexutil.getShiIndex(years[1]);
        int monthIndex=paiPanService.getIndex(i[1]);//获取月份索引
        int dayIndex=paiPanService.getIndex(i[2]);//获取日索引
        int hourIndex=paiPanService.getIndex(i[3]);//获取时辰索引

        String ming=paiPanService.mingGongIndex(monthIndex,hourIndex);//        获取命宫位置
        String shen=paiPanService.shenGongIndex(monthIndex,hourIndex);//        获取身宫位置

        int mingIndex=paiPanService.getIndex(ming);//获取命宫索引

        String wxj=paiPanService.getWuXingJu(TGindex,mingIndex);//获取五行局
        int WuXingIndex=paiPanService.getIndex(wxj);//获取五行局索引

        String ZiWei =paiPanService.getZiWei(WuXingIndex,dayIndex);//获取紫微星
        int ZiWeiIndex=paiPanService.getIndex(ZiWei);//获取紫微星索引

        Information Information=new Information();
        Information.setWuxingju(wxj);//设置五行居

        paiPanService.getZiWeiZhuXing(map,ZiWeiIndex);//        设置紫微诸星
        paiPanService.getTianFuZhuXing(map,ZiWeiIndex);//        设置天府诸星

        String sex=paiPanService.getYinYangIndex(years[0],user.getSex());
        int sexint=0;

        switch(sex){
            case "阳男":sexint=0;break;
            case "阴女":sexint=0;break;
            case "阳女":sexint=1;break;
            case "阴男":sexint=1;break;
            default:sexint=3;
        }

        paiPanService.getHuoLing(map,hourIndex,ok);//        设置火铃
        paiPanService.getYueXing(map,monthIndex,dayIndex);//        设置月系诸星
        paiPanService.getGanXing(map,TGindex);//        设置干系诸星
        paiPanService.getZhiXing(map,sexint);//        设置支系诸星
        paiPanService.getChangSheng(map,WuXingIndex,sexint);
        paiPanService.getXiaoXian(map,ok,user.getSex());
        paiPanService.getBoShi(map,TGindex,sexint);
        paiPanService.getSuiQian(map,DZindex);
        paiPanService.getJiangQian(map,ok);
        Information.setGongs(paiPanService.OtherStars(map,ming,WuXingIndex,shen,sexint).values().stream().collect(Collectors.toList()));
        return Information;
    }

    @GetMapping("/paipan")
    public Information paipan(){
        Information Information=new Information();

        //19971228
        String year=util.jiSuan(Integer.parseInt ("1997"));
        System.err.println("year"+year);
        String mouth="十一月";
        String hour="巳";

        String Shen=paiPanService.getShenGongIndex(mouth,hour);
        System.err.println("身宫"+Shen);
        String ming=paiPanService.getMingGongIndex(mouth,hour);
        System.err.println("命宫"+ming);

        Gong gong=new Gong();
        Star star=new Star();
        Map<String,Gong> map=new HashMap<>();

        map.putAll(paiPanService.getYuGongIndex(ming));
        map.put(ming,new Gong());
        System.err.println("余宫"+map);
//        paiPanService.getGongGan(map,"丁");

        Information.setGong(paiPanService.getGongGan(map,"丁"));
        String wxj=paiPanService.getWuXingJu("丁",ming);
        Information.setWuxingju(wxj);
        System.err.println("五行局"+paiPanService.getWuXingJu("丁",ming));



        Map<String, String> startMap = new HashMap<String, String>();

        String ziweiIndex=paiPanService.getZiWei(wxj,"二八");
        startMap.put("紫微",ziweiIndex);

        System.err.println("紫微星"+ziweiIndex);
        String b=paiPanService.getStarBright(ziweiIndex,"紫微");
        System.err.println("紫微星亮度"+b);
        Map<String, String> map1=paiPanService.getZhuStarIndex(ziweiIndex);
        for (String key : map1.keySet()) {
            System.err.println(key+"--"+map1.get(key));
        }

        Map<String, String> map2=paiPanService.getYueXing("十一月");

        for (String key : map2.keySet()) {
            System.err.println(key+"--"+map2.get(key));
        }

        Map<String, String> map3=paiPanService.getGanXing("丁");

        for (String key : map3.keySet()) {
            System.err.println(key+"--"+map3.get(key));
        }

        Map<String, String> map4=paiPanService.getZhiXingIndex("丑");

        for (String key : map4.keySet()) {
            System.err.println(key+"-1-"+map4.get(key));
        }

        Map<String, String> map5=paiPanService.getLingAndHuo("巳");

        for (String key : map5.keySet()) {
            System.err.println(key+"-1-"+map5.get(key));
        }
        return Information;
    }
}
