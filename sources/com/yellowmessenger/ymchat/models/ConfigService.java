package com.yellowmessenger.ymchat.models;

import com.yellowmessenger.ymchat.YMConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ConfigService {
    private static ConfigService getAuthRequestContext;
    public YMConfig PlaceComponentResult = new YMConfig("");
    public Map<String, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    public Map<String, String> MyBillsEntityDataFactory = new HashMap();

    private ConfigService() {
    }

    public static ConfigService MyBillsEntityDataFactory() {
        if (getAuthRequestContext == null) {
            synchronized (ConfigService.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new ConfigService();
                }
            }
        }
        return getAuthRequestContext;
    }

    public final boolean PlaceComponentResult(YMConfig yMConfig) {
        if (yMConfig != null) {
            this.PlaceComponentResult = yMConfig;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = yMConfig.initRecordTimeStamp;
            this.MyBillsEntityDataFactory = yMConfig.getErrorConfigVersion != null ? yMConfig.getErrorConfigVersion : new HashMap<>();
            return true;
        }
        return false;
    }
}
