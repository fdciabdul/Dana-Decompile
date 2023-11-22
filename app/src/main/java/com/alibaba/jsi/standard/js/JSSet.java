package com.alibaba.jsi.standard.js;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSSet extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isSet() {
        return true;
    }

    public JSSet(JSContext jSContext) {
        super(jSContext, Bridge.createNative(jSContext, 10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSSet(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public int getSize(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) DeepRecoverARiverProxy.TYPE_ENTITY_TA_PAGE, this.mNativePtr);
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 0;
    }

    public void clear(JSContext jSContext) {
        checkDeleted();
        Bridge.cmd(jSContext, (int) DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE, this.mNativePtr);
    }

    public boolean addValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 262, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public boolean hasValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 263, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public boolean removeValue(JSContext jSContext, JSValue jSValue) {
        checkDeleted();
        return Bridge.cmd(jSContext, 264, this.mNativePtr, new Object[]{jSValue}) != null;
    }

    public JSArray asArray(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 265, this.mNativePtr);
        if (cmd instanceof JSArray) {
            return (JSArray) cmd;
        }
        return null;
    }
}
