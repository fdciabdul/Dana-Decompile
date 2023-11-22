package com.iap.ac.android.biz.common.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class Utils {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int getAuthRequestContext = 1;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 35, 67, -12, 69, 13, 0, -3, 3, -47, 44, -11, 1, -69, Ascii.GS, -29, 5, 63};
    public static final int MyBillsEntityDataFactory = 98;

    public static String SHA256(String str) throws NoSuchAlgorithmException {
        if (str == null || str.length() <= 0) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static boolean checkClassExist(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("check class [");
            sb.append(str);
            sb.append("] error: ");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return false;
        }
    }

    public static String e(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0064 -> B:12:0x0069). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String formatSecurityGuardException(java.lang.Throwable r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            boolean r1 = r12 instanceof com.alibaba.wireless.security.open.SecException
            if (r1 == 0) goto L6f
            java.lang.StringBuilder r0 = com.iap.ac.android.biz.accommon.a.a.a(r0)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.alibaba.wireless.security.open.SecException r12 = (com.alibaba.wireless.security.open.SecException) r12
            int r12 = r12.getErrorCode()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r3 = 0
            r2[r3] = r12
            byte[] r12 = com.iap.ac.android.biz.common.utils.Utils.BuiltInFictitiousFunctionClassFactory
            r4 = 7
            r4 = r12[r4]
            byte r4 = (byte) r4
            byte r5 = (byte) r4
            byte r6 = (byte) r5
            int r4 = r4 * 3
            int r4 = 44 - r4
            int r5 = r5 * 3
            int r5 = r5 + 4
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r7 = new byte[r6]
            r8 = -1
            int r6 = r6 + r8
            if (r12 != 0) goto L46
            r10 = r6
            r8 = r7
            r9 = -1
            r6 = r5
            r7 = r10
            r5 = r2
            r2 = r0
            goto L69
        L46:
            r8 = r7
            r9 = -1
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r0
        L4d:
            int r9 = r9 + r1
            byte r10 = (byte) r5
            r8[r9] = r10
            if (r9 != r7) goto L64
            java.lang.String r12 = new java.lang.String
            r12.<init>(r8, r3)
            java.lang.String r12 = java.lang.String.format(r12, r4)
            r0.append(r12)
            java.lang.String r0 = r2.toString()
            goto L6f
        L64:
            r10 = r12[r6]
            r11 = r5
            r5 = r4
            r4 = r11
        L69:
            int r4 = r4 + r10
            int r6 = r6 + r1
            r11 = r5
            r5 = r4
            r4 = r11
            goto L4d
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.biz.common.utils.Utils.formatSecurityGuardException(java.lang.Throwable):java.lang.String");
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getNonce() {
        return UUID.randomUUID().toString();
    }

    public static boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String domain = getDomain(str2);
        if (TextUtils.isEmpty(domain)) {
            return false;
        }
        if (domain.equals(str)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(str);
        return domain.endsWith(sb.toString());
    }

    public static boolean isUrlFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String readConfigFromAsset(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        try {
            BufferedReader bufferedReader2 = null;
            try {
                Object[] objArr = {context.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((-16719083) - Color.rgb(0, 0, 0)), (-1) - TextUtils.indexOf((CharSequence) "", '0'), 48 - ImageFormat.getBitsPerPixel(0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                } catch (Exception e2) {
                    e = e2;
                    inputStreamReader = null;
                    bufferedReader = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("acCommon readConfigFromAsset failed: ");
                    sb.append(e);
                    ACLog.e(Constants.TAG, sb.toString());
                    safeClose(bufferedReader);
                    try {
                        safeClose(inputStreamReader);
                        safeClose(inputStream);
                        return null;
                    } catch (Exception e3) {
                        throw e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = null;
                    safeClose(bufferedReader2);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    throw th;
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    safeClose(bufferedReader2);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    throw th;
                }
                try {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if ((readLine != null ? '!' : '-') == '-') {
                                break;
                            }
                            int i = getAuthRequestContext + 55;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                            int i2 = i % 2;
                            sb2.append(readLine);
                        }
                        String obj2 = sb2.toString();
                        safeClose(bufferedReader);
                        safeClose(inputStreamReader);
                        safeClose(inputStream);
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 5;
                        getAuthRequestContext = i3 % 128;
                        if ((i3 % 2 == 0 ? (char) 4 : '!') != '!') {
                            int i4 = 76 / 0;
                            return obj2;
                        }
                        return obj2;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = inputStreamReader;
                        bufferedReader2 = bufferedReader;
                        safeClose(bufferedReader2);
                        safeClose(inputStreamReader);
                        safeClose(inputStream);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("acCommon readConfigFromAsset failed: ");
                    sb3.append(e);
                    ACLog.e(Constants.TAG, sb3.toString());
                    safeClose(bufferedReader);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    return null;
                }
            } catch (Throwable th5) {
                try {
                    Throwable cause = th5.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th5;
                } catch (Exception e6) {
                    e = e6;
                    inputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    StringBuilder sb32 = new StringBuilder();
                    sb32.append("acCommon readConfigFromAsset failed: ");
                    sb32.append(e);
                    ACLog.e(Constants.TAG, sb32.toString());
                    safeClose(bufferedReader);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                    inputStreamReader = null;
                    safeClose(bufferedReader2);
                    safeClose(inputStreamReader);
                    safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Exception e7) {
            throw e7;
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("acCommon readConfigFromAsset failed: ");
                sb.append(e);
                ACLog.e(Constants.TAG, sb.toString());
            }
        }
    }

    public static long stringToLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("stringToLong exception: ");
            sb.append(e);
            ACLog.e(Constants.TAG, sb.toString());
            return j;
        }
    }
}
