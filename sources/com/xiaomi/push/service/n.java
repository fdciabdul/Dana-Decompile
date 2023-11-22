package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class n {
    private static volatile n lookAheadTest;
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;
    public long MyBillsEntityDataFactory;
    public final SharedPreferences getAuthRequestContext;
    public final boolean getErrorConfigVersion;
    public final AtomicInteger NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicInteger(0);
    public String PlaceComponentResult = null;
    public volatile boolean scheduleImpl = false;
    public String moveToNextValue = null;
    private final AtomicInteger DatabaseTableConfigUtil = new AtomicInteger(0);
    private final AtomicInteger GetContactSyncConfig = new AtomicInteger(0);
    public int BuiltInFictitiousFunctionClassFactory = -1;
    private final boolean initRecordTimeStamp = false;

    /* loaded from: classes8.dex */
    public static class a {
        public static String BuiltInFictitiousFunctionClassFactory() {
            return "record_hb_count_start";
        }

        public static String KClassImpl$Data$declaredNonStaticMembers$2() {
            return "record_wifi_ptc";
        }

        public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String MyBillsEntityDataFactory() {
            return "support_wifi_digest";
        }

        public static String PlaceComponentResult() {
            return "record_ptc_start";
        }

        public static String getAuthRequestContext() {
            return "record_mobile_ptc";
        }

        public static String getAuthRequestContext(String str) {
            return String.format("HB_%s", str);
        }

        public static String moveToNextValue() {
            return "keep_short_hb_effective_time";
        }
    }

    private n(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getErrorConfigVersion = com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.getAuthRequestContext = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.BuiltInFictitiousFunctionClassFactory(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.BuiltInFictitiousFunctionClassFactory(), currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.PlaceComponentResult(), -1L);
        this.MyBillsEntityDataFactory = j;
        if (j == -1) {
            this.MyBillsEntityDataFactory = currentTimeMillis;
            sharedPreferences.edit().putLong(a.PlaceComponentResult(), currentTimeMillis).apply();
        }
    }

    public static n KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (lookAheadTest == null) {
            synchronized (n.class) {
                if (lookAheadTest == null) {
                    lookAheadTest = new n(context);
                }
            }
        }
        return lookAheadTest;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.get() >= Math.max(5, 3);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return !TextUtils.isEmpty(this.PlaceComponentResult) && this.PlaceComponentResult.startsWith("M-");
    }

    public final int PlaceComponentResult() {
        if (TextUtils.isEmpty(this.PlaceComponentResult)) {
            return -1;
        }
        try {
            return this.getAuthRequestContext.getInt(a.getAuthRequestContext(this.PlaceComponentResult), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L15
            java.lang.String r10 = r9.PlaceComponentResult
            if (r10 == 0) goto L14
            java.lang.String r0 = "W-"
            boolean r10 = r10.startsWith(r0)
            if (r10 != 0) goto L17
        L14:
            r10 = 0
        L15:
            r9.PlaceComponentResult = r10
        L17:
            android.content.SharedPreferences r10 = r9.getAuthRequestContext
            java.lang.String r0 = r9.PlaceComponentResult
            java.lang.String r0 = com.xiaomi.push.service.n.a.getAuthRequestContext(r0)
            r1 = -1
            int r10 = r10.getInt(r0, r1)
            android.content.SharedPreferences r0 = r9.getAuthRequestContext
            java.lang.String r2 = r9.PlaceComponentResult
            java.lang.String r2 = com.xiaomi.push.service.n.a.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            r3 = -1
            long r5 = r0.getLong(r2, r3)
            long r7 = java.lang.System.currentTimeMillis()
            if (r10 == r1) goto L72
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L51
            android.content.SharedPreferences r10 = r9.getAuthRequestContext
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.PlaceComponentResult
            java.lang.String r0 = com.xiaomi.push.service.n.a.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            r2 = 777600000(0x2e593c00, double:3.84185446E-315)
            long r7 = r7 + r2
            android.content.SharedPreferences$Editor r10 = r10.putLong(r0, r7)
            goto L6f
        L51:
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L72
            android.content.SharedPreferences r10 = r9.getAuthRequestContext
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.PlaceComponentResult
            java.lang.String r0 = com.xiaomi.push.service.n.a.getAuthRequestContext(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            java.lang.String r0 = r9.PlaceComponentResult
            java.lang.String r0 = com.xiaomi.push.service.n.a.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
        L6f:
            r10.apply()
        L72:
            java.util.concurrent.atomic.AtomicInteger r10 = r9.NetworkUserEntityData$$ExternalSyntheticLambda0
            r0 = 0
            r10.getAndSet(r0)
            java.lang.String r10 = r9.PlaceComponentResult
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r2 = 1
            if (r10 != 0) goto L8a
            int r10 = r9.PlaceComponentResult()
            if (r10 != r1) goto L8a
            r9.scheduleImpl = r2
            goto L8c
        L8a:
            r9.scheduleImpl = r0
        L8c:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r1 = r9.PlaceComponentResult
            r10[r0] = r1
            boolean r0 = r9.scheduleImpl
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "[HB] network changed, netid:%s, %s"
            java.lang.String r10 = java.lang.String.format(r0, r10)
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.PlaceComponentResult(java.lang.String):void");
    }

    public final boolean getAuthRequestContext() {
        boolean z = this.getAuthRequestContext.getLong(a.moveToNextValue(), -1L) >= System.currentTimeMillis();
        if (this.getErrorConfigVersion) {
            return this.initRecordTimeStamp || z;
        }
        return false;
    }
}
