package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class JSNumberObject extends JSObject {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isNumberObject() {
        return true;
    }

    public JSNumberObject(JSContext jSContext, double d) {
        super(jSContext, Bridge.createNative(jSContext, 16, 0L, d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSNumberObject(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public double valueOf(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 300, this.mNativePtr);
        return cmd instanceof JSNumber ? ((JSNumber) cmd).valueOf() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
