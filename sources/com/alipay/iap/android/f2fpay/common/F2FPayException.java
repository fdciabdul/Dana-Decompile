package com.alipay.iap.android.f2fpay.common;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class F2FPayException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f6954a;

    public F2FPayException(String str) {
        this(F2FPayErrorCode.OTHER_ERROR, str);
    }

    public F2FPayException(String str, String str2) {
        super(str2);
        this.f6954a = TextUtils.isEmpty(str) ? F2FPayErrorCode.OTHER_ERROR : str;
    }

    public String getErrorCode() {
        return this.f6954a;
    }
}
