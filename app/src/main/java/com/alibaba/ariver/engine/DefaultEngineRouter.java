package com.alibaba.ariver.engine;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes3.dex */
public class DefaultEngineRouter implements EngineRouter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6015a;
    private final Object b = new Object();
    private final Map<String, Worker> c = new ConcurrentHashMap();
    private final Stack<Worker> d = new Stack<>();
    private final Map<String, Render> e = new ConcurrentHashMap();
    private final Stack<Render> f = new Stack<>();
    private Map<String, List<EngineRouter.RenderInitListener>> g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("AriverEngine:");
        sb.append("DefaultEngineRouter");
        f6015a = sb.toString();
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerWorker(String str, Worker worker) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            if (!this.c.containsKey(str)) {
                this.c.put(str, worker);
                this.d.push(worker);
            } else {
                String str2 = f6015a;
                StringBuilder sb = new StringBuilder();
                sb.append("DefaultEngineRouter has sample worker ");
                sb.append(str);
                RVLogger.d(str2, sb.toString());
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterWorker(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.d) {
            String str2 = f6015a;
            StringBuilder sb = new StringBuilder();
            sb.append("unRegisterWorker: ");
            sb.append(str);
            RVLogger.d(str2, sb.toString());
            Worker worker = this.c.get(str);
            if (worker != null) {
                this.c.remove(str);
                this.d.remove(worker);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Worker getWorkerById(String str) {
        synchronized (this.d) {
            if (TextUtils.isEmpty(str)) {
                if (this.d.size() > 0) {
                    return this.d.peek();
                }
                return null;
            }
            return this.c.get(str);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void resetRenderToTop(Render render) {
        String str = f6015a;
        StringBuilder sb = new StringBuilder();
        sb.append("resetRenderToTop: ");
        sb.append(render);
        RVLogger.d(str, sb.toString());
        if (render == null) {
            return;
        }
        synchronized (this.f) {
            if (this.f.remove(render)) {
                this.f.push(render);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRender(String str, Render render) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f) {
            if (!this.e.containsKey(str)) {
                this.e.put(str, render);
                this.f.push(render);
            } else {
                String str2 = f6015a;
                StringBuilder sb = new StringBuilder();
                sb.append("DefaultEngineRouter has sample worker ");
                sb.append(str);
                RVLogger.d(str2, sb.toString());
            }
        }
        a(render);
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void unRegisterRender(String str) {
        String str2 = f6015a;
        StringBuilder sb = new StringBuilder();
        sb.append("unRegisterRender: ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f) {
            Render render = this.e.get(str);
            if (render != null) {
                this.e.remove(str);
                this.f.remove(render);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public Render getRenderById(String str) {
        synchronized (this.f) {
            if (TextUtils.isEmpty(str)) {
                if (this.f.size() > 0) {
                    return this.f.peek();
                }
                return null;
            }
            return this.e.get(str);
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public List<Render> getRegisteredRender() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList(this.f);
        }
        return arrayList;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void destroy() {
        Collection<Worker> values = this.c.values();
        Iterator<Worker> it = values.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.c.clear();
        this.e.clear();
        this.f.clear();
        values.clear();
        synchronized (this.b) {
            Map<String, List<EngineRouter.RenderInitListener>> map = this.g;
            if (map != null) {
                map.clear();
            }
            this.g = null;
        }
    }

    @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter
    public void registerRenderInitListener(String str, EngineRouter.RenderInitListener renderInitListener) {
        synchronized (this.b) {
            if (this.g == null) {
                this.g = new HashMap();
            }
            if (!this.g.containsKey(str)) {
                this.g.put(str, new LinkedList());
            }
            this.g.get(str).add(renderInitListener);
        }
        Render renderById = getRenderById(str);
        if (renderById != null) {
            a(renderById);
        }
    }

    private void a(Render render) {
        if (render != null) {
            String renderId = render.getRenderId();
            if (TextUtils.isEmpty(renderId)) {
                return;
            }
            synchronized (this.b) {
                if (!CollectionUtils.isEmpty(this.g)) {
                    List<EngineRouter.RenderInitListener> list = this.g.get(renderId);
                    if (!CollectionUtils.isEmpty(list)) {
                        Iterator<EngineRouter.RenderInitListener> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onRenderInit(render);
                        }
                    }
                    this.g.remove(renderId);
                }
            }
        }
    }
}
