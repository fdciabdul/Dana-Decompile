package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.java.JSSupport;
import com.alibaba.jsi.standard.java.JavaSupport;
import com.alibaba.jsi.standard.js.Bridge;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSException;
import com.alibaba.jsi.standard.js.JSObject;
import com.alibaba.jsi.standard.js.JSValue;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class JSContext {
    private static final Map<Long, JSContext> sGlobalContextMap = new HashMap();
    private final long mContextId;
    private final Object[] mDataSlots;
    private Runnable mDeleteUnusedObjectsRunnable;
    private Events mEventListener;
    private final J2JHelper mJ2JHelper;
    private final JSEngine mJSEngine;
    private final JSSupport mJSSupport;
    private final JavaSupport mJavaSupport;
    protected long mNativePtr;
    private String mTitle;
    private final Object mLock = new Object();
    private boolean mDestroyed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSContext(String str, Object obj, JSEngine jSEngine, Class<? extends Annotation> cls) {
        J2JHelper j2JHelper = new J2JHelper(this);
        this.mJ2JHelper = j2JHelper;
        this.mJavaSupport = new JavaSupport(this, j2JHelper);
        this.mJSSupport = new JSSupport(this, j2JHelper);
        this.mDataSlots = new Object[6];
        this.mTitle = str;
        this.mJSEngine = jSEngine;
        long nativeCreateContext = JNIBridge.nativeCreateContext(jSEngine.getNativeInstance(), this.mTitle, null);
        this.mNativePtr = nativeCreateContext;
        long nativeCommand = JNIBridge.nativeCommand(2L, nativeCreateContext, null);
        this.mContextId = nativeCommand;
        Map<Long, JSContext> map = sGlobalContextMap;
        synchronized (map) {
            map.put(Long.valueOf(nativeCommand), this);
        }
        j2JHelper.initialize(obj, cls);
    }

    public void setEventListener(Events events) {
        this.mEventListener = events;
    }

    public Events getEventListener() {
        return this.mEventListener;
    }

    public void dispose() {
        synchronized (this.mLock) {
            if (checkDestroyed()) {
                return;
            }
            resetJ2JExtension();
            JNIBridge.nativeDisposeContext(this.mJSEngine.getNativeInstance(), this.mNativePtr);
            Map<Long, JSContext> map = sGlobalContextMap;
            synchronized (map) {
                map.remove(Long.valueOf(this.mContextId));
            }
            this.mNativePtr = 0L;
            this.mDestroyed = true;
        }
    }

    public boolean isDisposed() {
        return this.mDestroyed;
    }

    public void reset() {
        synchronized (this.mLock) {
            if (checkDestroyed()) {
                return;
            }
            resetJ2JExtension();
            JNIBridge.nativeResetContext(this.mJSEngine.getNativeInstance(), this.mNativePtr);
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getId() {
        return this.mContextId;
    }

    public boolean setGroup(JSContext jSContext) {
        if (checkDestroyed() || jSContext.checkDestroyed()) {
            return false;
        }
        if (getJSEngine() == jSContext.getJSEngine()) {
            return 1 == JNIBridge.nativeCommand(5L, this.mNativePtr, new Object[]{Long.valueOf(jSContext.mNativePtr)});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("main_context belongs to JSEngine '");
        sb.append(jSContext.getJSEngine().getEmbedderName());
        sb.append("', but expect '");
        sb.append(getJSEngine().getEmbedderName());
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    public int getGroupId() {
        return (int) JNIBridge.nativeCommand(6L, this.mNativePtr, null);
    }

    public boolean setOrigin(String str) {
        return !checkDestroyed() && 1 == JNIBridge.nativeCommand(7L, this.mNativePtr, new Object[]{str});
    }

    public String getOrigin() {
        if (checkDestroyed()) {
            return null;
        }
        Object[] objArr = new Object[1];
        if (1 == JNIBridge.nativeCommand(8L, this.mNativePtr, objArr)) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public JSValue executeJS(String str, String str2) {
        synchronized (this.mLock) {
            if (checkDestroyed()) {
                return null;
            }
            Object nativeExecuteJS = JNIBridge.nativeExecuteJS(this.mJSEngine.getNativeInstance(), this.mNativePtr, str, str2);
            JSValue jSValue = nativeExecuteJS != null ? (JSValue) nativeExecuteJS : null;
            this.mJSEngine.requestLoopAsync(0L);
            return jSValue;
        }
    }

    public JSEngine getJSEngine() {
        return this.mJSEngine;
    }

    public JSObject globalObject() {
        if (checkDestroyed()) {
            return null;
        }
        Object cmd = Bridge.cmd(this, 10);
        if (cmd instanceof JSObject) {
            return (JSObject) cmd;
        }
        return null;
    }

    public JSValue getGlobal(JSValue jSValue) {
        JSObject globalObject = globalObject();
        if (globalObject == null) {
            return null;
        }
        JSValue jSValue2 = globalObject.get(this, jSValue);
        globalObject.delete();
        return jSValue2;
    }

    public JSValue getGlobal(String str) {
        JSObject globalObject = globalObject();
        if (globalObject == null) {
            return null;
        }
        JSValue jSValue = globalObject.get(this, str);
        globalObject.delete();
        return jSValue;
    }

    public boolean hasException() {
        return (checkDestroyed() || Bridge.cmd(this, 11) == null) ? false : true;
    }

    public JSException getException() {
        if (checkDestroyed()) {
            return null;
        }
        Object cmd = Bridge.cmd(this, 12);
        if (cmd instanceof JSException) {
            return (JSException) cmd;
        }
        return null;
    }

    public void throwException(JSException jSException) {
        if (checkDestroyed()) {
            return;
        }
        Bridge.cmd(this, 13, new Object[]{jSException});
    }

    public JavaSupport getJavaSupport() {
        return this.mJavaSupport;
    }

    public JSSupport getJSSupport() {
        return this.mJSSupport;
    }

    public boolean setData(int i, Object obj) {
        Object[] objArr = this.mDataSlots;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = obj;
        return true;
    }

    public Object getData(int i) {
        Object[] objArr = this.mDataSlots;
        if (i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public int getDataSlotsCount() {
        return this.mDataSlots.length;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public static JSContext getContext(long j) {
        JSContext jSContext;
        Map<Long, JSContext> map = sGlobalContextMap;
        synchronized (map) {
            jSContext = map.get(Long.valueOf(j));
        }
        return jSContext;
    }

    protected boolean checkDestroyed() {
        if (isDisposed()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Context has been destroyed! Id: ");
            sb.append(this.mContextId);
            OSUtil.e(sb.toString());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReload() {
        Events events = this.mEventListener;
        if (events != null) {
            events.onReload(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onUncaughtJSException(JSException jSException, int i) {
        Events events = this.mEventListener;
        if (events != null) {
            return events.onUncaughtJSException(this, jSException, i);
        }
        if (jSException != null) {
            jSException.delete();
            return false;
        }
        return false;
    }

    private void resetJ2JExtension() {
        EngineScope engineScope = new EngineScope(this.mJSEngine);
        try {
            this.mJSSupport.reset();
            this.mJ2JHelper.reset();
        } finally {
            engineScope.exit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public J2JHelper getJ2JHelper() {
        return this.mJ2JHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeleteUnusedObjectsRunnable(Runnable runnable) {
        this.mDeleteUnusedObjectsRunnable = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runnable getDeleteUnusedObjectsRunnable() {
        return this.mDeleteUnusedObjectsRunnable;
    }
}
