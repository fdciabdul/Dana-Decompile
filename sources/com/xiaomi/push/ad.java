package com.xiaomi.push;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import o.A;

/* loaded from: classes8.dex */
public class ad {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 269894776;
    private static int PlaceComponentResult = 1;

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(getAuthRequestContext(str));
                str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
                int i3 = BuiltInFictitiousFunctionClassFactory + 109;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (NoSuchAlgorithmException unused) {
            }
            return str;
        }
        return null;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                return stringBuffer.toString();
            }
            int i3 = PlaceComponentResult + 81;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 == 0) {
                stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
                i2++;
            } else {
                stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(94)));
                i2 += 9;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r4 <= 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if ((r4 <= 1 ? '\\' : '(') != '(') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (r2 <= 3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        if ((r2 >> r5) == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
    
        if ((r2 % r5 == 0 ? 15 : 16) != 15) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r0.append(r8.charAt(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
    
        r0.append("*");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0084, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String MyBillsEntityDataFactory(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> La3
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == r2) goto L8b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r3 = r8.length()
            r4 = 38
            r5 = 3
            if (r3 >= r5) goto L1e
            r6 = 38
            goto L20
        L1e:
            r6 = 84
        L20:
            if (r6 == r4) goto L23
            goto L47
        L23:
            int r4 = com.xiaomi.push.ad.PlaceComponentResult
            int r4 = r4 + 57
            int r6 = r4 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r6
            int r4 = r4 % 2
            if (r4 == 0) goto L36
            int r4 = r3 >> 5
            if (r4 > r2) goto L34
            goto L43
        L34:
            r2 = r4
            goto L43
        L36:
            int r4 = r3 / 3
            r6 = 40
            if (r4 > r2) goto L3f
            r7 = 92
            goto L41
        L3f:
            r7 = 40
        L41:
            if (r7 == r6) goto L34
        L43:
            if (r2 <= r5) goto L46
            goto L47
        L46:
            r5 = r2
        L47:
            int r2 = com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 29
            int r4 = r2 % 128
            com.xiaomi.push.ad.PlaceComponentResult = r4
            int r2 = r2 % 2
        L51:
            if (r1 >= r3) goto L86
            int r2 = com.xiaomi.push.ad.PlaceComponentResult
            int r2 = r2 + 99
            int r4 = r2 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r4
            int r2 = r2 % 2
            if (r2 == 0) goto L66
            int r2 = r1 >>> 0
            int r4 = r2 >> r5
            if (r4 != 0) goto L75
            goto L7d
        L66:
            int r2 = r1 + 1
            int r4 = r2 % r5
            r6 = 15
            if (r4 != 0) goto L71
            r4 = 15
            goto L73
        L71:
            r4 = 16
        L73:
            if (r4 == r6) goto L7d
        L75:
            char r1 = r8.charAt(r1)     // Catch: java.lang.Exception -> La3
            r0.append(r1)     // Catch: java.lang.Exception -> La3
            goto L82
        L7d:
            java.lang.String r1 = "*"
            r0.append(r1)     // Catch: java.lang.Exception -> L84
        L82:
            r1 = r2
            goto L51
        L84:
            r8 = move-exception
            throw r8
        L86:
            java.lang.String r8 = r0.toString()
            return r8
        L8b:
            int r8 = com.xiaomi.push.ad.PlaceComponentResult
            int r8 = r8 + 99
            int r0 = r8 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r0
            int r8 = r8 % 2
            if (r8 == 0) goto L98
            goto L99
        L98:
            r1 = 1
        L99:
            if (r1 == r2) goto La0
            r8 = 0
            int r8 = r8.length     // Catch: java.lang.Throwable -> L9e
            goto La0
        L9e:
            r8 = move-exception
            throw r8
        La0:
            java.lang.String r8 = ""
            return r8
        La3:
            r8 = move-exception
            goto La6
        La5:
            throw r8
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ad.MyBillsEntityDataFactory(java.lang.String):java.lang.String");
    }

    public static String MyBillsEntityDataFactory(Object[] objArr, String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 109;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            String authRequestContext = getAuthRequestContext(objArr, str, objArr.length);
            int i3 = BuiltInFictitiousFunctionClassFactory + 39;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r0 == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String PlaceComponentResult(java.lang.String r3) {
        /*
            int r0 = com.xiaomi.push.ad.PlaceComponentResult
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 57
            if (r0 == 0) goto L11
            r0 = 57
            goto L13
        L11:
            r0 = 69
        L13:
            if (r0 == r1) goto L1c
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L56
            if (r0 != 0) goto L47
            goto L24
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L56
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L47
        L24:
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.security.NoSuchAlgorithmException -> L46
            byte[] r1 = getAuthRequestContext(r3)     // Catch: java.security.NoSuchAlgorithmException -> L46
            r0.update(r1)     // Catch: java.security.NoSuchAlgorithmException -> L46
            java.math.BigInteger r1 = new java.math.BigInteger     // Catch: java.security.NoSuchAlgorithmException -> L46
            byte[] r0 = r0.digest()     // Catch: java.security.NoSuchAlgorithmException -> L46
            r2 = 1
            r1.<init>(r2, r0)     // Catch: java.security.NoSuchAlgorithmException -> L46
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.security.NoSuchAlgorithmException -> L46
            r2 = 0
            r0[r2] = r1     // Catch: java.security.NoSuchAlgorithmException -> L46
            java.lang.String r1 = "%1$032X"
            java.lang.String r3 = java.lang.String.format(r1, r0)     // Catch: java.security.NoSuchAlgorithmException -> L46
        L46:
            return r3
        L47:
            java.lang.String r3 = ""
            int r0 = com.xiaomi.push.ad.PlaceComponentResult
            int r0 = r0 + 27
            int r1 = r0 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            return r3
        L54:
            r3 = move-exception
            throw r3
        L56:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ad.PlaceComponentResult(java.lang.String):java.lang.String");
    }

    public static String PlaceComponentResult(Collection<?> collection, String str) {
        int i = PlaceComponentResult + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if ((collection == null ? (char) 23 : ']') != ']') {
            int i3 = PlaceComponentResult + 71;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return null;
        }
        return PlaceComponentResult(collection.iterator(), str);
    }

    private static String PlaceComponentResult(Iterator<?> it, String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 53;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 69;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int length = objArr.length;
                return "";
            }
            return "";
        }
        Object next = it.next();
        try {
            if (!it.hasNext()) {
                try {
                    int i4 = PlaceComponentResult + 69;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    int i5 = i4 % 2;
                    return next.toString();
                } catch (Exception e) {
                    throw e;
                }
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            if (next != null) {
                stringBuffer.append(next);
            }
            while (true) {
                if (!(it.hasNext())) {
                    return stringBuffer.toString();
                }
                int i6 = BuiltInFictitiousFunctionClassFactory + 21;
                PlaceComponentResult = i6 % 128;
                int i7 = i6 % 2;
                if ((str != null ? '@' : '3') != '3') {
                    int i8 = BuiltInFictitiousFunctionClassFactory + 93;
                    PlaceComponentResult = i8 % 128;
                    int i9 = i8 % 2;
                    stringBuffer.append(str);
                }
                Object next2 = it.next();
                if (next2 != null) {
                    stringBuffer.append(next2);
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r8 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r8 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r1 = r9 + 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r1 > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        r2 = r7[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r4 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r2 = r2.toString().length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        r2 = com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory + 9;
        com.xiaomi.push.ad.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
        r2 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        r4 = new java.lang.StringBuffer(r1 * (r2 + r8.length()));
        r1 = com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory + 53;
        com.xiaomi.push.ad.PlaceComponentResult = r1 % 128;
        r1 = r1 % 2;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if (r1 >= r9) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if (r2 == true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        return r4.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        if (r1 <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        r4.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        r2 = r7[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0070, code lost:
    
        if (r2 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        r6 = ')';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        r6 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0077, code lost:
    
        if (r6 == ')') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        r4.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r7 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getAuthRequestContext(java.lang.Object[] r7, java.lang.String r8, int r9) {
        /*
            int r0 = com.xiaomi.push.ad.PlaceComponentResult
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L15
            r1.hashCode()     // Catch: java.lang.Throwable -> L13
            if (r7 != 0) goto L18
            goto L17
        L13:
            r7 = move-exception
            throw r7
        L15:
            if (r7 != 0) goto L18
        L17:
            return r1
        L18:
            java.lang.String r0 = ""
            if (r8 != 0) goto L1d
            r8 = r0
        L1d:
            int r1 = r9 + 0
            if (r1 > 0) goto L22
            return r0
        L22:
            r0 = 0
            r2 = r7[r0]
            r3 = 1
            if (r2 != 0) goto L2a
            r4 = 0
            goto L2b
        L2a:
            r4 = 1
        L2b:
            if (r4 == 0) goto L36
            java.lang.String r2 = r2.toString()
            int r2 = r2.length()
            goto L42
        L36:
            int r2 = com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 9
            int r4 = r2 % 128
            com.xiaomi.push.ad.PlaceComponentResult = r4
            int r2 = r2 % 2
            r2 = 16
        L42:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            int r5 = r8.length()
            int r2 = r2 + r5
            int r1 = r1 * r2
            r4.<init>(r1)
            int r1 = com.xiaomi.push.ad.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 53
            int r2 = r1 % 128
            com.xiaomi.push.ad.PlaceComponentResult = r2
            int r1 = r1 % 2
            r1 = 0
        L59:
            if (r1 >= r9) goto L5d
            r2 = 1
            goto L5e
        L5d:
            r2 = 0
        L5e:
            if (r2 == r3) goto L67
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L65
            return r7
        L65:
            r7 = move-exception
            throw r7
        L67:
            if (r1 <= 0) goto L6c
            r4.append(r8)
        L6c:
            r2 = r7[r1]
            r5 = 41
            if (r2 == 0) goto L75
            r6 = 41
            goto L77
        L75:
            r6 = 87
        L77:
            if (r6 == r5) goto L7a
            goto L7d
        L7a:
            r4.append(r2)
        L7d:
            int r1 = r1 + 1
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ad.getAuthRequestContext(java.lang.Object[], java.lang.String, int):java.lang.String");
    }

    private static byte[] getAuthRequestContext(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(new char[]{17, 16, 2, 65513, 65524}, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 161, 5 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), false, 5 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            int i3 = BuiltInFictitiousFunctionClassFactory + 17;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return bytes;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        int i4 = $11 + 91;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if (!(a2.MyBillsEntityDataFactory < i2)) {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr2[i6] = (char) (cArr2[i6] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if ((i3 > 0 ? (char) 2 : 'T') != 'T') {
            int i7 = $10 + 57;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                int i9 = $10 + 73;
                $11 = i9 % 128;
                int i10 = i9 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        if (z) {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? '#' : 'W') == 'W') {
                    break;
                }
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
                int i11 = $10 + 111;
                $11 = i11 % 128;
                int i12 = i11 % 2;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
