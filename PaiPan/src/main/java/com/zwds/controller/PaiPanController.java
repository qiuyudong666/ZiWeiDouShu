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

        //个人信息19971228
        String year=util.jiSuan(Integer.parseInt ("1997"));
        String mouth="十一月";
        String day="二八";
        String hour="巳";
        String sex="男";
        System.err.println("【个人信息】【"+year+mouth+day+hour+sex+"】");

        //获取天干地支
        String[] yearArr=year.split("-");
        String TianGan=yearArr[0];
        String DiZhi=yearArr[1];
        System.err.println("【天干地支】【"+TianGan+DiZhi+"】");

        //获取阴阳-男女
        String YinYangNanNv=paiPanService.getYinYangIndex(TianGan,sex);
        System.err.println("【阴阳-男女】【"+YinYangNanNv+"】");

        //获取命宫身宫
        String Shen=paiPanService.getShenGongIndex(mouth,hour);
        System.err.println("【身宫】【"+Shen+"】");
        String ming=paiPanService.getMingGongIndex(mouth,hour);
        System.err.println("【命宫】【"+ming+"】");

        Gong gong=new Gong();
        Star star=new Star();

        //获取其他宫
        Map<String,Gong> map=new HashMap<>();
        map.putAll(paiPanService.getYuGongIndex(ming));
        map.put(ming,new Gong());
        for (String key : map.keySet()) {
            System.err.println("【"+key+"】【"+map.get(key)+"】");
        }

        //获取宫干
        Information.setGong(paiPanService.getGongGan(map,TianGan));
        for (String key : map.keySet()) {
            System.err.println("【"+key+"】【"+map.get(key)+"】");
        }

        //获取五行局
        String wxj=paiPanService.getWuXingJu(TianGan,ming);
        Information.setWuxingju(wxj);
        System.err.println("【五行局】【"+wxj+"】");

        Map<String, String> startMap = new HashMap<String, String>();

        //获取紫微所在宫
        String ziweiIndex=paiPanService.getZiWei(wxj,day);
        startMap.put("紫微",ziweiIndex);
        System.err.println("【紫微所在宫位】【"+ziweiIndex+"】");
        String b=paiPanService.getStarBright(ziweiIndex,"紫微");


        //获取其他主星所在宫位
        Map<String, String> map1=paiPanService.getZhuStarIndex(ziweiIndex);
        for (String key : map1.keySet()) {
            System.err.print("【"+key+"-"+map1.get(key)+"】");
        }
        System.err.println("----------------------------------【其他主星】");

        //获取时系诸星在宫位
        Map<String, String> map5=paiPanService.getLingAndHuo(hour);
        for (String key : map5.keySet()) {
            System.err.print("【"+key+"-"+map5.get(key)+"】");
        }
        System.err.println("----------------------------------【时系】");
        Map<String, String> map7=paiPanService.getShiXing(hour);
        for (String key : map7.keySet()) {
            System.err.print("【"+key+"-"+map7.get(key)+"】");
        }
        System.err.println("----------------------------------【时系】");

        //获取月系诸星在宫位
        Map<String, String> map2=paiPanService.getYueXing(mouth);
        for (String key : map2.keySet()) {
            System.err.print("【"+key+"-"+map2.get(key)+"】");
        }
        System.err.println("----------------------------------【月系】");

        //获取干系诸星在宫位
        Map<String, String> map8=paiPanService.getGanXingIndex(TianGan);
        for (String key : map8.keySet()) {
            System.err.print("【"+key+"-"+map8.get(key)+"】");
        }
        System.err.println("----------------------------------【干系】");

        //获取支系诸星在宫位
        Map<String, String> map4=paiPanService.getZhiXingIndex(DiZhi);
        for (String key : map4.keySet()) {
            System.err.print("【"+key+"-"+map4.get(key)+"】");
        }
        System.err.println("----------------------------------【支系】");

        //获取十二长生在宫位
        Map<String, String> map6=paiPanService.getChangSheng(TianGan,wxj,sex);
        for (String key : map6.keySet()) {
            System.err.print("【"+key+"-"+map6.get(key)+"】");
        }
        System.err.println("----------------------------------【十二长生】");

        //获取将前在宫位
        Map<String, String> map9=paiPanService.getJiangQian(DiZhi);
        for (String key : map9.keySet()) {
            System.err.print("【"+key+"-"+map9.get(key)+"】");
        }
        System.err.println("----------------------------------【将前】");

        //获取岁前在宫位
        Map<String, String> map10=paiPanService.getSuiQian(DiZhi);
        for (String key : map10.keySet()) {
            System.err.print("【"+key+"-"+map10.get(key)+"】");
        }
        System.err.println("----------------------------------【岁前】");

        //获取大限在宫位
        Map<String, String> map11=paiPanService.getDaXian(wxj,YinYangNanNv);
        for (String key : map11.keySet()) {
            System.err.print("【"+key+"-"+map11.get(key)+"】");
        }
        System.err.println("----------------------------------【大限】");

        //获取小限在宫位
        Map<String, String> map12=paiPanService.getXiaoXian(DiZhi,sex);
        for (String key : map12.keySet()) {
            System.err.print("【"+key+"-"+map12.get(key)+"】");
        }
        System.err.println("----------------------------------【小限】");

        //获取斗君在宫位
        String douJun=paiPanService.getDouJun(mouth,hour);
        System.err.println("【斗君】【"+douJun+"】");

        //获取命主在宫位
        String MingZhu=paiPanService.getMingZhuIndex(ming);
        System.err.println("【命主】【"+MingZhu+"】");

        //获取身主
        String ShenZhu=paiPanService.getShenZhuIndex(DiZhi);
        System.err.println("【身主】【"+ShenZhu+"】");

        //获取旬空所在宫位
        Map<String, String> map13=paiPanService.getXunKong(TianGan,DiZhi);
        for (String key : map13.keySet()) {
            System.err.print("【"+key+"-"+map13.get(key)+"】");
        }
        System.err.println("----------------------------------【旬空】");

        //获取截空所在宫位
        Map<String, String> map14=paiPanService.getJieKong(TianGan);
        for (String key : map14.keySet()) {
            System.err.print("【"+key+"-"+map14.get(key)+"】");
        }
        System.err.println("----------------------------------【截空】");

        //获取三台所在宫位
        String map15=paiPanService.getSanTai(map2.get("左辅"),day);
        System.err.println("【三台】【"+map15+"】");

        //获取八座所在宫位
        String map16=paiPanService.getBaZuo(map2.get("右弼"),day);
        System.err.println("【八座】【"+map16+"】");

        //获取八座所在宫位
        String map17=paiPanService.getChangQu(map7.get("文昌"),day);
        System.err.println("【恩光】【"+map17+"】");

        //获取天贵所在宫位
        String map18=paiPanService.getChangQu(map7.get("文曲"),day);
        System.err.println("【天贵】【"+map18+"】");

        //获取博士十二星所在宫位
        Map<String, String> map19=paiPanService.getBoShi(map8.get("禄存"),YinYangNanNv);
        for (String key : map19.keySet()) {
            System.err.print("【"+key+"-"+map19.get(key)+"】");
        }
        System.err.println("----------------------------------【博士十二星】");

        //获取天贵所在宫位
        String map20=paiPanService.getTianShou(Shen,DiZhi);
        System.err.println("【天寿】【"+map20+"】");

        return Information;
    }
}
