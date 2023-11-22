package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSValue;

/* loaded from: classes6.dex */
public class AsyncJSCallback extends JSCallback {
    private static final String TAG = "AsyncJSCallback";
    private V8Worker mWorker;

    public AsyncJSCallback(V8Worker v8Worker) {
        this.mWorker = v8Worker;
    }

    @Override // com.alibaba.jsi.standard.js.JSCallback
    public JSValue onCallFunction(Arguments arguments) {
        try {
            this.mWorker.waitIfAppPaused();
        } catch (Throwable th) {
            RVLogger.e(TAG, "onCallFunction error: ", th);
        }
        if (this.mWorker.isReleased() || this.mWorker.postMessageByMessageChannel(arguments)) {
            return null;
        }
        JSONObject fromJsApiArgs = V8Utils.fromJsApiArgs(arguments);
        if (this.mWorker.getJsApiHandler() != null) {
            this.mWorker.getJsApiHandler().handleAsyncJsapiRequest(fromJsApiArgs);
        }
        return null;
    }
}
