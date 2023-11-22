package com.huawei.hms.hatool;

import android.content.Context;

/* loaded from: classes8.dex */
public final class h1 {
    public static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    public static h1 MyBillsEntityDataFactory;
    public Context KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        new String[]{"ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag"};
    }

    public static h1 PlaceComponentResult() {
        if (MyBillsEntityDataFactory == null) {
            synchronized (h1.class) {
                if (MyBillsEntityDataFactory == null) {
                    MyBillsEntityDataFactory = new h1();
                }
            }
        }
        return MyBillsEntityDataFactory;
    }
}
