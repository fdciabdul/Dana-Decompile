package com.alipay.mobile.jsengine.v8;

/* loaded from: classes6.dex */
public class V8ScriptExecutionException extends V8ScriptException {
    protected V8ScriptExecutionException(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        this(str, i, str2, str3, i2, i3, str4, null);
    }

    protected V8ScriptExecutionException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        super(str, i, str2, str3, i2, i3, str4, th);
    }
}
