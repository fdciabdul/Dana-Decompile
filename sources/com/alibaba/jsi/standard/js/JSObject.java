package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.JSEngine;

/* loaded from: classes6.dex */
public class JSObject extends JSValue {
    public static final long kAllProperties = 0;
    public static final long kOnlyConfigurable = 4;
    public static final long kOnlyEnumerable = 2;
    public static final long kOnlyWritable = 1;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSObject asJSObject() {
        return this;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isJSObject() {
        return true;
    }

    public JSObject(JSContext jSContext) {
        super(jSContext, Bridge.createNative(jSContext, 7));
        checkContext(jSContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSObject(JSContext jSContext, long j) {
        super(jSContext, j);
        checkContext(jSContext);
    }

    public boolean set(JSContext jSContext, JSValue jSValue, JSValue jSValue2) {
        checkDeleted();
        return Bridge.cmd(jSContext, 100, this.mNativePtr, new Object[]{jSValue, jSValue2}) != null;
    }

    public boolean set(JSContext jSContext, int i, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 101, this.mNativePtr, (long) i, new Object[]{jSValue}) != null;
    }

    public boolean set(JSContext jSContext, String str, JSValue jSValue) {
        return set(jSContext, new JSString(str), jSValue);
    }

    public JSValue get(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 102, this.mNativePtr, new Object[]{jSValue});
        if (cmd != null) {
            return (JSValue) cmd;
        }
        return null;
    }

    public JSValue get(JSContext jSContext, int i) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 103, this.mNativePtr, i);
        if (cmd != null) {
            return (JSValue) cmd;
        }
        return null;
    }

    public JSValue get(JSContext jSContext, String str) {
        return get(jSContext, new JSString(str));
    }

    public boolean remove(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 104, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public boolean remove(JSContext jSContext, int i) {
        checkDeleted();
        return Bridge.cmd(jSContext, 105, this.mNativePtr, (long) i) != null;
    }

    public boolean remove(JSContext jSContext, String str) {
        return remove(jSContext, new JSString(str));
    }

    public boolean has(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 106, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public boolean has(JSContext jSContext, int i) {
        checkDeleted();
        return Bridge.cmd(jSContext, 107, this.mNativePtr, (long) i) != null;
    }

    public boolean has(JSContext jSContext, String str) {
        return has(jSContext, new JSString(str));
    }

    public boolean hasOwnProperty(JSContext jSContext, JSName jSName) {
        checkDeleted();
        return Bridge.cmd(jSContext, 108, this.mNativePtr, new Object[]{jSName}) != null;
    }

    public boolean hasOwnProperty(JSContext jSContext, int i) {
        checkDeleted();
        return Bridge.cmd(jSContext, 109, this.mNativePtr, (long) i) != null;
    }

    public boolean hasOwnProperty(JSContext jSContext, String str) {
        return hasOwnProperty(jSContext, new JSString(str));
    }

    public JSArray getPropertyNames(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 110, this.mNativePtr);
        if (cmd != null) {
            return (JSArray) cmd;
        }
        return null;
    }

    public JSArray getPropertyNames(JSContext jSContext, long j) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 123, this.mNativePtr, j);
        if (cmd != null) {
            return (JSArray) cmd;
        }
        return null;
    }

    public JSArray getOwnPropertyNames(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 111, this.mNativePtr);
        if (cmd != null) {
            return (JSArray) cmd;
        }
        return null;
    }

    public JSArray getOwnPropertyNames(JSContext jSContext, long j) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 124, this.mNativePtr, j);
        if (cmd != null) {
            return (JSArray) cmd;
        }
        return null;
    }

    public boolean setPrivate(JSContext jSContext, String str, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 112, this.mNativePtr, new Object[]{str, jSValue}) != null;
    }

    public JSValue getPrivate(JSContext jSContext, String str) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 113, this.mNativePtr, new Object[]{str});
        if (cmd != null) {
            return (JSValue) cmd;
        }
        return null;
    }

    public boolean removePrivate(JSContext jSContext, String str) {
        checkDeleted();
        return Bridge.cmd(jSContext, 114, this.mNativePtr, new Object[]{str}) != null;
    }

    public boolean hasPrivate(JSContext jSContext, String str) {
        checkDeleted();
        return Bridge.cmd(jSContext, 115, this.mNativePtr, new Object[]{str}) != null;
    }

    public JSValue getPrototype(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 116, this.mNativePtr);
        if (cmd != null) {
            return (JSValue) cmd;
        }
        return null;
    }

    public boolean setPrototype(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 117, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public JSEngine getJSEngine() {
        checkDeleted();
        Object cmd = Bridge.cmd((JSContext) null, 118, this.mNativePtr);
        if (cmd instanceof Long) {
            return JSEngine.getInstance(((Long) cmd).longValue());
        }
        return null;
    }

    public JSCallback getJSCallback(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 119, this.mNativePtr);
        if (cmd instanceof JSCallback) {
            return (JSCallback) cmd;
        }
        return null;
    }

    public boolean detachJSCallback(JSContext jSContext) {
        checkDeleted();
        return Bridge.cmd(jSContext, 122, this.mNativePtr) != null;
    }

    public int getPropertyAttributes(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 120, this.mNativePtr, new Object[]{jSValue});
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 0;
    }

    public boolean setIntegrityLevel(JSContext jSContext, int i) {
        checkDeleted();
        return Bridge.cmd(jSContext, 121, this.mNativePtr, (long) i) != null;
    }

    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSWeakValue createWeak(JSContext jSContext) {
        return createWeakNative(jSContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.jsi.standard.js.JSValue
    public JSValue lockWeak(JSContext jSContext) {
        return lockWeakNative(jSContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean weakExpired(JSContext jSContext) {
        return weakExpiredNative(jSContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkContext(JSContext jSContext) {
        if (jSContext.isDisposed()) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSContext '");
            sb.append(jSContext.getTitle());
            sb.append("'has been disposed!");
            throw new RuntimeException(sb.toString());
        }
    }
}
