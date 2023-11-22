package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class JSPromise extends JSObject {
    public static final int kError = 0;
    public static final int kPromiseFulfilled = 2;
    public static final int kPromisePending = 1;
    public static final int kPromiseRejected = 3;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isPromise() {
        return true;
    }

    /* loaded from: classes6.dex */
    public class Resolver extends JSObject {
        public Resolver(JSContext jSContext) {
            super(jSContext, Bridge.createNative(jSContext, 14));
        }

        public JSPromise getPromise(JSContext jSContext) {
            checkDeleted();
            Object cmd = Bridge.cmd(jSContext, 400, this.mNativePtr);
            if (cmd instanceof JSPromise) {
                return (JSPromise) cmd;
            }
            return null;
        }

        public boolean resolve(JSContext jSContext, JSValue jSValue) {
            checkDeleted();
            return Bridge.cmd(jSContext, 401, this.mNativePtr, new Object[]{jSValue}) != null;
        }

        public boolean reject(JSContext jSContext, JSValue jSValue) {
            checkDeleted();
            return Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY, this.mNativePtr, new Object[]{jSValue}) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSPromise(JSContext jSContext, long j) {
        super(jSContext, j);
    }

    public JSPromise promiseThen(JSContext jSContext, JSFunction jSFunction) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 420, this.mNativePtr, new Object[]{jSFunction});
        if (cmd instanceof JSPromise) {
            return (JSPromise) cmd;
        }
        return null;
    }

    public JSPromise promiseCatch(JSContext jSContext, JSFunction jSFunction) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 421, this.mNativePtr, new Object[]{jSFunction});
        if (cmd instanceof JSPromise) {
            return (JSPromise) cmd;
        }
        return null;
    }

    public boolean hasHandler(JSContext jSContext) {
        checkDeleted();
        return Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED, this.mNativePtr) != null;
    }

    public JSValue result(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_DYN_ENC_BASE64_DECODE_FAILED, this.mNativePtr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public int state(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 424, this.mNativePtr);
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 1;
    }
}
