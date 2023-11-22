package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c extends a {
    public c(Context context, boolean z) {
        this.PlaceComponentResult = true;
        if (KClassImpl$Data$declaredNonStaticMembers$2("grs_sdk_global_route_config.json", context) == 0) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public final int BuiltInFictitiousFunctionClassFactory(String str) {
        this.getAuthRequestContext = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONObject2 == null) {
                return -1;
            }
            if (jSONObject2.length() != 0) {
                this.getAuthRequestContext.addAll(getAuthRequestContext(jSONObject2));
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    private static List<com.huawei.hms.framework.network.grs.local.model.b> getAuthRequestContext(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.MyBillsEntityDataFactory = next;
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                jSONObject2.getString("name");
                jSONObject2.getString("description");
                JSONArray jSONArray = null;
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    bVar.BuiltInFictitiousFunctionClassFactory = hashSet;
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public final int getAuthRequestContext(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = string;
            com.huawei.hms.framework.network.grs.local.model.a aVar = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009d A[Catch: JSONException -> 0x0136, TryCatch #0 {JSONException -> 0x0136, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:8:0x0036, B:10:0x003f, B:11:0x0052, B:13:0x0058, B:15:0x0069, B:22:0x0082, B:23:0x0097, B:25:0x009d, B:27:0x00b1, B:29:0x00b7, B:32:0x00c8, B:34:0x00d4, B:35:0x00d9, B:17:0x0070, B:19:0x0076, B:20:0x007b, B:36:0x00e1, B:38:0x00ec, B:43:0x00fd, B:45:0x0103, B:49:0x0114, B:51:0x011a, B:52:0x0121, B:54:0x0129, B:46:0x0108, B:39:0x00f1, B:41:0x00f7, B:48:0x010f), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4 A[Catch: JSONException -> 0x0136, TryCatch #0 {JSONException -> 0x0136, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:8:0x0036, B:10:0x003f, B:11:0x0052, B:13:0x0058, B:15:0x0069, B:22:0x0082, B:23:0x0097, B:25:0x009d, B:27:0x00b1, B:29:0x00b7, B:32:0x00c8, B:34:0x00d4, B:35:0x00d9, B:17:0x0070, B:19:0x0076, B:20:0x007b, B:36:0x00e1, B:38:0x00ec, B:43:0x00fd, B:45:0x0103, B:49:0x0114, B:51:0x011a, B:52:0x0121, B:54:0x0129, B:46:0x0108, B:39:0x00f1, B:41:0x00f7, B:48:0x010f), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a A[Catch: JSONException -> 0x0136, TryCatch #0 {JSONException -> 0x0136, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:8:0x0036, B:10:0x003f, B:11:0x0052, B:13:0x0058, B:15:0x0069, B:22:0x0082, B:23:0x0097, B:25:0x009d, B:27:0x00b1, B:29:0x00b7, B:32:0x00c8, B:34:0x00d4, B:35:0x00d9, B:17:0x0070, B:19:0x0076, B:20:0x007b, B:36:0x00e1, B:38:0x00ec, B:43:0x00fd, B:45:0x0103, B:49:0x0114, B:51:0x011a, B:52:0x0121, B:54:0x0129, B:46:0x0108, B:39:0x00f1, B:41:0x00f7, B:48:0x010f), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129 A[Catch: JSONException -> 0x0136, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0136, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:8:0x0036, B:10:0x003f, B:11:0x0052, B:13:0x0058, B:15:0x0069, B:22:0x0082, B:23:0x0097, B:25:0x009d, B:27:0x00b1, B:29:0x00b7, B:32:0x00c8, B:34:0x00d4, B:35:0x00d9, B:17:0x0070, B:19:0x0076, B:20:0x007b, B:36:0x00e1, B:38:0x00ec, B:43:0x00fd, B:45:0x0103, B:49:0x0114, B:51:0x011a, B:52:0x0121, B:54:0x0129, B:46:0x0108, B:39:0x00f1, B:41:0x00f7, B:48:0x010f), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9 A[SYNTHETIC] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int MyBillsEntityDataFactory(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.MyBillsEntityDataFactory(java.lang.String):int");
    }
}
