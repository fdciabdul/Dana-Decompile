package com.mixpanel.android.util;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JSONUtils {
    public static String PlaceComponentResult(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
