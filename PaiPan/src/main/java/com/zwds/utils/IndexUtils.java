package com.zwds.utils;

import org.springframework.stereotype.Service;

@Service
public class IndexUtils {
    public int getShiIndex(String str) {
        int index=0;

        switch(str){
            case "寅":index=0;break;
            case "午":index=0;break;
            case "戌":index=0;break;
            case "申":index=1;break;
            case "子":index=1;break;
            case "辰":index=1;break;
            case "己":index=2;break;
            case "酉":index=2;break;
            case "丑":index=2;break;
            case "亥":index=3;break;
            case "卯":index=3;break;
            case "未":index=3;break;
            default:index=19;

        }
        System.out.println(str+"-"+index);
        return index;
    }


}
