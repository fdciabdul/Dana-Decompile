package com.alibaba.griver.device.jsapi.sensor;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.device.adapter.Callback;

/* loaded from: classes2.dex */
public class SensorBridgeExtension implements BridgeExtension {
    public static final String ON_GYROSCOPE_CHANGE = "gyroscopeChange";

    /* renamed from: a  reason: collision with root package name */
    private SensorServiceManager f6520a;

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void watchShake(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (jSONObject.containsKey("monitorAccelerometer")) {
            a(jSONObject.getBoolean("monitorAccelerometer").booleanValue(), page, jSONObject, bridgeCallback);
        } else if (jSONObject.containsKey("monitorCompass")) {
            b(jSONObject.getBoolean("monitorCompass").booleanValue(), page, jSONObject, bridgeCallback);
        } else if (jSONObject.containsKey("monitorGyroscope")) {
            c(jSONObject.getBoolean("monitorGyroscope").booleanValue(), page, jSONObject, bridgeCallback);
        } else {
            a(jSONObject, page, bridgeCallback);
        }
    }

    private void a(JSONObject jSONObject, Page page, final BridgeCallback bridgeCallback) {
        this.f6520a.create(-10, page.getPageContext().getActivity(), jSONObject).register(new Callback() { // from class: com.alibaba.griver.device.jsapi.sensor.SensorBridgeExtension.1
            @Override // com.alibaba.griver.device.adapter.Callback
            public void onTrigger(JSONObject jSONObject2, int i) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                SensorBridgeExtension.this.f6520a.unregister(-10);
            }
        });
    }

    private void a(boolean z, final Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        if (z) {
            this.f6520a.create(1, page.getPageContext().getActivity(), jSONObject).register(new Callback() { // from class: com.alibaba.griver.device.jsapi.sensor.SensorBridgeExtension.2
                @Override // com.alibaba.griver.device.adapter.Callback
                public void onTrigger(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    if (PWAUtils.isPwaAppAndLoadNewWay(page)) {
                        bridgeCallback.sendJSONResponse(jSONObject3);
                        SensorBridgeExtension.this.f6520a.unregister(1);
                        return;
                    }
                    EngineUtils.sendToRender(page.getRender(), "accelerometerChange", jSONObject3, null);
                }
            });
        } else {
            this.f6520a.unregister(1);
        }
    }

    private void b(boolean z, final Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        if (z) {
            this.f6520a.create(2, page.getPageContext().getActivity(), jSONObject).register(new Callback() { // from class: com.alibaba.griver.device.jsapi.sensor.SensorBridgeExtension.3
                @Override // com.alibaba.griver.device.adapter.Callback
                public void onTrigger(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    if (PWAUtils.isPwaAppAndLoadNewWay(page)) {
                        bridgeCallback.sendJSONResponse(jSONObject3);
                        SensorBridgeExtension.this.f6520a.unregister(2);
                        return;
                    }
                    EngineUtils.sendToRender(page.getRender(), "compassChange", jSONObject3, null);
                }
            });
        } else {
            this.f6520a.unregister(2);
        }
    }

    private void c(boolean z, final Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        if (z) {
            this.f6520a.create(4, page.getPageContext().getActivity(), jSONObject).register(new Callback() { // from class: com.alibaba.griver.device.jsapi.sensor.SensorBridgeExtension.4
                @Override // com.alibaba.griver.device.adapter.Callback
                public void onTrigger(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    if (PWAUtils.isPwaAppAndLoadNewWay(page)) {
                        bridgeCallback.sendJSONResponse(jSONObject3);
                        SensorBridgeExtension.this.f6520a.unregister(4);
                        return;
                    }
                    EngineUtils.sendToRender(page.getRender(), SensorBridgeExtension.ON_GYROSCOPE_CHANGE, jSONObject3, null);
                }
            });
        } else {
            this.f6520a.unregister(4);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.f6520a = new SensorServiceManager();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.f6520a.destroy();
    }
}
