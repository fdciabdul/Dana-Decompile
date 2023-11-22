package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes8.dex */
public class aw {
    private static volatile aw PlaceComponentResult;
    private Context BuiltInFictitiousFunctionClassFactory;

    private aw(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    public static aw KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (PlaceComponentResult == null) {
            synchronized (aw.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new aw(context);
                }
            }
        }
        return PlaceComponentResult;
    }
}
