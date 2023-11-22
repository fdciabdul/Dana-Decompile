package com.alibaba.griver.v8.dispatch;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.v8.dispatch.GriverJsApiMsgQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverConcurrentJsHandlerDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private static int f6776a;
    private String b;
    private List<GriverDispatchThread> c;
    private GriverJsApiMsgQueue d;

    static /* synthetic */ int access$004() {
        int i = f6776a + 1;
        f6776a = i;
        return i;
    }

    public GriverConcurrentJsHandlerDispatcher(App app, GriverJsApiMsgQueue griverJsApiMsgQueue, int i, String str) {
        this.b = "GriverConcurrentJsHandlerDispatcher";
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("-");
        sb.append(str);
        this.b = sb.toString();
        this.d = griverJsApiMsgQueue;
        this.c = new ArrayList(i);
        if (i <= 0) {
            RVLogger.d(this.b, "connect dispatch should size > 0");
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            GriverDispatchThread griverDispatchThread = new GriverDispatchThread(app, griverJsApiMsgQueue);
            griverDispatchThread.start();
            this.c.add(griverDispatchThread);
        }
    }

    public void quit() {
        Iterator<GriverDispatchThread> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().quit();
        }
        this.d.clear();
        this.c.clear();
        RVLogger.d(this.b, "NXConcurrentJsHandlerDispatcher quit");
    }

    /* loaded from: classes6.dex */
    public class GriverDispatchThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private GriverJsApiMsgQueue f6777a;
        private volatile boolean b;
        private App c;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public GriverDispatchThread(com.alibaba.ariver.app.api.App r3, com.alibaba.griver.v8.dispatch.GriverJsApiMsgQueue r4) {
            /*
                r1 = this;
                com.alibaba.griver.v8.dispatch.GriverConcurrentJsHandlerDispatcher.this = r2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r0 = "griverdispatch-"
                r2.append(r0)
                java.lang.String r0 = r3.getAppId()
                r2.append(r0)
                java.lang.String r0 = "-"
                r2.append(r0)
                int r0 = com.alibaba.griver.v8.dispatch.GriverConcurrentJsHandlerDispatcher.access$004()
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                r2 = 0
                r1.b = r2
                r1.f6777a = r4
                r1.c = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.v8.dispatch.GriverConcurrentJsHandlerDispatcher.GriverDispatchThread.<init>(com.alibaba.griver.v8.dispatch.GriverConcurrentJsHandlerDispatcher, com.alibaba.ariver.app.api.App, com.alibaba.griver.v8.dispatch.GriverJsApiMsgQueue):void");
        }

        public void quit() {
            this.b = true;
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.b) {
                try {
                    GriverJsApiMsgQueue.JsApiCallItem take = this.f6777a.take();
                    if (take != null) {
                        NativeCallContext callContext = take.getCallContext();
                        SendToNativeCallback callback = take.getCallback();
                        boolean isNeedPermission = take.isNeedPermission();
                        RVEngine engineProxy = this.c.getEngineProxy();
                        if (engineProxy != null && !engineProxy.isDestroyed()) {
                            engineProxy.getBridge().sendToNative(callContext, callback, isNeedPermission);
                        }
                        RVLogger.e(GriverConcurrentJsHandlerDispatcher.this.b, "NXDispatchThread handleMsg,but engine is null or is destroyed");
                    }
                } catch (InterruptedException e) {
                    if (this.b) {
                        return;
                    }
                    RVLogger.e(GriverConcurrentJsHandlerDispatcher.this.b, "NXDispatchThread handle msg  is interrupted ", e);
                } catch (Exception e2) {
                    RVLogger.e(GriverConcurrentJsHandlerDispatcher.this.b, "NXDispatchThread handle msg is failed", e2);
                }
            }
        }
    }
}
