package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSArray extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isArray() {
        return true;
    }

    public JSArray(JSContext jSContext) {
        super(jSContext, Bridge.createNative(jSContext, 8));
    }

    public JSArray(JSContext jSContext, int i) {
        super(jSContext, Bridge.createNative(jSContext, 8, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSArray(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public int length(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 200, this.mNativePtr);
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 0;
    }
}
