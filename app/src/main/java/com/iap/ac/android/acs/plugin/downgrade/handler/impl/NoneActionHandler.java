package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NoneActionHandler extends BaseActionHandler {
    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return "none";
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        callbackWithResponse(jSONObject, iAPConnectPluginContext.jsParameters, iActionHandlerCallback);
        return true;
    }
}
