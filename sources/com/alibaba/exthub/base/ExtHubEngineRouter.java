package com.alibaba.exthub.base;

import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import java.util.List;

/* loaded from: classes3.dex */
public class ExtHubEngineRouter implements EngineRouter {
    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void destroy() {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public List<Render> getRegisteredRender() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Render getRenderById(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Worker getWorkerById(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRender(String str, Render render) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRenderInitListener(String str, EngineRouter.RenderInitListener renderInitListener) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerWorker(String str, Worker worker) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void resetRenderToTop(Render render) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterRender(String str) {
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterWorker(String str) {
    }
}
