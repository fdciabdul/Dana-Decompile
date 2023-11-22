package com.alipay.mobile.jsengine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class LogData {
    private Map<String, String> currentParamMap;
    private Map<String, String> param1Map;
    private Map<String, String> param2Map;
    private Map<String, String> param3Map;
    private Map<String, String> param4Map;
    private String seedId;

    public static LogData seedId(String str) {
        return new LogData(str);
    }

    private LogData(String str) {
        this.seedId = str;
    }

    public String getSeedId() {
        return this.seedId;
    }

    public Map<String, String> getParam1Map() {
        return this.param1Map;
    }

    public Map<String, String> getParam2Map() {
        return this.param2Map;
    }

    public Map<String, String> getParam3Map() {
        return this.param3Map;
    }

    public Map<String, String> getParam4Map() {
        return this.param4Map;
    }

    public LogData param1() {
        if (this.param1Map == null) {
            this.param1Map = new HashMap();
        }
        this.currentParamMap = this.param1Map;
        return this;
    }

    public LogData param2() {
        if (this.param2Map == null) {
            this.param2Map = new HashMap();
        }
        this.currentParamMap = this.param2Map;
        return this;
    }

    public LogData param3() {
        if (this.param3Map == null) {
            this.param3Map = new HashMap();
        }
        this.currentParamMap = this.param3Map;
        return this;
    }

    public LogData param4() {
        if (this.param4Map == null) {
            this.param4Map = new HashMap();
        }
        this.currentParamMap = this.param4Map;
        return this;
    }

    public LogData add(String str, Object obj) {
        Map<String, String> map = this.currentParamMap;
        if (map == null) {
            return this;
        }
        map.put(str, obj == null ? "" : obj.toString());
        return this;
    }
}
