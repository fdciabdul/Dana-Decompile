package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.core.embedview.NXEmbedWebView;
import com.alipay.mobile.jsengine.v8.JavaCallback;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class WorkerJsapiCallback implements JavaCallback {
    static final String TAG = "WorkerJsapiCallback";
    private V8Worker mV8Worker;
    private int mWorkerIndex = 1;
    private Map<Integer, JSWorker> mWorkerMap = new HashMap();

    static int getMaxWorkerNum() {
        return 1;
    }

    public WorkerJsapiCallback(V8Worker v8Worker) {
        this.mV8Worker = v8Worker;
    }

    void terminateJsWorker(int i, JSWorker jSWorker) {
        this.mWorkerMap.remove(Integer.valueOf(i));
        jSWorker.terminate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        Iterator<Map.Entry<Integer, JSWorker>> it = this.mWorkerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().terminate();
        }
        this.mWorkerMap.clear();
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaCallback
    public Object invoke(V8Object v8Object, V8Array v8Array) {
        if (this.mV8Worker.isDestroyed()) {
            return null;
        }
        if (this.mWorkerMap.size() >= getMaxWorkerNum()) {
            RVLogger.e(TAG, "The number of worker exceeds system limit");
            return V8.getUndefined();
        }
        try {
            V8Object v8Object2 = (V8Object) v8Array.get(0);
            String string = v8Object2.getString("scriptPath");
            v8Object2.release();
            String replace = this.mV8Worker.getWorkerId().replace("index.worker.js", string);
            String loadResource = this.mV8Worker.loadResource(replace);
            StringBuilder sb = new StringBuilder();
            sb.append("create JS Worker: ");
            sb.append(string);
            sb.append(", ");
            sb.append(loadResource.length());
            sb.append(" bytes");
            RVLogger.d(TAG, sb.toString());
            int i = this.mWorkerIndex;
            this.mWorkerIndex = i + 1;
            V8Object v8Object3 = new V8Object(this.mV8Worker.getV8Runtime());
            V8Worker v8Worker = this.mV8Worker;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JSWorker_");
            sb2.append(i);
            JSWorker jSWorker = new JSWorker(v8Worker, sb2.toString(), v8Object3, replace, loadResource);
            v8Object3.registerJavaMethod(new onMessageCallback(jSWorker), "onMessage");
            v8Object3.registerJavaMethod(new postMessageCallback(jSWorker), NXEmbedWebView.POST_MESSAGE_ACTION_TYPE);
            v8Object3.registerJavaMethod(new terminateCallback(i, jSWorker), "terminate");
            try {
                hideWorkerProperty(v8Object3);
            } catch (Throwable th) {
                RVLogger.e(TAG, "failed to hideWorkerProperty for JSWorker: ", th);
            }
            this.mWorkerMap.put(Integer.valueOf(i), jSWorker);
            return v8Object3;
        } catch (Throwable th2) {
            RVLogger.e(TAG, "failed to create JS Worker", th2);
            return V8.getUndefined();
        }
    }

    private void hideWorkerProperty(V8Object v8Object) {
        V8 v8Runtime = this.mV8Worker.getV8Runtime();
        if (v8Runtime == null || v8Runtime.isReleased() || v8Object == null) {
            return;
        }
        V8Object object = v8Runtime.getObject("Object");
        V8Function v8Function = (V8Function) object.getObject("defineProperty");
        V8Object v8Object2 = new V8Object(v8Runtime);
        v8Object2.add("writable", false);
        v8Object2.add("configurable", false);
        v8Object2.add("enumerable", false);
        String[] strArr = {"onMessage", NXEmbedWebView.POST_MESSAGE_ACTION_TYPE, "terminate"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            V8Array v8Array = new V8Array(v8Runtime);
            v8Array.push((V8Value) v8Object);
            v8Array.push(str);
            v8Array.push((V8Value) v8Object2);
            try {
                Object call = v8Function.call(object, v8Array);
                if (call instanceof Releasable) {
                    ((Releasable) call).release();
                }
            } finally {
                try {
                    v8Array.release();
                } catch (Throwable th) {
                }
            }
            v8Array.release();
        }
        object.release();
        v8Function.release();
        v8Object2.release();
    }

    /* loaded from: classes6.dex */
    class onMessageCallback implements JavaVoidCallback {
        private JSWorker mWorker;

        public onMessageCallback(JSWorker jSWorker) {
            this.mWorker = jSWorker;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                this.mWorker.setOutMessageCallback((V8Function) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(WorkerJsapiCallback.TAG, "failed to set onmessage of JS Worker", th);
            }
        }
    }

    /* loaded from: classes6.dex */
    class postMessageCallback implements JavaVoidCallback {
        private JSWorker mWorker;

        public postMessageCallback(JSWorker jSWorker) {
            this.mWorker = jSWorker;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                this.mWorker.postMessageToWorker((V8Object) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(WorkerJsapiCallback.TAG, "failed to postMessage to JS Worker", th);
            }
        }
    }

    /* loaded from: classes6.dex */
    class terminateCallback implements JavaVoidCallback {
        private int mId;
        private JSWorker mWorker;

        public terminateCallback(int i, JSWorker jSWorker) {
            this.mId = i;
            this.mWorker = jSWorker;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                WorkerJsapiCallback.this.terminateJsWorker(this.mId, this.mWorker);
            } catch (Throwable th) {
                RVLogger.e(WorkerJsapiCallback.TAG, "failed to terminate JS Worker", th);
            }
        }
    }
}
