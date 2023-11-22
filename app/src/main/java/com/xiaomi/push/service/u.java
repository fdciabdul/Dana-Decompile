package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class u {
    public static final byte[] getAuthRequestContext = {39, -116, 116, Byte.MAX_VALUE, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 54;
    private static final Map<String, byte[]> BuiltInFictitiousFunctionClassFactory = new HashMap();
    private static ArrayList<Pair<String, byte[]>> PlaceComponentResult = new ArrayList<>();

    public static void BuiltInFictitiousFunctionClassFactory(Context context, int i, String str) {
        Map<String, byte[]> map = BuiltInFictitiousFunctionClassFactory;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("notify registration error. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                BuiltInFictitiousFunctionClassFactory(context, str2, BuiltInFictitiousFunctionClassFactory.get(str2), i, str);
            }
            BuiltInFictitiousFunctionClassFactory.clear();
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, ad.getAuthRequestContext(str));
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, byte[] bArr) {
        Map<String, byte[]> map = BuiltInFictitiousFunctionClassFactory;
        synchronized (map) {
            StringBuilder sb = new StringBuilder();
            sb.append("pending registration request. ");
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            map.put(str, bArr);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (PlaceComponentResult) {
                arrayList = PlaceComponentResult;
                PlaceComponentResult = new ArrayList<>();
            }
            try {
                byte b = getAuthRequestContext[15];
                byte b2 = (byte) (b - 1);
                boolean z = true;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (getAuthRequestContext[15] - 1);
                byte b4 = getAuthRequestContext[15];
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                    z = false;
                }
                Iterator<Pair<String, byte[]>> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair<String, byte[]> next = it.next();
                    ad.getAuthRequestContext(xMPushService, (String) next.first, (byte[]) next.second);
                    if (!z) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (com.xiaomi.push.cd e) {
            StringBuilder sb = new StringBuilder();
            sb.append("meet error when process pending message. ");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            xMPushService.a(10, e);
        }
    }

    public static void MyBillsEntityDataFactory(String str, byte[] bArr) {
        synchronized (PlaceComponentResult) {
            PlaceComponentResult.add(new Pair<>(str, bArr));
            if (PlaceComponentResult.size() > 50) {
                PlaceComponentResult.remove(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r7 = r7 * 12
            int r7 = 15 - r7
            byte[] r0 = com.xiaomi.push.service.u.getAuthRequestContext
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(byte, byte, int, java.lang.Object[]):void");
    }

    public static void getAuthRequestContext(XMPushService xMPushService) {
        try {
            Map<String, byte[]> map = BuiltInFictitiousFunctionClassFactory;
            synchronized (map) {
                for (String str : map.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("processing pending registration request. ");
                    sb.append(str);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                    ad.getAuthRequestContext(xMPushService, str, BuiltInFictitiousFunctionClassFactory.get(str));
                }
                BuiltInFictitiousFunctionClassFactory.clear();
            }
        } catch (com.xiaomi.push.cd e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fail to deal with pending register request. ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
            xMPushService.a(10, e);
        }
    }
}
