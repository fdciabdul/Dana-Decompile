package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* loaded from: classes8.dex */
public class BaseException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f7478a;
    public final ErrorEnum b;

    public BaseException(int i) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i);
        this.b = fromCode;
        this.f7478a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f7478a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b.getMessage();
    }
}
