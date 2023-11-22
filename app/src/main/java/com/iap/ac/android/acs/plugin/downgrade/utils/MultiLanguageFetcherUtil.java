package com.iap.ac.android.acs.plugin.downgrade.utils;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.multilanguage.MultiLanguageKit;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.multilanguage.utils.LanguageFormatter;
import com.iap.ac.android.acs.multilanguage.utils.LanguagePackageUtil;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MultiLanguageFetcherUtil {
    public static final String DOWNGRADE_LANG_PKG_ID = "ac_jsapi_downgrade";
    public static final String LANG_PACKAGE_BIZ_TYPE = "acs_apidowngrade";
    public static final String TAG = ApiDowngradeUtils.logTag("MultiLanguageFetcherUtil");

    public static void fetchI18NContent(Context context, final Map<String, String> map, final OnFetchCallback onFetchCallback) {
        MultiLanguageKit.getInstance(LANG_PACKAGE_BIZ_TYPE).fetchLanguagePackage(context, DOWNGRADE_LANG_PKG_ID, new OnFetchCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.utils.MultiLanguageFetcherUtil.1
            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public final void onFetchOnError(String str, String str2) {
                MultiLanguageFetcherUtil.processContentInLanguage(map, LanguagePackageUtil.getCurrentLanguage(), new HashMap(), onFetchCallback);
            }

            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public final void onFetchSuccess(String str, Map<String, String> map2) {
                MultiLanguageFetcherUtil.processContentInLanguage(map, str, map2, onFetchCallback);
            }
        });
    }

    public static String findI18NContentInLanguage(JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(str)) {
            ACLog.e(TAG, "findI18NContentInLanguage() the languageCode is null");
            return "";
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("start findI18NContentInLanguage() the languageCode is ");
        sb.append(str);
        ACLog.d(str2, sb.toString());
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            str = LanguagePackageUtil.splitPrefix(LanguagePackageUtil.convertConnectSymbol(str));
            optString = jSONObject.optString(str);
        }
        if (TextUtils.isEmpty(optString)) {
            optString = jSONObject.optString(LanguageFormatter.formatWithPattern(str));
        }
        return TextUtils.isEmpty(optString) ? jSONObject.optString("default") : optString;
    }

    public static boolean isMultiLanguageInMedusa(String str) {
        return takeI18NFullContent(str) == null;
    }

    public static void processContentInLanguage(Map<String, String> map, String str, Map<String, String> map2, OnFetchCallback onFetchCallback) {
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                JSONObject takeI18NFullContent = takeI18NFullContent(entry.getValue());
                if (takeI18NFullContent != null) {
                    map2.put(entry.getKey(), findI18NContentInLanguage(takeI18NFullContent, str));
                }
            }
            onFetchCallback.onFetchSuccess(str, map2);
        } catch (Exception e) {
            onFetchCallback.onFetchOnError("40002", ApiDowngradeConstant.Error.ERR_DOWNGRADE_FAILED);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("processContentInLanguage() error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
        }
    }

    public static JSONObject takeI18NFullContent(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
