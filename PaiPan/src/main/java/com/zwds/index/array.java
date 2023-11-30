package com.zwds.index;

import org.springframework.stereotype.Service;

@Service
public class array {

    public String getMingGongIndex(int month,int hour) {

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
        return arr[month][hour];

    }


    public String getShenGongIndex(int month,int hour) {

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
        return arr[month][hour];

    }

    public String getWuXingJu(int tiangan, int dizhi) {

        String[][] arr = {
                {"水二局","火六局","木三局","土五局","金四局","火六局"},
                {"火六局","土五局","金四局","木三局","水二局","土五局"},
                {"土五局","木三局","水二局","金四局","火六局","木三局"},
                {"木三局","金四局","火六局","水二局","土五局","金四局"},
                {"金四局","水二局","土五局","火六局","木三局","水二局"},
        };
        return arr[tiangan][dizhi];
    }

    public String getZiWeiIndex(int wxj, int day) {
        String[][] arr = {
                {"丑","寅","寅","卯","卯","辰","辰","巳","巳","午","午","未","未","申","申","酉","酉","戌","戌","亥","亥","子","子","丑","丑","寅","寅","卯","卯","辰"},
                {"辰","丑","寅","巳","寅","卯","午","卯","辰","未","辰","巳","申","巳","午","酉","午","未","戌","未","申","亥","申","酉","子","酉","戌","丑","戌","亥"},
                {"亥","辰","丑","寅","子","巳","寅","卯","丑","午","卯","辰","寅","未","辰","巳","卯","申","巳","午","辰","酉","午","丑","丑","戌","未","申","午","亥"},
                {"午","亥","辰","丑","寅","未","子","巳","寅","卯","申","丑","午","卯","辰","酉","寅","未","辰","巳","戌","卯","申","巳","午","亥","辰","酉","午","未"},
                {"酉","午","亥","辰","丑","寅","戌","未","子","巳","寅","卯","亥","申","丑","午","卯","辰","子","酉","寅","未","辰","巳","丑","戌","卯","申","巳","午"}
        };
        return arr[wxj][day];
    }

    public String getStarSiHua(int gong, int niangan) {
        String[][] arr = {
//                 紫微1-天机1-太阳1-武曲1-天同1廉贞1天府1太阴1贪狼1-巨门1天相1天梁1-七杀1破军1文昌1-文曲--禄存--擎羊--陀罗--火星--铃星--左辅--右弼
                {"","","忌","科","","禄","","","","","","","","权","","","","","","","","",""},
                {"科","禄","","","","","","忌","","","","权","","","","","","","","","","",""},
                {"","权","","","禄","忌","","","","","","","","","科","","","","","","","",""},
                {"","科","","","权","","","禄","","忌","","","","","","","","","","","","",""},
                {"","忌","","","","","","权","禄","","","","","","","","","","","","","","科"},
                {"旺","","","禄","","","","","","","","科","","","","忌","","","","","","",""},
                {"","","禄","权","忌","","","科","","","","","","","","","","","","","","",""},
                {"","","权","","","","","","","禄","","","","","","忌","科","","","","","",""},
                {"权","","","忌","","","","","","","","禄","","","","","","","","","","科",""},
                {"","","","","","","","科","忌","权","","","","禄","","","","","","","","",""}
        };
        System.out.println(niangan+"ziwei");
        return arr[gong][niangan];
    }

    public String getStarBright(int gong, int niangan) {
        String[][] arr = {
//                 紫微1-天机2-太阳3-武曲4-天同5廉贞6天府7太阴8贪狼9-巨门10天相11天梁12-七杀13破军14文昌15-文曲16--禄存17--擎羊18--陀罗19--火星20--铃星21--左辅--右弼
                {"平","庙","陷","旺","旺","平","庙","庙","旺","旺","庙","庙","旺","庙","得","得","庙","陷","19","陷","陷","",""},
                {"庙","陷","不","庙","不","利","庙","庙","庙","不","庙","旺","庙","旺","庙","庙","17","庙","庙","得","得","",""},
                {"旺","得","旺","得","利","庙","庙","旺","平","庙","庙","庙","庙","得","陷","平","庙","18","陷","庙","庙","",""},
                {"旺","旺","庙","利","平","平","得","陷","利","庙","陷","庙","旺","陷","利","旺","庙","陷","19","利","利","",""},
                {"得","利","旺","庙","平","利","庙","陷","庙","陷","得","庙","庙","旺","得","得","17","庙","庙","陷","陷","",""},
                {"旺","平","旺","平","庙","陷","得","陷","陷","旺","得","陷","平","平","庙","庙","庙","18","陷","得","得","",""},
                {"庙","庙","旺","旺","陷","平","旺","不","旺","旺","庙","庙","旺","庙","陷","陷","庙","陷","19","庙","庙","",""},
                {"庙","陷","得","庙","不","利","庙","不","庙","不","得","旺","庙","旺","利","旺","17","庙","庙","利","利","",""},
                {"旺","得","得","得","旺","庙","得","利","平","庙","庙","陷","庙","得","15","16","庙","18","陷","陷","陷","",""},
                {"旺","旺","平","利","平","平","旺","旺","利","庙","陷","得","旺","陷","庙","庙","庙","陷","19","得","得","",""},
                {"得","利","不","庙","平","利","庙","旺","庙","陷","得","庙","庙","旺","陷","陷","17","庙","庙","庙","庙","",""},
                {"旺","平","陷","平","庙","陷","得","庙","陷","旺","得","陷","平","平","利","旺","庙","18","陷","利","利","",""},
        };
        System.out.println(niangan+"ziwei");
        return arr[gong][niangan];
    }

    public String getTianGan(int gong, int niangan) {
        String[][] arr = {
//                 紫微1-天机1-太阳1-武曲1-天同1廉贞1天府1太阴1贪狼1-巨门1天相1天梁1-七杀1破军1文昌1-文曲--禄存--擎羊--陀罗--火星--铃星--左辅--右弼
                {"丙","丁","丙","丁","戊","己","庚","辛","壬","癸","甲","乙"},
                {"戊","己","戊","己","庚","辛","壬","癸","甲","乙","丙","丁"},
                {"庚","辛","庚","辛","壬","癸","甲","乙","丙","丁","戊","己"},
                {"壬","癸","壬","癸","甲","乙","丙","丁","戊","己","庚","辛"},
                {"甲","乙","甲","乙","丙","丁","戊","己","庚","辛","壬","癸"},
                {"丙","丁","丙","丁","戊","己","庚","辛","壬","癸","甲","乙"},
                {"戊","己","戊","己","庚","辛","壬","癸","甲","乙","丙","丁"},
                {"庚","辛","庚","辛","壬","癸","甲","乙","丙","丁","戊","己"},
                {"壬","癸","壬","癸","甲","乙","丙","丁","戊","己","庚","辛"},
                {"甲","乙","甲","乙","丙","丁","戊","己","庚","辛","壬","癸"},
        };
        System.out.println(niangan+"ziwei");
        return arr[gong][niangan];
    }

    public String getDaXian(int month,int hour,int or) {

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
        return arr[month][hour];

    }


    public String getXiaoXian(int month,int hour,int or) {

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
        return arr[month][hour];

    }


    public String getWuXingChangSheng(int month,int hour,int or) {

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
                {"未","戌","辰","未","丑"},
                {"午","酉","卯","午","子"},
                {"巳","申","寅","巳","亥"},
                {"辰","未","丑","辰","戌"},
                {"卯","午","子","卯","酉"},
                {"寅","巳","亥","寅","申"},
                {"丑","辰","戌","丑","未"},
                {"子","卯","酉","子","午"},
                {"亥","寅","申","亥","巳"},
                {"戌","丑","未","戌","辰"},
                {"酉","子","午","酉","卯"}
        };
        String[][] arr;
        if(or==0){
            arr=arr1;
        }else{
            arr=arr2;
        }
        return arr[month][hour];

    }

    public String getZhiXing(int gong, int niangan) {
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

        return arr[gong][niangan];
    }

    public String getGanXing(int gong, int niangan) {
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

        return arr[gong][niangan];
    }

    public String getYueXing(int gong, int niangan) {
        String[][] arr = {
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"},
                {"巳","申","寅","亥","巳","申","寅","亥","巳","申","寅","亥"},
                {"戌","巳","辰","寅","未","卯","亥","未","寅","午","戌","寅"},
                {"寅","子","戌","申","午","辰","寅","子","戌","申","午","辰"},
        };

        return arr[gong][niangan];
    }

    public String getJiangQian(int gong, int niangan) {
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

        return arr[gong][niangan];
    }

    public String getSuiQian(int gong, int niangan) {
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

        return arr[gong][niangan];
    }

    public String getYuGong(int gong, int ming) {
        String[][] arr = {
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"午","未","申","酉","戌","亥","子","丑","寅","卯","辰","巳"},
                {"巳","午","未","申","酉","戌","亥","子","丑","寅","卯","辰"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                {"丑","寅","卯","辰","巳","午","未","申","酉","戌","亥","子"}
        };

        return arr[gong][ming];
    }
    public String[] getGongName() {
        String[] gongarr={"命宫","兄弟宫","夫妻宫","子女宫","财帛宫","疾厄宫","迁移宫","交友宫","官禄宫","田宅","福德宫","父母宫"};
        return gongarr;
    }

    public String getZhuStar(int gong, int niangan) {
        String[][] arr = {
                {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"},
                {"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"},
                {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
                {"申","酉","戌","亥","子","丑","寅","卯","辰","巳","午","未"},
                {"未","申","酉","戌","亥","子","丑","寅","卯","辰","巳","午"},
                {"辰","巳","午","未","申","酉","戌","亥","子","丑","寅","卯"},
                {"辰","卯","寅","丑","子","亥","戌","酉","申","未","午","巳"},
                {"巳","辰","卯","寅","丑","子","亥","戌","酉","申","未","午"},
                {"午","巳","辰","卯","寅","丑","子","亥","戌","酉","申","未"},
                {"未","午","巳","辰","卯","寅","丑","子","亥","戌","酉","申"},
                {"申","未","午","巳","辰","卯","寅","丑","子","亥","戌","酉"},
                {"酉","申","未","午","巳","辰","卯","寅","丑","子","亥","戌"},
                {"戌","酉","申","未","午","巳","辰","卯","寅","丑","子","亥"},
                {"寅","丑","子","亥","戌","酉","申","未","午","巳","辰","卯"},


        };

        return arr[gong][niangan];
    }


    public String getBoShi(int month,int hour,int or) {

        String[][] arr1 = {
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
        String[][] arr2 = {
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
        String[][] arr;
        if(or==0){
            arr=arr1;
        }else{
            arr=arr2;
        }
        return arr[month][hour];

    }

    public String[][] getHuoAndLing(int index) {
        String[][] arr=new String[12][2];
        if(index==0){
            arr = new String[][]{
                    {"丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子"},
                    {"卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑", "寅"}
            };
        }else if(index==1){
            arr = new String[][]{
                    {"寅","卯","辰","巳","午","未","申","酉","戌","亥","子","丑"},
                    {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"}
            };
        }else if(index==2){
            arr = new String[][]{
                    {"卯","辰","巳","午","未","申","酉","戌","亥","子","丑","寅"},
                    {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"}
            };
        }else if(index==3){
            arr = new String[][]{
                    {"戌","亥","子","丑","寅","卯","辰","巳","午","未","申","酉"},
                    {"酉","戌","亥","子","丑","寅","卯","辰","巳","午","未","申"},
            };
        }

        return arr;

    }

}
