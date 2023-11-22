package com.iap.ac.android.loglite.utils;

import com.iap.ac.android.loglite.c.a;
import com.iap.ac.android.loglite.core.pageMonitor.AutoTrackPageInfo;
import id.dana.data.here.HereOauthManager;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class BizCodeMatchUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f7600a;
    public static String b;
    public static long c;
    public static String d;
    public static Map<String, AutoTrackPageInfo> e;

    public static String a(String str, String str2, String str3) {
        f7600a = str2;
        b = str3;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(str2).getBytes(), SecureKeyStorageProvider.ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(a(b).getBytes()));
            return new String(cipher.doFinal(a.a(str)), HereOauthManager.ENC);
        } catch (Exception e2) {
            LoggerWrapper.w("ColorUtil", e2);
            return null;
        }
    }

    public static String b(String str, String str2, String str3) {
        f7600a = str2;
        b = str3;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(a(f7600a).getBytes(), SecureKeyStorageProvider.ALGORITHM), new IvParameterSpec(a(b).getBytes()));
            return a.a(cipher.doFinal(str.getBytes(HereOauthManager.ENC)));
        } catch (Exception e2) {
            LoggerWrapper.w("ColorUtil", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            long r0 = android.os.SystemClock.uptimeMillis()
            long r2 = com.iap.ac.android.loglite.utils.BizCodeMatchUtils.c
            long r2 = r0 - r2
            r4 = 5000(0x1388, double:2.4703E-320)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L9b
            r2 = 0
            if (r7 != 0) goto L12
            goto L25
        L12:
            java.lang.String r3 = "connectivity"
            java.lang.Object r7 = r7.getSystemService(r3)     // Catch: java.lang.Throwable -> L1f
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7     // Catch: java.lang.Throwable -> L1f
            android.net.NetworkInfo r7 = r7.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L1f
            goto L26
        L1f:
            r7 = move-exception
            java.lang.String r3 = "LogNetUtil"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r3, r7)
        L25:
            r7 = r2
        L26:
            java.lang.String r3 = "WIFI"
            if (r7 != 0) goto L2c
            goto L97
        L2c:
            java.lang.String r4 = r7.getTypeName()
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L38
            r2 = r3
            goto L97
        L38:
            java.lang.String r3 = r7.getSubtypeName()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L47
            java.lang.String r2 = r7.getSubtypeName()
            goto L72
        L47:
            int r3 = r7.getSubtype()
            r4 = 16
            if (r3 != r4) goto L52
            java.lang.String r2 = "GSM"
            goto L72
        L52:
            int r3 = r7.getSubtype()
            r4 = 17
            if (r3 != r4) goto L5d
            java.lang.String r2 = "TD-CDMA"
            goto L72
        L5d:
            int r3 = r7.getSubtype()
            r4 = 18
            if (r3 != r4) goto L68
            java.lang.String r2 = "TDS-HSDPSA"
            goto L72
        L68:
            int r3 = r7.getSubtype()
            r4 = 19
            if (r3 != r4) goto L72
            java.lang.String r2 = "TDS-HSUPA"
        L72:
            if (r2 == 0) goto L97
            java.lang.String r3 = r7.getExtraInfo()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L97
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "|"
            r3.append(r2)
            java.lang.String r7 = r7.getExtraInfo()
            r3.append(r7)
            java.lang.String r2 = r3.toString()
        L97:
            com.iap.ac.android.loglite.utils.BizCodeMatchUtils.d = r2
            com.iap.ac.android.loglite.utils.BizCodeMatchUtils.c = r0
        L9b:
            java.lang.String r7 = com.iap.ac.android.loglite.utils.BizCodeMatchUtils.d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.loglite.utils.BizCodeMatchUtils.a(android.content.Context):java.lang.String");
    }

    public static String a(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 136);
        }
        return String.valueOf(charArray);
    }

    public static boolean a() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
