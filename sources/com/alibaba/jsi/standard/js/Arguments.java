package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class Arguments {
    long mNativePtr;
    private JSContext mContext = null;
    private int mArgsCount = -1;
    private String mFunctionName = null;
    private boolean mDetached = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Arguments(long j) {
        this.mNativePtr = j;
    }

    private void checkDetached() {
        if (this.mDetached) {
            StringBuilder sb = new StringBuilder();
            sb.append("Arguments has been detached: ");
            sb.append(this);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detach() {
        this.mDetached = true;
        this.mNativePtr = 0L;
    }

    public int count() {
        checkDetached();
        if (this.mArgsCount == -1) {
            Object cmd = Bridge.cmd((JSContext) null, 700, this.mNativePtr);
            if (cmd instanceof Long) {
                this.mArgsCount = ((Long) cmd).intValue();
            } else {
                this.mArgsCount = 0;
            }
        }
        return this.mArgsCount;
    }

    public JSValue get(int i) {
        checkDetached();
        Object cmd = Bridge.cmd((JSContext) null, 701, this.mNativePtr, i);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public JSContext getContext() {
        checkDetached();
        if (this.mContext == null) {
            Object cmd = Bridge.cmd((JSContext) null, 702, this.mNativePtr);
            if (cmd instanceof Long) {
                this.mContext = JSContext.getContext(((Long) cmd).longValue());
            }
        }
        return this.mContext;
    }

    public JSValue thiz() {
        checkDetached();
        Object cmd = Bridge.cmd((JSContext) null, (int) SecExceptionCode.SEC_ERROR_STA_KEY_ENC_NO_KEY, this.mNativePtr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public String getFunctionName() {
        checkDetached();
        if (this.mFunctionName == null) {
            Object cmd = Bridge.cmd((JSContext) null, (int) SecExceptionCode.SEC_ERROR_STA_KEY_ENC_INVALID_ENCRYPTED_DATA, this.mNativePtr);
            if (cmd instanceof String) {
                this.mFunctionName = (String) cmd;
            }
        }
        return this.mFunctionName;
    }

    public boolean isConstructCall() {
        checkDetached();
        return Bridge.cmd((JSContext) null, (int) SecExceptionCode.SEC_ERROR_STA_KEY_ENC_MISMATCH_KEY_DATA, this.mNativePtr) != null;
    }

    public JSValue newTarget() {
        checkDetached();
        Object cmd = Bridge.cmd((JSContext) null, 706, this.mNativePtr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }

    public JSValue[] arguments() {
        checkDetached();
        Object cmd = Bridge.cmd((JSContext) null, 707, this.mNativePtr);
        if (cmd instanceof JSValue[]) {
            return (JSValue[]) cmd;
        }
        return null;
    }
}
