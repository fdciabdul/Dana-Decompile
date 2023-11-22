package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ba {
    public static void values(ae aeVar, g gVar, String str, Context context, SharedPreferences sharedPreferences, Integer num, Throwable th) {
        if (gVar.AFKeystoreWrapper()) {
            if (ae.valueOf == null) {
                AFLogger.values("[GCD-E01] AppsFlyerConversionListener is null - skip gcd");
                return;
            }
            StringBuilder sb = new StringBuilder("[GCD-A01] Loading conversion data. Counter: ");
            sb.append(gVar.onInstallConversionFailureNative);
            AFLogger.values(sb.toString());
            long j = sharedPreferences.getLong("appsflyerConversionDataCacheExpiration", 0L);
            if (j != 0 && System.currentTimeMillis() - j > 5184000000L) {
                AFLogger.values("[GCD-E02] Cached conversion data expired");
                ae.valueOf(context, "sixtyDayConversionData");
                ae.AFKeystoreWrapper(context, "attributionId", (String) null);
                aeVar.valueOf(context, "appsflyerConversionDataCacheExpiration", 0L);
            }
            if (sharedPreferences.getString("attributionId", null) == null) {
                if (th != null) {
                    StringBuilder sb2 = new StringBuilder("Launch exception: ");
                    sb2.append(th.getMessage());
                    ay.AFInAppEventParameterName(sb2.toString());
                } else if (num.intValue() != 200) {
                    ay.AFInAppEventParameterName("Launch status code: ".concat(String.valueOf(num)));
                } else {
                    ay ayVar = new ay(aeVar, (Application) context.getApplicationContext(), str);
                    ae.AFInAppEventType(ayVar.AFInAppEventType, ayVar, 10L, TimeUnit.MILLISECONDS);
                }
            } else if (ae.valueOf(sharedPreferences, "appsFlyerCount", false) <= 1) {
            } else {
                try {
                    Map<String, Object> values = values(context);
                    if (values == null) {
                        return;
                    }
                    try {
                        if (!values.containsKey("is_first_launch")) {
                            values.put("is_first_launch", Boolean.FALSE);
                        }
                        ay.AFInAppEventType(values);
                    } catch (Throwable th2) {
                        AFLogger.AFInAppEventType(th2.getLocalizedMessage(), th2);
                    }
                } catch (az e) {
                    AFLogger.AFInAppEventType(e.getMessage(), e);
                }
            }
        }
    }

    public static Map<String, Object> values(Context context) throws az {
        String string = ae.values(context).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return valueOf(string);
        }
        throw new az();
    }

    public static Map<String, Object> valueOf(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals("is_cache")) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.AFInAppEventType(e.getMessage(), e);
            return null;
        }
    }
}
