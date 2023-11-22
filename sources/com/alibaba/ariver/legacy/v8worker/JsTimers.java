package com.alibaba.ariver.legacy.v8worker;

import android.os.Handler;
import com.alibaba.ariver.v8worker.Timer;
import com.alipay.mobile.jsengine.v8.JavaCallback;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class JsTimers {
    private Handler mJsHandler;
    private int mNextId = 0;
    private boolean mPaused = false;
    private ArrayList<JsTimerTask> mTasks = new ArrayList<>();
    private Timer mTimer = new Timer();

    public Handler getHandler() {
        return this.mJsHandler;
    }

    public int allocId() {
        int size = this.mTasks.size();
        if (size > 100) {
            for (int i = this.mNextId; i < size; i++) {
                if (this.mTasks.get(i) == null) {
                    int i2 = this.mNextId + 1;
                    this.mNextId = i2;
                    if (i2 >= size) {
                        this.mNextId = 0;
                    }
                    return i;
                }
            }
            return size;
        }
        return size;
    }

    public void freeId(int i) {
        this.mTasks.set(i, null);
    }

    public JsTimers(V8 v8, Handler handler) {
        this.mJsHandler = handler;
        v8.registerJavaMethod(new JavaCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JsTimers.1
            @Override // com.alipay.mobile.jsengine.v8.JavaCallback
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                V8Function v8Function = (V8Function) v8Array.get(0);
                int intValue = ((Integer) v8Array.get(1)).intValue();
                boolean booleanValue = ((Boolean) v8Array.get(2)).booleanValue();
                int allocId = JsTimers.this.allocId();
                JsTimerTask jsTimerTask = new JsTimerTask(JsTimers.this, v8Function, allocId, booleanValue);
                if (allocId < JsTimers.this.mTasks.size()) {
                    JsTimers.this.mTasks.set(allocId, jsTimerTask);
                } else {
                    JsTimers.this.mTasks.add(jsTimerTask);
                }
                if (booleanValue) {
                    long j = intValue;
                    JsTimers.this.mTimer.schedule(jsTimerTask, j, j);
                } else {
                    JsTimers.this.mTimer.schedule(jsTimerTask, intValue);
                }
                return Integer.valueOf(allocId + 1);
            }
        }, "__nativeCreateTimer__");
        v8.registerJavaMethod(new JavaVoidCallback() { // from class: com.alibaba.ariver.legacy.v8worker.JsTimers.2
            @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
            public void invoke(V8Object v8Object, V8Array v8Array) {
                JsTimerTask jsTimerTask;
                int intValue = ((Integer) v8Array.get(0)).intValue() - 1;
                if (intValue < 0 || intValue >= JsTimers.this.mTasks.size() || (jsTimerTask = (JsTimerTask) JsTimers.this.mTasks.get(intValue)) == null) {
                    return;
                }
                JsTimers.this.freeId(intValue);
                jsTimerTask.cancel();
            }
        }, "__nativeDeleteTimer__");
    }

    public void pause() {
        if (this.mPaused) {
            return;
        }
        this.mPaused = true;
        this.mTimer.pause();
    }

    public void resume() {
        if (this.mPaused) {
            this.mPaused = false;
            this.mTimer.resume();
        }
    }

    public void terminate() {
        this.mTimer.cancel();
        this.mTimer.purge();
        for (int i = 0; i < this.mTasks.size(); i++) {
            JsTimerTask jsTimerTask = this.mTasks.get(i);
            if (jsTimerTask != null) {
                this.mTasks.set(i, null);
                jsTimerTask.cancel();
            }
        }
    }
}
