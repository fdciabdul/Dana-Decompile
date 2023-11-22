package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public final class bp implements ak {
    private static volatile bp BuiltInFictitiousFunctionClassFactory;
    Context KClassImpl$Data$declaredNonStaticMembers$2;
    SharedPreferences MyBillsEntityDataFactory;
    private long getAuthRequestContext;
    private volatile boolean getErrorConfigVersion = false;
    ConcurrentHashMap<String, a> PlaceComponentResult = new ConcurrentHashMap<>();

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        String BuiltInFictitiousFunctionClassFactory;
        long PlaceComponentResult = 172800;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str) {
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        abstract void MyBillsEntityDataFactory(bp bpVar);

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (bp.BuiltInFictitiousFunctionClassFactory == null || !com.xiaomi.push.y.PlaceComponentResult(bp.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferences = bp.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(":ts-");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            if (currentTimeMillis - sharedPreferences.getLong(sb.toString(), 0L) <= this.PlaceComponentResult) {
                z = com.xiaomi.push.l.MyBillsEntityDataFactory;
                if (!z) {
                    return;
                }
            }
            SharedPreferences.Editor edit = bp.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.edit();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(":ts-");
            sb2.append(this.BuiltInFictitiousFunctionClassFactory);
            com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit.putLong(sb2.toString(), System.currentTimeMillis()));
            MyBillsEntityDataFactory(bp.BuiltInFictitiousFunctionClassFactory);
        }
    }

    private bp(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
        this.MyBillsEntityDataFactory = context.getSharedPreferences("sync", 0);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        SharedPreferences.Editor edit = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit.putString(sb.toString(), str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean MyBillsEntityDataFactory(bp bpVar) {
        bpVar.getErrorConfigVersion = false;
        return false;
    }

    public static bp getAuthRequestContext(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (bp.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new bp(context);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.xiaomi.push.service.ak
    public final void PlaceComponentResult() {
        if (this.getErrorConfigVersion) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.getAuthRequestContext < 3600000) {
            return;
        }
        this.getAuthRequestContext = currentTimeMillis;
        this.getErrorConfigVersion = true;
        com.xiaomi.push.o.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.schedule(new bq(this), (int) (Math.random() * 10.0d), TimeUnit.SECONDS);
    }
}
