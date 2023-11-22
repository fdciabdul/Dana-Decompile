package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.common.container.WebContainer;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RedirectActionHandler extends BaseActionHandler {
    private void openWebContainer(Context context, String str) {
        WebContainer.getInstance("ac_biz").startContainer(context, str);
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return "redirect";
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject2 = iAPConnectPluginContext.jsParameters;
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            logActionException(jSONObject, jSONObject2, "the value of \"url\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        openWebContainer(iAPConnectPluginContext.getContext(), ApiDowngradeUtils.processKeyword(optString, jSONObject2));
        callbackWithResponse(jSONObject, jSONObject2, iActionHandlerCallback);
        return true;
    }
}
