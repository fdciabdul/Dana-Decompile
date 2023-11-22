package com.huawei.agconnect;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class JsonProcessingFactory {
    private static final Map<String, JsonProcessor> MyBillsEntityDataFactory = new HashMap();

    /* loaded from: classes7.dex */
    public interface JsonProcessor {
        String getAuthRequestContext(AGConnectOptions aGConnectOptions);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, JsonProcessor jsonProcessor) {
        MyBillsEntityDataFactory.put(str, jsonProcessor);
    }
}
