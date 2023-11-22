package com.alibaba.ariver.legacy.v8worker;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.R;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;

/* loaded from: classes6.dex */
public class JSWorker {
    private static final String TAG = "JSWorker";
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private V8Function mInMessageCallback;
    private V8Object mMainJSObject;
    private V8Function mOutMessageCallback;
    private V8 mV8Runtime;
    private V8Worker mV8Worker;

    public JSWorker(V8Worker v8Worker, String str, V8Object v8Object, final String str2, final Object obj) {
        this.mV8Worker = v8Worker;
        this.mMainJSObject = v8Object;
        HandlerThread handlerThread = new HandlerThread(str);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.JSWorker.1
            @Override // java.lang.Runnable
            public void run() {
                JSWorker.this.doInit(str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInit(String str, Object obj) {
        V8 createV8Runtime = V8.createV8Runtime("worker");
        this.mV8Runtime = createV8Runtime;
        createV8Runtime.registerJavaMethod(new importScriptsCallback(), "importScripts");
        this.mV8Runtime.registerJavaMethod(new onMessageCallback(), "onMessage");
        this.mV8Runtime.registerJavaMethod(new postMessageCallback(), NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
        JSConsole.setup(this.mV8Runtime);
        doExecuteScript(V8Utils.readRawFile(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), R.raw.workerjs_worker), "https://appx/v8.multiworker.js", 0);
        RVLogger.d(TAG, "Starting JS Worker...");
        doExecuteScript(obj, str, 0);
        RVLogger.d(TAG, "JS Worker ready.");
    }

    private void doExecuteScript(Object obj, String str, int i) {
        if (isReleased()) {
            return;
        }
        try {
            if (obj instanceof String) {
                this.mV8Runtime.executeVoidScript((String) obj, str, i);
            } else if (obj instanceof byte[]) {
                this.mV8Runtime.executeVoidScript((byte[]) obj, str, i);
            }
            this.mV8Runtime.pumpMessageLoop(false);
        } catch (Throwable th) {
            String makeLogMsg = V8Utils.makeLogMsg(th);
            StringBuilder sb = new StringBuilder();
            sb.append("Caught exception when executeScript ");
            sb.append(str);
            sb.append("\n");
            sb.append(makeLogMsg);
            RVLogger.e(TAG, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminate() {
        if (isReleased()) {
            return;
        }
        V8Object v8Object = this.mMainJSObject;
        if (v8Object != null) {
            v8Object.release();
            this.mMainJSObject = null;
        }
        V8Function v8Function = this.mOutMessageCallback;
        if (v8Function != null) {
            v8Function.release();
            this.mOutMessageCallback = null;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.JSWorker.2
            /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
            
                if (android.os.Build.VERSION.SDK_INT >= 18) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r4 = this;
                    com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                    boolean r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$100(r0)
                    if (r0 == 0) goto L9
                    return
                L9:
                    r0 = 18
                    com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this     // Catch: java.lang.Throwable -> L30
                    com.alipay.mobile.jsengine.v8.V8Function r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$200(r1)     // Catch: java.lang.Throwable -> L30
                    if (r1 == 0) goto L22
                    com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this     // Catch: java.lang.Throwable -> L30
                    com.alipay.mobile.jsengine.v8.V8Function r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$200(r1)     // Catch: java.lang.Throwable -> L30
                    r1.release()     // Catch: java.lang.Throwable -> L30
                    com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this     // Catch: java.lang.Throwable -> L30
                    r2 = 0
                    com.alibaba.ariver.legacy.v8worker.JSWorker.access$202(r1, r2)     // Catch: java.lang.Throwable -> L30
                L22:
                    com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this     // Catch: java.lang.Throwable -> L30
                    com.alipay.mobile.jsengine.v8.V8 r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$300(r1)     // Catch: java.lang.Throwable -> L30
                    r1.release()     // Catch: java.lang.Throwable -> L30
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r0) goto L46
                    goto L3c
                L30:
                    r1 = move-exception
                    java.lang.String r2 = "JSWorker"
                    java.lang.String r3 = "Caught exception when release v8 vm"
                    com.alibaba.ariver.kernel.common.utils.RVLogger.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L50
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r0) goto L46
                L3c:
                    com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$400(r0)
                    r0.quitSafely()
                    return
                L46:
                    com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$400(r0)
                    r0.quit()
                    return
                L50:
                    r1 = move-exception
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r0) goto L5f
                    com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$400(r0)
                    r0.quitSafely()
                    goto L68
                L5f:
                    com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$400(r0)
                    r0.quit()
                L68:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.legacy.v8worker.JSWorker.AnonymousClass2.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReleased() {
        V8 v8 = this.mV8Runtime;
        return v8 == null || v8.isReleased();
    }

    public void setOutMessageCallback(V8Function v8Function) {
        V8Function v8Function2 = this.mOutMessageCallback;
        if (v8Function2 != null) {
            v8Function2.release();
        }
        this.mOutMessageCallback = v8Function;
    }

    public void setInMessageCallback(V8Function v8Function) {
        V8Function v8Function2 = this.mInMessageCallback;
        if (v8Function2 != null) {
            v8Function2.release();
        }
        this.mInMessageCallback = v8Function;
    }

    public void postMessageToMain(V8Object v8Object) {
        doPostMessage(v8Object, this.mV8Worker.getHandler(), false);
    }

    public void postMessageToWorker(V8Object v8Object) {
        doPostMessage(v8Object, this.mHandler, true);
    }

    private void doPostMessage(V8Object v8Object, Handler handler, final boolean z) {
        final long serialize = v8Object.serialize();
        v8Object.release();
        if (serialize == 0) {
            RVLogger.e(TAG, "failed to serialize js object...");
        } else {
            handler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.JSWorker.3
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
                
                    if (r2 != null) goto L23;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
                
                    return;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        r5 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto Lb
                        com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                        com.alipay.mobile.jsengine.v8.V8 r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$300(r0)
                        goto L15
                    Lb:
                        com.alibaba.ariver.legacy.v8worker.JSWorker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                        com.alibaba.ariver.legacy.v8worker.V8Worker r0 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$500(r0)
                        com.alipay.mobile.jsengine.v8.V8 r0 = r0.getV8Runtime()
                    L15:
                        boolean r1 = r2
                        if (r1 == 0) goto L20
                        com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                        com.alipay.mobile.jsengine.v8.V8Function r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$200(r1)
                        goto L26
                    L20:
                        com.alibaba.ariver.legacy.v8worker.JSWorker r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.this
                        com.alipay.mobile.jsengine.v8.V8Function r1 = com.alibaba.ariver.legacy.v8worker.JSWorker.access$600(r1)
                    L26:
                        if (r0 == 0) goto L78
                        boolean r2 = r0.isReleased()
                        if (r2 != 0) goto L78
                        if (r1 == 0) goto L78
                        boolean r2 = r1.isReleased()
                        if (r2 != 0) goto L78
                        long r2 = r3
                        com.alipay.mobile.jsengine.v8.V8Value r2 = r0.deserialize(r2)
                        com.alipay.mobile.jsengine.v8.V8Array r3 = new com.alipay.mobile.jsengine.v8.V8Array
                        r3.<init>(r0)
                        r3.push(r2)
                        r1.call(r0, r3)     // Catch: java.lang.Throwable -> L4a
                        if (r2 == 0) goto L6a
                        goto L67
                    L4a:
                        r0 = move-exception
                        java.lang.String r0 = com.alibaba.ariver.legacy.v8worker.V8Utils.makeLogMsg(r0)     // Catch: java.lang.Throwable -> L6e
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
                        r1.<init>()     // Catch: java.lang.Throwable -> L6e
                        java.lang.String r4 = "doPostMessage "
                        r1.append(r4)     // Catch: java.lang.Throwable -> L6e
                        r1.append(r0)     // Catch: java.lang.Throwable -> L6e
                        java.lang.String r0 = "JSWorker"
                        java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L6e
                        com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r1)     // Catch: java.lang.Throwable -> L6e
                        if (r2 == 0) goto L6a
                    L67:
                        r2.release()
                    L6a:
                        r3.release()
                        return
                    L6e:
                        r0 = move-exception
                        if (r2 == 0) goto L74
                        r2.release()
                    L74:
                        r3.release()
                        throw r0
                    L78:
                        long r1 = r3
                        r0.cancelSerialization(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.legacy.v8worker.JSWorker.AnonymousClass3.run():void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class importScriptsCallback implements JavaVoidCallback {
        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
        }

        importScriptsCallback() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class onMessageCallback implements JavaVoidCallback {
        onMessageCallback() {
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                JSWorker.this.setInMessageCallback((V8Function) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(JSWorker.TAG, "failed to set onmessage in Worker", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class postMessageCallback implements JavaVoidCallback {
        postMessageCallback() {
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                JSWorker.this.postMessageToMain((V8Object) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(JSWorker.TAG, "failed to postMessage in Worker", th);
            }
        }
    }
}
