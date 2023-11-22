package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSSymbolObject extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isSymbolObject() {
        return true;
    }

    public JSSymbolObject(JSContext jSContext, JSSymbol jSSymbol) {
        super(jSContext, Bridge.createNative(jSContext, 18, new Object[]{jSSymbol}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSSymbolObject(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public JSSymbol valueOf(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 303, this.mNativePtr);
        if (cmd instanceof JSSymbol) {
            return (JSSymbol) cmd;
        }
        return null;
    }
}
