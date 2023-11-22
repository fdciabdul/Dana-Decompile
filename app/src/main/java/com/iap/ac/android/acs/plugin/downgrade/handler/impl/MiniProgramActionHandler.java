package com.iap.ac.android.acs.plugin.downgrade.handler.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandlerCallback;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.model.ContainerParams;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MiniProgramActionHandler extends BaseActionHandler {
    private void openMiniProgram(Context context, String str, String str2, String str3) {
        ContainerParams createForMniProgram = ContainerParams.createForMniProgram(str);
        createForMniProgram.containerBundle = new Bundle();
        createForMniProgram.containerBundle.putString("page", str2);
        createForMniProgram.containerBundle.putString("query", str3);
        WebContainer.getInstance("ac_biz").startContainer(context, createForMniProgram);
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public String getActionType() {
        return ApiDowngradeConstant.ActionType.MINI_PROGRAM;
    }

    @Override // com.iap.ac.android.acs.plugin.downgrade.handler.IActionHandler
    public boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback) {
        JSONObject jSONObject2 = iAPConnectPluginContext.jsParameters;
        String optString = jSONObject.optString("appId");
        if (TextUtils.isEmpty(optString)) {
            logActionException(jSONObject, jSONObject2, "the value of \"appId\" is empty");
            callbackWithError(jSONObject, jSONObject2, iActionHandlerCallback);
            return false;
        }
        openMiniProgram(iAPConnectPluginContext.getContext(), optString, jSONObject.optString("page"), ApiDowngradeUtils.processKeyword(jSONObject.optString("params"), jSONObject2));
        callbackWithResponse(jSONObject, jSONObject2, iActionHandlerCallback);
        return true;
    }
}
