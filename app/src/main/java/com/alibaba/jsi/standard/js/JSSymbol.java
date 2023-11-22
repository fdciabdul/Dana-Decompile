package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class JSSymbol extends JSName {
    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isSymbol() {
        return true;
    }

    public JSSymbol(JSContext jSContext, String str, boolean z) {
        super(jSContext, Bridge.createNative(jSContext, 5, z ? 1L : 0L, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSSymbol(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public String getName(JSContext jSContext) {
        checkDeleted();
        if (this.mNativePtr != 0) {
            Object cmd = Bridge.cmd(jSContext, 80, this.mNativePtr);
            if (cmd instanceof String) {
                return (String) cmd;
            }
            return null;
        }
        return null;
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
}
