package com.appsflyer.internal;

import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject AFKeystoreWrapper(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                if (jSONObject2.optBoolean(BlobStatic.INVTP_TYPE_MONITOR, false) && !z) {
                    aj.valueOf().values();
                } else {
                    aj.valueOf().AFKeystoreWrapper();
                    aj.valueOf().AFInAppEventParameterName();
                }
                if (jSONObject2.has("ol_id")) {
                    String optString = jSONObject2.optString("ol_scheme", null);
                    String optString2 = jSONObject2.optString("ol_domain", null);
                    String optString3 = jSONObject2.optString("ol_ver", null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                        return jSONObject2;
                    }
                    return jSONObject2;
                }
                return jSONObject2;
            } catch (Throwable th) {
                th = th;
                jSONObject = jSONObject2;
                AFLogger.AFInAppEventType(th.getMessage(), th);
                aj.valueOf().AFKeystoreWrapper();
                aj.valueOf().AFInAppEventParameterName();
                return jSONObject;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
