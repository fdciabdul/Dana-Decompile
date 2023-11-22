package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public final class e0 {
    public static e0 PlaceComponentResult;
    public volatile Map<String, f0> BuiltInFictitiousFunctionClassFactory = new HashMap();

    public static e0 PlaceComponentResult() {
        if (PlaceComponentResult == null) {
            synchronized (e0.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new e0();
                }
            }
        }
        return PlaceComponentResult;
    }
}
