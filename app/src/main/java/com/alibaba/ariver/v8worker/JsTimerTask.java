package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class JsTimerTask extends TimerTask {
    private final String TAG = "JsTimerTask";
    private volatile boolean mBusy = false;
    private JSFunction mFunction;
    private int mId;
    private JSContext mJsContext;
    private JsTimers mJsTimers;
    private boolean mRepeat;

    public JsTimerTask(JsTimers jsTimers, JSContext jSContext, JSFunction jSFunction, int i, boolean z) {
        this.mJsTimers = jsTimers;
        this.mJsContext = jSContext;
        this.mFunction = jSFunction;
        this.mId = i;
        this.mRepeat = z;
    }

    @Override // com.alibaba.ariver.v8worker.TimerTask, java.lang.Runnable
    public void run() {
        if (this.mRepeat && (this.mBusy || this.mJsTimers.mPaused)) {
            return;
        }
        try {
            JSContext jSContext = this.mJsContext;
            if (jSContext == null || jSContext.isDisposed()) {
                return;
            }
            this.mJsTimers.getHandler().post(new Runnable() { // from class: com.alibaba.ariver.v8worker.JsTimerTask.1
                @Override // java.lang.Runnable
                public void run() {
                    if (JsTimerTask.this.mJsTimers == null || JsTimerTask.this.mFunction == null || JsTimerTask.this.mJsContext == null || JsTimerTask.this.mJsContext.isDisposed()) {
                        return;
                    }
                    if (!JsTimerTask.this.mRepeat) {
                        JsTimerTask.this.mJsTimers.freeId(JsTimerTask.this.mId);
                    } else {
                        JsTimerTask.this.mBusy = true;
                    }
                    JSValue call = JsTimerTask.this.mFunction.call(JsTimerTask.this.mJsContext, null, null);
                    if (call != null) {
                        call.delete();
                    }
                    if (JsTimerTask.this.mRepeat) {
                        JsTimerTask.this.mBusy = false;
                    } else {
                        JsTimerTask.this.cancel();
                    }
                }
            });
        } catch (Throwable th) {
            RVLogger.e("JsTimerTask", "JsTimerTask.run error", th);
        }
    }

    @Override // com.alibaba.ariver.v8worker.TimerTask
    public boolean cancel() {
        JSFunction jSFunction = this.mFunction;
        if (jSFunction != null) {
            jSFunction.delete();
            this.mFunction = null;
        }
        return super.cancel();
    }
}
