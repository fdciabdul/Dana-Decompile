package com.alibaba.ariver.v8worker;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSValueBlob;

/* loaded from: classes6.dex */
public class MultiThreadWorker {
    private static final String TAG = "MultiThreadWorker";
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private JSFunction mInMessageFunction;
    private JSObject mMainJSObject;
    private JSFunction mOutMessageFunction;
    private V8Worker mV8Worker;
    private EngineScope mWorkerEngineScope;
    private JSContext mWorkerJSContext;
    private JSEngine mWorkerJSEngine;

    public MultiThreadWorker(V8Worker v8Worker, final String str, JSObject jSObject, final String str2, final String str3) {
        this.mV8Worker = v8Worker;
        this.mMainJSObject = jSObject;
        HandlerThread handlerThread = new HandlerThread(str);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.mHandlerThread.getName());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("v8Proxy is null, V8Worker Thread will be controlled: ");
            sb.append(this.mHandlerThread.getName());
            RVLogger.e(TAG, sb.toString());
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.MultiThreadWorker.1
            @Override // java.lang.Runnable
            public void run() {
                MultiThreadWorker.this.doInit(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInit(String str, String str2, String str3) {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        String packageName = v8Proxy != null ? v8Proxy.getPackageName() : "Alipay";
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append("-JSEngine-");
        sb.append(str);
        String obj = sb.toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", obj);
        bundle.putString("version", "1.0");
        this.mWorkerJSEngine = JSEngine.createInstance(applicationContext, bundle, this.mHandler);
        if (RVKernelUtils.isDebug()) {
            this.mWorkerJSEngine.setEnableStats(true);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("-JSContext");
        this.mWorkerJSContext = this.mWorkerJSEngine.createContext(sb2.toString());
        this.mWorkerEngineScope = new EngineScope(this.mWorkerJSEngine);
        if (!RVKernelUtils.isDebug()) {
            JSConsole.setup(this.mWorkerJSContext, null, this.mV8Worker.getAppId());
        }
        JSObject globalObject = this.mWorkerJSContext.globalObject();
        globalObject.set(this.mWorkerJSContext, "worker", globalObject);
        globalObject.set(this.mWorkerJSContext, "self", globalObject);
        JSFunction jSFunction = new JSFunction(this.mWorkerJSContext, new importScriptsCallback(), "importScripts");
        globalObject.set(this.mWorkerJSContext, "importScripts", jSFunction);
        jSFunction.delete();
        JSFunction jSFunction2 = new JSFunction(this.mWorkerJSContext, new onMessageCallback(), "onMessage");
        globalObject.set(this.mWorkerJSContext, "onMessage", jSFunction2);
        jSFunction2.delete();
        JSFunction jSFunction3 = new JSFunction(this.mWorkerJSContext, new postMessageCallback(), NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
        globalObject.set(this.mWorkerJSContext, NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, jSFunction3);
        jSFunction3.delete();
        globalObject.delete();
        doExecuteScript(V8Utils.readRawFile(applicationContext, R.raw.workerjs_worker), "https://appx/v8.multiworker.js");
        RVLogger.d(TAG, "Starting JS Worker...");
        doExecuteScript(str3, str2);
        RVLogger.d(TAG, "JS Worker ready.");
    }

    private void doExecuteScript(String str, String str2) {
        if (isReleased() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSValue executeJS = this.mWorkerJSContext.executeJS(str, str2);
            if (this.mWorkerJSContext.hasException()) {
                String jSException = this.mWorkerJSContext.getException().toString(this.mWorkerJSContext);
                StringBuilder sb = new StringBuilder();
                sb.append("doExecuteScript: ");
                sb.append(str2);
                sb.append(" error: ");
                sb.append(jSException);
                RVLogger.e(TAG, sb.toString());
            }
            if (executeJS != null) {
                executeJS.delete();
            }
        } catch (Throwable th) {
            String makeLogMsg = V8Utils.makeLogMsg(th);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Caught exception when executeScript ");
            sb2.append(str2);
            sb2.append("\n");
            sb2.append(makeLogMsg);
            RVLogger.e(TAG, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void terminate() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.MultiThreadWorker.2
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0099, code lost:
            
                if (android.os.Build.VERSION.SDK_INT >= 18) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
            
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
                    java.lang.String r0 = "MultiThreadWorker"
                    com.alibaba.ariver.v8worker.MultiThreadWorker r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.this
                    boolean r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$100(r1)
                    if (r1 == 0) goto Lb
                    return
                Lb:
                    r1 = 18
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSObject r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$200(r2)     // Catch: java.lang.Throwable -> L9c
                    r3 = 0
                    if (r2 == 0) goto L24
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSObject r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$200(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.delete()     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker.access$202(r2, r3)     // Catch: java.lang.Throwable -> L9c
                L24:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSFunction r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$300(r2)     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L3a
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSFunction r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$300(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.delete()     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker.access$302(r2, r3)     // Catch: java.lang.Throwable -> L9c
                L3a:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSFunction r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$400(r2)     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L50
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.JSFunction r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$400(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.delete()     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker.access$402(r2, r3)     // Catch: java.lang.Throwable -> L9c
                L50:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.JSContext r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$500(r2)     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L61
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.JSContext r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$500(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.dispose()     // Catch: java.lang.Throwable -> L9c
                L61:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.EngineScope r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$600(r2)     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L72
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.js.EngineScope r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$600(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.exit()     // Catch: java.lang.Throwable -> L9c
                L72:
                    boolean r2 = com.alibaba.ariver.kernel.common.utils.RVKernelUtils.isDebug()     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L86
                    java.lang.String r2 = "\n******** WARNING ********, These JS Objects will be leaked:\n"
                    com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r2)     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.JSEngine r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$700(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.printObjects()     // Catch: java.lang.Throwable -> L9c
                L86:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.JSEngine r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$700(r2)     // Catch: java.lang.Throwable -> L9c
                    if (r2 == 0) goto L97
                    com.alibaba.ariver.v8worker.MultiThreadWorker r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.this     // Catch: java.lang.Throwable -> L9c
                    com.alibaba.jsi.standard.JSEngine r2 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$700(r2)     // Catch: java.lang.Throwable -> L9c
                    r2.dispose()     // Catch: java.lang.Throwable -> L9c
                L97:
                    int r0 = android.os.Build.VERSION.SDK_INT
                    if (r0 < r1) goto Lb0
                    goto La6
                L9c:
                    r2 = move-exception
                    java.lang.String r3 = "Caught exception when release v8 vm"
                    com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r3, r2)     // Catch: java.lang.Throwable -> Lba
                    int r0 = android.os.Build.VERSION.SDK_INT
                    if (r0 < r1) goto Lb0
                La6:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r0 = com.alibaba.ariver.v8worker.MultiThreadWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$800(r0)
                    r0.quitSafely()
                    return
                Lb0:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r0 = com.alibaba.ariver.v8worker.MultiThreadWorker.this
                    android.os.HandlerThread r0 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$800(r0)
                    r0.quit()
                    return
                Lba:
                    r0 = move-exception
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r1) goto Lc9
                    com.alibaba.ariver.v8worker.MultiThreadWorker r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.this
                    android.os.HandlerThread r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$800(r1)
                    r1.quitSafely()
                    goto Ld2
                Lc9:
                    com.alibaba.ariver.v8worker.MultiThreadWorker r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.this
                    android.os.HandlerThread r1 = com.alibaba.ariver.v8worker.MultiThreadWorker.access$800(r1)
                    r1.quit()
                Ld2:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.v8worker.MultiThreadWorker.AnonymousClass2.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReleased() {
        JSContext jSContext = this.mWorkerJSContext;
        return jSContext == null || jSContext.isDisposed() || this.mWorkerJSEngine == null;
    }

    public void setOutMessageCallback(JSFunction jSFunction) {
        JSFunction jSFunction2 = this.mOutMessageFunction;
        if (jSFunction2 != null) {
            jSFunction2.delete();
        }
        this.mOutMessageFunction = jSFunction;
    }

    public void setInMessageCallback(JSFunction jSFunction) {
        JSFunction jSFunction2 = this.mInMessageFunction;
        if (jSFunction2 != null) {
            jSFunction2.delete();
        }
        this.mInMessageFunction = jSFunction;
    }

    public void postMessageToMain(JSObject jSObject) {
        doPostMessage(jSObject, this.mV8Worker.getHandler(), false);
    }

    public void postMessageToWorker(JSObject jSObject) {
        doPostMessage(jSObject, this.mHandler, true);
    }

    private void doPostMessage(JSObject jSObject, Handler handler, final boolean z) {
        final JSValueBlob serialize = jSObject.serialize();
        jSObject.delete();
        if (serialize == null) {
            RVLogger.e(TAG, "failed to serialize js object...");
        } else {
            handler.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.MultiThreadWorker.3
                @Override // java.lang.Runnable
                public void run() {
                    JSContext appxJSContext = z ? MultiThreadWorker.this.mWorkerJSContext : MultiThreadWorker.this.mV8Worker.getAppxJSContext();
                    JSFunction jSFunction = z ? MultiThreadWorker.this.mInMessageFunction : MultiThreadWorker.this.mOutMessageFunction;
                    if (appxJSContext == null || appxJSContext.isDisposed() || jSFunction == null || jSFunction.isVoid()) {
                        serialize.delete();
                        return;
                    }
                    JSValue[] jSValueArr = {serialize.deserialize(appxJSContext)};
                    serialize.delete();
                    try {
                        jSFunction.call(appxJSContext, null, jSValueArr);
                    } catch (Throwable th) {
                        try {
                            String makeLogMsg = V8Utils.makeLogMsg(th);
                            StringBuilder sb = new StringBuilder();
                            sb.append("doPostMessage ");
                            sb.append(makeLogMsg);
                            RVLogger.e(MultiThreadWorker.TAG, sb.toString());
                            if (jSValueArr[0] == null) {
                                return;
                            }
                            JSValue jSValue = jSValueArr[0];
                        } finally {
                            JSValue jSValue2 = jSValueArr[0];
                            if (jSValue2 != null) {
                                jSValue2.delete();
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class importScriptsCallback extends JSCallback {
        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            return null;
        }

        importScriptsCallback() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class onMessageCallback extends JSCallback {
        onMessageCallback() {
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            try {
                MultiThreadWorker.this.setInMessageCallback((JSFunction) arguments.get(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(MultiThreadWorker.TAG, "failed to set onmessage in Worker", th);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class postMessageCallback extends JSCallback {
        postMessageCallback() {
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            try {
                MultiThreadWorker.this.postMessageToMain((JSObject) arguments.get(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(MultiThreadWorker.TAG, "failed to postMessage in Worker", th);
                return null;
            }
        }
    }
}
