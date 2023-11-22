package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.MultiLanguageFetcherUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseActionHandler implements IActionHandler {
    public final String TAG = ApiDowngradeUtils.logTag(getClass().getSimpleName());

    public void callbackWithError(JSONObject jSONObject, JSONObject jSONObject2, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("error", ApiDowngradeConstant.Error.ERR_DEF_CODE);
            jSONObject3.put("errorMessage", ApiDowngradeConstant.Error.ERR_DOWNGRADE_FAILED);
        } catch (JSONException e) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("callbackWithError() json error: ");
            sb.append(e);
            ACLog.w(str, sb.toString());
        }
        callbackWithResponse(jSONObject3, jSONObject, jSONObject2, iActionHandlerCallback);
    }

    public void callbackWithResponse(JSONObject jSONObject, JSONObject jSONObject2, IActionHandlerCallback iActionHandlerCallback) {
        callbackWithResponse(new JSONObject(), jSONObject, jSONObject2, iActionHandlerCallback);
    }

    public void logActionException(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleAction() error, config: ");
        sb.append(jSONObject);
        sb.append(", params: ");
        sb.append(jSONObject2);
        sb.append(", errorMessage: ");
        sb.append(str);
        String obj = sb.toString();
        ACLog.e(this.TAG, obj);
        ApiDowngradeLogger.logException(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_PARAMS_INVALID, getActionType(), obj);
    }

    public void logFetchLangException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("fetchLanguagePackage() error in MEDUSA, errorMessage: ");
        sb.append(str);
        String obj = sb.toString();
        ACLog.e(this.TAG, obj);
        ApiDowngradeLogger.logException(ApiDowngradeLogger.EVENT_JSAPI_DOWNGRADE_TEXT_NOT_FOUND, getActionType(), obj);
    }

    public String takeValueInMultiLanguage(String str, String str2, Map<String, String> map) {
        if (!MultiLanguageFetcherUtil.isMultiLanguageInMedusa(str)) {
            str = str2;
        }
        return map.get(str);
    }

    private void callbackWithResponse(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, IActionHandlerCallback iActionHandlerCallback) {
        try {
            boolean optBoolean = jSONObject2.optBoolean("success", false);
            jSONObject.putOpt("success", Boolean.valueOf(optBoolean));
            String processKeyword = ApiDowngradeUtils.processKeyword(jSONObject2.optString("result", null), jSONObject3);
            if (!TextUtils.isEmpty(processKeyword)) {
                JSONObject jSONObject4 = new JSONObject(processKeyword);
                Iterator<String> keys = jSONObject4.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject4.opt(next));
                }
            }
            if (optBoolean) {
                iActionHandlerCallback.onHandleSuccess(jSONObject);
            } else {
                iActionHandlerCallback.onHandleFailure(jSONObject);
            }
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("callbackWithResponse() with json: ");
            sb.append(jSONObject);
            ACLog.d(str, sb.toString());
        } catch (JSONException e) {
            String str2 = this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("callbackWithResponse() json error: ");
            sb2.append(e);
            ACLog.w(str2, sb2.toString());
        }
    }
}
