package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes8.dex */
public final class i {
    public static i BuiltInFictitiousFunctionClassFactory;
    public static Map<String, m> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    public l MyBillsEntityDataFactory = new l();

    public static void BuiltInFictitiousFunctionClassFactory(String str, m mVar) {
        KClassImpl$Data$declaredNonStaticMembers$2.put(str, mVar);
    }

    public static m PlaceComponentResult(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2.get(str);
    }

    public static Set<String> getAuthRequestContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2.keySet();
    }

    public static i KClassImpl$Data$declaredNonStaticMembers$2() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (i.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new i();
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }
}
