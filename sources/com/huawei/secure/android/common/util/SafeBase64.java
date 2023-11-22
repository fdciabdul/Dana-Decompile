package com.huawei.secure.android.common.util;

import android.util.Base64;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class SafeBase64 {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "SafeBase64";

    private SafeBase64() {
    }

    public static byte[] decode(byte[] bArr, int i) {
        try {
            return Base64.decode(bArr, i);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message0 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        try {
            return Base64.encode(bArr, i);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message3 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return Base64.encodeToString(bArr, i);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message5 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return "";
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.encodeToString(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message6 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.decode(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message1 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        try {
            return Base64.encode(bArr, i, i2, i3);
        } catch (Exception e) {
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message4 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str, sb.toString());
            return new byte[0];
        }
    }

    public static byte[] decode(String str, int i) {
        try {
            return Base64.decode(str, i);
        } catch (Exception e) {
            String str2 = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(e.getClass().getSimpleName());
            sb.append(" , message2 : ");
            sb.append(e.getMessage());
            InstrumentInjector.log_e(str2, sb.toString());
            return new byte[0];
        }
    }
}
