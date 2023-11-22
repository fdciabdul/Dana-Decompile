package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.h.e;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2 = "a";
    public final Map<String, Map<String, Map<String, String>>> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap(16);
    public final Map<String, Long> MyBillsEntityDataFactory = new ConcurrentHashMap(16);
    public final h NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final c PlaceComponentResult;
    public final c getAuthRequestContext;

    public final Map<String, String> PlaceComponentResult(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = this.BuiltInFictitiousFunctionClassFactory.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        MyBillsEntityDataFactory(grsBaseInfo, bVar, context, str);
        return map.get(str);
    }

    public a(c cVar, c cVar2, h hVar) {
        this.getAuthRequestContext = cVar2;
        this.PlaceComponentResult = cVar;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = hVar;
        hVar.PlaceComponentResult = this;
    }

    private void MyBillsEntityDataFactory(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l = this.MyBillsEntityDataFactory.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.MyBillsEntityDataFactory(l)) {
            bVar.getAuthRequestContext = 2;
            return;
        }
        if (e.getAuthRequestContext(l)) {
            com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context);
            h hVar = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            hVar.getAuthRequestContext.execute(new h.b(cVar, str, this.getAuthRequestContext, null));
        }
        bVar.getAuthRequestContext = 1;
    }
}
