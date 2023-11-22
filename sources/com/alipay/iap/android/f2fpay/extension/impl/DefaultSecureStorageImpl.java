package com.alipay.iap.android.f2fpay.extension.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;
import com.alipay.secotp.SecOtpGenerator;

/* loaded from: classes3.dex */
public class DefaultSecureStorageImpl implements IF2FPaySecureStorage {

    /* renamed from: a  reason: collision with root package name */
    protected SharedPreferences f6966a;
    protected String b;
    protected int c;

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public boolean checkOtpInfoExist(String str) {
        return SecOtpGeneratorManager.getInstance().getGenerator().checkConfigure("f2fpay") && TextUtils.equals(str, this.b);
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public void clear() {
        this.c = 0;
        this.b = null;
        this.f6966a.edit().clear().commit();
        SecOtpGeneratorManager.getInstance().getGenerator().deleteConfigure("f2fpay");
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public F2FPayOtpInfo getOtpInfoByIdentity(String str) {
        if (TextUtils.equals(str, this.b)) {
            return new F2FPayOtpInfo(null, null, this.c);
        }
        return null;
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public void initialize(Context context) {
        SecOtpGeneratorManager.getInstance().initialize(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("f2fpay_security_storage", 0);
        this.f6966a = sharedPreferences;
        this.b = sharedPreferences.getString("CurrentIdentity", "");
        this.c = this.f6966a.getInt("CurrentOtpInfoInterval", 0);
    }

    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public void saveOtpInfo(F2FPayOtpInfo f2FPayOtpInfo, String str) {
        String str2;
        long j;
        String str3;
        int i = f2FPayOtpInfo != null ? f2FPayOtpInfo.interval : 0;
        this.b = str;
        this.c = i;
        SecOtpGenerator generator = SecOtpGeneratorManager.getInstance().getGenerator();
        if (f2FPayOtpInfo != null) {
            String str4 = f2FPayOtpInfo.index;
            String str5 = f2FPayOtpInfo.otpSeed;
            j = f2FPayOtpInfo.interval;
            str3 = str4;
            str2 = str5;
        } else {
            str2 = null;
            j = 0;
            str3 = null;
        }
        generator.saveConfigure("f2fpay", str3, str2, j);
        this.f6966a.edit().putString("CurrentIdentity", str).putInt("CurrentOtpInfoInterval", i).commit();
    }
}
