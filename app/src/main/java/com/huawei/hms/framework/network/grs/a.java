package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    static final String MyBillsEntityDataFactory = "a";
    h BuiltInFictitiousFunctionClassFactory;
    com.huawei.hms.framework.network.grs.e.c KClassImpl$Data$declaredNonStaticMembers$2;
    final GrsBaseInfo PlaceComponentResult;
    com.huawei.hms.framework.network.grs.e.a getAuthRequestContext;

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.PlaceComponentResult = grsBaseInfo;
        this.getAuthRequestContext = aVar;
        this.BuiltInFictitiousFunctionClassFactory = hVar;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cVar;
    }

    private static Map<String, String> BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e) {
            Logger.w(MyBillsEntityDataFactory, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return concurrentHashMap;
        }
    }

    public static CountryCodeBean PlaceComponentResult(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    public static Map<String, Map<String, String>> PlaceComponentResult(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(MyBillsEntityDataFactory, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, BuiltInFictitiousFunctionClassFactory(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e) {
            Logger.w(MyBillsEntityDataFactory, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return concurrentHashMap;
        }
    }

    public static Map<String, String> getAuthRequestContext(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(MyBillsEntityDataFactory, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(MyBillsEntityDataFactory, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e) {
            Logger.w(MyBillsEntityDataFactory, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> PlaceComponentResult(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult, str, bVar, context);
        if (PlaceComponentResult == null || PlaceComponentResult.isEmpty()) {
            Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2 = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(context.getPackageName(), this.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(context, this.getAuthRequestContext, this.PlaceComponentResult, str, false);
            return KClassImpl$Data$declaredNonStaticMembers$2 == null ? new HashMap() : KClassImpl$Data$declaredNonStaticMembers$2;
        }
        com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, this.PlaceComponentResult);
        return PlaceComponentResult;
    }

    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0117a implements com.huawei.hms.framework.network.grs.b {
        Map<String, String> BuiltInFictitiousFunctionClassFactory;
        IQueryUrlsCallBack KClassImpl$Data$declaredNonStaticMembers$2;
        GrsBaseInfo MyBillsEntityDataFactory;
        String PlaceComponentResult;
        Context getAuthRequestContext;
        com.huawei.hms.framework.network.grs.e.a getErrorConfigVersion;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0117a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = map;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = iQueryUrlsCallBack;
            this.getAuthRequestContext = context;
            this.MyBillsEntityDataFactory = grsBaseInfo;
            this.getErrorConfigVersion = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            Map<String, String> map = this.BuiltInFictitiousFunctionClassFactory;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrls");
                this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackSuccess(this.BuiltInFictitiousFunctionClassFactory);
            } else if (this.BuiltInFictitiousFunctionClassFactory != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackFail(-3);
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPackageName(), this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.PlaceComponentResult, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public final void PlaceComponentResult(com.huawei.hms.framework.network.grs.g.d dVar) {
            Map<String, String> authRequestContext = a.getAuthRequestContext(dVar.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
            if (authRequestContext.isEmpty()) {
                Map<String, String> map = this.BuiltInFictitiousFunctionClassFactory;
                if (map != null && !map.isEmpty()) {
                    Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrls");
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackSuccess(this.BuiltInFictitiousFunctionClassFactory);
                    return;
                } else if (this.BuiltInFictitiousFunctionClassFactory != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackFail(-5);
                    return;
                } else {
                    Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                    authRequestContext = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPackageName(), this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.PlaceComponentResult, true);
                }
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "get url is from remote server");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onCallBackSuccess(authRequestContext);
        }
    }

    /* loaded from: classes7.dex */
    static class b implements com.huawei.hms.framework.network.grs.b {
        String BuiltInFictitiousFunctionClassFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        IQueryUrlCallBack MyBillsEntityDataFactory;
        GrsBaseInfo NetworkUserEntityData$$ExternalSyntheticLambda0;
        String PlaceComponentResult;
        Context getAuthRequestContext;
        com.huawei.hms.framework.network.grs.e.a lookAheadTest;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.MyBillsEntityDataFactory = iQueryUrlCallBack;
            this.PlaceComponentResult = str3;
            this.getAuthRequestContext = context;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = grsBaseInfo;
            this.lookAheadTest = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrl");
                this.MyBillsEntityDataFactory.onCallBackSuccess(this.PlaceComponentResult);
            } else if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                this.MyBillsEntityDataFactory.onCallBackFail(-3);
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                this.MyBillsEntityDataFactory.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPackageName(), this.NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext(this.getAuthRequestContext, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public final void PlaceComponentResult(com.huawei.hms.framework.network.grs.g.d dVar) {
            String authRequestContext;
            IQueryUrlCallBack iQueryUrlCallBack;
            Map<String, String> authRequestContext2 = a.getAuthRequestContext(dVar.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory);
            if (authRequestContext2.containsKey(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                Logger.i(a.MyBillsEntityDataFactory, "get url is from remote server");
                iQueryUrlCallBack = this.MyBillsEntityDataFactory;
                authRequestContext = authRequestContext2.get(this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrl");
                this.MyBillsEntityDataFactory.onCallBackSuccess(this.PlaceComponentResult);
                return;
            } else if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                this.MyBillsEntityDataFactory.onCallBackFail(-5);
                return;
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                authRequestContext = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPackageName(), this.NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext(this.getAuthRequestContext, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                iQueryUrlCallBack = this.MyBillsEntityDataFactory;
            }
            iQueryUrlCallBack.onCallBackSuccess(authRequestContext);
        }
    }

    public final String getAuthRequestContext(Context context, String str) {
        com.huawei.hms.framework.network.grs.g.d KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(new com.huawei.hms.framework.network.grs.g.k.c(this.PlaceComponentResult, context), str, this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return "";
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.getAuthRequestContext.PlaceComponentResult.getAuthRequestContext(this.PlaceComponentResult.getGrsParasKey(true, true, context), "");
        }
        return KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
    }
}
