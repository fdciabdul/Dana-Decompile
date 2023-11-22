package com.alipay.iap.android.f2fpay.otp;

/* loaded from: classes3.dex */
public class F2FPayOtpInfo {
    public String index;
    public int interval;
    public String otpSeed;

    public F2FPayOtpInfo() {
    }

    public F2FPayOtpInfo(String str, String str2, int i) {
        this.index = str;
        this.otpSeed = str2;
        this.interval = i;
    }

    public String toString() {
        return String.format("index = %s, otpSeed = %s, interval = %d", this.index, this.otpSeed, Integer.valueOf(this.interval));
    }
}
