package com.alibaba.exthub.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.kernel.api.node.Node;

/* loaded from: classes3.dex */
public class ExtHubRVEngine implements RVEngine {
    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render createRender(Activity activity, Node node, CreateParams createParams) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Worker createWorker(Context context, Node node, String str, String str2) throws Throwable {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void destroy() {
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getAppId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Context getApplication() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public NativeBridge getBridge() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getEngineType() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getInstanceId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Node getNode() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Bundle getStartParams() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render getTopRender() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void init(InitParams initParams, EngineInitCallback engineInitCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isDestroyed() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isReady() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void setup(Bundle bundle, Bundle bundle2, EngineSetupCallback engineSetupCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public EngineRouter getEngineRouter() {
        return new ExtHubEngineRouter();
    }
}
