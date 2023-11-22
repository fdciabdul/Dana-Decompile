package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.v8worker.TimerTask;
import com.alibaba.ariver.v8worker.extension.V8JSErrorPoint;
import com.alipay.mobile.jsengine.v8.V8Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class JsTimerTask extends TimerTask {
    private V8Function mFunction;
    private int mId;
    private JsTimers mJsTimers;
    private boolean mRepeat;

    public JsTimerTask(JsTimers jsTimers, V8Function v8Function, int i, boolean z) {
        this.mJsTimers = jsTimers;
        this.mFunction = v8Function;
        this.mId = i;
        this.mRepeat = z;
    }

    @Override // com.alibaba.ariver.v8worker.TimerTask, java.lang.Runnable
    public void run() {
        this.mJsTimers.getHandler().post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.JsTimerTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (!JsTimerTask.this.mRepeat) {
                    JsTimerTask.this.mJsTimers.freeId(JsTimerTask.this.mId);
                }
                if (JsTimerTask.this.mFunction != null) {
                    try {
                        JsTimerTask.this.mFunction.call(null, null);
                    } catch (Throwable th) {
                        ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).create()).onException(th.getMessage());
                    }
                }
                if (JsTimerTask.this.mRepeat) {
                    return;
                }
                JsTimerTask.this.cancel();
            }
        });
    }

    @Override // com.alibaba.ariver.v8worker.TimerTask
    public boolean cancel() {
        V8Function v8Function = this.mFunction;
        if (v8Function != null) {
            v8Function.release();
            this.mFunction = null;
        }
        return super.cancel();
    }
}
