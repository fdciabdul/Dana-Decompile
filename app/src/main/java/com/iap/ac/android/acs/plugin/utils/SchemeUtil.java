package com.iap.ac.android.acs.plugin.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public class SchemeUtil {
    public static final String BACKING_SCHEME = "acsback://";
    public static final String CONFIG_KEY_ACS_THIRDPARTY_URI_PREFIX = "ACS_THIRDPARTY_URI_PREFIX";

    public static Uri buildSchemeWithBacking(String str, String str2) {
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        boolean z = true;
        for (String str3 : queryParameterNames) {
            if (TextUtils.equals(str3, str2)) {
                clearQuery.appendQueryParameter(str3, "acsback://");
                z = false;
            } else {
                clearQuery.appendQueryParameter(str3, parse.getQueryParameter(str3));
            }
        }
        if (z) {
            clearQuery.appendQueryParameter(str2, "acsback://");
        }
        return clearQuery.build();
    }

    public static boolean checkUriCanBeProcessed(Activity activity, String str) {
        return checkUriCanBeProcessed(activity, str, null);
    }

    public static boolean checkUriInWhiteList(String str) {
        return isKeyStartWith(str, (JSONArray) ConfigCenter.INSTANCE.getKeyOrDefault("ACS_THIRDPARTY_URI_PREFIX", new JSONArray()));
    }

    public static boolean isKeyStartWith(String str, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.startsWith(jSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkUriCanBeProcessed(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(str2)) {
                str2 = "android.intent.action.VIEW";
            }
            intent.setAction(str2);
            intent.setData(Uri.parse(str));
            List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size() > 0;
            }
            return false;
        } catch (Exception e) {
            ACLog.e("IAPConnectPlugin", "checkUriCanBeProcessed Exception", e);
            return false;
        }
    }
}
