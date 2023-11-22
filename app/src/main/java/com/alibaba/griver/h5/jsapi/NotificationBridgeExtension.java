package com.alibaba.griver.h5.jsapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class NotificationBridgeExtension extends SimpleBridgeExtension {
    public static final String NOTIFY_PREFIX = "IAPAppContainer_";

    /* renamed from: a  reason: collision with root package name */
    private LocalBroadcastManager f6549a = null;
    private Map<String, Boolean> b = null;
    private Map<String, BroadcastReceiver> c = null;

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        super.onInitialized();
        this.f6549a = LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext());
        this.b = new HashMap();
        this.c = new HashMap();
    }

    @ActionFilter
    public void postNotification(@BindingApiContext(required = true) ApiContext apiContext, @BindingParam(name = {"name"}) String str, @BindingParam(name = {"data"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        }
        Set<String> keySet = jSONObject.keySet();
        Intent intent = new Intent();
        String config = GriverConfig.getConfig("h5_notify_prefix", null);
        if (config == null) {
            config = NOTIFY_PREFIX;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(config);
        sb.append(str);
        intent.setAction(sb.toString());
        for (String str2 : keySet) {
            intent.putExtra(str2, String.valueOf(JSONUtils.getValue(jSONObject, str2, new Object())));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("postNotify action:");
        sb2.append(config);
        sb2.append(str);
        sb2.append(" intent data ");
        sb2.append(jSONObject);
        GriverLogger.d("NotificationBridgeExtension", sb2.toString());
        this.f6549a.sendBroadcast(intent);
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    @ActionFilter
    public void addNotifyListener(@BindingApiContext(required = true) ApiContext apiContext, @BindingParam(name = {"name"}) final String str, @BindingParam(name = {"keep"}) boolean z, @BindingCallback(isSticky = true) final BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            GriverLogger.d("NotificationBridgeExtension", "broadcastname none");
        } else if (this.b.containsKey(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", "repeat event");
            jSONObject.put("error", (Object) 12);
            bridgeCallback.sendJSONResponse(jSONObject);
            GriverLogger.d("NotificationBridgeExtension", "repeat event");
        } else {
            this.b.put(str, Boolean.valueOf(z));
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.alibaba.griver.h5.jsapi.NotificationBridgeExtension.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent == null || NotificationBridgeExtension.this.b == null || NotificationBridgeExtension.this.b.get(str) == null || bridgeCallback == null || NotificationBridgeExtension.this.f6549a == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    try {
                        bundle = intent.getExtras();
                    } catch (Exception e) {
                        GriverLogger.e("NotificationBridgeExtension", "getExtras Exception", e);
                    }
                    if (Boolean.TRUE.equals(NotificationBridgeExtension.this.b.get(str))) {
                        bridgeCallback.sendJSONResponse(BundleUtils.toJSONObject(bundle));
                        return;
                    }
                    bridgeCallback.sendJSONResponse(BundleUtils.toJSONObject(bundle));
                    GriverLogger.d("NotificationBridgeExtension", "unregister receiver keepalive false");
                    NotificationBridgeExtension.this.f6549a.unregisterReceiver(this);
                    NotificationBridgeExtension.this.b.remove(str);
                }
            };
            this.f6549a.registerReceiver(broadcastReceiver, new IntentFilter(str));
            GriverLogger.d("NotificationBridgeExtension", "register receiver");
            this.c.put(str, broadcastReceiver);
        }
    }

    @ActionFilter
    public void removeNotifyListener(@BindingApiContext(required = true) ApiContext apiContext, @BindingParam(name = {"name"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (this.c.containsKey(str)) {
            this.f6549a.unregisterReceiver(this.c.get(str));
            this.b.remove(str);
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }
}
