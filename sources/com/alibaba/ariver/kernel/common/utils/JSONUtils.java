package com.alibaba.ariver.kernel.common.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import o.D;

/* loaded from: classes2.dex */
public class JSONUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = -2791761391471757165L;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;

    public static JSONObject parseObject(String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                if (!(TextUtils.isEmpty(str))) {
                    try {
                        return JSON.parseObject(str);
                    } catch (Exception e) {
                        ExtHubLogger.e("parseObject error!", e);
                        return null;
                    }
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return null;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static JSONObject parseObject(byte[] bArr) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        JSONObject jSONObject = null;
        if (bArr == null) {
            return null;
        }
        try {
            Object[] objArr = new Object[1];
            a(1 - KeyEvent.getDeadChar(0, 0), new char[]{14702, 25186, 14651, 53950, 26359, 55117, 47118, 18091, 60602}, objArr);
            jSONObject = JSON.parseObject(new String(bArr, ((String) objArr[0]).intern()));
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            ExtHubLogger.e("parseObject error!", e);
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T parseObject(byte[] r3, java.lang.Class<T> r4) {
        /*
            r0 = 95
            if (r3 == 0) goto L6
            r1 = 1
            goto L8
        L6:
            r1 = 95
        L8:
            r2 = 0
            if (r1 == r0) goto L2f
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 59
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            int r0 = r3.length
            r1 = 34
            if (r0 != 0) goto L1d
            r0 = 34
            goto L1f
        L1d:
            r0 = 64
        L1f:
            if (r0 == r1) goto L2f
            r0 = 0
            com.alibaba.fastjson.parser.Feature[] r0 = new com.alibaba.fastjson.parser.Feature[r0]     // Catch: java.lang.Exception -> L29
            java.lang.Object r3 = com.alibaba.fastjson.JSON.parseObject(r3, r4, r0)     // Catch: java.lang.Exception -> L29
            goto L30
        L29:
            r3 = move-exception
            java.lang.String r4 = "parseObject error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r4, r3)
        L2f:
            r3 = r2
        L30:
            int r4 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 109
            int r0 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0
            int r4 = r4 % 2
            if (r4 != 0) goto L42
            r2.hashCode()     // Catch: java.lang.Throwable -> L40
            return r3
        L40:
            r3 = move-exception
            throw r3
        L42:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.parseObject(byte[], java.lang.Class):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r3 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r8.length == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        r8 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory + 77;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        r0 = new java.lang.Object[1];
        a(-android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0), new char[]{14702, 25186, 14651, 53950, 26359, 55117, 47118, 18091, 60602}, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        com.alibaba.exthub.common.ExtHubLogger.e("parseObject error!", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return (T) com.alibaba.fastjson.JSON.parseObject(new java.lang.String(r8, ((java.lang.String) r0[0]).intern()), (java.lang.Class) r9, r10, new com.alibaba.fastjson.parser.Feature[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T parseObject(byte[] r8, java.lang.Class<T> r9, com.alibaba.fastjson.parser.deserializer.ParseProcess r10) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r0 = r0 + 45
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r0 = 1
            r2 = 0
            if (r8 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = 1
        L11:
            r4 = 0
            if (r3 == r0) goto L8e
            int r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 43
            int r5 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r5
            int r3 = r3 % r1
            if (r3 != 0) goto L26
            int r3 = r8.length
            int r5 = r4.length     // Catch: java.lang.Throwable -> L24
            if (r3 != 0) goto L33
            goto L29
        L24:
            r8 = move-exception
            throw r8
        L26:
            int r3 = r8.length
            if (r3 != 0) goto L33
        L29:
            int r8 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r8 = r8 + 77
            int r9 = r8 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r9
            int r8 = r8 % r1
            goto L8e
        L33:
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L88
            java.lang.String r5 = ""
            r6 = 48
            int r5 = android.text.TextUtils.indexOf(r5, r6, r2)     // Catch: java.lang.Exception -> L88
            int r5 = -r5
            r6 = 9
            char[] r6 = new char[r6]     // Catch: java.lang.Exception -> L88
            r7 = 14702(0x396e, float:2.0602E-41)
            r6[r2] = r7     // Catch: java.lang.Exception -> L88
            r7 = 25186(0x6262, float:3.5293E-41)
            r6[r0] = r7     // Catch: java.lang.Exception -> L88
            r7 = 14651(0x393b, float:2.053E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 3
            r7 = 53950(0xd2be, float:7.56E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 4
            r7 = 26359(0x66f7, float:3.6937E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 5
            r7 = 55117(0xd74d, float:7.7235E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 6
            r7 = 47118(0xb80e, float:6.6026E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 7
            r7 = 18091(0x46ab, float:2.5351E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            r1 = 8
            r7 = 60602(0xecba, float:8.4921E-41)
            r6[r1] = r7     // Catch: java.lang.Exception -> L88
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L88
            a(r5, r6, r0)     // Catch: java.lang.Exception -> L88
            r0 = r0[r2]     // Catch: java.lang.Exception -> L88
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L88
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L88
            r3.<init>(r8, r0)     // Catch: java.lang.Exception -> L88
            com.alibaba.fastjson.parser.Feature[] r8 = new com.alibaba.fastjson.parser.Feature[r2]     // Catch: java.lang.Exception -> L88
            java.lang.Object r4 = com.alibaba.fastjson.JSON.parseObject(r3, r9, r10, r8)     // Catch: java.lang.Exception -> L88
            goto L8e
        L88:
            r8 = move-exception
            java.lang.String r9 = "parseObject error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r9, r8)
        L8e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.parseObject(byte[], java.lang.Class, com.alibaba.fastjson.parser.deserializer.ParseProcess):java.lang.Object");
    }

    public static JSONArray parseArray(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(str)) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    return null;
                }
                int i4 = 23 / 0;
                return null;
            }
            try {
                jSONArray = JSON.parseArray(str);
                try {
                    int i5 = MyBillsEntityDataFactory + 17;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                ExtHubLogger.e("parseArray error!", e2);
            }
            return jSONArray;
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r8 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r8 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> toStringArray(com.alibaba.fastjson.JSONArray r8) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 0
            if (r0 == r2) goto L1c
            r3.hashCode()     // Catch: java.lang.Throwable -> L1a
            if (r8 == 0) goto L4a
            goto L1e
        L1a:
            r8 = move-exception
            throw r8
        L1c:
            if (r8 == 0) goto L4a
        L1e:
            int r0 = r8.size()     // Catch: java.lang.Throwable -> L44
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L44
            r4.<init>()     // Catch: java.lang.Throwable -> L44
            r5 = 0
        L28:
            if (r5 >= r0) goto L2c
            r6 = 1
            goto L2d
        L2c:
            r6 = 0
        L2d:
            if (r6 == 0) goto L43
            java.lang.String r6 = r8.getString(r5)     // Catch: java.lang.Throwable -> L44
            r4.add(r6)     // Catch: java.lang.Throwable -> L44
            int r5 = r5 + 1
            int r6 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r6 = r6 + 103
            int r7 = r6 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % 2
            goto L28
        L43:
            return r4
        L44:
            r8 = move-exception
            java.lang.String r0 = "toStringArray error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r0, r8)
        L4a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.toStringArray(com.alibaba.fastjson.JSONArray):java.util.List");
    }

    public static Bundle toBundle(JSONObject jSONObject) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Bundle bundle = toBundle(null, jSONObject);
        try {
            int i3 = MyBillsEntityDataFactory + 3;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return bundle;
                }
                int i4 = 56 / 0;
                return bundle;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        if (r8 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        r8 = new android.os.Bundle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r9 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r9.isEmpty() != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r0 = r9.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r0.hasNext() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r4 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        r5 = r9.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        if ((r5 instanceof java.lang.Integer) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        r8.putInt(r4, ((java.lang.Integer) r5).intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if ((r5 instanceof java.lang.Boolean) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r6 = '-';
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        r6 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        if (r6 == '-') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if ((r5 instanceof java.lang.String) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        r8.putString(r4, (java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        if ((r5 instanceof java.lang.Long) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        r8.putLong(r4, ((java.lang.Long) r5).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
    
        if ((r5 instanceof java.lang.Double) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
    
        r6 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
    
        r6 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        if (r6 == 'N') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        r8.putDouble(r4, ((java.lang.Double) r5).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0097, code lost:
    
        if ((r5 instanceof java.lang.Float) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
    
        r8.putDouble(r4, new java.math.BigDecimal(java.lang.Float.toString(((java.lang.Float) r5).floatValue())).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        if ((r5 instanceof com.alibaba.fastjson.JSON) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
    
        r6 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b7, code lost:
    
        r6 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
    
        if (r6 == ';') goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bb, code lost:
    
        r8.putString(r4, ((com.alibaba.fastjson.JSON) r5).toJSONString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c4, code lost:
    
        r4 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d2, code lost:
    
        if ((r5 instanceof java.math.BigDecimal) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d4, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d7, code lost:
    
        if (r6 == true) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d9, code lost:
    
        r8.putDouble(r4, ((java.math.BigDecimal) r5).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e6, code lost:
    
        r6 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory + 77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ea, code lost:
    
        com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ee, code lost:
    
        r8.putBoolean(r4, ((java.lang.Boolean) r5).booleanValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f9, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fa, code lost:
    
        com.alibaba.exthub.common.ExtHubLogger.e("toBundle exception", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0101, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0102, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0103, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r8 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle toBundle(android.os.Bundle r8, com.alibaba.fastjson.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.toBundle(android.os.Bundle, com.alibaba.fastjson.JSONObject):android.os.Bundle");
    }

    public static String getString(JSONObject jSONObject, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String string = getString(jSONObject, str, "");
        int i3 = MyBillsEntityDataFactory + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return string;
        }
        return string;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            if (!(jSONObject.isEmpty())) {
                try {
                    if ((!jSONObject.containsKey(str) ? (char) 20 : 'I') == 20) {
                        int i = MyBillsEntityDataFactory + 89;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                        int i2 = i % 2;
                        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                        return str2;
                    }
                    try {
                        String string = jSONObject.getString(str);
                        if ((string != null ? '\b' : (char) 2) != '\b') {
                            return str2;
                        }
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 95;
                        MyBillsEntityDataFactory = i5 % 128;
                        int i6 = i5 % 2;
                        return string;
                    } catch (Throwable th) {
                        ExtHubLogger.e("Ariver", "getString exception!", th);
                        return str2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            MyBillsEntityDataFactory = i7 % 128;
            int i8 = i7 % 2;
            return str2;
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r2.containsKey(r3) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if ((!r2.containsKey(r3) ? 'I' : '5') != 'I') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r2 = r2.getBooleanValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getBoolean(com.alibaba.fastjson.JSONObject r2, java.lang.String r3, boolean r4) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r2 == 0) goto L57
            boolean r0 = r2.isEmpty()
            r1 = 94
            if (r0 != 0) goto L17
            r0 = 27
            goto L19
        L17:
            r0 = 94
        L19:
            if (r0 == r1) goto L57
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L36
            boolean r0 = r2.containsKey(r3)     // Catch: java.lang.Exception -> L34
            r1 = 46
            int r1 = r1 / 0
            if (r0 != 0) goto L45
            goto L54
        L32:
            r2 = move-exception
            throw r2
        L34:
            r2 = move-exception
            throw r2
        L36:
            boolean r0 = r2.containsKey(r3)     // Catch: java.lang.Exception -> L55
            r1 = 73
            if (r0 != 0) goto L41
            r0 = 73
            goto L43
        L41:
            r0 = 53
        L43:
            if (r0 == r1) goto L54
        L45:
            boolean r2 = r2.getBooleanValue(r3)     // Catch: java.lang.Throwable -> L57
            int r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 17
            int r4 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            return r2
        L54:
            return r4
        L55:
            r2 = move-exception
            throw r2
        L57:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.getBoolean(com.alibaba.fastjson.JSONObject, java.lang.String, boolean):boolean");
    }

    public static int getInt(JSONObject jSONObject, String str) {
        try {
            int i = MyBillsEntityDataFactory + 45;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 != 0) {
                }
                return getInt(jSONObject, str, 0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        if ((r4 == null) != true) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r4 != null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getInt(com.alibaba.fastjson.JSONObject r4, java.lang.String r5, int r6) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1b
            r0 = 26
            int r0 = r0 / r1
            if (r4 == 0) goto L50
            goto L22
        L19:
            r4 = move-exception
            throw r4
        L1b:
            if (r4 == 0) goto L1f
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            if (r0 == r2) goto L50
        L22:
            boolean r0 = r4.isEmpty()     // Catch: java.lang.Exception -> L4e
            if (r0 != 0) goto L50
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L4c
            int r0 = r0 + 61
            int r3 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L4c
            int r0 = r0 % 2
            boolean r0 = r4.containsKey(r5)     // Catch: java.lang.Exception -> L4c
            if (r0 != 0) goto L39
            goto L3a
        L39:
            r1 = 1
        L3a:
            if (r1 == r2) goto L3d
            return r6
        L3d:
            int r4 = r4.getIntValue(r5)     // Catch: java.lang.Throwable -> L50
            int r5 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r5 = r5 + 109
            int r6 = r5 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            return r4
        L4c:
            r4 = move-exception
            throw r4
        L4e:
            r4 = move-exception
            throw r4
        L50:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.getInt(com.alibaba.fastjson.JSONObject, java.lang.String, int):int");
    }

    public static long getLong(JSONObject jSONObject, String str) {
        int i = MyBillsEntityDataFactory + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            return getLong(jSONObject, str, 0L);
        }
        try {
            return getLong(jSONObject, str, 0L);
        } catch (Exception e) {
            throw e;
        }
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        try {
            if ((jSONObject != null ? 'A' : 'X') != 'X' && !jSONObject.isEmpty()) {
                try {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    if ((!jSONObject.containsKey(str) ? 'V' : 'J') != 'J') {
                        int i3 = MyBillsEntityDataFactory + 109;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        int i4 = i3 % 2;
                        int i5 = MyBillsEntityDataFactory + 105;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        if (i5 % 2 == 0) {
                            return j;
                        }
                        int i6 = 82 / 0;
                        return j;
                    }
                    try {
                        return jSONObject.getLongValue(str);
                    } catch (Throwable unused) {
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i7 = MyBillsEntityDataFactory + 21;
            KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
            int i8 = i7 % 2;
            return j;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static float getFloat(JSONObject jSONObject, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        MyBillsEntityDataFactory = i % 128;
        return getFloat(jSONObject, str, (i % 2 == 0 ? Typography.dollar : ']') != '$' ? 0.0f : 2.0f);
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        int i = MyBillsEntityDataFactory + 99;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (jSONObject != null && !jSONObject.isEmpty()) {
            if (!jSONObject.containsKey(str)) {
                int i3 = MyBillsEntityDataFactory + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? '(' : 'D') != '(') {
                    return f;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return f;
            }
            try {
                return jSONObject.getFloatValue(str);
            } catch (Throwable unused) {
            }
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r3.isEmpty() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (r3.isEmpty() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        if (r0 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        if (r3.containsKey(r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r3 = r3.getJSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r4 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory + 95;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if ((r4 % 2) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        r4 = '1';
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        r4 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
    
        if (r4 == '_') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r4 = 51 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006c, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.JSONObject getJSONObject(com.alibaba.fastjson.JSONObject r3, java.lang.String r4, com.alibaba.fastjson.JSONObject r5) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 17
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r3 == 0) goto L6f
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6d
            int r0 = r0 + 71
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L6d
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L2a
            boolean r0 = r3.isEmpty()
            r2 = 28
            int r2 = r2 / r1
            if (r0 != 0) goto L6f
            goto L30
        L28:
            r3 = move-exception
            throw r3
        L2a:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L6f
        L30:
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 19
            int r2 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L47
            boolean r0 = r3.containsKey(r4)     // Catch: java.lang.Exception -> L6d
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L45
            if (r0 != 0) goto L4e
            goto L4d
        L45:
            r3 = move-exception
            throw r3
        L47:
            boolean r0 = r3.containsKey(r4)     // Catch: java.lang.Exception -> L6d
            if (r0 != 0) goto L4e
        L4d:
            return r5
        L4e:
            com.alibaba.fastjson.JSONObject r3 = r3.getJSONObject(r4)     // Catch: java.lang.Throwable -> L6f
            int r4 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6d
            r5 = 95
            int r4 = r4 + r5
            int r0 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L6d
            int r4 = r4 % 2
            if (r4 == 0) goto L62
            r4 = 49
            goto L64
        L62:
            r4 = 95
        L64:
            if (r4 == r5) goto L6c
            r4 = 51
            int r4 = r4 / r1
            return r3
        L6a:
            r3 = move-exception
            throw r3
        L6c:
            return r3
        L6d:
            r3 = move-exception
            throw r3
        L6f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.getJSONObject(com.alibaba.fastjson.JSONObject, java.lang.String, com.alibaba.fastjson.JSONObject):com.alibaba.fastjson.JSONObject");
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (!(jSONObject == null) && !jSONObject.isEmpty()) {
            if (jSONObject.containsKey(str) ? false : true) {
                try {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    return jSONArray;
                } catch (Exception e) {
                    throw e;
                }
            }
            try {
                return jSONObject.getJSONArray(str);
            } catch (Throwable unused) {
            }
        }
        int i3 = MyBillsEntityDataFactory + 27;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return jSONArray;
    }

    public static boolean contains(JSONObject jSONObject, String str) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            if (jSONObject != null) {
                if (!(jSONObject.isEmpty()) && jSONObject.containsKey(str)) {
                    return true;
                }
            }
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        if (r4 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r4.isEmpty() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory + 89;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if ((r0 % 2) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r0 == true) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        if (r4.containsKey(r5) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        if (r1 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:
    
        r3 = 90 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0042, code lost:
    
        if (r4.containsKey(r5) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0044, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0045, code lost:
    
        if (r1 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        return (T) r4.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004f, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
    
        if (r4 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T getValue(com.alibaba.fastjson.JSONObject r4, java.lang.String r5, T r6) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L52
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L50
            int r0 = r0 % 2
            if (r0 != 0) goto L15
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L13
            if (r4 == 0) goto L4f
            goto L17
        L13:
            r4 = move-exception
            throw r4
        L15:
            if (r4 == 0) goto L4f
        L17:
            boolean r0 = r4.isEmpty()     // Catch: java.lang.Exception -> L52
            if (r0 != 0) goto L4f
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L52
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2d
            r0 = 1
            goto L2e
        L2d:
            r0 = 0
        L2e:
            if (r0 == r1) goto L3b
            boolean r0 = r4.containsKey(r5)
            if (r0 != 0) goto L37
            goto L38
        L37:
            r1 = 0
        L38:
            if (r1 == 0) goto L47
            goto L4c
        L3b:
            boolean r0 = r4.containsKey(r5)
            r3 = 90
            int r3 = r3 / r2
            if (r0 != 0) goto L45
            r1 = 0
        L45:
            if (r1 == 0) goto L4c
        L47:
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Exception -> L50
            return r4
        L4c:
            return r6
        L4d:
            r4 = move-exception
            throw r4
        L4f:
            return r6
        L50:
            r4 = move-exception
            throw r4
        L52:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.getValue(com.alibaba.fastjson.JSONObject, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static JSONObject deepCopy(JSONObject jSONObject) {
        Object[] objArr = null;
        try {
            try {
                if ((jSONObject == null ? '_' : '3') != '3') {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                for (String str : jSONObject.keySet()) {
                    Object obj = jSONObject.get(str);
                    if ((obj instanceof JSONArray ? '\f' : '\'') == '\f') {
                        int i3 = MyBillsEntityDataFactory + 87;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        if (i3 % 2 != 0) {
                            jSONObject2.put(str, (Object) deepCopy((JSONArray) obj));
                            int length = objArr.length;
                        } else {
                            jSONObject2.put(str, (Object) deepCopy((JSONArray) obj));
                        }
                    } else if (obj instanceof JSONObject) {
                        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                        MyBillsEntityDataFactory = i4 % 128;
                        char c = i4 % 2 == 0 ? '`' : (char) 29;
                        jSONObject2.put(str, (Object) deepCopy((JSONObject) obj));
                        if (c != '`') {
                            continue;
                        } else {
                            int length2 = objArr.length;
                        }
                    } else {
                        jSONObject2.put(str, obj);
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
                        MyBillsEntityDataFactory = i5 % 128;
                        int i6 = i5 % 2;
                    }
                }
                return jSONObject2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static JSONArray deepCopy(JSONArray jSONArray) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'C' : 'X') == 'C') {
            int i2 = 9 / 0;
            if (jSONArray == null) {
                return null;
            }
        } else if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            Iterator<Object> it = jSONArray.iterator();
            while (true) {
                if (!(it.hasNext())) {
                    return jSONArray2;
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                Object next = it.next();
                if ((next instanceof JSONArray ? '?' : ',') != ',') {
                    jSONArray2.add(deepCopy((JSONArray) next));
                } else if (next instanceof JSONObject) {
                    jSONArray2.add(deepCopy((JSONObject) next));
                } else {
                    jSONArray2.add(next);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static <T> Map<String, T> jsonToMap(JSONObject jSONObject, Map<String, T> map) {
        if (jSONObject != null) {
            try {
                int i = MyBillsEntityDataFactory + 27;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                if (!(jSONObject.isEmpty())) {
                    map = new HashMap();
                    Iterator<String> it = jSONObject.keySet().iterator();
                    int i3 = MyBillsEntityDataFactory + 57;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    while (it.hasNext()) {
                        try {
                            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                            MyBillsEntityDataFactory = i5 % 128;
                            if (i5 % 2 != 0) {
                                String next = it.next();
                                map.put(next, jSONObject.get(next));
                            } else {
                                String next2 = it.next();
                                map.put(next2, jSONObject.get(next2));
                                int i6 = 78 / 0;
                            }
                        } catch (Throwable th) {
                            ExtHubLogger.e("Ariver", th);
                        }
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return map;
    }

    public static Integer getColorInt(JSONObject jSONObject, String str) {
        Object[] objArr = null;
        try {
            if ((jSONObject == null ? 'S' : '`') == '`') {
                try {
                    Object obj = jSONObject.get(str);
                    if (obj == null) {
                        return null;
                    }
                    return TypeUtils.parseColorInt(obj);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i = MyBillsEntityDataFactory + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'R' : 'D') != 'D') {
                int length = objArr.length;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static Long getColorLong(JSONObject jSONObject, String str) {
        Object[] objArr = null;
        if (jSONObject != null) {
            Object obj = jSONObject.get(str);
            if ((obj == null ? 'H' : ')') != ')') {
                int i = MyBillsEntityDataFactory + 27;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    int length = objArr.length;
                    return null;
                }
                return null;
            }
            return TypeUtils.parseColorLong(obj);
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        MyBillsEntityDataFactory = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 1 : '+') != '+') {
            int i5 = 92 / 0;
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if ((r3 == null ? 30 : 'V') != 'V') goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r3 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        r3 = new byte[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 91;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((r0 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r0 == true) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r0 = 3 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:
    
        r0 = android.os.Parcel.obtain();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0040, code lost:
    
        r0.writeSerializable(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
    
        return r0.marshall();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0050, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0051, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] marshallJSONObject(com.alibaba.fastjson.JSONObject r3) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1e
            r0 = 63
            int r0 = r0 / r1
            r0 = 86
            if (r3 != 0) goto L17
            r2 = 30
            goto L19
        L17:
            r2 = 86
        L19:
            if (r2 == r0) goto L3c
            goto L20
        L1c:
            r3 = move-exception
            throw r3
        L1e:
            if (r3 != 0) goto L3c
        L20:
            byte[] r3 = new byte[r1]
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L3a
            int r0 = r0 + 91
            int r2 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L3a
            int r0 = r0 % 2
            r2 = 1
            if (r0 != 0) goto L31
            r0 = 1
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == r2) goto L35
            return r3
        L35:
            r0 = 3
            int r0 = r0 / r1
            return r3
        L38:
            r3 = move-exception
            throw r3
        L3a:
            r3 = move-exception
            throw r3
        L3c:
            android.os.Parcel r0 = android.os.Parcel.obtain()     // Catch: java.lang.Exception -> L50
            r0.writeSerializable(r3)     // Catch: java.lang.Throwable -> L4b
            byte[] r3 = r0.marshall()     // Catch: java.lang.Throwable -> L4b
            r0.recycle()     // Catch: java.lang.Exception -> L50
            return r3
        L4b:
            r3 = move-exception
            r0.recycle()
            throw r3
        L50:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.marshallJSONObject(com.alibaba.fastjson.JSONObject):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        if (r4 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:
    
        if (r4 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        if (r4.length == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0023, code lost:
    
        r0 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        r0 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        if (r0 == '<') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        r0 = android.os.Parcel.obtain();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r0.unmarshall(r4, 0, r4.length);
        r0.setDataPosition(0);
        r4 = (com.alibaba.fastjson.JSONObject) r0.readSerializable();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        com.alibaba.exthub.common.ExtHubLogger.e("AriverKernel", "unmarshallJSONObject error!", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        r0.recycle();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0064, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:
    
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.JSONObject unmarshallJSONObject(byte[] r4) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L71
            int r0 = r0 + 99
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L71
            int r0 = r0 % 2
            r1 = 73
            if (r0 != 0) goto L11
            r0 = 73
            goto L13
        L11:
            r0 = 36
        L13:
            r2 = 0
            if (r0 == r1) goto L19
            if (r4 == 0) goto L69
            goto L1e
        L19:
            r0 = 37
            int r0 = r0 / r2
            if (r4 == 0) goto L69
        L1e:
            int r0 = r4.length
            r1 = 60
            if (r0 == 0) goto L26
            r0 = 67
            goto L28
        L26:
            r0 = 60
        L28:
            if (r0 == r1) goto L69
            android.os.Parcel r0 = android.os.Parcel.obtain()
            int r1 = r4.length     // Catch: java.lang.Throwable -> L3f
            r0.unmarshall(r4, r2, r1)     // Catch: java.lang.Throwable -> L3f
            r0.setDataPosition(r2)     // Catch: java.lang.Throwable -> L3f
            java.io.Serializable r4 = r0.readSerializable()     // Catch: java.lang.Throwable -> L3f
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch: java.lang.Throwable -> L3f
            r0.recycle()
            goto L4b
        L3f:
            r4 = move-exception
            java.lang.String r1 = "AriverKernel"
            java.lang.String r3 = "unmarshallJSONObject error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r1, r3, r4)     // Catch: java.lang.Throwable -> L64
            r0.recycle()
            r4 = 0
        L4b:
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto L5a
            r0 = 1
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 == r1) goto L5e
            return r4
        L5e:
            r0 = 29
            int r0 = r0 / r2
            return r4
        L62:
            r4 = move-exception
            throw r4
        L64:
            r4 = move-exception
            r0.recycle()
            throw r4
        L69:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            return r4
        L6f:
            r4 = move-exception
            throw r4
        L71:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.unmarshallJSONObject(byte[]):com.alibaba.fastjson.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Parcel] */
    public static byte[] marshallJSONArray(JSONArray jSONArray) {
        byte[] bArr;
        int i = MyBillsEntityDataFactory + 91;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Parcel parcel = i % 2 != 0 ? 1 : 0;
        try {
            if (parcel != 1) {
                Parcel obtain = Parcel.obtain();
                obtain.writeSerializable(jSONArray);
                bArr = obtain.marshall();
            } else {
                Parcel obtain2 = Parcel.obtain();
                obtain2.writeSerializable(jSONArray);
                bArr = obtain2.marshall();
                obtain2.recycle();
                parcel = 23 / 0;
            }
        } catch (Throwable th) {
            try {
                ExtHubLogger.e("AriverKernel", "marshallJSONArray", th);
                parcel.recycle();
                bArr = null;
            } finally {
                parcel.recycle();
            }
        }
        int i2 = MyBillsEntityDataFactory + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if ((r4 != null ? 'E' : 'S') != 'S') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r4.length == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        r0 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        if (r0 == 26) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 39;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        r0 = android.os.Parcel.obtain();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r0.unmarshall(r4, 0, r4.length);
        r0.setDataPosition(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        com.alibaba.exthub.common.ExtHubLogger.e("AriverKernel", "unmarshallJSONObject error!", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return (com.alibaba.fastjson.JSONArray) r0.readSerializable();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r4 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.JSONArray unmarshallJSONArray(byte[] r4) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r2 = 0
            if (r0 == 0) goto L16
            if (r4 == 0) goto L62
            goto L22
        L16:
            int r0 = r2.length     // Catch: java.lang.Throwable -> L68
            r0 = 83
            if (r4 == 0) goto L1e
            r3 = 69
            goto L20
        L1e:
            r3 = 83
        L20:
            if (r3 == r0) goto L62
        L22:
            int r0 = r4.length
            r3 = 26
            if (r0 == 0) goto L2a
            r0 = 26
            goto L2c
        L2a:
            r0 = 79
        L2c:
            if (r0 == r3) goto L2f
            goto L62
        L2f:
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 39
            int r3 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L60
            int r0 = r0 % 2
            android.os.Parcel r0 = android.os.Parcel.obtain()
            int r3 = r4.length     // Catch: java.lang.Throwable -> L4f
            r0.unmarshall(r4, r1, r3)     // Catch: java.lang.Throwable -> L4f
            r0.setDataPosition(r1)     // Catch: java.lang.Throwable -> L4f
            java.io.Serializable r4 = r0.readSerializable()     // Catch: java.lang.Throwable -> L4f
            com.alibaba.fastjson.JSONArray r4 = (com.alibaba.fastjson.JSONArray) r4     // Catch: java.lang.Throwable -> L4f
            r0.recycle()
            r2 = r4
            goto L5a
        L4f:
            r4 = move-exception
            java.lang.String r1 = "AriverKernel"
            java.lang.String r3 = "unmarshallJSONObject error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r1, r3, r4)     // Catch: java.lang.Throwable -> L5b
            r0.recycle()
        L5a:
            return r2
        L5b:
            r4 = move-exception
            r0.recycle()
            throw r4
        L60:
            r4 = move-exception
            throw r4
        L62:
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            return r4
        L68:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.unmarshallJSONArray(byte[]):com.alibaba.fastjson.JSONArray");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if ((r3 == null ? kotlin.text.Typography.quote : 'X') != '\"') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if ((r3 == null) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 51;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if ((r3 % 2) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        r3 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        com.alibaba.exthub.common.ExtHubLogger.e("AriverKernel", "JSONObject to String error!", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String toString(com.alibaba.fastjson.JSONObject r3) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            r2 = 0
            if (r0 != 0) goto L20
            r0 = 30
            int r0 = r0 / r2
            r0 = 34
            if (r3 != 0) goto L19
            r2 = 34
            goto L1b
        L19:
            r2 = 88
        L1b:
            if (r2 == r0) goto L25
            goto L39
        L1e:
            r3 = move-exception
            throw r3
        L20:
            if (r3 != 0) goto L23
            r2 = 1
        L23:
            if (r2 == 0) goto L39
        L25:
            int r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L37
            int r3 = r3 + 51
            int r0 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L37
            int r3 = r3 % 2
            if (r3 != 0) goto L36
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L34
            return r1
        L34:
            r3 = move-exception
            throw r3
        L36:
            return r1
        L37:
            r3 = move-exception
            throw r3
        L39:
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L48
            int r0 = com.alibaba.ariver.kernel.common.utils.JSONUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 101
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.JSONUtils.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r3
        L48:
            r3 = move-exception
            java.lang.String r0 = "AriverKernel"
            java.lang.String r2 = "JSONObject to String error!"
            com.alibaba.exthub.common.ExtHubLogger.e(r0, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.JSONUtils.toString(com.alibaba.fastjson.JSONObject):java.lang.String");
    }

    public static JSONObject mergeJsonWhitoutRecursive(JSONObject jSONObject, JSONObject jSONObject2) {
        if ((jSONObject2 != null ? (char) 27 : (char) 23) == 27) {
            if ((jSONObject2.isEmpty() ? (char) 3 : (char) 0) == 0) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<Map.Entry<String, Object>> it = jSONObject2.entrySet().iterator();
                while (true) {
                    if (!(it.hasNext())) {
                        break;
                    }
                    Map.Entry<String, Object> next = it.next();
                    jSONObject.put(next.getKey(), next.getValue());
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                }
            } else {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                MyBillsEntityDataFactory = i5 % 128;
                int i6 = i5 % 2;
            }
        }
        return jSONObject;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            try {
                if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? '0' : '6') != '6') {
                    try {
                        int i2 = $11 + 85;
                        $10 = i2 % 128;
                        int i3 = i2 % 2;
                        d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                        KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
                        d.MyBillsEntityDataFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    int i4 = $11 + 93;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
