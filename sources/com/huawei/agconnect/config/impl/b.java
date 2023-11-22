package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements AGConnectOptions {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final AGCRoutePolicy KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final d NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context PlaceComponentResult;
    public final List<Service> getAuthRequestContext;
    private final e getErrorConfigVersion;
    private final Map<String, String> lookAheadTest = new HashMap();
    private final Map<String, String> scheduleImpl;

    @Override // com.huawei.agconnect.AGConnectOptions
    public final AGCRoutePolicy BuiltInFictitiousFunctionClassFactory() {
        AGCRoutePolicy aGCRoutePolicy = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return aGCRoutePolicy == null ? AGCRoutePolicy.getAuthRequestContext : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final String MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.PlaceComponentResult = context;
        str = str == null ? context.getPackageName() : str;
        this.MyBillsEntityDataFactory = str;
        if (inputStream != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new h(inputStream, str);
            Utils.PlaceComponentResult(inputStream);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new k(context, str);
        }
        this.getErrorConfigVersion = new e(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (aGCRoutePolicy != AGCRoutePolicy.getAuthRequestContext && "1.0".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.getAuthRequestContext) ? Utils.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory("/region", null), this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory("/agcgw/url", null)) : aGCRoutePolicy;
        this.scheduleImpl = Utils.PlaceComponentResult(map);
        this.getAuthRequestContext = list;
        StringBuilder sb = new StringBuilder();
        sb.append("{packageName='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append(", routePolicy=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", reader=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0.toString().hashCode());
        sb.append(", customConfigMap=");
        sb.append(new JSONObject(this.scheduleImpl).toString().hashCode());
        sb.append('}');
        this.BuiltInFictitiousFunctionClassFactory = String.valueOf(sb.toString().hashCode());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    @Override // com.huawei.agconnect.AGConnectOptions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r4 = com.huawei.agconnect.config.impl.Utils.BuiltInFictitiousFunctionClassFactory(r4)
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.scheduleImpl
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L13
            return r1
        L13:
            java.util.Map r1 = com.huawei.agconnect.JsonProcessingFactory.KClassImpl$Data$declaredNonStaticMembers$2()
            boolean r2 = r1.containsKey(r4)
            if (r2 != 0) goto L1f
        L1d:
            r1 = r0
            goto L42
        L1f:
            java.util.Map<java.lang.String, java.lang.String> r2 = r3.lookAheadTest
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L30
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.lookAheadTest
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            goto L42
        L30:
            java.lang.Object r1 = r1.get(r4)
            com.huawei.agconnect.JsonProcessingFactory$JsonProcessor r1 = (com.huawei.agconnect.JsonProcessingFactory.JsonProcessor) r1
            if (r1 != 0) goto L39
            goto L1d
        L39:
            java.lang.String r1 = r1.getAuthRequestContext(r3)
            java.util.Map<java.lang.String, java.lang.String> r2 = r3.lookAheadTest
            r2.put(r4, r1)
        L42:
            if (r1 == 0) goto L45
            return r1
        L45:
            com.huawei.agconnect.config.impl.d r1 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r4 = r1.BuiltInFictitiousFunctionClassFactory(r4, r0)
            boolean r1 = com.huawei.agconnect.config.impl.e.KClassImpl$Data$declaredNonStaticMembers$2(r4)
            if (r1 == 0) goto L57
            com.huawei.agconnect.config.impl.e r1 = r3.getErrorConfigVersion
            java.lang.String r4 = r1.PlaceComponentResult(r4, r0)
        L57:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.b.BuiltInFictitiousFunctionClassFactory(java.lang.String):java.lang.String");
    }
}
