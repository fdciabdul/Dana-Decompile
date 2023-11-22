package com.alibaba.ariver.v8worker;

import android.os.Handler;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.Arguments;
import com.alibaba.jsi.standard.js.JSBoolean;
import com.alibaba.jsi.standard.js.JSCallback;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSNumber;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSValue;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class JsTimers {
    private static int MAX_ACTIVE_TIMERS = 5000;
    private static int MAX_TIMER_ID = Integer.MAX_VALUE;
    private Handler mJsHandler;
    private String TAG = "V8Worker_JSI_JsTimers";
    private int mNextId = 0;
    volatile boolean mPaused = false;
    private Map<Integer, JsTimerTask> mTasks = new ConcurrentHashMap();
    private Timer mTimer = new Timer();

    public Handler getHandler() {
        return this.mJsHandler;
    }

    public int allocId() {
        int i = 0;
        while (i < 2) {
            int i2 = this.mNextId;
            int i3 = i2 + 1;
            this.mNextId = i3;
            if (i3 >= MAX_TIMER_ID) {
                this.mNextId = 0;
                i++;
            }
            if (!this.mTasks.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public void freeId(int i) {
        this.mTasks.remove(Integer.valueOf(i));
    }

    public JsTimers(final JSContext jSContext, Handler handler, final V8Worker v8Worker) {
        this.mJsHandler = handler;
        if (jSContext == null || jSContext.isDisposed()) {
            return;
        }
        JSObject globalObject = jSContext.globalObject();
        JSFunction jSFunction = new JSFunction(jSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.JsTimers.1
            @Override // com.alibaba.jsi.standard.js.JSCallback
            public JSValue onCallFunction(Arguments arguments) {
                try {
                    JSContext jSContext2 = jSContext;
                    if (jSContext2 != null && !jSContext2.isDisposed()) {
                        if (JsTimers.this.mTasks.size() >= JsTimers.MAX_ACTIVE_TIMERS) {
                            RVLogger.e(JsTimers.this.TAG, "CreateTimer too many active timers.");
                            return new JSNumber(0);
                        }
                        v8Worker.waitIfAppPaused();
                        JSFunction jSFunction2 = (JSFunction) arguments.get(0);
                        JSValue jSValue = arguments.get(1);
                        JSValue jSValue2 = arguments.get(2);
                        int asInteger = ((JSNumber) jSValue).asInteger();
                        boolean valueOf = ((JSBoolean) jSValue2).valueOf();
                        int allocId = JsTimers.this.allocId();
                        if (allocId < 0) {
                            RVLogger.e(JsTimers.this.TAG, "CreateTimer failed to allocate timer Id.");
                            return new JSNumber(0);
                        }
                        JsTimerTask jsTimerTask = new JsTimerTask(JsTimers.this, jSContext, jSFunction2, allocId, valueOf);
                        JsTimers.this.mTasks.put(Integer.valueOf(allocId), jsTimerTask);
                        if (asInteger < 0) {
                            asInteger = 0;
                        }
                        if (valueOf) {
                            long j = asInteger;
                            JsTimers.this.mTimer.schedule(jsTimerTask, j, j);
                        } else {
                            JsTimers.this.mTimer.schedule(jsTimerTask, asInteger);
                        }
                        jSValue.delete();
                        jSValue2.delete();
                        return new JSNumber(allocId + 1);
                    }
                    return new JSNumber(0);
                } catch (Throwable th) {
                    RVLogger.e(JsTimers.this.TAG, "nativeCreateTimer error", th);
                    return new JSNumber(0);
                }
            }
        }, "__nativeCreateTimer__");
        globalObject.set(jSContext, "__nativeCreateTimer__", jSFunction);
        jSFunction.delete();
        JSFunction jSFunction2 = new JSFunction(jSContext, new JSCallback() { // from class: com.alibaba.ariver.v8worker.JsTimers.2
            @Override // com.alibaba.jsi.standard.js.JSCallback
            public JSValue onCallFunction(Arguments arguments) {
                int asInteger;
                JsTimerTask jsTimerTask;
                try {
                    JSValue jSValue = arguments.get(0);
                    asInteger = ((JSNumber) jSValue).asInteger() - 1;
                    jSValue.delete();
                    jsTimerTask = (JsTimerTask) JsTimers.this.mTasks.get(Integer.valueOf(asInteger));
                } catch (Throwable th) {
                    RVLogger.e(JsTimers.this.TAG, "nativeDeleteTimer error", th);
                }
                if (jsTimerTask == null) {
                    return null;
                }
                JsTimers.this.freeId(asInteger);
                jsTimerTask.cancel();
                return null;
            }
        }, "__nativeDeleteTimer__");
        globalObject.set(jSContext, "__nativeDeleteTimer__", jSFunction2);
        jSFunction2.delete();
        globalObject.delete();
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
        Iterator<Map.Entry<Integer, JsTimerTask>> it = this.mTasks.entrySet().iterator();
        while (it.hasNext()) {
            JsTimerTask value = it.next().getValue();
            if (value != null) {
                value.cancel();
            }
        }
        this.mTasks.clear();
    }
}
