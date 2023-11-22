package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.j;

/* loaded from: classes8.dex */
public class ac {
    public static AbstractPushManager BuiltInFictitiousFunctionClassFactory(Context context, c cVar) {
        j.a PlaceComponentResult = j.PlaceComponentResult(cVar);
        if (PlaceComponentResult == null || TextUtils.isEmpty(PlaceComponentResult.MyBillsEntityDataFactory) || TextUtils.isEmpty(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.z.PlaceComponentResult(PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, context);
    }
}
