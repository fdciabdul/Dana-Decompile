package com.alipay.iap.android.f2fpay.extension.impl;

import com.alipay.iap.android.f2fpay.cipher.AesCipher;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipayplus.mobile.component.f2fpay.service.request.F2fPayInitRequest;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fPayInitResult;

/* loaded from: classes3.dex */
public class AesCipherOtpInitializeInterceptor implements IF2FPayInitializeComponent.Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final AesCipher f6963a;

    public AesCipherOtpInitializeInterceptor(String str, String str2) {
        this(str, str2.getBytes());
    }

    public AesCipherOtpInitializeInterceptor(String str, byte[] bArr) {
        this.f6963a = AesCipher.createRandom(str, bArr);
    }

    @Override // com.alipay.iap.android.common.extensions.interceptor.IOverrideInterceptor
    public F2fPayInitResult afterExecute(F2fPayInitResult f2fPayInitResult) {
        if (f2fPayInitResult != null) {
            f2fPayInitResult.otpSeed = this.f6963a.decrypt(f2fPayInitResult.otpSeed);
            f2fPayInitResult.serverTime = this.f6963a.decrypt(f2fPayInitResult.serverTime);
        }
        return f2fPayInitResult;
    }

    @Override // com.alipay.iap.android.common.extensions.interceptor.IOverrideInterceptor
    public F2fPayInitRequest beforeExecute(F2fPayInitRequest f2fPayInitRequest) {
        if (f2fPayInitRequest != null) {
            f2fPayInitRequest.random = this.f6963a.encrypted();
        }
        return f2fPayInitRequest;
    }
}
