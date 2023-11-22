package com.alipay.secotp;

/* loaded from: classes3.dex */
public class SecOtpGenerator {

    /* renamed from: a  reason: collision with root package name */
    private static SecOtpGenerator f7410a;

    static {
        try {
            System.loadLibrary("o6ac0b");
        } catch (Throwable unused) {
        }
    }

    private SecOtpGenerator() {
    }

    public static SecOtpGenerator getInstance() {
        if (f7410a == null) {
            synchronized (SecOtpGenerator.class) {
                if (f7410a == null) {
                    f7410a = new SecOtpGenerator();
                }
            }
        }
        return f7410a;
    }

    public native boolean checkConfigure(String str);

    public native int deleteConfigure(String str);

    public native String generatePayCode(String str, String str2, long j) throws SecOtpException;

    public native int initialize(String str);

    public native int saveConfigure(String str, String str2, String str3, long j);
}
