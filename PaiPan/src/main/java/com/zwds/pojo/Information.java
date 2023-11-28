package com.zwds.pojo;

import com.zwds.pojo.Gong;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Information {
    private String wuxingju;
    private Map<String, Gong> gong;
    private List<Gong> gongs;
}
