package com.alibaba.griver.v8.proxy;

import android.os.Bundle;
import android.os.Handler;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alibaba.griver.v8.AriverJSEngineDelegate;
import com.alipay.mobile.jsengine.Delegate;

/* loaded from: classes6.dex */
public class GriverV8Proxy implements V8Proxy {
    Delegate mDelegate;

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public void addAssociatedThread(String str) {
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public int getAllowCreatedWorkerMaxCount() {
        return 0;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public Handler getDispatchHandler(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getPackageName() {
        return "Alibaba";
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getSessionId(Render render) {
        return "";
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String[] getV8PluginNameList(String str, Bundle bundle) {
        return null;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean hasSyncApiPermission(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public int quickVerifyWebViewCoreSo(String str) {
        return 1;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean removeWebViewCore() {
        return true;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public Delegate generateDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new AriverJSEngineDelegate();
        }
        return this.mDelegate;
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public String getWebViewCoreSoPath() {
        if (this.mDelegate == null) {
            generateDelegate();
        }
        return this.mDelegate.getWebViewCoreSoPath();
    }

    @Override // com.alibaba.ariver.v8worker.V8Proxy
    public boolean unzipWebViewCoreSo() {
        if (this.mDelegate == null) {
            generateDelegate();
        }
        this.mDelegate.unzipWebViewCoreSo();
        return true;
    }
}
