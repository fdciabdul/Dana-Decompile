package com.iap.ac.android.biz.common.utils;

import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AcBizUtils {
    public static final String AC_CHANNEL_B15 = "B15";
    public static final String AC_DEFAULT_SOURCE_SITE = "GNETW7CN";
    public static final String FUNC_NAME_IS_AC_BIZ = "isAcBizMiniProgram";
    public static final String JS_API_PARAM_KEY_THE_JSAPI_EXECONFIG = "theJSAPIExeConfig";
    public static final String JS_KEY_CHANNEL = "channel";

    public static String getChannel(JSONObject jSONObject, String str) {
        StringBuilder a2 = a.a("getChannel jsApi is ");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        a2.append(str);
        ACLog.d(Constants.TAG, a2.toString());
        if (jSONObject != null && jSONObject.has("theJSAPIExeConfig")) {
            try {
                String string = jSONObject.getString("theJSAPIExeConfig");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2.has("channel")) {
                        return jSONObject2.getString("channel");
                    }
                }
            } catch (JSONException e) {
                ACLog.e(Constants.TAG, "getChannel", e);
            }
        }
        return "";
    }

    @Deprecated
    public static boolean isAcBizMiniProgram(String str, String str2) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            ACLog.e(Constants.TAG, "isAcBizMiniProgram, appId is null");
            return false;
        }
        List regionMiniAppList = ConfigCenter.INSTANCE.getRegionMiniAppList();
        if (regionMiniAppList == null || !regionMiniAppList.contains(str)) {
            List<String> acsAppIdList = ConfigCenter.INSTANCE.getAcsAppIdList();
            if (acsAppIdList != null && acsAppIdList.contains(str)) {
                z = true;
            }
            if (z || str2 == null || !TextUtils.equals(str2, AC_DEFAULT_SOURCE_SITE)) {
                return z;
            }
            return true;
        }
        return true;
    }

    public static boolean isAcBizPay(String str, String str2, String str3) {
        if (ConfigCenter.INSTANCE.isToggleNewSourceSite() && !TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str)) {
                ACLog.e(Constants.TAG, "AcBizUtils#isAcBizPay, appId is null");
                return false;
            }
            return AC_DEFAULT_SOURCE_SITE.equals(str3);
        }
        return isAcBizMiniProgram(str, str2);
    }

    public static boolean isAcBizMiniProgram(String str, String str2, String str3) {
        if (ConfigCenter.INSTANCE.isToggleNewSourceSite() && !TextUtils.isEmpty(str3)) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                ACLog.e(Constants.TAG, "isAcBizMiniProgram, appId is null");
                return false;
            }
            List regionMiniAppList = ConfigCenter.INSTANCE.getRegionMiniAppList();
            if (regionMiniAppList == null || !regionMiniAppList.contains(str)) {
                List<String> acsAppIdList = ConfigCenter.INSTANCE.getAcsAppIdList();
                if (acsAppIdList != null && acsAppIdList.contains(str)) {
                    z = true;
                }
                if (z || str3 == null || !TextUtils.equals(str3, AC_DEFAULT_SOURCE_SITE)) {
                    return z;
                }
                return true;
            }
            return true;
        }
        return isAcBizMiniProgram(str, str2);
    }
}
