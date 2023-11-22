package com.iap.ac.android.acs.multilanguage.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f7530a;
    public String b;

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("version");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = optJSONObject.optString("url");
                    if (!TextUtils.isEmpty(optString2)) {
                        aVar.f7530a = optString;
                        aVar.b = optString2;
                        optJSONObject.optString("appName");
                        optJSONObject.optString("fileName");
                        return aVar;
                    }
                    throw new JSONException("the response url in data is null");
                }
                throw new JSONException("the response version in data is null");
            }
            throw new JSONException("the response data is null");
        }
        throw new JSONException("the response json is null");
    }
}
