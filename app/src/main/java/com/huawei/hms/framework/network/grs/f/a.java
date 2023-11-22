package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import id.dana.analytics.tracker.TrackerKey;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class a {
    protected com.huawei.hms.framework.network.grs.local.model.a KClassImpl$Data$declaredNonStaticMembers$2;
    protected List<com.huawei.hms.framework.network.grs.local.model.b> getAuthRequestContext;
    protected Map<String, String> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap(16);
    protected boolean MyBillsEntityDataFactory = false;
    protected boolean PlaceComponentResult = false;
    protected boolean lookAheadTest = false;
    protected Set<String> scheduleImpl = new HashSet(16);

    private int PlaceComponentResult(String str) {
        this.getAuthRequestContext = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONArray == null) {
                return -1;
            }
            this.getAuthRequestContext.addAll(BuiltInFictitiousFunctionClassFactory(jSONArray));
            return 0;
        } catch (JSONException e) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public abstract int BuiltInFictitiousFunctionClassFactory(String str);

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.lookAheadTest;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    public abstract int MyBillsEntityDataFactory(String str);

    public final com.huawei.hms.framework.network.grs.local.model.a MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public abstract int getAuthRequestContext(String str);

    public final String getAuthRequestContext(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2) {
        Map<String, String> MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, aVar, grsBaseInfo, str, true);
        if (MyBillsEntityDataFactory == null) {
            Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
            return null;
        }
        return MyBillsEntityDataFactory.get(str2);
    }

    public final Set<String> getAuthRequestContext() {
        return this.scheduleImpl;
    }

    private static Map<String, String> PlaceComponentResult(List<com.huawei.hms.framework.network.grs.local.model.b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : list) {
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.MyBillsEntityDataFactory);
            }
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.MyBillsEntityDataFactory);
            }
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.MyBillsEntityDataFactory);
            }
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.MyBillsEntityDataFactory);
            }
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(String str, Context context) {
        int authRequestContext;
        char c;
        StringBuilder sb = new StringBuilder();
        sb.append(GrsApp.getInstance().getBrand("/"));
        sb.append(str);
        String obj = sb.toString();
        String BuiltInFictitiousFunctionClassFactory = com.huawei.hms.framework.network.grs.h.c.BuiltInFictitiousFunctionClassFactory(obj, context);
        if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
            authRequestContext = -1;
        } else if ((!this.PlaceComponentResult || (authRequestContext = BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory)) == 0) && (authRequestContext = getAuthRequestContext(BuiltInFictitiousFunctionClassFactory)) == 0) {
            authRequestContext = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
        }
        if (authRequestContext == 0) {
            Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", obj);
            c = 0;
        } else {
            c = 65535;
        }
        return c != 0 ? -1 : 0;
    }

    private static List<com.huawei.hms.framework.network.grs.local.model.b> BuiltInFictitiousFunctionClassFactory(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.MyBillsEntityDataFactory = jSONObject.getString("id");
                jSONObject.getString("name");
                jSONObject.getString("description");
                JSONArray jSONArray2 = null;
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null && jSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        hashSet.add((String) jSONArray2.get(i2));
                    }
                    bVar.BuiltInFictitiousFunctionClassFactory = hashSet;
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    public final Map<String, String> MyBillsEntityDataFactory(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        com.huawei.hms.framework.network.grs.local.model.c cVar;
        com.huawei.hms.framework.network.grs.local.model.d dVar;
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Logger.w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
            cVar = null;
        } else {
            cVar = aVar2.PlaceComponentResult.get(str);
        }
        if (cVar == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String PlaceComponentResult = e.PlaceComponentResult(context, aVar, cVar.MyBillsEntityDataFactory, grsBaseInfo, z);
        if (PlaceComponentResult == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", cVar.MyBillsEntityDataFactory);
            return null;
        }
        List<com.huawei.hms.framework.network.grs.local.model.b> list = cVar.PlaceComponentResult;
        String str2 = ((list == null || list.size() == 0) ? this.BuiltInFictitiousFunctionClassFactory : PlaceComponentResult(list, grsBaseInfo, PlaceComponentResult)).get(PlaceComponentResult);
        if (TextUtils.isEmpty(str2)) {
            Logger.w(TrackerKey.Property.SERVICE, "In servings.getServing(String groupId), the groupId is Empty or null");
            dVar = null;
        } else {
            dVar = cVar.BuiltInFictitiousFunctionClassFactory.get(str2);
        }
        if (dVar == null) {
            return null;
        }
        return dVar.PlaceComponentResult;
    }

    public final void PlaceComponentResult() {
        com.huawei.hms.framework.network.grs.local.model.a aVar = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar != null) {
            Map<String, com.huawei.hms.framework.network.grs.local.model.c> map = aVar.PlaceComponentResult;
            if (map != null) {
                map.clear();
            }
            this.lookAheadTest = true;
        }
    }

    public final void MyBillsEntityDataFactory(Context context, List<String> list) {
        List<com.huawei.hms.framework.network.grs.local.model.b> list2;
        int PlaceComponentResult;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(GrsApp.getInstance().getBrand("/"));
                sb.append(str);
                String BuiltInFictitiousFunctionClassFactory = com.huawei.hms.framework.network.grs.h.c.BuiltInFictitiousFunctionClassFactory(sb.toString(), context);
                if ((TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) ? -1 : (!this.PlaceComponentResult || !((list2 = this.getAuthRequestContext) == null || list2.isEmpty()) || (PlaceComponentResult = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory)) == 0) ? KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory) : PlaceComponentResult) == 0) {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(GrsBaseInfo grsBaseInfo) {
        this.BuiltInFictitiousFunctionClassFactory.put("no_route_country", "no-country");
        List<com.huawei.hms.framework.network.grs.local.model.b> list = this.getAuthRequestContext;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : this.getAuthRequestContext) {
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getIssueCountry())) {
                this.BuiltInFictitiousFunctionClassFactory.put(grsBaseInfo.getIssueCountry(), bVar.MyBillsEntityDataFactory);
            }
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getRegCountry())) {
                this.BuiltInFictitiousFunctionClassFactory.put(grsBaseInfo.getRegCountry(), bVar.MyBillsEntityDataFactory);
            }
            if (bVar.BuiltInFictitiousFunctionClassFactory.contains(grsBaseInfo.getSerCountry())) {
                this.BuiltInFictitiousFunctionClassFactory.put(grsBaseInfo.getSerCountry(), bVar.MyBillsEntityDataFactory);
            }
        }
        this.getAuthRequestContext = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(org.json.JSONArray r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.KClassImpl$Data$declaredNonStaticMembers$2(org.json.JSONArray):void");
    }
}
