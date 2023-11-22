package com.alibaba.griver.base.common;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.storage.GriverKVStorage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TrackingCodeManager {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, JSONObject> f6282a = new HashMap<>();
    private static int b = 3600;
    private static TrackingCodeManager c;

    public static TrackingCodeManager getInstance() {
        if (c == null) {
            synchronized (TrackingCodeManager.class) {
                if (c == null) {
                    c = new TrackingCodeManager();
                }
            }
        }
        return c;
    }

    private boolean a(JSONObject jSONObject) {
        try {
        } catch (JSONException e) {
            GriverLogger.e("TrackingCodeManager", " parseLong error ", e);
        }
        return (Long.parseLong(jSONObject.getString("attributionWindow")) * 1000) + Long.parseLong(jSONObject.getString("deepLinkAppTime")) < System.currentTimeMillis();
    }

    public String getTrackingCode(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = f6282a.get(str)) != null && jSONObject.has("trackingCode")) {
            try {
                return jSONObject.getString("trackingCode");
            } catch (JSONException e) {
                GriverLogger.e("TrackingCodeManager", " getTrackingCode error ", e);
            }
        }
        return "";
    }

    private JSONObject a(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trackingCode", str);
            jSONObject.put("attributionWindow", str2);
            jSONObject.put("deepLinkAppTime", str3);
            return jSONObject;
        } catch (JSONException e) {
            GriverLogger.e("TrackingCodeManager", " tackingCodeParameterToJsonObj error ", e);
            return null;
        }
    }

    public void setTrackingCode(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("appId")) {
            return;
        }
        String string = bundle.getString("appId");
        JSONObject jSONObject = null;
        if (!f6282a.containsKey(string)) {
            f6282a.put(string, null);
            String string2 = GriverKVStorage.getString(string, "trackingCode");
            String string3 = GriverKVStorage.getString(string, "attributionWindow");
            String string4 = GriverKVStorage.getString(string, "deepLinkAppTime");
            if (!TextUtils.isEmpty(string2)) {
                f6282a.put(string, a(string2, string3, string4));
            }
        }
        JSONObject jSONObject2 = f6282a.get(string);
        if (jSONObject2 == null || !a(jSONObject2)) {
            jSONObject = jSONObject2;
        } else {
            GriverKVStorage.putString(string, "trackingCode", "");
            GriverKVStorage.putString(string, "attributionWindow", "");
            GriverKVStorage.putString(string, "deepLinkAppTime", "");
            f6282a.put(string, null);
        }
        if (jSONObject == null) {
            a(string, bundle);
        }
    }

    private void a(String str, Bundle bundle) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String obj = sb.toString();
        String str4 = "";
        if (bundle.containsKey("trackingCode")) {
            str4 = bundle.getString("trackingCode");
            str2 = bundle.getString("attributionWindow");
        } else {
            if (bundle.containsKey("sourceInfo")) {
                String string = BundleUtils.getString(bundle, "sourceInfo", "");
                if (!TextUtils.isEmpty(string)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mini://platformapi/?");
                    sb2.append(string);
                    Uri parse = Uri.parse(sb2.toString());
                    if (parse != null && !TextUtils.isEmpty(parse.getQueryParameter("trackingCode"))) {
                        str4 = parse.getQueryParameter("trackingCode");
                        str2 = parse.getQueryParameter("attributionWindow");
                    }
                }
            }
            str2 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        GriverKVStorage.putString(str, "trackingCode", str4);
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b);
            str3 = sb3.toString();
        } else {
            str3 = str2;
        }
        GriverKVStorage.putString(str, "attributionWindow", str3);
        GriverKVStorage.putString(str, "deepLinkAppTime", obj);
        HashMap<String, JSONObject> hashMap = f6282a;
        if (TextUtils.isEmpty(str2)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b);
            str2 = sb4.toString();
        }
        hashMap.put(str, a(str4, str2, obj));
    }
}
