package com.huawei.hms.framework.common;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.huawei.secure.android.common.util.SafeString;
import id.dana.cashier.view.InputCardNumberView;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import o.whenAvailable;

/* loaded from: classes7.dex */
public class StringUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory = null;
    private static long PlaceComponentResult = 0;
    private static boolean getAuthRequestContext = false;

    static {
        MyBillsEntityDataFactory();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = new char[]{62235, 25746, 56344, 13819, 44374};
        PlaceComponentResult = 6338777147259184326L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r3 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        if ((!r3.equals(r4) ? '^' : 27) != 27) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean strEquals(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 82
            if (r3 == r4) goto L7
            r1 = 82
            goto L9
        L7:
            r1 = 8
        L9:
            if (r1 == r0) goto Lc
            goto L3d
        Lc:
            r0 = 2
            if (r3 == 0) goto L41
            int r1 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L3f
            int r1 = r1 + 119
            int r2 = r1 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L3f
            int r1 = r1 % r0
            r2 = 17
            if (r1 != 0) goto L1e
            r1 = 2
            goto L20
        L1e:
            r1 = 17
        L20:
            if (r1 == r2) goto L2d
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L4c
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L2b
            if (r3 != 0) goto L3d
            goto L41
        L2b:
            r3 = move-exception
            throw r3
        L2d:
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L4c
            r4 = 27
            if (r3 != 0) goto L38
            r3 = 94
            goto L3a
        L38:
            r3 = 27
        L3a:
            if (r3 == r4) goto L3d
            goto L41
        L3d:
            r3 = 1
            goto L4b
        L3f:
            r3 = move-exception
            throw r3
        L41:
            r3 = 0
            int r4 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L4c
            int r4 = r4 + 31
            int r1 = r4 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L4c
            int r4 = r4 % r0
        L4b:
            return r3
        L4c:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.strEquals(java.lang.String, java.lang.String):boolean");
    }

    public static String byte2Str(byte[] bArr) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 99;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if ((bArr == null ? 'N' : '*') != '*') {
                    int i3 = BuiltInFictitiousFunctionClassFactory + 13;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return "";
                }
                try {
                    Object[] objArr = new Object[1];
                    a(ViewConfiguration.getTouchSlop() >> 8, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, (char) Color.red(0), objArr);
                    return new String(bArr, ((String) objArr[0]).intern());
                } catch (UnsupportedEncodingException e) {
                    Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e.getMessage()));
                    return "";
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5) ? '9' : '\\') != '9') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r5 = new byte[0];
        r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if ((r0 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        r3 = new java.lang.Object[1];
        a(android.text.TextUtils.indexOf("", ""), 4 - android.text.TextUtils.lastIndexOf("", '0'), (char) (android.view.ViewConfiguration.getFadingEdgeLength() >> 16), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
    
        return r5.getBytes(((java.lang.String) r3[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        com.huawei.hms.framework.common.Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(r5.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
    
        return new byte[0];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] str2Byte(java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            int r1 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 57
            int r1 = r1 + r2
            int r3 = r1 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % 2
            r3 = 22
            if (r1 == 0) goto L14
            r1 = 90
            goto L16
        L14:
            r1 = 22
        L16:
            r4 = 0
            if (r1 == r3) goto L2e
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L2c
            r3 = 52
            int r3 = r3 / r4
            if (r1 == 0) goto L25
            r1 = 57
            goto L27
        L25:
            r1 = 92
        L27:
            if (r1 == r2) goto L34
            goto L48
        L2a:
            r5 = move-exception
            throw r5
        L2c:
            r5 = move-exception
            throw r5
        L2e:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L48
        L34:
            byte[] r5 = new byte[r4]
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 73
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L47
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L45
            return r5
        L45:
            r5 = move-exception
            throw r5
        L47:
            return r5
        L48:
            int r1 = android.text.TextUtils.indexOf(r0, r0)     // Catch: java.io.UnsupportedEncodingException -> L6e
            r2 = 48
            int r0 = android.text.TextUtils.lastIndexOf(r0, r2)     // Catch: java.io.UnsupportedEncodingException -> L6e
            int r0 = 4 - r0
            int r2 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch: java.io.UnsupportedEncodingException -> L6e
            int r2 = r2 >> 16
            char r2 = (char) r2     // Catch: java.io.UnsupportedEncodingException -> L6e
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.io.UnsupportedEncodingException -> L6e
            a(r1, r0, r2, r3)     // Catch: java.io.UnsupportedEncodingException -> L6e
            r0 = r3[r4]     // Catch: java.io.UnsupportedEncodingException -> L6e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.io.UnsupportedEncodingException -> L6e
            java.lang.String r0 = r0.intern()     // Catch: java.io.UnsupportedEncodingException -> L6e
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L6e
            return r5
        L6e:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            java.lang.String r5 = anonymizeMessage(r5)
            java.lang.String r0 = "StringUtils.str2Byte error: UnsupportedEncodingException"
            com.huawei.hms.framework.common.Logger.w(r0, r5)
            byte[] r5 = new byte[r4]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.str2Byte(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r4 = r4.toCharArray();
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r1 >= r4.length) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        if (r2 == true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if ((r1 % 2) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r2 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory + 71;
        com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r2 % 128;
        r2 = r2 % 2;
        r4[r1] = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r1 = r1 + 1;
        r2 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        return new java.lang.String(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String anonymizeMessage(java.lang.String r4) {
        /*
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 96
            if (r0 == 0) goto L11
            r0 = 96
            goto L13
        L11:
            r0 = 45
        L13:
            if (r0 == r1) goto L1c
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L25
            goto L24
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L59
            if (r0 == 0) goto L25
        L24:
            return r4
        L25:
            char[] r4 = r4.toCharArray()
            r0 = 0
            r1 = 0
        L2b:
            int r2 = r4.length
            r3 = 1
            if (r1 >= r2) goto L31
            r2 = 0
            goto L32
        L31:
            r2 = 1
        L32:
            if (r2 == r3) goto L53
            int r2 = r1 % 2
            if (r2 == 0) goto L46
            int r2 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 71
            int r3 = r2 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            r2 = 42
            r4[r1] = r2
        L46:
            int r1 = r1 + 1
            int r2 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 3
            int r3 = r2 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r3
            int r2 = r2 % 2
            goto L2b
        L53:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L59:
            r4 = move-exception
            goto L5c
        L5b:
            throw r4
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.anonymizeMessage(java.lang.String):java.lang.String");
    }

    public static byte[] getBytes(long j) {
        byte[] bytes;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        try {
            if ((i % 2 != 0 ? 'b' : (char) 27) != 'b') {
                bytes = getBytes(String.valueOf(j));
            } else {
                bytes = getBytes(String.valueOf(j));
                Object obj = null;
                obj.hashCode();
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return bytes;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if ((r3 == null ? kotlin.text.Typography.quote : 'Z') != 'Z') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r3 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r3 % 128;
        r3 = r3 % 2;
        r3 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if ((r3 % 2) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r0 = r3.getBytes(id.dana.data.here.HereOauthManager.ENC);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        com.huawei.hms.framework.common.Logger.w("StringUtils", "the content has error while it is converted to bytes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        if ((r3 == null) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getBytes(java.lang.String r3) {
        /*
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L57
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L57
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L15
            byte[] r0 = new byte[r1]
            if (r3 != 0) goto L12
            r1 = 1
        L12:
            if (r1 == 0) goto L3e
            goto L22
        L15:
            byte[] r0 = new byte[r1]
            r1 = 90
            if (r3 != 0) goto L1e
            r2 = 34
            goto L20
        L1e:
            r2 = 90
        L20:
            if (r2 == r1) goto L3e
        L22:
            int r3 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 77
            int r1 = r3 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r3 = r3 % 2
            int r3 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 95
            int r1 = r3 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r3 = r3 % 2
            if (r3 == 0) goto L3d
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L3b
            return r0
        L3b:
            r3 = move-exception
            throw r3
        L3d:
            return r0
        L3e:
            java.lang.String r1 = "utf-8"
            byte[] r0 = r3.getBytes(r1)     // Catch: java.io.UnsupportedEncodingException -> L45
            goto L4c
        L45:
            java.lang.String r3 = "StringUtils"
            java.lang.String r1 = "the content has error while it is converted to bytes"
            com.huawei.hms.framework.common.Logger.w(r3, r1)
        L4c:
            int r3 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L57
            int r3 = r3 + 15
            int r1 = r3 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L57
            int r3 = r3 % 2
            return r0
        L57:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.getBytes(java.lang.String):byte[]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0028
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String format(java.lang.String r2, java.lang.Object... r3) {
        /*
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 77
            if (r0 == 0) goto L10
            r0 = 4
            goto L12
        L10:
            r0 = 77
        L12:
            if (r0 == r1) goto L1d
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L1b
            if (r2 != 0) goto L2a
            goto L25
        L1b:
            r2 = move-exception
            throw r2
        L1d:
            r0 = 1
            if (r2 != 0) goto L22
            r1 = 0
            goto L23
        L22:
            r1 = 1
        L23:
            if (r1 == r0) goto L2a
        L25:
            java.lang.String r2 = ""
            return r2
        L28:
            r2 = move-exception
            throw r2
        L2a:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r2 = java.lang.String.format(r0, r2, r3)
            int r3 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 67
            int r0 = r3 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r0
            int r3 = r3 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.format(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String toLowerCase(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '\t' : InputCardNumberView.DIVIDER) != ' ') {
            int length = objArr.length;
            if (str == null) {
                return "";
            }
        } else if (str == null) {
            return "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if ((i2 % 2 != 0 ? 'B' : (char) 29) != 'B') {
            return lowerCase;
        }
        int length2 = objArr.length;
        return lowerCase;
    }

    public static String getTraceInfo(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(1024);
        int length = stackTrace.length;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        while (true) {
            if (!(i3 >= length)) {
                StackTraceElement stackTraceElement = stackTrace[i3];
                sb.append("at ");
                sb.append(stackTraceElement.toString());
                sb.append(";");
                i3++;
                try {
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                try {
                    return sb.toString();
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:50:0x0080
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String substring(java.lang.String r5, int r6) {
        /*
            java.lang.String r0 = "com.huawei.secure.android.common.util.SafeString"
            boolean r0 = MyBillsEntityDataFactory(r0)
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L30
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 37
            int r4 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L19
            r0 = 0
            goto L1a
        L19:
            r0 = 1
        L1a:
            if (r0 == r3) goto L24
            java.lang.String r5 = com.huawei.secure.android.common.util.SafeString.substring(r5, r6)     // Catch: java.lang.Throwable -> L29
            int r6 = r1.length     // Catch: java.lang.Throwable -> L22
            goto L28
        L22:
            r5 = move-exception
            throw r5
        L24:
            java.lang.String r5 = com.huawei.secure.android.common.util.SafeString.substring(r5, r6)     // Catch: java.lang.Throwable -> L29
        L28:
            return r5
        L29:
            java.lang.String r0 = "StringUtils"
            java.lang.String r4 = "SafeString.substring error"
            com.huawei.hms.framework.common.Logger.w(r0, r4)
        L30:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r4 = 94
            if (r0 != 0) goto L3b
            r0 = 54
            goto L3d
        L3b:
            r0 = 94
        L3d:
            if (r0 == r4) goto L7d
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 77
            int r4 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L4d
            r0 = 0
            goto L4e
        L4d:
            r0 = 1
        L4e:
            if (r0 == r3) goto L5e
            int r0 = r5.length()     // Catch: java.lang.Exception -> L5c
            r3 = 40
            int r3 = r3 / r2
            if (r0 < r6) goto L7d
            goto L64
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            r5 = move-exception
            throw r5
        L5e:
            int r0 = r5.length()
            if (r0 < r6) goto L7d
        L64:
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 81
            int r2 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L76
            int r0 = r1.length     // Catch: java.lang.Throwable -> L74
            if (r6 < 0) goto L7d
            goto L78
        L74:
            r5 = move-exception
            throw r5
        L76:
            if (r6 < 0) goto L7d
        L78:
            java.lang.String r5 = r5.substring(r6)     // Catch: java.lang.Exception -> L7d
            return r5
        L7d:
            java.lang.String r5 = ""
            return r5
        L80:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.substring(java.lang.String, int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (MyBillsEntityDataFactory("com.huawei.secure.android.common.util.SafeString") != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String substring(java.lang.String r3, int r4, int r5) {
        /*
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 65
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            boolean r0 = com.huawei.hms.framework.common.StringUtils.getAuthRequestContext
            if (r0 != 0) goto L23
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L21
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L21
            int r0 = r0 % 2
            java.lang.String r0 = "com.huawei.secure.android.common.util.SafeString"
            boolean r0 = MyBillsEntityDataFactory(r0)
            if (r0 == 0) goto L2f
            goto L23
        L21:
            r3 = move-exception
            goto L89
        L23:
            java.lang.String r3 = com.huawei.secure.android.common.util.SafeString.substring(r3, r4, r5)     // Catch: java.lang.Throwable -> L28
            return r3
        L28:
            java.lang.String r0 = "StringUtils"
            java.lang.String r1 = "SafeString.substring error"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
        L2f:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L21
            if (r0 != 0) goto L86
            if (r4 < 0) goto L86
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 111
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L50
            int r0 = r3.length()
            r2 = 77
            int r2 = r2 / r1
            if (r5 > r0) goto L86
            goto L5f
        L4e:
            r3 = move-exception
            throw r3
        L50:
            int r0 = r3.length()     // Catch: java.lang.Exception -> L21
            r2 = 96
            if (r5 > r0) goto L5b
            r0 = 98
            goto L5d
        L5b:
            r0 = 96
        L5d:
            if (r0 == r2) goto L86
        L5f:
            if (r5 < r4) goto L62
            goto L63
        L62:
            r1 = 1
        L63:
            if (r1 == 0) goto L66
            goto L86
        L66:
            int r0 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            java.lang.String r3 = r3.substring(r4, r5)     // Catch: java.lang.Exception -> L86
            int r4 = com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 17
            int r5 = r4 % 128
            com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L85
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L83
            return r3
        L83:
            r3 = move-exception
            throw r3
        L85:
            return r3
        L86:
            java.lang.String r3 = ""
            return r3
        L89:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.substring(java.lang.String, int, int):java.lang.String");
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        int i = BuiltInFictitiousFunctionClassFactory + 123;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (getAuthRequestContext || MyBillsEntityDataFactory("com.huawei.secure.android.common.util.SafeString")) {
            try {
                return SafeString.replace(str, charSequence, charSequence2);
            } catch (Throwable unused) {
                Logger.w("StringUtils", "SafeString.substring error");
            }
        }
        if (!(TextUtils.isEmpty(str))) {
            try {
                if (!(TextUtils.isEmpty(charSequence))) {
                    int i3 = BuiltInFictitiousFunctionClassFactory + 117;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    try {
                        if (i3 % 2 != 0) {
                            str = str.replace(charSequence, charSequence2);
                        } else {
                            String replace = str.replace(charSequence, charSequence2);
                            Object[] objArr = null;
                            int length = objArr.length;
                            str = replace;
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return str;
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                getAuthRequestContext = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long stringToLong(String str, long j) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(str) ? 'D' : ']') != 'D') {
            try {
                j = Long.parseLong(str);
                int i3 = BuiltInFictitiousFunctionClassFactory + 39;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("String to Long catch NumberFormatException.");
                sb.append(anonymizeMessage(e.getMessage()));
                Logger.w("StringUtils", sb.toString());
            }
            return j;
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        int i6 = i5 % 2;
        return j;
    }

    public static int stringToInteger(String str, int i) {
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        if (!(TextUtils.isEmpty(str))) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("String to Integer catch NumberFormatException.");
                sb.append(anonymizeMessage(e.getMessage()));
                Logger.w("StringUtils", sb.toString());
                return i;
            }
        }
        int i4 = BuiltInFictitiousFunctionClassFactory + 23;
        KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
        if (!(i4 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return i;
        }
        return i;
    }

    public static boolean stringToBoolean(String str, boolean z) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        return Boolean.valueOf(str).booleanValue();
                    } catch (NumberFormatException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("String to Integer catch NumberFormatException.");
                        sb.append(anonymizeMessage(e.getMessage()));
                        Logger.w("StringUtils", sb.toString());
                        return z;
                    }
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                int i5 = BuiltInFictitiousFunctionClassFactory + 83;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
                return z;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        if (r5.isEmpty() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        r2 = new java.lang.StringBuilder();
        r5 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r5.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r2.append(r5.next());
        r2.append(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r5 = r2.toString().substring(0, r2.length() - 1);
        r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory + 79;
        com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String collection2String(java.util.Collection<java.lang.String> r5) {
        /*
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            r3 = 0
            if (r2 == r1) goto L5c
            int r2 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 15
            int r4 = r2 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L20
            boolean r2 = r5.isEmpty()
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1e
            if (r2 != 0) goto L5c
            goto L26
        L1e:
            r5 = move-exception
            throw r5
        L20:
            boolean r2 = r5.isEmpty()
            if (r2 != 0) goto L5c
        L26:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.Iterator r5 = r5.iterator()
        L2f:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r5.next()
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            java.lang.String r3 = ";"
            r2.append(r3)
            goto L2f
        L44:
            java.lang.String r5 = r2.toString()
            int r2 = r2.length()
            int r2 = r2 - r1
            java.lang.String r5 = r5.substring(r0, r2)
            int r0 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return r5
        L5c:
            int r5 = com.huawei.hms.framework.common.StringUtils.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 27
            int r2 = r5 % 128
            com.huawei.hms.framework.common.StringUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r5 = r5 % 2
            if (r5 != 0) goto L69
            goto L6a
        L69:
            r0 = 1
        L6a:
            if (r0 == r1) goto L70
            int r5 = r3.length     // Catch: java.lang.Throwable -> L6e
            return r3
        L6e:
            r5 = move-exception
            throw r5
        L70:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.StringUtils.collection2String(java.util.Collection):java.lang.String");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 0 : 'I') == 'I') {
                    break;
                }
                int i3 = $10 + 31;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
            char[] cArr = new char[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '4' : '\f') == '\f') {
                    objArr[0] = new String(cArr);
                    return;
                }
                int i5 = $11 + 89;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
