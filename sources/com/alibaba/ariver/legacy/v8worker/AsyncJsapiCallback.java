package com.alibaba.ariver.legacy.v8worker;

import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;

/* loaded from: classes6.dex */
public class AsyncJsapiCallback implements JavaVoidCallback {
    private V8Worker mWorker;

    public AsyncJsapiCallback(V8Worker v8Worker) {
        this.mWorker = v8Worker;
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
    public void invoke(V8Object v8Object, V8Array v8Array) {
        if (this.mWorker.tryPostMessageByMessageChannel(v8Array)) {
            return;
        }
        this.mWorker.getJsApiHandler().handleAsyncJsapiRequest(V8Utils.fromV8Object(v8Array.get(2)));
    }
}
