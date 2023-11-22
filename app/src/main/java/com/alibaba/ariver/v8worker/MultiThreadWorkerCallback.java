package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSString;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSVoid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class MultiThreadWorkerCallback extends JSCallback {
    static final String TAG = "MultiThreadWorkerCallback";
    private V8Worker mV8Worker;
    private int mWorkerIndex = 1;
    private Map<Integer, MultiThreadWorker> mWorkerMap = new HashMap();

    public MultiThreadWorkerCallback(V8Worker v8Worker) {
        this.mV8Worker = v8Worker;
    }

    static int getMaxWorkerNum() {
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        int allowCreatedWorkerMaxCount = v8Proxy != null ? v8Proxy.getAllowCreatedWorkerMaxCount() : 1;
        if (allowCreatedWorkerMaxCount > 0) {
            return allowCreatedWorkerMaxCount;
        }
        return 1;
    }

    void terminateJsWorker(int i, MultiThreadWorker multiThreadWorker) {
        this.mWorkerMap.remove(Integer.valueOf(i));
        multiThreadWorker.terminate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        Iterator<Map.Entry<Integer, MultiThreadWorker>> it = this.mWorkerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().terminate();
        }
        this.mWorkerMap.clear();
    }

    @Override // com.alibaba.jsi.standard.js.JSCallback
    public JSValue onCallFunction(Arguments arguments) {
        try {
            if (this.mV8Worker.isDestroyed()) {
                return null;
            }
            if (this.mWorkerMap.size() >= getMaxWorkerNum()) {
                RVLogger.e(TAG, "The number of worker exceeds system limit");
                return null;
            }
            JSObject jSObject = (JSObject) arguments.get(0);
            String jSValue = jSObject.get(arguments.getContext(), "scriptPath").toString(arguments.getContext());
            jSObject.delete();
            String replace = this.mV8Worker.getWorkerId().replace("index.worker.js", jSValue);
            String loadResource = this.mV8Worker.loadResource(replace);
            StringBuilder sb = new StringBuilder();
            sb.append("create JS Worker: ");
            sb.append(jSValue);
            sb.append(", ");
            sb.append(loadResource.length());
            sb.append(" bytes");
            RVLogger.d(TAG, sb.toString());
            int i = this.mWorkerIndex;
            this.mWorkerIndex = i + 1;
            JSContext appxJSContext = this.mV8Worker.getAppxJSContext();
            if (appxJSContext != null && !appxJSContext.isDisposed()) {
                JSObject jSObject2 = new JSObject(appxJSContext);
                V8Worker v8Worker = this.mV8Worker;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MultiThreadWorker-");
                sb2.append(i);
                MultiThreadWorker multiThreadWorker = new MultiThreadWorker(v8Worker, sb2.toString(), jSObject2, replace, loadResource);
                JSFunction jSFunction = new JSFunction(appxJSContext, new onMessageCallback(multiThreadWorker), "onMessage");
                jSObject2.set(appxJSContext, "onMessage", jSFunction);
                jSFunction.delete();
                JSFunction jSFunction2 = new JSFunction(appxJSContext, new postMessageCallback(multiThreadWorker), NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
                jSObject2.set(appxJSContext, NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, jSFunction2);
                jSFunction2.delete();
                JSFunction jSFunction3 = new JSFunction(appxJSContext, new terminateCallback(i, multiThreadWorker), "terminate");
                jSObject2.set(appxJSContext, "terminate", jSFunction3);
                jSFunction3.delete();
                try {
                    hideWorkerProperty(jSObject2);
                } catch (Throwable th) {
                    RVLogger.e(TAG, "failed to hideWorkerProperty for JSWorker: ", th);
                }
                this.mWorkerMap.put(Integer.valueOf(i), multiThreadWorker);
                return jSObject2;
            }
            return new JSVoid(true);
        } catch (Throwable th2) {
            RVLogger.e(TAG, "failed to create JS Worker", th2);
            return new JSVoid(true);
        }
    }

    private void hideWorkerProperty(JSObject jSObject) {
        JSValue jSValue;
        JSContext appxJSContext = this.mV8Worker.getAppxJSContext();
        if (appxJSContext == null || appxJSContext.isDisposed() || jSObject == null) {
            return;
        }
        JSObject globalObject = appxJSContext.globalObject();
        JSObject jSObject2 = (JSObject) globalObject.get(appxJSContext, "Object");
        JSFunction jSFunction = (JSFunction) jSObject2.get(appxJSContext, "defineProperty");
        JSObject jSObject3 = new JSObject(appxJSContext);
        jSObject3.set(appxJSContext, "writable", new JSBoolean(false));
        jSObject3.set(appxJSContext, "configurable", new JSBoolean(false));
        jSObject3.set(appxJSContext, "enumerable", new JSBoolean(false));
        String[] strArr = {"onMessage", NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, "terminate"};
        for (int i = 0; i < 3; i++) {
            JSValue[] jSValueArr = {jSObject, new JSString(strArr[i]), jSObject3};
            try {
                JSValue call = jSFunction.call(appxJSContext, jSObject2, jSValueArr);
                if (call != null) {
                    call.delete();
                }
                jSValue = jSValueArr[1];
            } finally {
                try {
                    jSValue.delete();
                } catch (Throwable th) {
                }
            }
            jSValue.delete();
        }
        globalObject.delete();
        jSObject2.delete();
        jSFunction.delete();
        jSObject3.delete();
    }

    /* loaded from: classes6.dex */
    class onMessageCallback extends JSCallback {
        private MultiThreadWorker mMultiThreadWorker;

        public onMessageCallback(MultiThreadWorker multiThreadWorker) {
            this.mMultiThreadWorker = multiThreadWorker;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            try {
                this.mMultiThreadWorker.setOutMessageCallback((JSFunction) arguments.get(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(MultiThreadWorkerCallback.TAG, "failed to set onmessage of JS Worker", th);
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    class postMessageCallback extends JSCallback {
        private MultiThreadWorker mMultiThreadWorker;

        public postMessageCallback(MultiThreadWorker multiThreadWorker) {
            this.mMultiThreadWorker = multiThreadWorker;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            try {
                this.mMultiThreadWorker.postMessageToWorker((JSObject) arguments.get(0));
                return null;
            } catch (Throwable th) {
                RVLogger.e(MultiThreadWorkerCallback.TAG, "failed to postMessage to JS Worker", th);
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    class terminateCallback extends JSCallback {
        private int mId;
        private MultiThreadWorker mMultiThreadWorker;

        public terminateCallback(int i, MultiThreadWorker multiThreadWorker) {
            this.mId = i;
            this.mMultiThreadWorker = multiThreadWorker;
        }

        @Override // com.alibaba.jsi.standard.js.JSCallback
        public JSValue onCallFunction(Arguments arguments) {
            try {
                MultiThreadWorkerCallback.this.terminateJsWorker(this.mId, this.mMultiThreadWorker);
                return null;
            } catch (Throwable th) {
                RVLogger.e(MultiThreadWorkerCallback.TAG, "failed to terminate JS Worker", th);
                return null;
            }
        }
    }
}
