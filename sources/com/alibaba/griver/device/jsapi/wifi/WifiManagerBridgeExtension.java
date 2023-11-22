package com.alibaba.griver.device.jsapi.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.CommonUtils;
import com.alibaba.griver.device.R;
import java.util.List;

/* loaded from: classes2.dex */
public class WifiManagerBridgeExtension implements AppPausePoint, AppResumePoint, BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6528a = "WifiManagerBridgeExtension";
    private WifiManager b;
    private Page f;
    private BridgeCallback g;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private BroadcastReceiver h = new BroadcastReceiver() { // from class: com.alibaba.griver.device.jsapi.wifi.WifiManagerBridgeExtension.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            char c;
            String action = intent.getAction();
            String str = WifiManagerBridgeExtension.f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("onReceiveWifiBroadcast... action = ");
            sb.append(action);
            RVLogger.d(str, sb.toString());
            action.hashCode();
            int hashCode = action.hashCode();
            if (hashCode == -1875733435) {
                if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != -343630553) {
                if (hashCode == 1878357501 && action.equals("android.net.wifi.SCAN_RESULTS")) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (action.equals("android.net.wifi.STATE_CHANGE")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                WifiManagerBridgeExtension.this.b(intent);
            } else if (c == 1) {
                WifiManagerBridgeExtension.this.a(intent);
            } else if (c != 2) {
            } else {
                WifiManagerBridgeExtension.this.d();
            }
        }
    };

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

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("WPA") || str.contains("wpa")) {
            return 2;
        }
        if (str.contains("WEP") || str.contains("wep")) {
            return 1;
        }
        return (str.contains("EAP") || str.contains("eap")) ? 3 : 0;
    }

    private static int a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return 2;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            return 3;
        }
        return wifiConfiguration.wepKeys[0] == null ? 0 : 1;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse startWifi() {
        return b();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse stopWifi() {
        return c();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getWifiList(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        this.g = bridgeCallback;
        this.f = page;
        return a(page);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse connectWifi(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingParam(stringDefault = "", value = {"SSID"}) String str, @BindingParam(stringDefault = "", value = {"BSSID"}) String str2, @BindingParam(stringDefault = "", value = {"password"}) String str3, @BindingParam({"isWEP"}) boolean z) {
        this.g = bridgeCallback;
        this.f = page;
        return a(str, str2, str3, z);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getConnectedWifi() {
        return a();
    }

    private BridgeResponse a() {
        i();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (!this.d) {
            return new BridgeResponse.Error(12000, applicationContext.getString(R.string.griver_not_use_startwifi_before));
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(12005, applicationContext.getString(R.string.griver_wifi_is_disabled));
        }
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("SSID", (Object) connectionInfo.getSSID());
            jSONObject.put("BSSID", (Object) connectionInfo.getBSSID());
            jSONObject.put("secure", (Object) Boolean.valueOf(a(connectionInfo)));
            jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100)));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wifi", (Object) jSONObject);
            String str = f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("getConnectedWifi... wifiInfo = ");
            sb.append(jSONObject.toJSONString());
            RVLogger.d(str, sb.toString());
            return new BridgeResponse(jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("fail", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject3);
    }

    private BridgeResponse b() {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        try {
            boolean isWifiEnabled = i().isWifiEnabled();
            String str = f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("startWifi... isWifiEnable = ");
            sb.append(isWifiEnabled);
            RVLogger.d(str, sb.toString());
            if (!isWifiEnabled) {
                return new BridgeResponse.Error(12005, applicationContext.getString(R.string.griver_wifi_is_disabled));
            }
            boolean z = true;
            if (!isWifiEnabled && !i().setWifiEnabled(true)) {
                z = false;
            }
            JSONObject jSONObject = new JSONObject();
            this.d = z;
            jSONObject.put(z ? "success" : "fail", (Object) Boolean.TRUE);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("startWifi... flag isWifiStarted = ");
            sb2.append(z);
            RVLogger.d(str, sb2.toString());
            return new BridgeResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e(f6528a, "startWifi... fail with exception", e);
            return new BridgeResponse.Error(12001, applicationContext.getString(R.string.griver_system_not_support_ability));
        }
    }

    private BridgeResponse c() {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (!this.d) {
            return new BridgeResponse.Error(12000, applicationContext.getString(R.string.griver_not_use_startwifi_before));
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(12005, applicationContext.getString(R.string.griver_wifi_is_disabled));
        }
        try {
            g();
            this.d = false;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            return new BridgeResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e(f6528a, "stopWifi... fail with exception", e);
            this.d = false;
            return new BridgeResponse.Error(12001, applicationContext.getString(R.string.griver_system_not_support_ability));
        }
    }

    private BridgeResponse a(String str, String str2, String str3, boolean z) {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (!this.d) {
            return new BridgeResponse.Error(12000, applicationContext.getString(R.string.griver_not_use_startwifi_before));
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(12000, applicationContext.getString(R.string.griver_wifi_is_disabled));
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BridgeResponse.INVALID_PARAM;
        }
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            String str4 = f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("connectWifi... now connecting SSID = ");
            sb.append(ssid);
            sb.append(" BSSID = ");
            sb.append(bssid);
            RVLogger.d(str4, sb.toString());
            if (TextUtils.equals(str, ssid) && TextUtils.equals(str2, bssid)) {
                RVLogger.d(str4, "connectWifi... re connect Wi-Fi ");
                return new BridgeResponse.Error(12004, applicationContext.getString(R.string.griver_connect_wifi_duplicated));
            }
        }
        int a2 = a(str, str2);
        if (a2 < 0) {
            String str5 = f6528a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connectWifi... no config found, create new WifiConfig, ssid = ");
            sb2.append(str);
            sb2.append(" bssid = ");
            sb2.append(str2);
            sb2.append(" pw = ");
            sb2.append(str3);
            sb2.append(" isWep = ");
            sb2.append(z);
            RVLogger.d(str5, sb2.toString());
            try {
                a2 = a(str, str2, str3, Boolean.valueOf(z));
            } catch (Exception e) {
                RVLogger.e(f6528a, "connectWifi... addWifiConfig fail, ", e);
                new BridgeResponse.Error(12011, applicationContext.getString(R.string.griver_can_not_config_wifi_in_background));
            }
        }
        if (a2 >= 0) {
            RVLogger.d(f6528a, "connectWifi... create success, and connect");
            boolean enableNetwork = i().enableNetwork(a2, true);
            i().saveConfiguration();
            i().reconnect();
            f();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(enableNetwork ? "success" : "fail", (Object) Boolean.TRUE);
            return new BridgeResponse(jSONObject);
        }
        RVLogger.d(f6528a, "connectWifi... create config fail");
        return new BridgeResponse.Error(12011, applicationContext.getString(R.string.griver_can_not_config_wifi_in_background));
    }

    private int a(String str, String str2) {
        List<WifiConfiguration> configuredNetworks = i().getConfiguredNetworks();
        if (configuredNetworks == null || configuredNetworks.size() <= 0) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        String obj = sb.toString();
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (TextUtils.equals(wifiConfiguration.SSID, obj) && TextUtils.equals(wifiConfiguration.BSSID, str2)) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    private int a(String str, String str2, String str3, Boolean bool) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        wifiConfiguration.SSID = sb.toString();
        wifiConfiguration.BSSID = str2;
        wifiConfiguration.hiddenSSID = false;
        wifiConfiguration.status = 2;
        if (TextUtils.isEmpty(str3)) {
            String[] strArr = wifiConfiguration.wepKeys;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\"");
            sb2.append(str3);
            sb2.append("\"");
            strArr[0] = sb2.toString();
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else if (bool != null && bool.booleanValue()) {
            String[] strArr2 = wifiConfiguration.wepKeys;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\"");
            sb3.append(str3);
            sb3.append("\"");
            strArr2[0] = sb3.toString();
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\"");
            sb4.append(str3);
            sb4.append("\"");
            wifiConfiguration.preSharedKey = sb4.toString();
        }
        return i().addNetwork(wifiConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.DISCONNECTED)) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifiDisconnect");
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTING)) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifiConnecting");
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifiConnected");
            h();
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.OBTAINING_IPADDR)) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifiGettingIP");
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.FAILED)) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifiConnecting");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            this.g.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        try {
            List<ScanResult> scanResults = i().getScanResults();
            if (scanResults != null && scanResults.size() > 0) {
                RVLogger.d(f6528a, "processScanResult... getWifiList success, unregisterWifiReceiver");
                g();
                JSONArray jSONArray = new JSONArray(scanResults.size() * 2);
                for (ScanResult scanResult : scanResults) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("SSID", (Object) scanResult.SSID);
                    jSONObject.put("BSSID", (Object) scanResult.BSSID);
                    jSONObject.put("secure", (Object) Boolean.valueOf(a(scanResult.capabilities) > 0));
                    jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(scanResult.level, 100)));
                    jSONArray.add(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wifiList", (Object) jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("data", (Object) jSONObject2);
                String str = f6528a;
                StringBuilder sb = new StringBuilder();
                sb.append("processScanResult... onGetWifiList, wifiList = ");
                sb.append(jSONArray.toJSONString());
                RVLogger.d(str, sb.toString());
                Page page = this.f;
                if (page != null) {
                    EngineUtils.sendToRender(page.getRender(), "getWifiList", jSONObject3, null);
                    return;
                }
                return;
            }
            BridgeCallback bridgeCallback = this.g;
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12010, applicationContext.getString(R.string.griver_system_error_in_scan_wifi)));
            }
        } catch (Exception e) {
            RVLogger.e(f6528a, "processScanResult... fail with exception", e);
            BridgeCallback bridgeCallback2 = this.g;
            if (bridgeCallback2 != null) {
                bridgeCallback2.sendBridgeResponse(new BridgeResponse.Error(12010, applicationContext.getString(R.string.griver_core_system_error)));
            }
        }
    }

    private BridgeResponse a(Page page) {
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        i();
        if (!this.d) {
            return new BridgeResponse.Error(12000, applicationContext.getString(R.string.griver_not_use_startwifi_before));
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(12005, applicationContext.getString(R.string.griver_wifi_is_disabled));
        }
        boolean isAppPermissionOPen = CommonUtils.isAppPermissionOPen(page.getPageContext().getActivity());
        boolean e = e();
        String str = f6528a;
        StringBuilder sb = new StringBuilder();
        sb.append("getWifiList... isAppPermissionOPen = ");
        sb.append(isAppPermissionOPen);
        sb.append(" & isGpsSwitchOPen = ");
        sb.append(e);
        RVLogger.e(str, sb.toString());
        if (isAppPermissionOPen) {
            if (!e) {
                return new BridgeResponse.Error(12006, applicationContext.getString(R.string.griver_gps_is_disabled));
            }
            f();
            boolean startScan = i().startScan();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(startScan ? "success" : "fail", (Object) Boolean.TRUE);
            return new BridgeResponse(jSONObject);
        }
        return new BridgeResponse.Error(12010, applicationContext.getString(R.string.griver_system_error_with_location_permission));
    }

    private boolean e() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return false;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        String str = f6528a;
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        RVLogger.d(str, sb.toString());
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return Settings.Secure.getInt(applicationContext.getContentResolver(), "location_mode", 0) != 0;
            } catch (Throwable th) {
                String str2 = f6528a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isGpsSwitchOPen, error,msg=");
                sb2.append(th);
                RVLogger.e(str2, sb2.toString());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        if (intent.getIntExtra("wifi_state", 1) == 0) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifi DISABLING");
        } else if (i().getWifiState() == 1) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifi DISABLED");
        } else if (i().getWifiState() == 2) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifi ENABLING");
        } else if (i().getWifiState() == 3) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifi ENABLED");
        } else if (i().getWifiState() == 4) {
            RVLogger.d(f6528a, "onReceiveWifiBroadcast... onWifi UNKNOWN");
        }
    }

    private void f() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        if (this.c || applicationContext == null) {
            return;
        }
        RVLogger.d(f6528a, "registerWifiReceiver... is not Registered , register receiver!!");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        applicationContext.registerReceiver(this.h, intentFilter);
        this.c = true;
    }

    private void g() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        if (!this.c || applicationContext == null) {
            return;
        }
        RVLogger.d(f6528a, "unregisterWifiReceiver... isRegistered = true, unregister receiver");
        applicationContext.unregisterReceiver(this.h);
        this.c = false;
    }

    private void h() {
        i();
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("SSID", (Object) connectionInfo.getSSID());
            jSONObject.put("BSSID", (Object) connectionInfo.getBSSID());
            jSONObject.put("secure", (Object) Boolean.valueOf(a(connectionInfo)));
            jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100)));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wifi", (Object) jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", (Object) jSONObject2);
            String str = f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("processWifiConnectedCallBack... onWifiConnected, JsonParams = ");
            sb.append(jSONObject.toJSONString());
            RVLogger.d(str, sb.toString());
            Page page = this.f;
            if (page != null) {
                EngineUtils.sendToRender(page.getRender(), "wifiConnected", jSONObject3, null);
            }
        }
    }

    private boolean a(WifiInfo wifiInfo) {
        List<WifiConfiguration> configuredNetworks = i().getConfiguredNetworks();
        if (configuredNetworks == null) {
            return false;
        }
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            String replace = wifiConfiguration.SSID.replace("\"", "");
            String replace2 = wifiInfo.getSSID().replace("\"", "");
            String str = f6528a;
            StringBuilder sb = new StringBuilder();
            sb.append("checkWifiSecurity... currentSSid = ");
            sb.append(replace2);
            sb.append(" configSSid = ");
            sb.append(replace);
            sb.append(" networkId = ");
            sb.append(wifiConfiguration.networkId);
            RVLogger.d(str, sb.toString());
            if (TextUtils.equals(replace2, replace) && wifiInfo.getNetworkId() == wifiConfiguration.networkId) {
                int a2 = a(wifiConfiguration);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("checkWifiSecurity..:: ");
                sb2.append(a2);
                RVLogger.d(str, sb2.toString());
                return a2 > 0;
            }
        }
        return false;
    }

    private WifiManager i() {
        RVEnvironmentService rVEnvironmentService;
        if (this.b == null && (rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)) != null) {
            this.b = (WifiManager) rVEnvironmentService.getApplicationContext().getSystemService("wifi");
        }
        return this.b;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppResumePoint
    public void onAppResume(App app) {
        if (this.e) {
            f();
        }
        this.e = false;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
        this.e = true;
        g();
    }
}
