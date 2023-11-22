package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.a;
import com.xiaomi.push.bg;
import com.xiaomi.push.dv;
import com.xiaomi.push.eb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MiPushClient4Hybrid {
    private static Map<String, a.C0157a> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    private static Map<String, Long> getAuthRequestContext = new HashMap();

    /* loaded from: classes8.dex */
    public static class MiPushCallback {
    }

    public static void BuiltInFictitiousFunctionClassFactory(eb ebVar) {
        PushMessageHelper.BuiltInFictitiousFunctionClassFactory(bg.COMMAND_UNREGISTER.f83a, null, ebVar.f361a, ebVar.f369d, null);
        ebVar.a();
    }

    public static void PlaceComponentResult(Context context, dv dvVar) {
        a.C0157a c0157a;
        String c = dvVar.c();
        if (dvVar.a() == 0 && (c0157a = KClassImpl$Data$declaredNonStaticMembers$2.get(c)) != null) {
            String str = dvVar.f295e;
            String str2 = dvVar.f296f;
            c0157a.lookAheadTest = str;
            c0157a.getErrorConfigVersion = str2;
            c0157a.scheduleImpl = com.xiaomi.channel.commonutils.android.c.getErrorConfigVersion(c0157a.PlaceComponentResult);
            Context context2 = c0157a.PlaceComponentResult;
            c0157a.NetworkUserEntityData$$ExternalSyntheticLambda0 = com.xiaomi.channel.commonutils.android.a.BuiltInFictitiousFunctionClassFactory(context2, context2.getPackageName());
            c0157a.getAuthRequestContext = true;
            a PlaceComponentResult = a.PlaceComponentResult(context);
            PlaceComponentResult.PlaceComponentResult.put(c, c0157a);
            String MyBillsEntityDataFactory = a.C0157a.MyBillsEntityDataFactory(c0157a);
            StringBuilder sb = new StringBuilder();
            sb.append("hybrid_app_info_");
            sb.append(c);
            a.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult.getAuthRequestContext).edit().putString(sb.toString(), MyBillsEntityDataFactory).commit();
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(dvVar.f295e)) {
            arrayList = new ArrayList();
            arrayList.add(dvVar.f295e);
        }
        PushMessageHelper.BuiltInFictitiousFunctionClassFactory(bg.COMMAND_REGISTER.f83a, arrayList, dvVar.f285a, dvVar.f294d, null);
    }
}
