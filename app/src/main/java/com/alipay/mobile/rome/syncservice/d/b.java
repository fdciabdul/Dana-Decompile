package com.alipay.mobile.rome.syncservice.d;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7280a = "b";

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return TextUtils.equals(str, str2);
    }

    public static long a(String str) {
        try {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(str).getTime();
        } catch (ParseException unused) {
            String str2 = f7280a;
            StringBuilder sb = new StringBuilder("dateString2Long ParseException[data:");
            sb.append(str);
            sb.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            return 0L;
        }
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(j));
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            String str2 = f7280a;
            StringBuilder sb = new StringBuilder("string2long = ");
            sb.append(str);
            com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
            return -1L;
        }
    }
}
