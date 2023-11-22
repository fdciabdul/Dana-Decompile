package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSStringObject extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isStringObject() {
        return true;
    }

    public JSStringObject(JSContext jSContext, JSString jSString) {
        super(jSContext, Bridge.createNative(jSContext, 17, new Object[]{jSString}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSStringObject(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public String valueOf(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 302, this.mNativePtr);
        if (cmd instanceof JSString) {
            return ((JSString) cmd).valueOf();
        }
        return null;
    }
}
