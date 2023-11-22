package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class cx {
    private static int $10 = 0;
    private static int $11 = 1;
    private static C0221r BuiltInFictitiousFunctionClassFactory = null;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static volatile int MyBillsEntityDataFactory = 0;
    private static String NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static final Object PlaceComponentResult;
    private static com.xiaomi.push.providers.a getAuthRequestContext = null;
    private static char[] getErrorConfigVersion = null;
    private static int initRecordTimeStamp = 1;
    private static int lookAheadTest;
    private static long moveToNextValue;
    private static List<a> scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        public String BuiltInFictitiousFunctionClassFactory;
        public long KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public long getAuthRequestContext;
        public String moveToNextValue;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.PlaceComponentResult = i;
            this.MyBillsEntityDataFactory = i2;
            this.moveToNextValue = str2;
            this.getAuthRequestContext = j2;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(a aVar) {
            return TextUtils.equals(aVar.BuiltInFictitiousFunctionClassFactory, this.BuiltInFictitiousFunctionClassFactory) && TextUtils.equals(aVar.moveToNextValue, this.moveToNextValue) && aVar.PlaceComponentResult == this.PlaceComponentResult && aVar.MyBillsEntityDataFactory == this.MyBillsEntityDataFactory && Math.abs(aVar.KClassImpl$Data$declaredNonStaticMembers$2 - this.KClassImpl$Data$declaredNonStaticMembers$2) <= RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        }
    }

    static {
        PlaceComponentResult();
        BuiltInFictitiousFunctionClassFactory = new C0221r(true);
        MyBillsEntityDataFactory = -1;
        KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
        PlaceComponentResult = new Object();
        scheduleImpl = Collections.synchronizedList(new ArrayList());
        NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        getAuthRequestContext = null;
        int i = lookAheadTest + 63;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? '?' : (char) 2) != '?') {
            return;
        }
        int i2 = 28 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if ((!r8) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r8 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        r8 = com.xiaomi.push.cx.initRecordTimeStamp + 37;
        com.xiaomi.push.cx.lookAheadTest = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        if ((r8 % 2) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        r8 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r8 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r8 == '5') goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        r8 = r8.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        if (r11 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        r11 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r11 = '1';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r11 == '1') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        if (r11 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
    
        r11 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        r11 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004f, code lost:
    
        if (r11 == '*') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0051, code lost:
    
        r3 = com.xiaomi.push.cx.KClassImpl$Data$declaredNonStaticMembers$2;
        com.xiaomi.push.cx.KClassImpl$Data$declaredNonStaticMembers$2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005c, code lost:
    
        if ((r9 - r3) <= 30000) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r9 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r9 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
    
        if (r9 == '<') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0065, code lost:
    
        r8 = com.xiaomi.push.cx.initRecordTimeStamp + 87;
        com.xiaomi.push.cx.lookAheadTest = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
    
        if ((r8 % 2) == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0077, code lost:
    
        r9 = 85 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        if (r6 <= com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils.KB) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
    
        if (r6 <= com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils.KB) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        return r6 * 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r5 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008a, code lost:
    
        r5 = com.xiaomi.push.cx.initRecordTimeStamp + 91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        com.xiaomi.push.cx.lookAheadTest = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0092, code lost:
    
        if ((r5 % 2) == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0094, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r1 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0097, code lost:
    
        r5 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009a, code lost:
    
        r5 = 86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x009e, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009f, code lost:
    
        r5 = 11;
        r8 = com.xiaomi.push.cx.lookAheadTest + 105;
        com.xiaomi.push.cx.initRecordTimeStamp = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
    
        return (r6 * r5) / 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long BuiltInFictitiousFunctionClassFactory(int r5, long r6, boolean r8, long r9, boolean r11) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cx.BuiltInFictitiousFunctionClassFactory(int, long, boolean, long, boolean):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if ((r0 != null) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        r3 = com.xiaomi.push.cx.lookAheadTest + 119;
        com.xiaomi.push.cx.initRecordTimeStamp = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r0 = new com.xiaomi.push.providers.a(r3);
        com.xiaomi.push.cx.getAuthRequestContext = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.providers.a BuiltInFictitiousFunctionClassFactory(android.content.Context r3) {
        /*
            int r0 = com.xiaomi.push.cx.lookAheadTest
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.xiaomi.push.cx.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1b
            com.xiaomi.push.providers.a r0 = com.xiaomi.push.cx.getAuthRequestContext
            if (r0 == 0) goto L18
            r1 = 1
        L18:
            if (r1 == 0) goto L2c
            goto L21
        L1b:
            com.xiaomi.push.providers.a r0 = com.xiaomi.push.cx.getAuthRequestContext     // Catch: java.lang.Exception -> L36
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L2c
        L21:
            int r3 = com.xiaomi.push.cx.lookAheadTest
            int r3 = r3 + 119
            int r1 = r3 % 128
            com.xiaomi.push.cx.initRecordTimeStamp = r1
            int r3 = r3 % 2
            return r0
        L2c:
            com.xiaomi.push.providers.a r0 = new com.xiaomi.push.providers.a
            r0.<init>(r3)
            com.xiaomi.push.cx.getAuthRequestContext = r0
            return r0
        L34:
            r3 = move-exception
            throw r3
        L36:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cx.BuiltInFictitiousFunctionClassFactory(android.content.Context):com.xiaomi.push.providers.a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory() {
        int i = initRecordTimeStamp + 17;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        List<a> list = scheduleImpl;
        int i3 = lookAheadTest + 117;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = initRecordTimeStamp + 35;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Object obj = PlaceComponentResult;
        int i3 = initRecordTimeStamp + 97;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return obj;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, long j, boolean z, boolean z2, long j2) {
        try {
            int i = lookAheadTest + 27;
            initRecordTimeStamp = i % 128;
            if (!(i % 2 == 0)) {
                MyBillsEntityDataFactory(context, str, BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(context), j, z, j2, z2), z, j2);
                return;
            }
            try {
                MyBillsEntityDataFactory(context, str, BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(context), j, z, j2, z2), z, j2);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void MyBillsEntityDataFactory() {
        synchronized (cx.class) {
            com.xiaomi.channel.commonutils.android.f.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    public static void MyBillsEntityDataFactory(Context context) {
        try {
            int i = initRecordTimeStamp + 33;
            try {
                lookAheadTest = i % 128;
                int i2 = i % 2;
                MyBillsEntityDataFactory = getAuthRequestContext(context);
                int i3 = lookAheadTest + 11;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory(Context context, List list) {
        int i = lookAheadTest + 103;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            try {
                PlaceComponentResult(context, list);
            } catch (Exception e) {
                throw e;
            }
        } else {
            PlaceComponentResult(context, list);
            Object obj = null;
            obj.hashCode();
        }
        int i2 = lookAheadTest + 27;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (com.xiaomi.push.cx.MyBillsEntityDataFactory == (-1)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int PlaceComponentResult(android.content.Context r4) {
        /*
            int r0 = com.xiaomi.push.cx.lookAheadTest
            int r0 = r0 + 125
            int r1 = r0 % 128
            com.xiaomi.push.cx.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 67
            if (r0 != 0) goto L11
            r0 = 96
            goto L13
        L11:
            r0 = 67
        L13:
            r2 = 0
            r3 = -1
            if (r0 == r1) goto L21
            int r0 = com.xiaomi.push.cx.MyBillsEntityDataFactory
            r1 = 11
            int r1 = r1 / r2
            if (r0 != r3) goto L43
            goto L2a
        L1f:
            r4 = move-exception
            throw r4
        L21:
            int r0 = com.xiaomi.push.cx.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L48
            r1 = 1
            if (r0 != r3) goto L27
            r2 = 1
        L27:
            if (r2 == r1) goto L2a
            goto L43
        L2a:
            int r0 = com.xiaomi.push.cx.lookAheadTest     // Catch: java.lang.Exception -> L48
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.xiaomi.push.cx.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L46
            int r0 = r0 % 2
            int r4 = getAuthRequestContext(r4)
            com.xiaomi.push.cx.MyBillsEntityDataFactory = r4
            if (r0 != 0) goto L43
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r4 = move-exception
            throw r4
        L43:
            int r4 = com.xiaomi.push.cx.MyBillsEntityDataFactory
            return r4
        L46:
            r4 = move-exception
            throw r4
        L48:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cx.PlaceComponentResult(android.content.Context):int");
    }

    public static int PlaceComponentResult(String str) {
        int i = initRecordTimeStamp + 17;
        lookAheadTest = i % 128;
        try {
            if (!(i % 2 == 0)) {
                Object[] objArr = new Object[1];
                a(Process.getGidForName("") - 1, 88 >> (ViewConfiguration.getGlobalActionKeyTimeout() > 1L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 1L ? 0 : -1)), (char) (13841 % (ViewConfiguration.getWindowTouchSlop() >>> 110)), objArr);
                return str.getBytes(((String) objArr[0]).intern()).length;
            }
            Object[] objArr2 = new Object[1];
            a((-1) - Process.getGidForName(""), 6 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (23141 - (ViewConfiguration.getWindowTouchSlop() >> 8)), objArr2);
            return str.getBytes(((String) objArr2[0]).intern()).length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    static void PlaceComponentResult() {
        getErrorConfigVersion = new char[]{43390, 29247, 8173, 14534, 50195};
        moveToNextValue = 921567265987438606L;
    }

    private static void PlaceComponentResult(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.BuiltInFictitiousFunctionClassFactory) {
                SQLiteDatabase writableDatabase = BuiltInFictitiousFunctionClassFactory(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.BuiltInFictitiousFunctionClassFactory);
                        contentValues.put("message_ts", Long.valueOf(aVar.KClassImpl$Data$declaredNonStaticMembers$2));
                        contentValues.put("network_type", Integer.valueOf(aVar.PlaceComponentResult));
                        contentValues.put("bytes", Long.valueOf(aVar.getAuthRequestContext));
                        contentValues.put("rcv", Integer.valueOf(aVar.MyBillsEntityDataFactory));
                        contentValues.put("imsi", aVar.moveToNextValue);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void PlaceComponentResult(com.xiaomi.push.cx.a r6) {
        /*
            java.util.List<com.xiaomi.push.cx$a> r0 = com.xiaomi.push.cx.scheduleImpl
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L10
            r1 = 0
            goto L11
        L10:
            r1 = 1
        L11:
            if (r1 == 0) goto L19
            java.util.List<com.xiaomi.push.cx$a> r0 = com.xiaomi.push.cx.scheduleImpl
            r0.add(r6)
            return
        L19:
            int r1 = com.xiaomi.push.cx.initRecordTimeStamp     // Catch: java.lang.Exception -> L46
            int r1 = r1 + 125
            int r4 = r1 % 128
            com.xiaomi.push.cx.lookAheadTest = r4     // Catch: java.lang.Exception -> L46
            int r1 = r1 % 2
            java.lang.Object r1 = r0.next()
            com.xiaomi.push.cx$a r1 = (com.xiaomi.push.cx.a) r1
            boolean r4 = r1.BuiltInFictitiousFunctionClassFactory(r6)
            if (r4 == 0) goto L30
            r2 = 1
        L30:
            if (r2 == 0) goto L6
            long r2 = r1.getAuthRequestContext     // Catch: java.lang.Exception -> L44
            long r4 = r6.getAuthRequestContext
            long r2 = r2 + r4
            r1.getAuthRequestContext = r2
            int r6 = com.xiaomi.push.cx.lookAheadTest     // Catch: java.lang.Exception -> L46
            int r6 = r6 + 73
            int r0 = r6 % 128
            com.xiaomi.push.cx.initRecordTimeStamp = r0     // Catch: java.lang.Exception -> L46
            int r6 = r6 % 2
            return
        L44:
            r6 = move-exception
            throw r6
        L46:
            r6 = move-exception
            goto L49
        L48:
            throw r6
        L49:
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cx.PlaceComponentResult(com.xiaomi.push.cx$a):void");
    }

    private static int getAuthRequestContext(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                if (connectivityManager == null) {
                    int i = lookAheadTest + 5;
                    initRecordTimeStamp = i % 128;
                    if (!(i % 2 != 0)) {
                        int i2 = 85 / 0;
                    }
                    return -1;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int type = activeNetworkInfo.getType();
                    int i3 = lookAheadTest + 5;
                    initRecordTimeStamp = i3 % 128;
                    if ((i3 % 2 == 0 ? 'O' : 'a') != 'a') {
                        int i4 = 82 / 0;
                        return type;
                    }
                    return type;
                }
                try {
                    int i5 = lookAheadTest + 43;
                    initRecordTimeStamp = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = lookAheadTest + 81;
                    initRecordTimeStamp = i7 % 128;
                    int i8 = i7 % 2;
                    return -1;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    private static String getAuthRequestContext() {
        synchronized (cx.class) {
            if (TextUtils.isEmpty(NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                return "";
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    private static void MyBillsEntityDataFactory(Context context, String str, long j, boolean z, long j2) {
        int PlaceComponentResult2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (PlaceComponentResult2 = PlaceComponentResult(context))) {
            return;
        }
        synchronized (PlaceComponentResult) {
            isEmpty = scheduleImpl.isEmpty();
            PlaceComponentResult(new a(str, j2, PlaceComponentResult2, z ? 1 : 0, PlaceComponentResult2 == 0 ? getAuthRequestContext() : "", j));
        }
        if (isEmpty) {
            C0221r c0221r = BuiltInFictitiousFunctionClassFactory;
            c0221r.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(new t(c0221r, new cy(context)), RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 83;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i5 = $11 + 33;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ moveToNextValue))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                    objArr[0] = new String(cArr);
                    return;
                }
                int i7 = $11 + 3;
                $10 = i7 % 128;
                if (i7 % 2 != 0) {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } else {
                    try {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        whenavailable.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
