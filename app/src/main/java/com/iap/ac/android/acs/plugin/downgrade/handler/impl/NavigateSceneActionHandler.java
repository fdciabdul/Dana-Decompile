package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.router.BizSceneNavigateManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NavigateSceneActionHandler extends BaseActionHandler {
    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.NAVIGATE_SCENE;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject2 = iAPConnectPluginContext.jsParameters;
        String optString = jSONObject.optString("sceneCode");
        if (TextUtils.isEmpty(optString)) {
            logActionException(jSONObject, jSONObject2, "the value of \"sceneCode\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        BizSceneNavigateManager.getInstance().navigate(iAPConnectPluginContext, optString, iActionHandlerCallback);
        return true;
    }
}
