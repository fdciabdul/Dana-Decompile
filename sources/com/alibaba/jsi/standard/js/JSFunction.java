package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;

/* loaded from: classes6.dex */
public class JSFunction extends JSObject {
    private String mFunctionName;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isFunction() {
        return true;
    }

    public JSFunction(JSContext jSContext, JSCallback jSCallback, String str) {
        super(jSContext, Bridge.createNative(jSContext, 12, new Object[]{jSCallback, str}));
        this.mFunctionName = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public JSFunction(com.alibaba.jsi.standard.JSContext r3, com.alibaba.jsi.standard.js.JSCallback r4, java.lang.String r5, boolean r6) {
        /*
            r2 = this;
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r4
            r4 = 1
            r0[r4] = r5
            r4 = 0
            if (r6 == 0) goto Lf
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L10
        Lf:
            r5 = r4
        L10:
            r6 = 2
            r0[r6] = r5
            r5 = 12
            long r5 = com.alibaba.jsi.standard.js.Bridge.createNative(r3, r5, r0)
            r2.<init>(r3, r5)
            r2.mFunctionName = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.js.JSFunction.<init>(com.alibaba.jsi.standard.JSContext, com.alibaba.jsi.standard.js.JSCallback, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSFunction(JSContext jSContext, long j) {
        super(jSContext, j);
        this.mFunctionName = null;
    }

    public JSValue call(JSContext jSContext, JSValue jSValue, JSValue[] jSValueArr) {
        checkDeleted();
        checkContext(jSContext);
        Object[] objArr = new Object[jSValueArr != null ? jSValueArr.length + 1 : 1];
        int i = 0;
        objArr[0] = jSValue;
        if (jSValueArr != null) {
            int length = jSValueArr.length;
            int i2 = 1;
            while (i < length) {
                objArr[i2] = jSValueArr[i];
                i++;
                i2++;
            }
        }
        Object cmd = Bridge.cmd(jSContext, 550, this.mNativePtr, objArr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public String getName(JSContext jSContext) {
        checkDeleted();
        if (this.mFunctionName == null) {
            Object cmd = Bridge.cmd(jSContext, 551, this.mNativePtr);
            if (cmd instanceof String) {
                this.mFunctionName = (String) cmd;
            }
        }
        return this.mFunctionName;
    }

    public JSObject newInstance(JSContext jSContext, JSValue[] jSValueArr) {
        checkDeleted();
        checkContext(jSContext);
        Object cmd = Bridge.cmd(jSContext, 552, this.mNativePtr, jSValueArr);
        if (cmd instanceof JSObject) {
            return (JSObject) cmd;
        }
        return null;
    }

    public JSCallback getFunctionCallback(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 554, this.mNativePtr);
        if (cmd instanceof JSCallback) {
            return (JSCallback) cmd;
        }
        return null;
    }

    public boolean detach(JSContext jSContext) {
        checkDeleted();
        return Bridge.cmd(jSContext, 553, this.mNativePtr) != null;
    }
}
