package com.alibaba.griver.device.jsapi.system;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class GetBatteryInfoBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6522a = "com.alibaba.griver.device.jsapi.system.GetBatteryInfoBridgeExtension";
    private BridgeCallback d;
    private IntentFilter b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private volatile boolean c = false;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.alibaba.griver.device.jsapi.system.GetBatteryInfoBridgeExtension.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int intExtra = intent.getIntExtra("level", 0);
                boolean z = intent.getIntExtra("plugged", 0) != 0;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("level", (Object) Integer.valueOf(intExtra));
                jSONObject.put("isCharging", (Object) Boolean.valueOf(z));
                GetBatteryInfoBridgeExtension.this.d.sendBridgeResponse(new BridgeResponse(jSONObject));
            } catch (Throwable unused) {
            }
            GetBatteryInfoBridgeExtension.this.b();
        }
    };

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public void getBatteryInfo(@BindingCallback BridgeCallback bridgeCallback) {
        this.d = bridgeCallback;
        a();
    }

    private void a() {
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            if (rVEnvironmentService != null) {
                Application applicationContext = rVEnvironmentService.getApplicationContext();
                if (applicationContext != null) {
                    applicationContext.registerReceiver(this.e, this.b);
                    return;
                } else {
                    RVLogger.d(f6522a, "register battery receiver failed");
                    return;
                }
            }
            RVLogger.d(f6522a, "register battery receiver failed");
        } catch (Throwable th) {
            RVLogger.e(f6522a, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Application applicationContext;
        try {
            if (this.c) {
                this.c = false;
                RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
                if (rVEnvironmentService == null || (applicationContext = rVEnvironmentService.getApplicationContext()) == null) {
                    return;
                }
                applicationContext.unregisterReceiver(this.e);
            }
        } catch (Throwable th) {
            RVLogger.e(f6522a, th);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.d = null;
        b();
    }
}
