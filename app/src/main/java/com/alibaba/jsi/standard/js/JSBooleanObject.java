package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSBooleanObject extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isBooleanObject() {
        return true;
    }

    public JSBooleanObject(JSContext jSContext, boolean z) {
        super(jSContext, Bridge.createNative(jSContext, 15, z ? 1L : 0L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSBooleanObject(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public boolean valueOf(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 301, this.mNativePtr);
        if (cmd instanceof JSBoolean) {
            return ((JSBoolean) cmd).valueOf();
        }
        return false;
    }
}
