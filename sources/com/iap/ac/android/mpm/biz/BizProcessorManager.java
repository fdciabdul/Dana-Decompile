package com.iap.ac.android.mpm.biz;

import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BizProcessorManager {
    private static Map<String, BaseBizProcessor> bizProcessorMap = new HashMap();

    public static void addProcessor(String str, BaseBizProcessor baseBizProcessor) {
        bizProcessorMap.put(str, baseBizProcessor);
    }

    public static BaseBizProcessor getProcessor(String str) {
        return bizProcessorMap.get(str);
    }

    public static void removeProcessor(String str) {
        bizProcessorMap.remove(str);
    }
}
