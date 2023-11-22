package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.LeakUtil;
import id.dana.lib.drawbitmap.invoice.Config;

/* loaded from: classes6.dex */
public class JSValue implements Deletable {
    public static final int kAttributeDontDelete = 4;
    public static final int kAttributeDontEnum = 2;
    public static final int kAttributeNone = 0;
    public static final int kAttributeReadOnly = 1;
    public static final int kIntegrityFrozen = 0;
    public static final int kIntegritySealed = 1;
    private JSContext mContext;
    private boolean mDeleted;
    long mNativePtr;

    public JSObject asJSObject() {
        return null;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isArrayBuffer() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isBooleanObject() {
        return false;
    }

    public boolean isFunction() {
        return false;
    }

    public boolean isJSObject() {
        return false;
    }

    public boolean isMap() {
        return false;
    }

    public boolean isName() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isNumberObject() {
        return false;
    }

    public boolean isPrimitive() {
        return false;
    }

    public boolean isPromise() {
        return false;
    }

    public boolean isSet() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isStringObject() {
        return false;
    }

    public boolean isSymbol() {
        return false;
    }

    public boolean isSymbolObject() {
        return false;
    }

    public boolean isVoid() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue lockWeak(JSContext jSContext) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean weakExpired(JSContext jSContext) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue(JSContext jSContext) {
        this.mDeleted = false;
        this.mContext = jSContext;
        this.mNativePtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue(JSContext jSContext, long j) {
        this.mDeleted = false;
        this.mContext = jSContext;
        this.mNativePtr = j;
        if (j != 0) {
            LeakUtil.add(jSContext, this);
        }
    }

    @Override // com.alibaba.jsi.standard.js.Deletable
    public void delete() {
        long j = this.mNativePtr;
        if (j == 0 || this.mDeleted) {
            return;
        }
        Bridge.nativeDelete(j, 1);
        this.mNativePtr = 0L;
        LeakUtil.remove(this.mContext, this);
        this.mContext = null;
        this.mDeleted = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkDeleted() {
        if (this.mDeleted) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSValue has been deleted: ");
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
        long j = this.mNativePtr;
        if (j != 0) {
            Object cmd = Bridge.cmd(jSContext, 50, j);
            if (cmd instanceof String) {
                return (String) cmd;
            }
            return null;
        }
        return null;
    }

    public JSValue copy(JSContext jSContext) {
        long j = this.mNativePtr;
        if (j != 0) {
            Object cmd = Bridge.cmd(jSContext, 51, j);
            if (cmd instanceof JSValue) {
                return (JSValue) cmd;
            }
            return null;
        }
        return null;
    }

    @Deprecated
    public JSValueBlob serialize() {
        return serialize(this.mContext);
    }

    public JSValueBlob serialize(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) Config.WIDTH, this.mNativePtr);
        if (cmd instanceof Long) {
            return new JSValueBlob((Long) cmd);
        }
        return null;
    }

    public boolean equals(JSValue jSValue) {
        long j = this.mNativePtr;
        if (j != 0) {
            long j2 = jSValue.mNativePtr;
            return (j2 == 0 || Bridge.cmd((JSContext) null, 52, j, j2) == null) ? false : true;
        }
        return false;
    }

    public JSWeakValue createWeak(JSContext jSContext) {
        return new JSWeakValue(jSContext, this, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSWeakValue createWeakNative(JSContext jSContext) {
        checkDeleted();
        long j = this.mNativePtr;
        if (j != 0) {
            Object cmd = Bridge.cmd(jSContext, 53, j);
            if (cmd instanceof JSValue) {
                return new JSWeakValue(jSContext, (JSValue) cmd, true);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue lockWeakNative(JSContext jSContext) {
        checkDeleted();
        long j = this.mNativePtr;
        if (j != 0) {
            Object cmd = Bridge.cmd(jSContext, 54, j);
            if (cmd instanceof JSValue) {
                return (JSValue) cmd;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean weakExpiredNative(JSContext jSContext) {
        checkDeleted();
        long j = this.mNativePtr;
        return j == 0 || Bridge.cmd(jSContext, 55, j) != null;
    }
}
