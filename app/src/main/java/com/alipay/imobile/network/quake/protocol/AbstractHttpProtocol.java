package com.alipay.imobile.network.quake.protocol;

import android.text.TextUtils;
import com.alipay.imobile.network.quake.transport.HttpDate;
import java.util.Date;
import java.util.Map;
import o.C;

/* loaded from: classes3.dex */
public abstract class AbstractHttpProtocol<T> implements Protocol<T> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 52115;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 1040;
    private static char MyBillsEntityDataFactory = 40926;
    private static char PlaceComponentResult = 24652;
    private static int getAuthRequestContext = 0;
    private static int scheduleImpl = 1;

    protected String parseCharset(Map<String, String> map) {
        int i = getAuthRequestContext + 23;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        c(5 - TextUtils.indexOf("", ""), new char[]{39652, 58689, 49184, 52424, 57369, 15790}, objArr);
        String parseCharset = parseCharset(map, ((String) objArr[0]).intern());
        int i3 = scheduleImpl + 75;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object obj = null;
            obj.hashCode();
            return parseCharset;
        }
        return parseCharset;
    }

    public String parseCharset(Map<String, String> map, String str) {
        try {
            int i = getAuthRequestContext + 71;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            try {
                if (map != null) {
                    String str2 = map.get("Content-Type");
                    if (str2 == null) {
                        return str;
                    }
                    String[] split = str2.split(";");
                    int length = split.length;
                    for (int i3 = 1; i3 < length; i3++) {
                        String[] split2 = split[i3].trim().split("=");
                        if (split2.length == 2) {
                            int i4 = scheduleImpl + 91;
                            getAuthRequestContext = i4 % 128;
                            if (i4 % 2 != 0) {
                                if (("charset".equals(split2[0]) ? '\n' : 'H') == '\n') {
                                    return split2[1];
                                }
                            } else {
                                if (("charset".equals(split2[0]) ? '8' : (char) 29) != 29) {
                                    return split2[1];
                                }
                            }
                        }
                    }
                    return str;
                }
                int i5 = scheduleImpl + 91;
                getAuthRequestContext = i5 % 128;
                int i6 = i5 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    protected long parseDateAsEpoch(String str) {
        int i = getAuthRequestContext + 85;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        Date parse = HttpDate.parse(str);
        if (parse == null) {
            int i3 = scheduleImpl + 3;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return 0L;
        }
        return parse.getTime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x019f, code lost:
    
        r11 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext + 43;
        r18 = r7;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl = r11 % 128;
        r11 = r11 % 2;
        r16 = r5 + (r19 - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b2, code lost:
    
        r18 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b4, code lost:
    
        r5 = r16;
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b7, code lost:
    
        r7 = new com.alipay.imobile.network.quake.cache.Cache.Entry();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01bc, code lost:
    
        r7.data = r26.data;
        r7.dataVersion = r8;
        r7.softExpireTime = r5;
        r7.finalExpireTime = r11;
        r7.lastModified = r14;
        r7.extData = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ce, code lost:
    
        if (com.alipay.iap.android.common.log.LoggerWrapper.isDebuggable() == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01d0, code lost:
    
        r2 = com.alipay.imobile.network.quake.Quake.TAG;
        r4 = new java.lang.StringBuilder();
        r4.append(r3);
        r4.append(r9);
        r4.append(", stale-while-revalidate=");
        r4.append(r0);
        r4.append(", must-revalidate=");
        r4.append(r18);
        r4.append(", softExpireTime=");
        r4.append(r5);
        r4.append(", finalExpireTime=");
        r4.append(r11);
        r4.append(", current=");
        r4.append(java.lang.System.currentTimeMillis());
        com.alipay.iap.android.common.log.LoggerWrapper.i(r2, r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0212, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0213, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0215, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        r4 = r0;
        r5 = java.lang.System.currentTimeMillis();
        r0 = r4.get("Date");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r0 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r9 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r12 = parseDateAsEpoch(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r0 = r4.get("Cache-Control");
        r9 = com.alipay.imobile.network.quake.Quake.TAG;
        r14 = new java.lang.StringBuilder();
        r14.append("headers.get(\"Cache-Control\")=");
        r14.append(r0);
        com.alipay.iap.android.common.log.LoggerWrapper.d(r9, r14.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        r14 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        r14 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (r14 == '7') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r9 = r0.split(",");
        r14 = r9.length;
        r7 = 0;
        r17 = 0;
        r19 = false;
        r20 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        if (r7 >= r14) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        r10 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        r10 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if (r10 == 'F') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
    
        r0 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl + 99;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        r0 = r9[r7].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
    
        if (io.split.android.client.network.SplitHttpHeadersBuilder.CACHE_CONTROL_NO_CACHE.equals(r0) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
    
        if ("no-store".equals(r0) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a6, code lost:
    
        if (r0.startsWith("max-age=") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
    
        r17 = java.lang.Long.parseLong(r0.substring(8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        if (r0.startsWith("stale-while-revalidate=") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
    
        r10 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext + 85;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
    
        if ((r10 % 2) != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c8, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ca, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cb, code lost:
    
        if (r10 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cf, code lost:
    
        r0 = r0.substring(23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
    
        r0 = r0.substring(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
    
        r20 = java.lang.Long.parseLong(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e6, code lost:
    
        if ("must-revalidate".equals(r0) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e8, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ea, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00eb, code lost:
    
        if (r10 == true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ed, code lost:
    
        r10 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext + 105;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
    
        if ("proxy-revalidate".equals(r0) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0100, code lost:
    
        r19 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0103, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0104, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0105, code lost:
    
        com.alipay.iap.android.common.log.LoggerWrapper.e(com.alipay.imobile.network.quake.Quake.TAG, "", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0110, code lost:
    
        r9 = r17;
        r0 = r19;
        r17 = r20;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0118, code lost:
    
        r0 = false;
        r7 = false;
        r9 = 0;
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x011e, code lost:
    
        r11 = r4.get(com.google.common.net.HttpHeaders.EXPIRES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0126, code lost:
    
        if (r11 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0128, code lost:
    
        r19 = parseDateAsEpoch(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012d, code lost:
    
        r19 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x012f, code lost:
    
        r11 = r4.get(com.google.common.net.HttpHeaders.LAST_MODIFIED);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0137, code lost:
    
        if (r11 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0139, code lost:
    
        r14 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext + 81;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl = r14 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0143, code lost:
    
        if ((r14 % 2) != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0145, code lost:
    
        r23 = parseDateAsEpoch(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0149, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0150, code lost:
    
        r23 = parseDateAsEpoch(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0154, code lost:
    
        r3 = "max-age=";
        r14 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0158, code lost:
    
        r3 = "max-age=";
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015b, code lost:
    
        r8 = r4.get("ETag");
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0163, code lost:
    
        if (r7 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0165, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0167, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0169, code lost:
    
        if (r7 == true) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x016b, code lost:
    
        r5 = r5 + (r9 * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0171, code lost:
    
        if (r0 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0173, code lost:
    
        r7 = r0;
        r0 = r17;
        r17 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0179, code lost:
    
        java.lang.Long.signum(r17);
        r7 = r0;
        r0 = r17;
        r17 = r5 + (r0 * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0183, code lost:
    
        r11 = com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.getAuthRequestContext + 123;
        com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.scheduleImpl = r11 % 128;
        r11 = r11 % 2;
        r11 = r17;
        r18 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0192, code lost:
    
        r7 = r0;
        r0 = r17;
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0199, code lost:
    
        if (r12 <= 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x019d, code lost:
    
        if (r19 < r12) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.imobile.network.quake.cache.Cache.Entry parseCacheHeaders(com.alipay.imobile.network.quake.NetworkResponse r26) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol.parseCacheHeaders(com.alipay.imobile.network.quake.NetworkResponse):com.alipay.imobile.network.quake.cache.Cache$Entry");
    }

    private static void c(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            int i2 = $10 + 61;
            $11 = i2 % 128;
            if (i2 % 2 == 0) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            int i3 = 58224;
            int i4 = $10 + 49;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = 0;
            while (true) {
                if ((i6 < 16 ? 'D' : '8') != 'D') {
                    break;
                }
                int i7 = $11 + 21;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i3) ^ ((cArr3[0] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i3) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                i3 -= 40503;
                i6++;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
