package com.alibaba.griver.core.jsapi.device.network;

import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.bridge.GriverNetworkPermissionExtension;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.NetworkUtils;
import com.alibaba.griver.base.common.utils.PermissionUtils;

/* loaded from: classes6.dex */
public class NetworkBridgeExtension implements BridgeExtension {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "NetworkBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    public void getNetworkType(@BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getPageContext() == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        String simpleNetworkType = NetworkUtil.getSimpleNetworkType(page.getPageContext().getActivity());
        StringBuilder sb = new StringBuilder();
        sb.append("network_type:");
        sb.append(simpleNetworkType);
        Object obj = sb.toString();
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("err_msg", obj);
        jSONObject.put("networkType", (Object) simpleNetworkType);
        jSONObject.put("networkAvailable", Boolean.valueOf(!"fail".equals(simpleNetworkType)));
        final Context activity = page.getPageContext().getActivity();
        if (((GriverNetworkPermissionExtension) RVProxy.get(GriverNetworkPermissionExtension.class)).shouldApplyPermission(page) && !PermissionUtils.hasPermission("android.permission.READ_PHONE_STATE")) {
            PermissionUtils.requestPermission("android.permission.READ_PHONE_STATE", 100, new IPermissionRequestCallback() { // from class: com.alibaba.griver.core.jsapi.device.network.NetworkBridgeExtension.1
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                    if (!PermissionUtils.positivePermissionResult(iArr)) {
                        GriverLogger.w(NetworkBridgeExtension.TAG, "user refuse to grant read phone state permission, can not get network detail");
                    }
                    NetworkBridgeExtension.this.getDetailNetwork(activity, jSONObject, bridgeCallback);
                }
            });
        } else {
            getDetailNetwork(activity, jSONObject, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDetailNetwork(Context context, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        NetworkUtils.getDetailNetwork(context, new NetworkUtils.NetworkDetailCallback() { // from class: com.alibaba.griver.core.jsapi.device.network.NetworkBridgeExtension.2
            @Override // com.alibaba.griver.base.common.utils.NetworkUtils.NetworkDetailCallback
            public void getNetworkType(String str) {
                jSONObject.put("networkInfo", (Object) str);
                bridgeCallback.sendJSONResponse(jSONObject);
            }

            @Override // com.alibaba.griver.base.common.utils.NetworkUtils.NetworkDetailCallback
            public void getNetworkError(int i, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("get detail network info failed, code: ");
                sb.append(i);
                sb.append(", message: ");
                sb.append(str);
                GriverLogger.w(NetworkBridgeExtension.TAG, sb.toString());
                jSONObject.put("networkInfo", (Object) "UNKNOWN");
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }
}
