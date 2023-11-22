package com.iap.ac.android.acs.plugin.downgrade.handler;

import com.iap.ac.android.acs.plugin.core.IAPConnectPluginContext;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IActionHandler {
    String getActionType();

    boolean handleAction(IAPConnectPluginContext iAPConnectPluginContext, JSONObject jSONObject, IActionHandlerCallback iActionHandlerCallback);
}
