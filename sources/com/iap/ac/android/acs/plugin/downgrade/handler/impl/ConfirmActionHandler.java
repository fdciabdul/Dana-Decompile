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
public class ConfirmActionHandler extends BaseActionHandler {
    public Dialog mConfirmDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirm(final IAPConnectPluginContext iAPConnectPluginContext, String str, String str2, String str3, JSONObject jSONObject, final IActionHandlerCallback iActionHandlerCallback) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(ApiDowngradeConstant.JsonKeys.CONFIRM_BUTTON_ACTION);
        final JSONObject optJSONObject2 = jSONObject.optJSONObject(ApiDowngradeConstant.JsonKeys.CANCEL_BUTTON_ACTION);
        Dialog dialog = this.mConfirmDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mConfirmDialog.dismiss();
        }
        Dialog createDialog = DialogCreator.createDialog(iAPConnectPluginContext.getActivity(), str, true, str2, str3, new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ConfirmActionHandler.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject2 = optJSONObject;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject2, iActionHandlerCallback);
            }
        }, new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ConfirmActionHandler.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject2 = optJSONObject2;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject2, iActionHandlerCallback);
            }
        });
        this.mConfirmDialog = createDialog;
        try {
            createDialog.show();
        } catch (Exception e) {
            String str4 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("show confirm dialog error: ");
            sb.append(e);
            ACLog.e(str4, sb.toString());
        }
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return "confirm";
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
        final String optString2 = jSONObject.optString(ApiDowngradeConstant.JsonKeys.CONFIRM_BUTTON);
        if (TextUtils.isEmpty(optString2)) {
            logActionException(jSONObject, jSONObject2, "the value of \"confirmButton\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        final String optString3 = jSONObject.optString(ApiDowngradeConstant.JsonKeys.CANCEL_BUTTON);
        if (TextUtils.isEmpty(optString3)) {
            logActionException(jSONObject, jSONObject2, "the value of \"cancelButton\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("message", optString);
        hashMap.put(ApiDowngradeConstant.JsonKeys.CONFIRM_BUTTON, optString2);
        hashMap.put(ApiDowngradeConstant.JsonKeys.CANCEL_BUTTON, optString3);
        MultiLanguageFetcherUtil.fetchI18NContent(iAPConnectPluginContext.getActivity(), hashMap, new OnFetchCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ConfirmActionHandler.1
            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchOnError(String str, String str2) {
                ConfirmActionHandler confirmActionHandler = ConfirmActionHandler.this;
                StringBuilder sb = new StringBuilder();
                sb.append("onFetchOnError: errorCode:");
                sb.append(str);
                sb.append(", errorMessage: ");
                sb.append(str2);
                confirmActionHandler.logFetchLangException(sb.toString());
                ConfirmActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            }

            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchSuccess(String str, Map<String, String> map) {
                String takeValueInMultiLanguage = ConfirmActionHandler.this.takeValueInMultiLanguage(optString, "message", map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage)) {
                    ConfirmActionHandler confirmActionHandler = ConfirmActionHandler.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFetchSuccess: the value of key: \"");
                    sb.append(optString);
                    sb.append("\"in language: ");
                    sb.append(str);
                    sb.append(" is empty");
                    confirmActionHandler.logFetchLangException(sb.toString());
                    ConfirmActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                String takeValueInMultiLanguage2 = ConfirmActionHandler.this.takeValueInMultiLanguage(optString2, ApiDowngradeConstant.JsonKeys.CONFIRM_BUTTON, map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage2)) {
                    ConfirmActionHandler confirmActionHandler2 = ConfirmActionHandler.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onFetchSuccess: the value of key: \"");
                    sb2.append(optString2);
                    sb2.append("\"in language: ");
                    sb2.append(str);
                    sb2.append(" is empty");
                    confirmActionHandler2.logFetchLangException(sb2.toString());
                    ConfirmActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                String takeValueInMultiLanguage3 = ConfirmActionHandler.this.takeValueInMultiLanguage(optString3, ApiDowngradeConstant.JsonKeys.CANCEL_BUTTON, map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage3)) {
                    ConfirmActionHandler confirmActionHandler3 = ConfirmActionHandler.this;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onFetchSuccess: the value of key: \"");
                    sb3.append(optString3);
                    sb3.append("\"in language: ");
                    sb3.append(str);
                    sb3.append(" is empty");
                    confirmActionHandler3.logFetchLangException(sb3.toString());
                    ConfirmActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                final String processKeyword = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage, jSONObject2);
                final String processKeyword2 = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage2, jSONObject2);
                final String processKeyword3 = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage3, jSONObject2);
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ConfirmActionHandler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ConfirmActionHandler.this.showConfirm(iAPConnectPluginContext, processKeyword, processKeyword2, processKeyword3, jSONObject, iActionHandlerCallback);
                    }
                });
            }
        });
        return true;
    }
}
