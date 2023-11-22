package com.alibaba.griver.device.jsapi.system;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;

/* loaded from: classes6.dex */
public class MemoryWarningBridgeExtension extends SimpleBridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private Page f6523a;
    final Context mContext = GriverEnv.getApplicationContext();
    final ComponentCallbacks2 mCallback = new ComponentCallbacks2() { // from class: com.alibaba.griver.device.jsapi.system.MemoryWarningBridgeExtension.1
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            if (i == 10 || i == 15) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("level", (Object) Integer.valueOf(i));
                jSONObject.put("data", (Object) jSONObject2);
                if (MemoryWarningBridgeExtension.this.f6523a != null) {
                    EngineUtils.sendToRender(MemoryWarningBridgeExtension.this.f6523a.getRender(), "memoryWarning", jSONObject, null);
                }
            }
        }
    };

    private void a() {
        b();
        this.mContext.registerComponentCallbacks(this.mCallback);
    }

    private void b() {
        this.mContext.unregisterComponentCallbacks(this.mCallback);
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse startMonitorMemoryWarning(@BindingNode(Page.class) Page page) {
        this.f6523a = page;
        a();
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse stopMonitorMemoryWarning(@BindingNode(Page.class) Page page) {
        b();
        return BridgeResponse.SUCCESS;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        super.onInitialized();
        a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        super.onFinalized();
        b();
    }
}
