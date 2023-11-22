package com.ta.audid.e;

import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.ta.audid.g.h;
import com.ta.audid.g.m;
import o.getCallingPid;

/* loaded from: classes.dex */
public class e {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char[] MyBillsEntityDataFactory = {37275, 37257, 37252, 37254, 37367, 37346, 37255, 37253, 37274};
    private static char PlaceComponentResult = 42070;
    private static int getAuthRequestContext;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if ((android.text.TextUtils.isEmpty(r9)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        r9 = com.ta.audid.e.e.getAuthRequestContext + 65;
        com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 = r9 % 128;
        r9 = r9 % 2;
        r9 = com.ta.audid.e.e.getAuthRequestContext + 1;
        com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r3 = new java.lang.Object[1];
        a(new char[]{6, 2, 2, 4, 13757}, (byte) (27 - android.view.KeyEvent.getDeadChar(0, 0)), (android.media.AudioTrack.getMaxVolume() > 0.0f ? 1 : (android.media.AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 4, r3);
        r9 = com.ta.utdid2.a.a.b.decode(r9.getBytes(((java.lang.String) r3[0]).intern()), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r9 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        r0 = new java.lang.String(com.ta.audid.g.h.b(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r9 = com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 + 117;
        com.ta.audid.e.e.getAuthRequestContext = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
    
        com.ta.audid.g.m.e("", r9, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r9) {
        /*
            int r0 = com.ta.audid.e.e.getAuthRequestContext
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 21
            if (r0 != 0) goto L11
            r0 = 21
            goto L13
        L11:
            r0 = 92
        L13:
            r3 = 1
            java.lang.String r4 = ""
            r5 = 0
            if (r0 == r2) goto L20
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L40
            goto L2e
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r2 = 15
            int r2 = r2 / r5
            if (r0 == 0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            if (r0 == 0) goto L40
        L2e:
            int r9 = com.ta.audid.e.e.getAuthRequestContext
            int r9 = r9 + 65
            int r0 = r9 % 128
            com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r9 = r9 % r1
            int r9 = com.ta.audid.e.e.getAuthRequestContext
            int r9 = r9 + r3
            int r0 = r9 % 128
            com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r9 = r9 % r1
            return r4
        L40:
            r0 = 5
            char[] r0 = new char[r0]     // Catch: java.lang.Exception -> L8c
            r2 = 6
            r0[r5] = r2     // Catch: java.lang.Exception -> L8c
            r0[r3] = r1     // Catch: java.lang.Exception -> L8c
            r0[r1] = r1     // Catch: java.lang.Exception -> L8c
            r2 = 3
            r6 = 4
            r0[r2] = r6     // Catch: java.lang.Exception -> L8c
            r2 = 13757(0x35bd, float:1.9278E-41)
            r0[r6] = r2     // Catch: java.lang.Exception -> L8c
            int r2 = android.view.KeyEvent.getDeadChar(r5, r5)     // Catch: java.lang.Exception -> L8c
            int r2 = 27 - r2
            byte r2 = (byte) r2     // Catch: java.lang.Exception -> L8c
            float r7 = android.media.AudioTrack.getMaxVolume()     // Catch: java.lang.Exception -> L8c
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            int r7 = r7 + r6
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L8c
            a(r0, r2, r7, r3)     // Catch: java.lang.Exception -> L8c
            r0 = r3[r5]     // Catch: java.lang.Exception -> L8c
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L8c
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L8c
            byte[] r9 = r9.getBytes(r0)     // Catch: java.lang.Exception -> L8c
            byte[] r9 = com.ta.utdid2.a.a.b.decode(r9, r1)     // Catch: java.lang.Exception -> L8c
            if (r9 == 0) goto L92
            byte[] r9 = com.ta.audid.g.h.b(r9)     // Catch: java.lang.Exception -> L8c
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Exception -> L8c
            r0.<init>(r9)     // Catch: java.lang.Exception -> L8c
            int r9 = com.ta.audid.e.e.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 + 117
            int r2 = r9 % 128
            com.ta.audid.e.e.getAuthRequestContext = r2
            int r9 = r9 % r1
            r4 = r0
            goto L92
        L8c:
            r9 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.ta.audid.g.m.e(r4, r9, r0)
        L92:
            return r4
        L93:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.audid.e.e.d(java.lang.String):java.lang.String");
    }

    public static String e(String str) {
        String str2 = "";
        if (!(TextUtils.isEmpty(str))) {
            try {
                byte[] encode = com.ta.utdid2.a.a.b.encode(h.b(str.getBytes()), 2);
                Object[] objArr = new Object[1];
                a(new char[]{6, 2, 2, 4, 13757}, (byte) ((Process.myPid() >> 22) + 27), KeyEvent.normalizeMetaState(0) + 5, objArr);
                str2 = new String(encode, ((String) objArr[0]).intern());
            } catch (Exception e) {
                m.e("", e, new Object[0]);
            }
            int i = getAuthRequestContext + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return str2;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr2 = null;
            int length = objArr2.length;
        }
        return "";
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (i3 < length) {
                int i4 = $11 + 33;
                $10 = i4 % 128;
                if ((i4 % 2 != 0 ? '9' : (char) 18) != 18) {
                    cArr3[i3] = (char) (cArr2[i3] - 1549216646985767851L);
                    i3 %= 1;
                } else {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    i3++;
                }
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            try {
                int i5 = $11 + 81;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                getcallingpid.getAuthRequestContext = 0;
                while (getcallingpid.getAuthRequestContext < i2) {
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? (char) 24 : 'c') != 24) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            int i7 = $10 + 59;
                            $11 = i7 % 128;
                            int i8 = i7 % 2;
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            try {
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                        }
                    } else {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    }
                    getcallingpid.getAuthRequestContext += 2;
                    int i15 = $10 + 101;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        for (int i17 = 0; i17 < i; i17++) {
            int i18 = $10 + 35;
            $11 = i18 % 128;
            int i19 = i18 % 2;
            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
