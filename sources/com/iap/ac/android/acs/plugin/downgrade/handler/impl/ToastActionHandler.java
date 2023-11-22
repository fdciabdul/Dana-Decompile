package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.text.TextUtils;
import android.widget.Toast;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.MultiLanguageFetcherUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ToastActionHandler extends BaseActionHandler {
    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.TOAST;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(final IAPConnectPluginContext iAPConnectPluginContext, final JSONObject jSONObject, final IActionHandlerCallback iActionHandlerCallback) {
        final JSONObject jSONObject2 = iAPConnectPluginContext.jsParameters;
        final String optString = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString)) {
            logActionException(jSONObject, jSONObject2, "the value of \"message\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message", optString);
        MultiLanguageFetcherUtil.fetchI18NContent(iAPConnectPluginContext.getActivity(), hashMap, new OnFetchCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ToastActionHandler.1
            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchOnError(String str, String str2) {
                ToastActionHandler toastActionHandler = ToastActionHandler.this;
                StringBuilder sb = new StringBuilder();
                sb.append("onFetchOnError: errorCode:");
                sb.append(str);
                sb.append(", errorMessage: ");
                sb.append(str2);
                toastActionHandler.logFetchLangException(sb.toString());
                ToastActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            }

            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchSuccess(String str, Map<String, String> map) {
                String takeValueInMultiLanguage = ToastActionHandler.this.takeValueInMultiLanguage(optString, "message", map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage)) {
                    ToastActionHandler toastActionHandler = ToastActionHandler.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFetchSuccess: the value of key: \"");
                    sb.append(optString);
                    sb.append("\"in language: ");
                    sb.append(str);
                    sb.append(" is empty");
                    toastActionHandler.logFetchLangException(sb.toString());
                    ToastActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                final String processKeyword = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage, jSONObject2);
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ToastActionHandler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(iAPConnectPluginContext.getContext(), processKeyword, 0).show();
                    }
                });
                ToastActionHandler.this.callbackWithResponse(jSONObject, jSONObject2, iActionHandlerCallback);
            }
        });
        return true;
    }
}
