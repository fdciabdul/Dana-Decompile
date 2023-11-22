package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.C0221r;
import com.xiaomi.push.at;
import com.xiaomi.push.au;
import com.xiaomi.push.cv;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class bn {
    private static bn BuiltInFictitiousFunctionClassFactory = new bn();
    private static String PlaceComponentResult;
    private C0221r.b KClassImpl$Data$declaredNonStaticMembers$2;
    private at.a MyBillsEntityDataFactory;
    List<a> getAuthRequestContext = new ArrayList();

    /* loaded from: classes8.dex */
    public static abstract class a {
        public void BuiltInFictitiousFunctionClassFactory(au.b bVar) {
        }
    }

    private bn() {
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        String str;
        Context context;
        Context context2;
        synchronized (bn.class) {
            if (PlaceComponentResult == null) {
                context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
                SharedPreferences sharedPreferences = context.getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                PlaceComponentResult = string;
                if (string == null) {
                    context2 = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
                    String PlaceComponentResult2 = com.xiaomi.channel.commonutils.android.c.PlaceComponentResult(context2);
                    PlaceComponentResult = PlaceComponentResult2;
                    if (PlaceComponentResult2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", PlaceComponentResult).commit();
                    }
                }
            }
            str = PlaceComponentResult;
        }
        return str;
    }

    public static bn KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ C0221r.b MyBillsEntityDataFactory(bn bnVar) {
        bnVar.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        return null;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(bn bnVar) {
        Context context;
        try {
            if (bnVar.MyBillsEntityDataFactory != null) {
                context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(context.openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c BuiltInFictitiousFunctionClassFactory2 = com.xiaomi.push.c.BuiltInFictitiousFunctionClassFactory(bufferedOutputStream);
                bnVar.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2);
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("save config failure: ");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int PlaceComponentResult() {
        /*
            r4 = this;
            com.xiaomi.push.at$a r0 = r4.MyBillsEntityDataFactory
            if (r0 != 0) goto L5c
            r0 = 0
            android.content.Context r1 = com.xiaomi.channel.commonutils.android.j.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            com.xiaomi.push.b r0 = com.xiaomi.push.b.BuiltInFictitiousFunctionClassFactory(r2)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            com.xiaomi.push.at$a r0 = com.xiaomi.push.at.a.MyBillsEntityDataFactory(r0)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r4.MyBillsEntityDataFactory = r0     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r2.close()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            goto L44
        L22:
            r0 = move-exception
            goto L56
        L24:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L2b
        L28:
            r1 = move-exception
            goto L58
        L2a:
            r1 = move-exception
        L2b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r2.<init>()     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = "load config failure: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L53
            r2.append(r1)     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L53
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r1)     // Catch: java.lang.Throwable -> L53
            r2 = r0
        L44:
            com.xiaomi.push.h.MyBillsEntityDataFactory(r2)
            com.xiaomi.push.at$a r0 = r4.MyBillsEntityDataFactory
            if (r0 != 0) goto L5c
            com.xiaomi.push.at$a r0 = new com.xiaomi.push.at$a
            r0.<init>()
            r4.MyBillsEntityDataFactory = r0
            goto L5c
        L53:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L56:
            r1 = r0
            r0 = r2
        L58:
            com.xiaomi.push.h.MyBillsEntityDataFactory(r0)
            throw r1
        L5c:
            com.xiaomi.push.at$a r0 = r4.MyBillsEntityDataFactory
            if (r0 == 0) goto L63
            int r0 = r0.getAuthRequestContext
            return r0
        L63:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bn.PlaceComponentResult():int");
    }

    public final void MyBillsEntityDataFactory(au.b bVar) {
        a[] aVarArr;
        if (bVar.KClassImpl$Data$declaredNonStaticMembers$2() && bVar.BuiltInFictitiousFunctionClassFactory > PlaceComponentResult() && this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            bo boVar = new bo(this);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = boVar;
            cv.BuiltInFictitiousFunctionClassFactory(boVar);
        }
        synchronized (this) {
            List<a> list = this.getAuthRequestContext;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.BuiltInFictitiousFunctionClassFactory(bVar);
        }
    }
}
