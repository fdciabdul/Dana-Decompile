package com.alipay.alipaysecuritysdk.apdid.bridge;

import android.content.Context;
import android.os.Process;
import com.alipay.alipaysecuritysdk.apdid.attack.ScanAttack;
import com.alipay.alipaysecuritysdk.common.c.a;
import com.alipay.alipaysecuritysdk.common.c.b;
import com.alipay.alipaysecuritysdk.common.e.e;

/* loaded from: classes3.dex */
public class JNIBridge {
    private static final String SO_NAME = "APSE_";
    private static final String SO_VERSION = "5.0.6";

    public static native String aesEncrypt(String str);

    private static native String getAA13(Context context);

    private static native String getAD102();

    private static native String[] getAD104(Context context, int i, int i2, int i3, int i4, int i5, String str);

    private static native long getAD107(Object obj);

    private static native String getAD108();

    private static native boolean getAE20();

    private static native String getDynData(Context context, int i);

    public static native byte[] zipAndEncryptData(Object obj, String str);

    static {
        try {
            System.loadLibrary("bbff23");
            a.a("library_load", "success", "");
        } catch (Throwable th) {
            b.a("SEC_SDK-apdid", "load libAPSE_5.0.6.so failed", th);
            a.a("library_load", "failed", th.getMessage());
        }
    }

    public static String getNativeProp(Context context, String str, String str2) {
        char c;
        try {
            switch (str.hashCode()) {
                case 2000450:
                    if (str.equals("AA13")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2004322:
                    if (str.equals("AE20")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 62103280:
                    if (str.equals("AD102")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 62103282:
                    if (str.equals("AD104")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 62103285:
                    if (str.equals("AD107")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 62103286:
                    if (str.equals("AD108")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2123892163:
                    if (str.equals("dynData")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return getAA13(context);
                case 1:
                    StringBuilder sb = new StringBuilder();
                    sb.append(getAE20());
                    return sb.toString();
                case 2:
                    return getAD102();
                case 3:
                    String[] ad104 = getAD104(context, ScanAttack.MODE_DETAIL, Process.myUid(), ScanAttack.CHECK_ALL, 0, 5, str2);
                    if (ad104 != null && ad104.length == 2) {
                        String str3 = ad104[0];
                        if (e.d(ad104[1])) {
                            return ad104[1];
                        }
                    }
                    break;
                case 4:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(getAD107(context));
                    return sb2.toString();
                case 5:
                    return getAD108();
                case 6:
                    return getDynData(context, e.a(str2, 0));
            }
        } catch (Throwable th) {
            b.a("SEC_SDK-apdid", th.getMessage(), th);
        }
        return "";
    }
}
