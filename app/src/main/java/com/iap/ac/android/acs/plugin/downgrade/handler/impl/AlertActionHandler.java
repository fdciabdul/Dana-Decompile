package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.ActionExecutor;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.ui.DialogCreator;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.MultiLanguageFetcherUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AlertActionHandler extends BaseActionHandler {
    public Dialog mAlertDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlert(final IAPConnectPluginContext iAPConnectPluginContext, String str, String str2, JSONObject jSONObject, final IActionHandlerCallback iActionHandlerCallback) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(ApiDowngradeConstant.JsonKeys.ALERT_BUTTON_ACTION);
        Dialog dialog = this.mAlertDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mAlertDialog.dismiss();
        }
        Dialog createDialog = DialogCreator.createDialog(iAPConnectPluginContext.getActivity(), str, false, str2, null, new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.AlertActionHandler.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject2 = optJSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject2, iActionHandlerCallback);
            }
        }, null);
        this.mAlertDialog = createDialog;
        try {
            createDialog.show();
        } catch (Exception e) {
            String str3 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("show alert dialog error: ");
            sb.append(e);
            ACLog.e(str3, sb.toString());
        }
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.ALERT;
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
        final String optString2 = jSONObject.optString(ApiDowngradeConstant.JsonKeys.ALERT_BUTTON);
        if (TextUtils.isEmpty(optString2)) {
            logActionException(jSONObject, jSONObject2, "the value of \"alertButton\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message", optString);
        hashMap.put(ApiDowngradeConstant.JsonKeys.ALERT_BUTTON, optString2);
        MultiLanguageFetcherUtil.fetchI18NContent(iAPConnectPluginContext.getActivity(), hashMap, new OnFetchCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.AlertActionHandler.1
            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchOnError(String str, String str2) {
                AlertActionHandler alertActionHandler = AlertActionHandler.this;
                StringBuilder sb = new StringBuilder();
                sb.append("onFetchOnError: errorCode:");
                sb.append(str);
                sb.append(", errorMessage: ");
                sb.append(str2);
                alertActionHandler.logFetchLangException(sb.toString());
                AlertActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            }

            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchSuccess(String str, Map<String, String> map) {
                String takeValueInMultiLanguage = AlertActionHandler.this.takeValueInMultiLanguage(optString, "message", map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage)) {
                    AlertActionHandler alertActionHandler = AlertActionHandler.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFetchSuccess: the value of key: \"");
                    sb.append(optString);
                    sb.append("\"in language: ");
                    sb.append(str);
                    sb.append(" is empty");
                    alertActionHandler.logFetchLangException(sb.toString());
                    AlertActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                String takeValueInMultiLanguage2 = AlertActionHandler.this.takeValueInMultiLanguage(optString2, ApiDowngradeConstant.JsonKeys.ALERT_BUTTON, map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage2)) {
                    AlertActionHandler alertActionHandler2 = AlertActionHandler.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onFetchSuccess: the value of key: \"");
                    sb2.append(optString2);
                    sb2.append("\"in language: ");
                    sb2.append(str);
                    sb2.append(" is empty");
                    alertActionHandler2.logFetchLangException(sb2.toString());
                    AlertActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                final String processKeyword = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage, jSONObject2);
                final String processKeyword2 = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage2, jSONObject2);
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.AlertActionHandler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AlertActionHandler.this.showAlert(iAPConnectPluginContext, processKeyword, processKeyword2, jSONObject, iActionHandlerCallback);
                    }
                });
            }
        });
        return true;
    }
}
