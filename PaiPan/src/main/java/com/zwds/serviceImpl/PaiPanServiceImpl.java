package com.zwds.serviceImpl;

import com.zwds.index.array;
import com.zwds.index.index;
import com.zwds.pojo.Gong;
import com.zwds.service.PaiPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaiPanServiceImpl implements PaiPanService {
    @Override
    public LinkedHashMap<String, Gong> initGong() {
        LinkedHashMap<String, Gong> map = new LinkedHashMap<>();
        String[] dizhi={"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
        for (int i=0;i<12;i++){
            Gong gong=new Gong();
            gong.setName(dizhi[i]);
            map.put(dizhi[i],gong);
        }
        return map;
    }

    public LinkedHashMap<String, Gong> OtherStars(LinkedHashMap<String, Gong> map,String ii,int it, String shen,int or) {
//        HashMap<String, Gong> map = new HashMap<>();
        String[][] arr1 = {
                {"2-11","3-12","4-13","5-14","6-15"},
                {"112-121","113-122","114-123","115-124","116-125"},
                {"102-111","103-112","104-113","105-114","106-115"},
                {"92-101","93-102","94-103","95-104","96-105"},
                {"82-91","83-92","84-193","85-94","86-195"},
                {"72-81","73-82","74-83","75-84","76-85"},
                {"62-71","63-72","64-73","65-74","66-75"},
                {"52-61","53-62","54-63","55-64","56-65"},
                {"42-51","43-52","44-53","45-54","46-55"},
                {"32-41","33-42","34-43","35-44","36-45"},
                {"22-31","23-32","24-33","25-34","26-35"},
                {"12-21","13-22","14-23","15-24","16-25"}
        };
        String[][] arr2 = {
                {"2-11","3-12","4-13","5-14","6-15"},
                {"12-21","13-22","14-23","15-24","16-25"},
                {"22-31","23-32","24-33","25-34","26-35"},
                {"32-41","33-42","34-43","35-44","36-45"},
                {"42-51","43-52","44-53","45-54","46-55"},
                {"52-61","53-62","54-63","55-64","56-65"},
                {"62-71","63-72","64-73","65-74","66-75"},
                {"72-81","73-82","74-83","75-84","76-85"},
                {"82-91","83-92","84-193","85-94","86-195"},
                {"92-101","93-102","94-103","95-104","96-105"},
                {"102-111","103-112","104-113","105-114","106-115"},
                {"112-121","113-122","114-123","115-124","116-125"},
        };
        String[][] arr;
        if(or==0){
            arr=arr1;
        }else{
            arr=arr2;
        }

        int index = 0;
        String[] dizhi={"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
        String[] gongarr={"命宫","兄弟宫","夫妻宫","子女宫","财帛宫","疾厄宫","迁移宫","交友宫","官禄宫","田宅","福德宫","父母宫"};
        dizhi=everseArray4(dizhi);
        for (int i=0;i<12;i++){
            if(ii==dizhi[i]){
                index=i;
            }
        }

        String[] sub1 = Arrays.copyOf(dizhi,index);
        String[] sub2 = Arrays.copyOfRange(dizhi, index, dizhi.length);

        String[] both = concat(sub2,sub1 );
        System.out.println( Arrays.toString (both));
        for (int i=0;i<12;i++){

            if(both[i]==shen){

                map.get(both[i]).setNickname(gongarr[i]+"(身)");
            }else{
                map.get(both[i]).setNickname(gongarr[i]);
            }
            map.get(both[i]).setDaxian(arr[i][it]);
        }
        return map;
    }

    private String[] everseArray4(String[] strArray) {
        int len = strArray.length;
        int mid = len >> 1;
        //定义一个新的数组
        String[] newArray = new String[len];
        for (int i = 0; i <= mid; i++) {
            newArray[i] = strArray[len - 1 - i];
            newArray[len - 1 - i] = strArray[i];
        }
        return newArray;
    }



    static String[] concat(String[] a, String[] b) {
        String[] c= new String[a.length+b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    @Override
    public String mingGongIndex(int month,int day) {
        String[][] arr = {
                {"寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯"},
                {"卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰"},
                {"辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳"},
                {"巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午"},
                {"午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未"},
                {"未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申"},
                {"申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉"},
                {"酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子"},
                {"子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑"},
                {"丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅"},
        };
        return arr[month][day];
    }

    @Override
    public String shenGongIndex(int month,int day) {
        String[][] arr = {
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
        };
        return arr[month][day];
    }

    @Override
    public String getWuXingJu(int tiangan, int dizhi) {
        int i=0;
        if(dizhi%2==1) {
            i=(dizhi-1)/2;
        }else{
            i=dizhi/2;
        }

        System.out.println(tiangan+"wuxingju"+i);
        String[][] arr = {
                {"水二局","火六局","木三局","土五局","金四局","火六局"},
                {"火六局","土五局","金四局","木三局","水二局","土五局"},
                {"土五局","木三局","水二局","金四局","火六局","木三局"},
                {"木三局","金四局","火六局","水二局","土五局","金四局"},
                {"金四局","水二局","土五局","火六局","木三局","水二局"},
        };
        return arr[tiangan][i];
    }

    @Override
    public String getTianGan(int tiangan, int dizhi) {
        String[][] arr = {
                {"丙","丁","丙","丁","戊","己","庚","辛","壬","癸","甲","乙"},
                {"戊","己","戊","己","庚","辛","壬","癸","甲","乙","丙","丁"},
                {"庚","辛","庚","辛","壬","癸","甲","乙","丙","丁","戊","己"},
                {"壬","癸","壬","癸","甲","乙","丙","丁","戊","己","庚","辛"},
                {"甲","乙","甲","乙","丙","丁","戊","己","庚","辛","壬","癸"}

        };
        return null;
    }

    @Override
    public String getZiWei(int gong, int niangan) {
        String[][] arr = {
                {"丑","寅","寅","卯","卯","辰","辰","巳","巳","午","午","未","未","申","申","酉","酉","戌","戌","亥","亥","子","子","丑","丑","寅","寅","卯","卯","辰"},
                {"辰","丑","寅","巳","寅","卯","午","卯","辰","未","辰","巳","申","巳","午","酉","午","未","戌","未","申","亥","申","酉","子","酉","戌","丑","戌","亥"},
                {"亥","辰","丑","寅","子","巳","寅","卯","丑","午","卯","辰","寅","未","辰","巳","卯","申","巳","午","辰","酉","午","丑","丑","戌","未","申","午","亥"},
                {"午","亥","辰","丑","寅","未","子","巳","寅","卯","申","丑","午","卯","辰","酉","寅","未","辰","巳","戌","卯","申","巳","午","亥","辰","酉","午","未"},
                {"酉","午","亥","辰","丑","寅","戌","未","子","巳","寅","卯","亥","申","丑","午","卯","辰","子","酉","寅","未","辰","巳","丑","戌","卯","申","巳","午"}

        };
        System.out.println(niangan+"ziwei");
        return arr[gong][niangan];
    }

    @Override
    public LinkedHashMap<String, Gong> getZiWeiZhuXing(LinkedHashMap<String, Gong> map, int ii) {

        String[][] arr = {
                {"子","亥","酉","申","未","辰"},
                {"丑","子","戌","酉","申","巳"},
                {"寅","丑","亥","戌","酉","午"},
                {"卯","寅","子","亥","戌","未"},
                {"辰","卯","丑","子","亥","申"},
                {"巳","辰","寅","丑","子","酉"},
                {"午","巳","卯","寅","丑","戌"},
                {"未","午","辰","卯","寅","亥"},
                {"申","未","巳","辰","卯","子"},
                {"酉","申","午","巳","辰","丑"},
                {"戌","酉","未","午","巳","寅"},
                {"亥","戌","申","未","午","卯"}
        };
        System.out.println(ii+"[]"+arr[ii]);
        String[] stars={"紫微","天机","太阳","武曲","天同","廉贞"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[ii][i]).getZhuxing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(arr[ii][i]).setZhuxing(list);
            }else{
               map.get(arr[ii][i]).getZhuxing().add(stars[i]);
            }
        }



        return map;
    }

    @Override
    public LinkedHashMap<String, Gong> getTianFuZhuXing(LinkedHashMap<String, Gong> map, int ii) {

        int[] tianfu={4,3,2,1,0,11,10,9,8,7,6,5};
        String[][] arr = {
                {"子","丑","寅","卯","辰","巳","午","戌"},
                {"丑","寅","卯","辰","巳","午","未","亥"},
                {"寅","卯","辰","巳","午","未","申","子"},
                {"卯","辰","巳","午","未","申","酉","丑"},
                {"辰","巳","午","未","申","酉","戌","寅"},
                {"巳","午","未","申","酉","戌","亥","卯"},
                {"午","未","申","酉","戌","亥","子","辰"},
                {"未","申","酉","戌","亥","子","丑","巳"},
                {"申","酉","戌","亥","子","丑","寅","午"},
                {"酉","戌","亥","子","丑","寅","卯","未"},
                {"戌","亥","子","丑","寅","卯","辰","申"},
                {"亥","子","丑","寅","卯","辰","巳","酉"},
        };
        int index=tianfu[ii];
        System.out.println(tianfu[3]+"[2]"+Arrays.toString(arr[ii]));
        String[] stars={"天府","太阴","贪狼","巨门","天相","天梁","七杀","破军"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[index][i]).getZhuxing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(arr[index][i]).setZhuxing(list);
            }else{
                map.get(arr[index][i]).getZhuxing().add(stars[i]);

            }
        }
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getHuoLing(LinkedHashMap<String, Gong> map, int ii,int ok) {
        String[][] changqu = {
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"}
        };
        String[] stars={"文昌","文曲"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(changqu[i][ii]).getShixing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(changqu[i][ii]).setShixing(list);
            }else{
                map.get(changqu[i][ii]).getShixing().add(stars[i]);

            }
        }

        String[][] st = {
                {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},
        };
        String[][] st1 = {
                {"子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未"},
                {"丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申"},
                {"寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉"},
                {"卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌"},
                {"辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子"},
                {"午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑"},
                {"未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅"},
                {"申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯"},
                {"酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳"},
                {"亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午"},
        };
        int strs=0;
        switch(changqu[0][ii]){
            case "子":strs=0;break;
            case "丑":strs=1;break;
            case "寅":strs=2;break;
            case "卯":strs=3;break;
            case "辰":strs=4;break;
            case "巳":strs=5;break;
            case "午":strs=6;break;
            case "未":strs=7;break;
            case "申":strs=8;break;
            case "酉":strs=9;break;
            case "戌":strs=10;break;
            case "亥":strs=11;break;
            default:strs=strs;
        }

        if(map.get(st[strs][27]).getRixing()==null){
            List list = new ArrayList<>();
            list.add("恩光");
            map.get(st[strs][27]).setRixing(list);
        }else{
            map.get(st[strs][27]).getRixing().add("恩光");
        }

        int strs1=0;
        switch(changqu[1][ii]){
            case "子":strs1=0;break;
            case "丑":strs1=1;break;
            case "寅":strs1=2;break;
            case "卯":strs1=3;break;
            case "辰":strs1=4;break;
            case "巳":strs1=5;break;
            case "午":strs1=6;break;
            case "未":strs1=7;break;
            case "申":strs1=8;break;
            case "酉":strs1=9;break;
            case "戌":strs1=10;break;
            case "亥":strs1=11;break;
            default:strs1=strs1;
        }
        if(map.get(st1[strs1][27]).getRixing()==null){
            List list = new ArrayList<>();
            list.add("天贵");
            map.get(st1[strs1][27]).setRixing(list);
        }else{
            map.get(st1[strs1][27]).getRixing().add("天贵");
        }



        String[][] kongjieTF = {
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
        };
        String[] yistars={"地劫","地空","台辅","封皓"};
        for(int i = 0; i < 4; i++){
            if(map.get(kongjieTF[i][ii]).getShixing()==null){
                List list = new ArrayList<>();
                list.add(yistars[i]);
                map.get(kongjieTF[i][ii]).setShixing(list);
            }else{
                map.get(kongjieTF[i][ii]).getShixing().add(yistars[i]);
            }
        }


        String[][] huoxing = {
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"}
        };
        String[][] lingxing = {
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"}
        };
        System.out.println(ok+"-"+ii);

            if(map.get(huoxing[ok][ii]).getShixing()==null||map.get(lingxing[ok][ii]).getShixing()==null){
                List list = new ArrayList<>();
                list.add("火星");
                List list1 = new ArrayList<>();
                list1.add("铃星");
                map.get(huoxing[ok][ii]).setShixing(list);
                map.get(lingxing[ok][ii]).setShixing(list1);
            }else{
                map.get(huoxing[ok][ii]).getShixing().add("火星");
                map.get(lingxing[ok][ii]).getShixing().add("铃星");
            }

        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getYueXing(LinkedHashMap<String, Gong> map, int ii, int it) {

        String[][] arr = {
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"巳","申","寅","亥","巳","申","寅","亥","巳","申","寅","亥"},
                {"戌","巳","辰","寅","未","卯","亥","未","寅","午","戌","寅"},
                {"寅","子","戌","申","午","辰","寅","子","戌","申","午","辰"},

        };

        String[] stars={"左辅","右弼","天刑","天姚","天巫","天月","阴煞"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getYuexing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(arr[i][ii]).setYuexing(list);
            }else{
                map.get(arr[i][ii]).getYuexing().add(stars[i]);

            }
        }

        String[][] st = {
                {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},
        };

        String[][] st1 = {
                {"子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未"},
                {"丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申"},
                {"寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉"},
                {"卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌"},
                {"辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子"},
                {"午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑"},
                {"未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅"},
                {"申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯"},
                {"酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳"},
                {"亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午"},
        };
        int strs=0;
        switch(arr[0][ii]){
            case "子":strs=0;break;
            case "丑":strs=1;break;
            case "寅":strs=2;break;
            case "卯":strs=3;break;
            case "辰":strs=4;break;
            case "巳":strs=5;break;
            case "午":strs=6;break;
            case "未":strs=7;break;
            case "申":strs=8;break;
            case "酉":strs=9;break;
            case "戌":strs=10;break;
            case "亥":strs=11;break;
            default:strs=strs;
        }

        if(map.get(st[strs][28]).getRixing()==null){
            List list = new ArrayList<>();
            list.add("三台");
            map.get(st[strs][28]).setRixing(list);
        }else{
            map.get(st[strs][28]).getRixing().add("三台");
        }

        int strs1=0;
        switch(arr[1][ii]){
            case "子":strs1=0;break;
            case "丑":strs1=1;break;
            case "寅":strs1=2;break;
            case "卯":strs1=3;break;
            case "辰":strs1=4;break;
            case "巳":strs1=5;break;
            case "午":strs1=6;break;
            case "未":strs1=7;break;
            case "申":strs1=8;break;
            case "酉":strs1=9;break;
            case "戌":strs1=10;break;
            case "亥":strs1=11;break;
            default:strs1=strs1;
        }
        if(map.get(st1[strs1][28]).getRixing()==null){
            List list = new ArrayList<>();
            list.add("八座");
            map.get(st1[strs1][28]).setRixing(list);
        }else{
            map.get(st1[strs1][28]).getRixing().add("八座");
        }


        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getGanXing(LinkedHashMap<String, Gong> map, int ii) {
        String[][] arr = {
                {"寅","卯","巳","午","巳","午","申","酉","亥","子"},
                {"卯","辰","午","未","午","未","酉","戌","子","丑"},
                {"丑","寅","辰","巳","辰","巳","未","申","戌","亥"},
                {"丑","子","亥","亥","丑","子","丑","午","卯","卯"},
                {"未","申","酉","酉","未","申","未","寅","巳","巳"},
                {"未","辰","巳","寅","卯","酉","亥","酉","戌","午"},
                {"酉","申","子","亥","卯","寅","午","巳","午","巳"},
                {"巳","午","子","巳","午","申","寅","午","酉","亥"}

        };

        String[] stars={"禄存","擎羊","陀罗","天魁","天钺","天官","天福","天厨"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getGanxing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(arr[i][ii]).setGanxing(list);
            }else{
                map.get(arr[i][ii]).getGanxing().add(stars[i]);

            }
        }
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getZhiXing(LinkedHashMap<String, Gong> map, int ii) {
        String[][] arr = {
                {"寅","亥","申","巳","寅","亥","申","巳","寅","亥","申","巳"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"卯","寅","丑","子","亥","戌","酉","申","未","午","巳","辰"},
                {"酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌"},
                {"寅","亥","申","巳","寅","亥","申","巳","寅","亥","申","巳"},
                {"戌","戌","丑","丑","丑","辰","辰","辰","未","未","未","戌"},
                {"申","酉","戌","巳","午","未","寅","卯","辰","亥","子","丑"},
                {"巳","丑","酉","巳","丑","酉","巳","丑","酉","巳","丑","酉"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},


        };

        String[] stars={"天马","解神","天哭","天虚","龙池","凤阁","红鸾","天喜","孤辰","寡宿","蜚廉","破碎","天空","月德"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getZhixing()==null){
                List list = new ArrayList<>();
                list.add(stars[i]);
                map.get(arr[i][ii]).setZhixing(list);
            }else{
                map.get(arr[i][ii]).getZhixing().add(stars[i]);

            }
        }
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getJiangQian(LinkedHashMap<String, Gong> map, int ii) {
        String[][] arr = {

                {"午","子","酉","卯"},
                {"未","丑","戌","辰"},
                {"申","寅","亥","巳"},
                {"酉","卯","子","午"},
                {"戌","辰","丑","未"},
                {"亥","巳","寅","申"},
                {"子","午","卯","酉"},
                {"丑","未","辰","戌"},
                {"寅","申","巳","亥"},
                {"卯","酉","午","子"},
                {"辰","戌","未","丑"},
                {"巳","亥","申","寅"}
        };

        String[] stars={"将星","攀鞍","岁驿","息神","华盖","劫煞","灾煞","天煞","指背","咸池","月煞","亡神"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getJiangqian()==null){
                map.get(arr[i][ii]).setJiangqian(stars[i]);
            }else{
                map.get(arr[i][ii]).setJiangqian(stars[i]);

            }
        }
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getSuiQian(LinkedHashMap<String, Gong> map, int ii) {
        String[][] arr = {
                {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},

        };

        String[] stars={"岁建","晦气","丧门","贯索","官符","小耗","大耗","龙德","白虎","天德","吊客","病符"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getSuiqian()==null){
                map.get(arr[i][ii]).setSuiqian(stars[i]);
            }else{
                map.get(arr[i][ii]).setSuiqian(stars[i]);
            }
        }
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getChangSheng(LinkedHashMap<String, Gong> map, int ii,int or) {
        String[][] arr1 = {
                {"申","亥","巳","申","寅"},
                {"酉","子","午","酉","卯"},
                {"戌","丑","未","戌","辰"},
                {"亥","寅","申","亥","巳"},
                {"子","卯","酉","子","午"},
                {"丑","辰","戌","丑","未"},
                {"寅","巳","亥","寅","申"},
                {"卯","午","子","卯","酉"},
                {"辰","未","丑","辰","戌"},
                {"巳","申","寅","巳","亥"},
                {"午","酉","卯","午","子"},
                {"未","戌","辰","未","丑"}
        };
        String[][] arr2 = {
                {"申","亥","巳","申","寅"},
                {"未","戌","辰","未","辰"},
                {"午","酉","卯","午","巳"},
                {"巳","申","寅","巳","午"},
                {"辰","未","丑","辰","未"},
                {"卯","午","子","卯","申"},
                {"寅","巳","亥","寅","酉"},
                {"丑","辰","戌","丑","戌"},
                {"子","卯","酉","子","亥"},
                {"亥","寅","申","亥","子"},
                {"戌","丑","未","戌","丑"},
                {"酉","子","午","酉","卯"}
        };
        String[][] arr;
        if(or==0){
            arr=arr1;
        }else{
            arr=arr2;
        }

        String[] stars={"长生","沐浴","冠带","临官","帝旺","衰","病","死","墓","绝","胎","养"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getChangsheng()==null){
                map.get(arr[i][ii]).setChangsheng(stars[i]);
            }
            else{
                map.get(arr[i][ii]).setChangsheng(stars[i]);
            }
            System.out.println(map.get(arr[i][ii]).getChangsheng()+i+stars[i]+arr[i][ii]);
        }

        System.out.println(map.toString());
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getXiaoXian(LinkedHashMap<String, Gong> map, int ii, String or) {

        String[][] arr1 = {
                {"辰","戌","未","丑"},
                {"巳","亥","申","寅"},
                {"午","子","酉","卯"},
                {"未","丑","戌","辰"},
                {"申","寅","亥","巳"},
                {"酉","卯","子","午"},
                {"戌","辰","丑","未"},
                {"亥","巳","寅","申"},
                {"子","午","卯","酉"},
                {"丑","未","辰","戌"},
                {"寅","申","巳","亥"},
                {"卯","酉","午","子"},
        };
        String[][] arr2 = {
                {"辰","戌","未","丑"},
                {"卯","酉","午","子"},
                {"寅","申","巳","亥"},
                {"丑","未","辰","戌"},
                {"子","午","卯","酉"},
                {"亥","巳","寅","申"},
                {"戌","辰","丑","未"},
                {"酉","卯","子","午"},
                {"申","寅","亥","巳"},
                {"未","丑","戌","辰"},
                {"午","子","酉","卯"},
                {"巳","亥","申","寅"}
        };
        String[][] arr;
        if(or=="男"){
            arr=arr1;
        }else{
            arr=arr2;
        }

        String[] stars={
                "1,13,25,37,49,61,73,85,97,109",
                "2,14,26,38,50,62,74,86,98,110",
                "3,15,27,39,51,63,75,87,99,111",
                "4,16,28,40,52,64,76,88,100,112",
                "5,17,29,41,53,65,77,89,101,113",
                "6,18,30,42,54,66,78,90,102,114",
                "7,19,31,43,55,67,79,91,103,115",
                "8,20,32,44,56,68,80,92,104,116",
                "9,21,33,45,57,69,81,93,105,117",
                "10,22,34,46,58,70,82,94,106,118",
                "11,23,35,47,59,71,83,95,107,119",
                "12,24,36,48,60,72,84,96,108,120"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getXiaoxian()==null){
                map.get(arr[i][ii]).setXiaoxian(stars[i]);
            }
            else{
                map.get(arr[i][ii]).setXiaoxian(stars[i]);
            }
        }

        System.out.println(map.toString());
        return null;
    }

    @Override
    public LinkedHashMap<String, Gong> getBoShi(LinkedHashMap<String, Gong> map, int ii, int or) {
        String[][] arr2 = {
                {"寅","卯","巳","午","巳","午","申","酉","亥","子"},
                {"丑","寅","辰","巳","辰","巳","未","申","戌","亥"},
                {"子","丑","卯","辰","卯","辰","午","未","酉","戌"},
                {"亥","子","寅","卯","寅","卯","巳","午","申","酉"},
                {"戌","亥","丑","寅","丑","寅","辰","巳","未","申"},
                {"酉","戌","子","丑","子","丑","卯","辰","午","未"},
                {"申","酉","亥","子","亥","子","寅","卯","巳","午"},
                {"未","申","戌","亥","戌","亥","丑","寅","辰","巳"},
                {"午","未","酉","戌","酉","戌","子","丑","卯","辰"},
                {"巳","午","申","酉","申","酉","亥","子","寅","卯"},
                {"辰","申","未","申","未","申","戌","亥","丑","寅"},
                {"卯","酉","午","未","午","未","酉","戌","子","丑"},
        };
        String[][] arr1 = {
                {"寅","卯","巳","午","巳","午","申","酉","亥","子"},
                {"卯","辰","午","未","午","未","酉","戌","子","丑"},
                {"辰","巳","未","申","未","申","戌","亥","丑","寅"},
                {"巳","午","申","酉","申","酉","亥","子","寅","卯"},
                {"午","未","酉","戌","酉","戌","子","丑","卯","辰"},
                {"未","申","戌","亥","戌","亥","丑","寅","辰","巳"},
                {"申","酉","亥","子","亥","子","寅","卯","巳","午"},
                {"酉","戌","子","丑","子","丑","卯","辰","午","未"},
                {"戌","亥","丑","寅","丑","寅","辰","巳","未","申"},
                {"亥","子","寅","卯","寅","卯","巳","午","申","酉"},
                {"子","丑","卯","辰","卯","辰","午","未","酉","戌"},
                {"丑","寅","辰","巳","辰","巳","未","申","戌","亥"},
        };
        String[][] arr;
        if(or==0){
            arr=arr1;
        }else{
            arr=arr2;
        }

        String[] stars={"博士","力士","青龙","小耗","将军","奏书","飞廉","喜神","病符","大耗", "伏兵","官府"};
        for(int i = 0; i < stars.length; i++){
            if(map.get(arr[i][ii]).getBoshixing()==null){
                map.get(arr[i][ii]).setBoshixing(stars[i]);
            }
            else{
                map.get(arr[i][ii]).setBoshixing(stars[i]);
            }
        }

        System.out.println(map.toString());
        return null;
    }


    @Override
    public int getIndex(String str) {
        int index=0;

        switch(str){
            case "甲":index=0;break;
            case "乙":index=1;break;
            case "丙":index=2;break;
            case "丁":index=3;break;
            case "戊":index=4;break;
            case "己":index=0;break;
            case "庚":index=1;break;
            case "辛":index=2;break;
            case "壬":index=3;break;
            case "癸":index=4;break;
            case "子":index=0;break;
            case "丑":index=1;break;
            case "寅":index=2;break;
            case "卯":index=3;break;
            case "辰":index=4;break;
            case "巳":index=5;break;
            case "午":index=6;break;
            case "未":index=7;break;
            case "申":index=8;break;
            case "酉":index=9;break;
            case "戌":index=10;break;
            case "亥":index=11;break;

            case "水二局":index=0;break;
            case "木三局":index=1;break;
            case "金四局":index=2;break;
            case "土五局":index=3;break;
            case "火六局":index=4;break;

            case "正月":index=0;break;
            case "二月":index=1;break;
            case "三月":index=2;break;
            case "四月":index=3;break;
            case "五月":index=4;break;
            case "六月":index=5;break;
            case "七月":index=6;break;
            case "八月":index=7;break;
            case "九月":index=8;break;
            case "十月":index=9;break;
            case "冬月":index=10;break;
            case "腊月":index=11;break;

            case "初一":index=0;break;
            case "初二":index=1;break;
            case "初三":index=2;break;
            case "初四":index=3;break;
            case "初五":index=4;break;
            case "初六":index=5;break;
            case "初七":index=6;break;
            case "初八":index=7;break;
            case "初九":index=8;break;
            case "初十":index=9;break;
            case "十一":index=10;break;
            case "十二":index=11;break;
            case "十三":index=12;break;
            case "十四":index=13;break;
            case "十五":index=14;break;
            case "十六":index=15;break;
            case "十七":index=16;break;
            case "十八":index=17;break;
            case "十九":index=18;break;
            case "二十":index=19;break;
            case "廿一":index=20;break;
            case "廿二":index=21;break;
            case "廿三":index=22;break;
            case "廿四":index=23;break;
            case "廿五":index=24;break;
            case "廿六":index=25;break;
            case "廿七":index=26;break;
            case "廿八":index=27;break;
            case "廿九":index=28;break;
            case "三十":index=29;break;
            default:index=19;

        }
        System.out.println(str+"-"+index);
        return index;
    }

    @Override
    public String getZhitoIndex(int index) {
        String strs="未知";
        switch(index){
            case 0:strs="子";break;
            case 1:strs="丑";break;
            case 2:strs="寅";break;
            case 3:strs="卯";break;
            case 4:strs="辰";break;
            case 5:strs="巳";break;
            case 6:strs="午";break;
            case 7:strs="未";break;
            case 8:strs="申";break;
            case 9:strs="酉";break;
            case 10:strs="戌";break;
            case 11:strs="亥";break;
            default:strs=strs;
        }
        return strs;
    }

    @Override
    public String getYinYangIndex(String str,String sex) {
        String strs="未知";
        switch(str){
            case "甲":strs="阳";break;
            case "乙":strs="阴";break;
            case "丙":strs="阳";break;
            case "丁":strs="阴";break;
            case "戊":strs="阳";break;
            case "己":strs="阴";break;
            case "庚":strs="阳";break;
            case "辛":strs="阴";break;
            case "壬":strs="阳";break;
            case "癸":strs="阴";break;
            case "子":strs="阳";break;
            case "丑":strs="阴";break;
            case "寅":strs="阳";break;
            case "卯":strs="阴";break;
            case "辰":strs="阳";break;
            case "巳":strs="阴";break;
            case "午":strs="阳";break;
            case "未":strs="阴";break;
            case "申":strs="阳";break;
            case "酉":strs="阴";break;
            case "戌":strs="阳";break;
            case "亥":strs="阴";break;
            default:strs=strs;
        }
        return strs+sex;
    }

    @Autowired
    index index;

    @Autowired
    array array;

    public String getShenGongIndex(String month,String hour) {
        int m=index.getYueIndex(month);
        int h=index.getDiZhiIndex(hour);
        return array.getShenGongIndex(m,h);
    }
    public String getMingGongIndex(String month,String hour) {
        int m=index.getYueIndex(month);
        int h=index.getDiZhiIndex(hour);
        return array.getMingGongIndex(m,h);
    }
    public Map<String, Gong> getYuGongIndex( String ming) {

        int m=index.getDiZhiIndex(ming);
        String[] gongarr=array.getGongName();
        Map<String,Gong> map=new HashMap<>();
        for(int i=0;i<11;i++){
            Gong gong=new Gong();
            gong.setNickname(gongarr[i+1]);
            map.put(array.getYuGong(i,m),gong);
        }
        return map;
    }

    public String getWuXingJu(String shengniangan,String ming) {
        int m=index.getDiZhiIndexWXJ(ming);
        int g=index.getTianGanIndexWXJ(shengniangan);
        return array.getWuXingJu(g,m);
    }

    public String getZiWei(String wxj,String day) {
        int w=index.getWuXingJuIndex(wxj);
        int d=index.getDayIndex(day);
        return array.getZiWeiIndex(w,d);
    }

    public String getStarBright(String gong,String starName) {
        int n=index.getStarIndex(starName);
        int g=index.getDiZhiIndex(gong);
        return array.getStarBright(g,n);
    }


    public Map<String,Gong> getGongGan(Map<String,Gong> map,String niangan) {
        int n=index.getTianGanIndex(niangan);

        for(String key:map.keySet()){
            int g=index.getDiZhiIndex(key);
            map.get(key).setTianGan(array.getTianGan(n,g));
        }
        return map;
    }

    public Map<String, String> getZhuStarIndex(String idx) {
        int i=index.getDiZhiIndex(idx);
        Map<String, String> startMap = new HashMap<String, String>();
        Map<String, Integer> map=index.getStarIndex1();
        for (String key : map.keySet()) {
            startMap.put(key,array.getZhuStar(map.get(key),i));
        }
        return startMap;
    }


    public Map<String, String> getYueXing(String idx) {
        int i=index.getYueIndex(idx);
        Map<String, String> startMap = new HashMap<String, String>();
        Map<String, Integer> map=index.getYueXingIndex();
        for (String key : map.keySet()) {
            startMap.put(key,array.getYueXing(map.get(key),i));
        }
        return startMap;
    }

    public Map<String, String> getGanXing(String idx) {
        int i=index.getTianGanIndex(idx);
        Map<String, String> startMap = new HashMap<String, String>();
        Map<String, Integer> map=index.getYueXingIndex();
        for (String key : map.keySet()) {
            startMap.put(key,array.getGanXing(map.get(key),i));
        }
        return startMap;
    }

    public Map<String, String> getZhiXingIndex(String idx) {
        int i=index.getDiZhiIndex(idx);
        Map<String, String> startMap = new HashMap<String, String>();
        Map<String, Integer> map=index.getZhiXingIndex();
        for (String key : map.keySet()) {
            startMap.put(key,array.getZhiXing(map.get(key),i));
        }
        return startMap;
    }


}

