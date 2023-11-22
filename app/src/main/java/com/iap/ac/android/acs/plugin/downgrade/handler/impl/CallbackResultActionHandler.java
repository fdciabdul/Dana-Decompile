package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CallbackResultActionHandler extends BaseActionHandler {
    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.CALLBACK_RESULT;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject2 = iAPConnectPluginContext.jsParameters;
        if (TextUtils.isEmpty(jSONObject.optString("result"))) {
            logActionException(jSONObject, jSONObject2, "the value of \"result\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        callbackWithResponse(jSONObject, jSONObject2, iActionHandlerCallback);
        return true;
    }
}
