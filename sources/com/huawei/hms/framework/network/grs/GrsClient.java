package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.a;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final c grsClientGlobal;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = d.BuiltInFictitiousFunctionClassFactory(grsBaseInfo, context);
    }

    public boolean forceExpire() {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return false;
        }
        return cVar.PlaceComponentResult();
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else if (iQueryUrlCallBack == null) {
            Logger.w(c.BuiltInFictitiousFunctionClassFactory, "IQueryUrlCallBack is must not null for process continue.");
        } else if (cVar.KClassImpl$Data$declaredNonStaticMembers$2 == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (!cVar.getAuthRequestContext()) {
            Logger.i(c.BuiltInFictitiousFunctionClassFactory, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        } else {
            a aVar = cVar.getErrorConfigVersion;
            Context context = cVar.MyBillsEntityDataFactory;
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            String str3 = aVar.PlaceComponentResult(str, bVar, context).get(str2);
            if (!bVar.getAuthRequestContext()) {
                com.huawei.hms.framework.network.grs.g.k.c cVar2 = new com.huawei.hms.framework.network.grs.g.k.c(aVar.PlaceComponentResult, context);
                h hVar = aVar.BuiltInFictitiousFunctionClassFactory;
                hVar.getAuthRequestContext.execute(new h.b(cVar2, str, aVar.KClassImpl$Data$declaredNonStaticMembers$2, new a.b(str, str2, iQueryUrlCallBack, str3, context, aVar.PlaceComponentResult, aVar.getAuthRequestContext)));
                return;
            }
            String str4 = a.MyBillsEntityDataFactory;
            Logger.i(str4, "get unexpired cache localUrl");
            if (TextUtils.isEmpty(str3)) {
                iQueryUrlCallBack.onCallBackFail(-5);
                return;
            }
            com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
            Logger.i(str4, "ayncGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else if (iQueryUrlsCallBack == null) {
            Logger.w(c.BuiltInFictitiousFunctionClassFactory, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (cVar.KClassImpl$Data$declaredNonStaticMembers$2 == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (!cVar.getAuthRequestContext()) {
            Logger.i(c.BuiltInFictitiousFunctionClassFactory, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        } else {
            a aVar = cVar.getErrorConfigVersion;
            Context context = cVar.MyBillsEntityDataFactory;
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            Map<String, String> PlaceComponentResult = aVar.PlaceComponentResult(str, bVar, context);
            if (!bVar.getAuthRequestContext()) {
                com.huawei.hms.framework.network.grs.g.k.c cVar2 = new com.huawei.hms.framework.network.grs.g.k.c(aVar.PlaceComponentResult, context);
                h hVar = aVar.BuiltInFictitiousFunctionClassFactory;
                hVar.getAuthRequestContext.execute(new h.b(cVar2, str, aVar.KClassImpl$Data$declaredNonStaticMembers$2, new a.C0117a(str, PlaceComponentResult, iQueryUrlsCallBack, context, aVar.PlaceComponentResult, aVar.getAuthRequestContext)));
                return;
            }
            String str2 = a.MyBillsEntityDataFactory;
            Logger.i(str2, "get unexpired cache localUrls");
            if (PlaceComponentResult.isEmpty()) {
                iQueryUrlsCallBack.onCallBackFail(-5);
                return;
            }
            com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(PlaceComponentResult).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(PlaceComponentResult);
        }
    }

    public void clearSp() {
        c cVar = this.grsClientGlobal;
        if (cVar != null && cVar.getAuthRequestContext()) {
            String grsParasKey = cVar.KClassImpl$Data$declaredNonStaticMembers$2.getGrsParasKey(true, true, cVar.MyBillsEntityDataFactory);
            com.huawei.hms.framework.network.grs.e.c cVar2 = cVar.PlaceComponentResult;
            PLSharedPreferences pLSharedPreferences = cVar2.KClassImpl$Data$declaredNonStaticMembers$2;
            if (pLSharedPreferences != null) {
                synchronized (pLSharedPreferences) {
                    cVar2.KClassImpl$Data$declaredNonStaticMembers$2.remove(grsParasKey);
                }
            }
            com.huawei.hms.framework.network.grs.e.c cVar3 = cVar.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append(grsParasKey);
            sb.append("time");
            String obj = sb.toString();
            PLSharedPreferences pLSharedPreferences2 = cVar3.KClassImpl$Data$declaredNonStaticMembers$2;
            if (pLSharedPreferences2 != null) {
                synchronized (pLSharedPreferences2) {
                    cVar3.KClassImpl$Data$declaredNonStaticMembers$2.remove(obj);
                }
            }
            com.huawei.hms.framework.network.grs.e.c cVar4 = cVar.PlaceComponentResult;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(grsParasKey);
            sb2.append("ETag");
            String obj2 = sb2.toString();
            PLSharedPreferences pLSharedPreferences3 = cVar4.KClassImpl$Data$declaredNonStaticMembers$2;
            if (pLSharedPreferences3 != null) {
                synchronized (pLSharedPreferences3) {
                    cVar4.KClassImpl$Data$declaredNonStaticMembers$2.remove(obj2);
                }
            }
            h hVar = cVar.getAuthRequestContext;
            synchronized (hVar.BuiltInFictitiousFunctionClassFactory) {
                hVar.MyBillsEntityDataFactory.remove(grsParasKey);
            }
        }
    }

    public String synGetGrsUrl(String str, String str2) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return "";
        }
        String str3 = null;
        if (cVar.KClassImpl$Data$declaredNonStaticMembers$2 == null || str == null || str2 == null) {
            Logger.w(c.BuiltInFictitiousFunctionClassFactory, "invalid para!");
            return null;
        }
        if (cVar.getAuthRequestContext()) {
            a aVar = cVar.getErrorConfigVersion;
            Context context = cVar.MyBillsEntityDataFactory;
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            str3 = aVar.PlaceComponentResult(str, bVar, context).get(str2);
            if (bVar.getAuthRequestContext() && !TextUtils.isEmpty(str3)) {
                Logger.i(a.MyBillsEntityDataFactory, "get unexpired cache localUrl: %s", StringUtils.anonymizeMessage(str3));
                com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
                return str3;
            }
            String str4 = a.getAuthRequestContext(aVar.getAuthRequestContext(context, str), str).get(str2);
            if (!TextUtils.isEmpty(str4)) {
                Logger.i(a.MyBillsEntityDataFactory, "get url is from remote server");
                com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
                return str4;
            }
            if (TextUtils.isEmpty(str3)) {
                Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                str3 = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(context.getPackageName(), aVar.PlaceComponentResult).getAuthRequestContext(context, aVar.getAuthRequestContext, aVar.PlaceComponentResult, str, str2);
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrl");
            }
            Logger.i(a.MyBillsEntityDataFactory, "synGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
        }
        return str3;
    }

    public Map<String, String> synGetGrsUrls(String str) {
        c cVar = this.grsClientGlobal;
        if (cVar == null) {
            return new HashMap();
        }
        if (cVar.KClassImpl$Data$declaredNonStaticMembers$2 == null || str == null) {
            Logger.w(c.BuiltInFictitiousFunctionClassFactory, "invalid para!");
            return new HashMap();
        } else if (!cVar.getAuthRequestContext()) {
            return new HashMap();
        } else {
            a aVar = cVar.getErrorConfigVersion;
            Context context = cVar.MyBillsEntityDataFactory;
            com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
            Map<String, String> PlaceComponentResult = aVar.PlaceComponentResult(str, bVar, context);
            if (bVar.getAuthRequestContext() && !PlaceComponentResult.isEmpty()) {
                Logger.i(a.MyBillsEntityDataFactory, "get unexpired cache localUrls: %s", StringUtils.anonymizeMessage(new JSONObject(PlaceComponentResult).toString()));
                com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
                return PlaceComponentResult;
            }
            Map<String, String> authRequestContext = a.getAuthRequestContext(aVar.getAuthRequestContext(context, str), str);
            if (!authRequestContext.isEmpty()) {
                Logger.i(a.MyBillsEntityDataFactory, "get url is from remote server");
                com.huawei.hms.framework.network.grs.f.b.MyBillsEntityDataFactory(context, aVar.PlaceComponentResult);
                return authRequestContext;
            }
            if (PlaceComponentResult.isEmpty()) {
                Logger.i(a.MyBillsEntityDataFactory, "access local config for return a domain.");
                PlaceComponentResult = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(context.getPackageName(), aVar.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(context, aVar.getAuthRequestContext, aVar.PlaceComponentResult, str, true);
            } else {
                Logger.i(a.MyBillsEntityDataFactory, "get expired cache localUrls");
            }
            String str2 = a.MyBillsEntityDataFactory;
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.anonymizeMessage(PlaceComponentResult != null ? new JSONObject(PlaceComponentResult).toString() : "");
            Logger.i(str2, "synGetGrsUrls: %s", objArr);
            return PlaceComponentResult;
        }
    }
}
