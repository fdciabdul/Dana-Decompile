package com.alibaba.ariver.engine.api.bridge;

import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import java.util.List;

/* loaded from: classes2.dex */
public interface EngineRouter {

    /* loaded from: classes3.dex */
    public interface RenderInitListener {
        void onRenderInit(Render render);
    }

    void destroy();

    List<Render> getRegisteredRender();

    Render getRenderById(String str);

    Worker getWorkerById(String str);

    void registerRender(String str, Render render);

    void registerRenderInitListener(String str, RenderInitListener renderInitListener);

    void registerWorker(String str, Worker worker);

    void resetRenderToTop(Render render);

    void unRegisterRender(String str);

    void unRegisterWorker(String str);
}
