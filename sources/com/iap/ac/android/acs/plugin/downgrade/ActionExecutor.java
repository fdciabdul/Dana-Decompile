package com.iap.ac.android.acs.plugin.downgrade;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.amcs.JSAPICompatibilityConfigManager;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.AlertActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.BaseActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.CallbackResultActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.ConfirmActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.ErrorPageActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.MiniProgramActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.NavigateSceneActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.NoneActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.RedirectActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.SchemeActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.handler.impl.ToastActionHandler;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.common.log.ACLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ActionExecutor {
    public static final String TAG = ApiDowngradeUtils.logTag("ActionExecutor");
    public static ActionExecutor sInstance;
    public final Map<String, BaseActionHandler> mActionHandlers = new ConcurrentHashMap();

    public ActionExecutor() {
        registerActionHandlers();
    }

    public static ActionExecutor getInstance() {
        if (sInstance == null) {
            synchronized (ActionExecutor.class) {
                if (sInstance == null) {
                    sInstance = new ActionExecutor();
                }
            }
        }
        return sInstance;
    }

    private void registerActionHandlers() {
        BaseActionHandler[] baseActionHandlerArr = {new AlertActionHandler(), new CallbackResultActionHandler(), new ConfirmActionHandler(), new ErrorPageActionHandler(), new MiniProgramActionHandler(), new NavigateSceneActionHandler(), new NoneActionHandler(), new RedirectActionHandler(), new SchemeActionHandler(), new ToastActionHandler()};
        for (int i = 0; i < 10; i++) {
            registerActionHandler(baseActionHandlerArr[i]);
        }
    }

    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        synchronized (this) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("handleAction() start. appId: ");
            sb.append(iAPConnectPluginContext.miniProgramAppID);
            sb.append(" config: ");
            sb.append(jSONObject);
            sb.append(", params: ");
            sb.append(iAPConnectPluginContext.jsParameters);
            ACLog.d(str, sb.toString());
            if (!JSAPICompatibilityConfigManager.getInstance().isJSAPICompatibilityEnabled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("handleAction(), ");
                sb2.append("cancel apidowngrade, for it is not enabled");
                ACLog.w(str, sb2.toString());
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", ApiDowngradeConstant.Error.ERR_DEF_CODE);
                    jSONObject2.put("errorMessage", "cancel apidowngrade, for it is not enabled");
                    iActionHandlerCallback.onHandleFailure(jSONObject2);
                } catch (JSONException e) {
                    String str2 = TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("handleAction(), json error: ");
                    sb3.append(e);
                    ACLog.w(str2, sb3.toString());
                }
                return false;
            } else if (UIUtils.isActivityDisabled(iAPConnectPluginContext.getActivity())) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("handleAction(), ");
                sb4.append("cancel apidowngrade, for the activity is null or disabled");
                ACLog.w(str, sb4.toString());
                return false;
            } else {
                String optString = jSONObject.optString("actionType");
                if (TextUtils.isEmpty(optString)) {
                    optString = "none";
                }
                BaseActionHandler baseActionHandler = this.mActionHandlers.get(optString);
                if (baseActionHandler == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("apidowngrade failed, can't find the actionHandler in actionType: ");
                    sb5.append(optString);
                    String obj = sb5.toString();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("handleAction(), ");
                    sb6.append(obj);
                    ACLog.w(str, sb6.toString());
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("error", ApiDowngradeConstant.Error.ERR_DEF_CODE);
                        jSONObject3.put("errorMessage", obj);
                    } catch (JSONException e2) {
                        String str3 = TAG;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("handleAction(), json error: ");
                        sb7.append(e2);
                        ACLog.w(str3, sb7.toString());
                    }
                    iActionHandlerCallback.onHandleFailure(jSONObject3);
                    return false;
                }
                ACLog.d(str, String.format("handleAction(), find actionHandler: %s, config: %s, jsParameters: %s", baseActionHandler.getClass().getSimpleName(), jSONObject, iAPConnectPluginContext.jsParameters));
                return baseActionHandler.handleAction(iAPConnectPluginContext, jSONObject, iActionHandlerCallback);
            }
        }
    }

    public void registerActionHandler(BaseActionHandler baseActionHandler) {
        this.mActionHandlers.put(baseActionHandler.getActionType(), baseActionHandler);
    }
}
