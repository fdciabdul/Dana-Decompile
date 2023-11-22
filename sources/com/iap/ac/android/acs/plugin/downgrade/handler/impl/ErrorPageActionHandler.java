package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.ActionExecutor;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.MultiLanguageFetcherUtil;
import com.iap.ac.android.common.log.ACLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ErrorPageActionHandler extends BaseActionHandler {

    /* loaded from: classes3.dex */
    public static abstract class AbstractLifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public AbstractLifecycleCheckCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes3.dex */
    public interface OnPageFinishedListener {
        void onPageFinished(String str);
    }

    private void registerFinishedCallback(Context context, final OnPageFinishedListener onPageFinishedListener) {
        if (context.getApplicationContext() instanceof Application) {
            final Application application = (Application) context.getApplicationContext();
            application.registerActivityLifecycleCallbacks(new AbstractLifecycleCheckCallbacks() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.AbstractLifecycleCheckCallbacks, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    if (activity instanceof ErrorPageActivity) {
                        String stringExtra = activity.getIntent().getStringExtra(ErrorPageActivity.KEY_PAGE_FINISH_TYPE);
                        OnPageFinishedListener onPageFinishedListener2 = onPageFinishedListener;
                        if (onPageFinishedListener2 != null) {
                            onPageFinishedListener2.onPageFinished(stringExtra);
                        }
                        application.unregisterActivityLifecycleCallbacks(this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startErrorPage(final IAPConnectPluginContext iAPConnectPluginContext, String str, String str2, String str3, String str4, final JSONObject jSONObject, final JSONObject jSONObject2, final IActionHandlerCallback iActionHandlerCallback) {
        ErrorPageActivity.startPage(iAPConnectPluginContext.getActivity(), str, str2, str3, str4);
        registerFinishedCallback(iAPConnectPluginContext.getContext(), new OnPageFinishedListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.2
            @Override // com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.OnPageFinishedListener
            public void onPageFinished(String str5) {
                String str6 = ErrorPageActionHandler.this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("startErrorPage() handle the onPageFinished method with finishType: ");
                sb.append(str5);
                ACLog.d(str6, sb.toString());
                if (TextUtils.equals(str5, ErrorPageActivity.PAGE_FINISH_WITH_ACTION)) {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    ActionExecutor.getInstance().handleAction(iAPConnectPluginContext, jSONObject3, iActionHandlerCallback);
                    return;
                }
                ErrorPageActionHandler.this.callbackWithError(jSONObject2, iAPConnectPluginContext.jsParameters, iActionHandlerCallback);
            }
        });
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.ERROR_PAGE;
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
        final String optString2 = jSONObject.optString(ApiDowngradeConstant.JsonKeys.BUTTON);
        if (TextUtils.isEmpty(optString2)) {
            logActionException(jSONObject, jSONObject2, "the value of \"button\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        final String optString3 = jSONObject.optString("title");
        final String optString4 = jSONObject.optString("iconUrl");
        final JSONObject optJSONObject = jSONObject.optJSONObject(ApiDowngradeConstant.JsonKeys.BUTTON_ACTION);
        HashMap hashMap = new HashMap();
        hashMap.put("title", optString3);
        hashMap.put("message", optString);
        hashMap.put(ApiDowngradeConstant.JsonKeys.BUTTON, optString2);
        MultiLanguageFetcherUtil.fetchI18NContent(iAPConnectPluginContext.getActivity(), hashMap, new OnFetchCallback() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.1
            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchOnError(String str, String str2) {
                ErrorPageActionHandler errorPageActionHandler = ErrorPageActionHandler.this;
                StringBuilder sb = new StringBuilder();
                sb.append("onFetchOnError: errorCode:");
                sb.append(str);
                sb.append(", errorMessage: ");
                sb.append(str2);
                errorPageActionHandler.logFetchLangException(sb.toString());
                ErrorPageActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            }

            @Override // com.iap.ac.android.acs.multilanguage.callback.OnFetchCallback
            public void onFetchSuccess(String str, Map<String, String> map) {
                String takeValueInMultiLanguage = ErrorPageActionHandler.this.takeValueInMultiLanguage(optString3, "title", map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("the value in language: ");
                    sb.append(str);
                    sb.append(" is empty, paramName: ");
                    sb.append("title");
                    sb.append(", keyName: ");
                    sb.append(optString3);
                    ACLog.w(ErrorPageActionHandler.this.TAG, sb.toString());
                }
                String takeValueInMultiLanguage2 = ErrorPageActionHandler.this.takeValueInMultiLanguage(optString, "message", map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage2)) {
                    ErrorPageActionHandler errorPageActionHandler = ErrorPageActionHandler.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onFetchSuccess: the value of key: \"");
                    sb2.append(optString);
                    sb2.append("\"in language: ");
                    sb2.append(str);
                    sb2.append(" is empty");
                    errorPageActionHandler.logFetchLangException(sb2.toString());
                    ErrorPageActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                String takeValueInMultiLanguage3 = ErrorPageActionHandler.this.takeValueInMultiLanguage(optString2, ApiDowngradeConstant.JsonKeys.BUTTON, map);
                if (TextUtils.isEmpty(takeValueInMultiLanguage3)) {
                    ErrorPageActionHandler errorPageActionHandler2 = ErrorPageActionHandler.this;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onFetchSuccess: the value of key: \"");
                    sb3.append(optString2);
                    sb3.append("\"in language: ");
                    sb3.append(str);
                    sb3.append(" is empty");
                    errorPageActionHandler2.logFetchLangException(sb3.toString());
                    ErrorPageActionHandler.this.callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
                    return;
                }
                final String processKeyword = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage, jSONObject2);
                final String processKeyword2 = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage2, jSONObject2);
                final String processKeyword3 = ApiDowngradeUtils.processKeyword(takeValueInMultiLanguage3, jSONObject2);
                ApiDowngradeUtils.runOnMain(new Runnable() { // from class: com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ErrorPageActionHandler.this.startErrorPage(iAPConnectPluginContext, processKeyword, optString4, processKeyword2, processKeyword3, optJSONObject, jSONObject, iActionHandlerCallback);
                    }
                });
            }
        });
        return true;
    }
}
