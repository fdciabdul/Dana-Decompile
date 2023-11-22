package com.huawei.hms.framework.network.grs;

import android.content.Context;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class d {
    private static final Map<String, c> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap(16);
    private static final Object MyBillsEntityDataFactory = new Object();

    public static c BuiltInFictitiousFunctionClassFactory(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (MyBillsEntityDataFactory) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, c> map = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(uniqueCode);
            c cVar = map.get(sb.toString());
            if (cVar == null) {
                c cVar2 = new c(context, grsBaseInfo);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getPackageName());
                sb2.append(uniqueCode);
                map.put(sb2.toString(), cVar2);
                return cVar2;
            } else if (cVar.PlaceComponentResult((Object) new c(grsBaseInfo))) {
                return cVar;
            } else {
                c cVar3 = new c(context, grsBaseInfo);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getPackageName());
                sb3.append(uniqueCode);
                map.put(sb3.toString(), cVar3);
                return cVar3;
            }
        }
    }
}
