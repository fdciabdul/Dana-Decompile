package com.alipay.multigateway.sdk;

import androidx.collection.ArrayMap;
import com.alipay.multigateway.sdk.decision.condition.getter.IGetter;
import java.util.Map;

/* loaded from: classes3.dex */
public class ConditionValueGetter {
    private static ConditionValueGetter sInstance;
    private final Map<String, IGetter> gettersMap = new ArrayMap();

    public static ConditionValueGetter getInstance() {
        if (sInstance == null) {
            synchronized (ConditionValueGetter.class) {
                if (sInstance == null) {
                    sInstance = new ConditionValueGetter();
                }
            }
        }
        return sInstance;
    }

    public void addGetter(String str, IGetter iGetter) {
        this.gettersMap.put(str, iGetter);
    }

    public <T> T getValue(String str, Object obj) {
        IGetter iGetter = this.gettersMap.get(str);
        if (iGetter == null) {
            return null;
        }
        return (T) iGetter.getValue(obj);
    }
}
