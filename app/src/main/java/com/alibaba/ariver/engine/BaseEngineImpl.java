package com.alibaba.ariver.engine;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.EngineStack;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.engine.common.bridge.DefaultNativeBridge;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* loaded from: classes3.dex */
public abstract class BaseEngineImpl implements RVEngine {

    /* renamed from: a  reason: collision with root package name */
    private Node f6013a;
    private String b;
    private EngineRouter d;
    protected InitParams initParams;
    private boolean f = false;
    private Context e = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    private NativeBridge c = createNativeBridge();

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getEngineType() {
        return "WEB";
    }

    public BaseEngineImpl(String str, Node node) {
        this.f6013a = node;
        this.b = str;
        EngineRouter createEngineRouter = createEngineRouter();
        this.d = createEngineRouter;
        this.c.bindEngineRouter(createEngineRouter);
    }

    protected NativeBridge createNativeBridge() {
        return new DefaultNativeBridge();
    }

    public void setNativeBridge(NativeBridge nativeBridge) {
        this.c = nativeBridge;
    }

    protected EngineRouter createEngineRouter() {
        return new DefaultEngineRouter();
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void init(InitParams initParams, EngineInitCallback engineInitCallback) {
        this.initParams = initParams;
        EngineStack.getInstance().pushEnginePorxy(this);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render getTopRender() {
        return this.d.getRenderById(null);
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getAppId() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Bundle getStartParams() {
        InitParams initParams = this.initParams;
        if (initParams == null) {
            return null;
        }
        return initParams.startParams;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public EngineRouter getEngineRouter() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public NativeBridge getBridge() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Node getNode() {
        return this.f6013a;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Context getApplication() {
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public final void destroy() {
        synchronized (this) {
            if (this.f) {
                return;
            }
            this.f = true;
            onDestroy();
            this.c.release();
            EngineStack.getInstance().removeProxy(this);
        }
    }

    protected void onDestroy() {
        EngineRouter engineRouter = this.d;
        if (engineRouter != null) {
            engineRouter.destroy();
        }
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isDestroyed() {
        return this.f;
    }
}
