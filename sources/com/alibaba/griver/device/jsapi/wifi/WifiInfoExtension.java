package com.alibaba.griver.device.jsapi.wifi;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class WifiInfoExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6527a = "WifiInfoExtension";

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

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getWifiInfo(@BindingApiContext ApiContext apiContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) apiContext.getActivity().getSystemService("connectivity");
        if (connectivityManager == null) {
            RVLogger.d(f6527a, "getWifiInfo...conn manager is null");
            return new BridgeResponse.Error(12, "get failed");
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
            RVLogger.d(f6527a, "getWifiInfo...netInfo is null or type is not wifi");
            return new BridgeResponse.Error(12, "get failed");
        }
        WifiManager wifiManager = (WifiManager) apiContext.getAppContext().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            RVLogger.d(f6527a, "getWifiInfo...WifiManager is null");
            return new BridgeResponse.Error(12, "get failed");
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            RVLogger.d(f6527a, "getWifiInfo...wifi infi is null");
            return new BridgeResponse.Error(12, "get failed");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", (Object) connectionInfo.getSSID());
        jSONObject.put("BSSID", (Object) connectionInfo.getBSSID());
        return new BridgeResponse(jSONObject);
    }
}
