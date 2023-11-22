package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSMap extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isMap() {
        return true;
    }

    public JSMap(JSContext jSContext) {
        super(jSContext, Bridge.createNative(jSContext, 9));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSMap(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public int getSize(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 230, this.mNativePtr);
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 0;
    }

    public void clear(JSContext jSContext) {
        checkDeleted();
        Bridge.cmd(jSContext, 231, this.mNativePtr);
    }

    public JSValue getValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 232, this.mNativePtr, new Object[]{jSValue});
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public boolean setValue(JSContext jSContext, JSValue jSValue, JSValue jSValue2) {
        checkDeleted();
        return Bridge.cmd(jSContext, 233, this.mNativePtr, new Object[]{jSValue, jSValue2}) != null;
    }

    public boolean hasValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 234, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public boolean removeValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 235, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public JSArray asArray(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 236, this.mNativePtr);
        if (cmd instanceof JSArray) {
            return (JSArray) cmd;
        }
        return null;
    }
}
