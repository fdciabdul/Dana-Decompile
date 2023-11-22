package com.iap.ac.android.acs.plugin.downgrade.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.iap.ac.android.acs.multilanguage.utils.FileUtils;
import com.iap.ac.android.acs.plugin.downgrade.pattern.PatternProcessManager;
import com.iap.ac.android.common.log.ACLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiDowngradeUtils {
    public static final String KEY_PREVIEW_ID = "previewId";
    public static final String KEY_SCENE = "scene";
    public static final String SCENE_TYPE_PREVIEW = "PREVIEW";
    public static final String TAG = logTag("ApiDowngradeUtils");

    public static String dirInAssets() {
        StringBuilder sb = new StringBuilder();
        sb.append("acs_jsapi_downgrade");
        sb.append(File.separator);
        return sb.toString();
    }

    public static String findValueFromBundle(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("query");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        for (String str2 : string.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split("=");
            if (split.length == 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (TextUtils.equals(str3, str) && !TextUtils.isEmpty(str4)) {
                    return str4;
                }
            }
        }
        return null;
    }

    public static boolean isScenePreview(Bundle bundle) {
        return TextUtils.equals(findValueFromBundle(bundle, "scene"), SCENE_TYPE_PREVIEW);
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectPlugin-ApiDowngrade-");
        sb.append(str);
        return sb.toString();
    }

    public static Map<String, String> parseJSONParamsToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        }
        return hashMap;
    }

    public static String processKeyword(String str, JSONObject jSONObject) {
        return PatternProcessManager.INSTANCE.processKeyword(str, jSONObject);
    }

    public static JSONObject readJSONFromAssets(Context context, String str) {
        try {
            return new JSONObject(FileUtils.readConfigFromAsset(context, str));
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("readSceneSchemeFromLocal() failed for: ");
            sb.append(e);
            ACLog.w(str2, sb.toString());
            return null;
        }
    }

    public static void runOnMain(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
