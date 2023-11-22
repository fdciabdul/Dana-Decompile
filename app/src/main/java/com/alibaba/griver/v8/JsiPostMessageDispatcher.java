package com.alibaba.griver.v8;

import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class JsiPostMessageDispatcher extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<JSONObject> f6773a;
    private final String b;
    private volatile boolean c;
    private V8Worker d;
    private App e;
    private int f;
    final ConditionVariable renderRendyLock;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public JsiPostMessageDispatcher(com.alibaba.ariver.v8worker.V8Worker r3, com.alibaba.ariver.app.api.App r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "worker-postmessage-"
            r0.append(r1)
            java.lang.String r1 = r4.getAppId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            android.os.ConditionVariable r0 = new android.os.ConditionVariable
            r0.<init>()
            r2.renderRendyLock = r0
            java.lang.String r0 = "viewId"
            r2.b = r0
            r0 = 0
            r2.c = r0
            r2.f = r0
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            r2.f6773a = r0
            r2.d = r3
            r2.e = r4
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVConfigService> r3 = com.alibaba.ariver.kernel.common.service.RVConfigService.class
            java.lang.Object r3 = com.alibaba.ariver.kernel.common.RVProxy.get(r3)
            com.alibaba.ariver.kernel.common.service.RVConfigService r3 = (com.alibaba.ariver.kernel.common.service.RVConfigService) r3
            java.lang.String r4 = "ta_messagequeue_init_timeout"
            java.lang.String r0 = "60000"
            java.lang.String r3 = r3.getConfig(r4, r0)
            int r3 = java.lang.Integer.parseInt(r3)
            r2.f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.v8.JsiPostMessageDispatcher.<init>(com.alibaba.ariver.v8worker.V8Worker, com.alibaba.ariver.app.api.App):void");
    }

    public void dispatch(JSONObject jSONObject) {
        if (RVKernelUtils.isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatch add PostMessage :\t ");
            sb.append(jSONObject);
            RVLogger.d("JsiPostMessageDispatcher", sb.toString());
        }
        this.f6773a.add(jSONObject);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.c) {
            try {
                JSONObject take = this.f6773a.take();
                String string = JSONUtils.getString(JSONUtils.getJSONObject(take, "data", null), "viewId", null);
                if (TextUtils.isEmpty(string)) {
                    RVLogger.d("JsiPostMessageDispatcher", "VIEW id is null");
                } else if (a(this.e, string)) {
                    a(take, string);
                } else {
                    b(take, string);
                }
            } catch (InterruptedException e) {
                if (this.c) {
                    return;
                }
                RVLogger.w("JsiPostMessageDispatcher", "postMessage is interrupted ", e);
            } catch (Exception e2) {
                RVLogger.e("JsiPostMessageDispatcher", "postMessage is failed", e2);
            }
        }
    }

    public void quit() {
        this.c = true;
        interrupt();
    }

    private boolean a(App app, String str) {
        if (this.d.isRenderReady()) {
            return false;
        }
        if (AppxPrerunChecker.isRenderMessageQueue(app.getAppId())) {
            if (a() == null) {
                throw new IllegalStateException("getEngineRouter is null");
            }
            if (a().getRenderById(str) != null) {
                return false;
            }
            this.renderRendyLock.close();
            RVLogger.d("JsiPostMessageDispatcher", "prerun registerRenderInitListener");
            a().registerRenderInitListener(str, new EngineRouter.RenderInitListener() { // from class: com.alibaba.griver.v8.JsiPostMessageDispatcher.1
                @Override // com.alibaba.ariver.engine.api.bridge.EngineRouter.RenderInitListener
                public void onRenderInit(Render render) {
                    RVLogger.d("JsiPostMessageDispatcher", "prerun registerRenderInitListener success");
                    JsiPostMessageDispatcher.this.renderRendyLock.open();
                }
            });
            if (!this.renderRendyLock.block(this.f)) {
                RVLogger.w("JsiPostMessageDispatcher", "warning, **** prerun failed, RenderInitListener is not callback");
                return false;
            }
            a().getRenderById(str);
            return false;
        }
        if (!this.d.isRenderReady()) {
            this.renderRendyLock.close();
            this.d.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.griver.v8.JsiPostMessageDispatcher.2
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    JsiPostMessageDispatcher.this.renderRendyLock.open();
                }
            });
            if (!this.renderRendyLock.block(this.f)) {
                RVLogger.e("JsiPostMessageDispatcher", "warning, **** RenderInitListener is not callback");
            }
        }
        return false;
    }

    private void a(JSONObject jSONObject, String str) {
        if (a() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("prerun jsMessage is ");
        sb.append(jSONObject);
        RVLogger.d("JsiPostMessageDispatcher", sb.toString());
        Render renderById = a().getRenderById(str);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action(this.d.isRenderReady() ? "message" : "messagequeue").type("call").param(jSONObject).build(), null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("postMessage but cannot find viewId: ");
        sb2.append(str);
        RVLogger.w("JsiPostMessageDispatcher", sb2.toString());
    }

    private void b(JSONObject jSONObject, String str) {
        if (a() == null) {
            return;
        }
        Render renderById = a().getRenderById(str);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("postMessage but cannot find viewId: ");
        sb.append(str);
        RVLogger.w("JsiPostMessageDispatcher", sb.toString());
    }

    private EngineRouter a() {
        if (this.e.getEngineProxy() == null) {
            RVLogger.d("JsiPostMessageDispatcher", "getEngineRouter is null");
            return null;
        }
        return this.e.getEngineProxy().getEngineRouter();
    }
}
