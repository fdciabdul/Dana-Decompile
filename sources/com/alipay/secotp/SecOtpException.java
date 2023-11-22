package com.alipay.secotp;

/* loaded from: classes3.dex */
public class SecOtpException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f7409a;

    public SecOtpException(String str, int i) {
        super(str);
        this.f7409a = i;
    }

    public int getCode() {
        return this.f7409a;
    }
}
