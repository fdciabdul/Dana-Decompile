package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.LeakUtil;
import com.alibaba.wireless.security.SecExceptionCode;

/* loaded from: classes6.dex */
public class JSException implements Deletable {
    private JSContext mContext;
    private boolean mDeleted = false;
    long mNativePtr;

    public JSException(JSContext jSContext, String str) {
        this.mContext = jSContext;
        this.mNativePtr = Bridge.createNative(jSContext, 21, new Object[]{str});
        LeakUtil.add(this.mContext, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSException(JSContext jSContext, long j) {
        this.mContext = jSContext;
        this.mNativePtr = j;
        LeakUtil.add(jSContext, this);
    }

    @Override // com.alibaba.jsi.standard.js.Deletable
    public void delete() {
        long j = this.mNativePtr;
        if (j != 0 && !this.mDeleted) {
            Bridge.nativeDelete(j, 4);
            this.mNativePtr = 0L;
            LeakUtil.remove(this.mContext, this);
        }
        this.mDeleted = true;
    }

    private void checkDeleted() {
        if (this.mDeleted) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSException has been deleted: ");
            sb.append(this);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detach() {
        if (this.mNativePtr != 0) {
            LeakUtil.remove(this.mContext, this);
            this.mNativePtr = 0L;
        }
    }

    public String toString(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 600, this.mNativePtr);
        if (cmd instanceof String) {
            return (String) cmd;
        }
        return null;
    }

    public String getName(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_SIGNATRUE_INVALID_INPUT, this.mNativePtr);
        if (cmd instanceof String) {
            return (String) cmd;
        }
        return null;
    }

    public String getMessage(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_SIGNATURE_NO_MEM, this.mNativePtr);
        if (cmd instanceof String) {
            return (String) cmd;
        }
        return null;
    }

    public String getStack(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_SIGNATURE_HASHHEX_FAILED, this.mNativePtr);
        if (cmd instanceof String) {
            return (String) cmd;
        }
        return null;
    }

    public JSValue getValue(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_SIGNATURE_BASE64_FAILED, this.mNativePtr);
        if (cmd instanceof JSValue) {
            return (JSValue) cmd;
        }
        return null;
    }
}
