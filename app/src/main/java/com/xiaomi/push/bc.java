package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes8.dex */
public final class bc {
    private static a BuiltInFictitiousFunctionClassFactory;
    private static final String PlaceComponentResult = XMJobService.class.getCanonicalName();
    private static int getAuthRequestContext = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory(boolean z);

        boolean MyBillsEntityDataFactory();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r7.equals(com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void BuiltInFictitiousFunctionClassFactory(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L19
            com.xiaomi.push.bd r0 = new com.xiaomi.push.bd
            r0.<init>(r9)
            goto Lcc
        L19:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 1
            r3 = 0
            java.lang.String r4 = r9.getPackageName()     // Catch: java.lang.Exception -> L7e
            r5 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r4, r5)     // Catch: java.lang.Exception -> L7e
            android.content.pm.ServiceInfo[] r4 = r1.services     // Catch: java.lang.Exception -> L7e
            if (r4 == 0) goto L7c
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L7e
            int r4 = r1.length     // Catch: java.lang.Exception -> L7e
            r5 = 0
        L30:
            if (r5 >= r4) goto L7a
            r6 = r1[r5]     // Catch: java.lang.Exception -> L77
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L77
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L77
            if (r7 == 0) goto L61
            java.lang.String r7 = com.xiaomi.push.bc.PlaceComponentResult     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L77
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Exception -> L77
            if (r8 == 0) goto L47
            goto L5b
        L47:
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(r9, r8)     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = r8.getSuperclass()     // Catch: java.lang.Exception -> L5d
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Exception -> L5d
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L5d
            if (r7 == 0) goto L5e
        L5b:
            r3 = 1
            goto L5e
        L5d:
        L5e:
            if (r3 != r2) goto L61
            goto L7a
        L61:
            java.lang.String r7 = com.xiaomi.push.bc.PlaceComponentResult     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L77
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L77
            if (r7 == 0) goto L74
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L77
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L77
            if (r6 == 0) goto L74
            goto L98
        L74:
            int r5 = r5 + 1
            goto L30
        L77:
            r1 = move-exception
            r2 = r3
            goto L80
        L7a:
            r2 = r3
            goto L98
        L7c:
            r2 = 0
            goto L98
        L7e:
            r1 = move-exception
            r2 = 0
        L80:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r1)
        L98:
            if (r2 != 0) goto Lc7
            boolean r1 = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory(r9)
            if (r1 != 0) goto La1
            goto Lc7
        La1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Should export service: "
            r9.append(r1)
            java.lang.String r1 = com.xiaomi.push.bc.PlaceComponentResult
            r9.append(r1)
            java.lang.String r1 = " with permission "
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r9.append(r0)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        Lc7:
            com.xiaomi.push.bd r0 = new com.xiaomi.push.bd
            r0.<init>(r9)
        Lcc:
            com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory(android.content.Context):void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(boolean z) {
        synchronized (bc.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("timer is not initialized");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Alarm] register alarm. (");
            sb.append(z);
            sb.append(")");
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(z);
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (bc.class) {
            a aVar = BuiltInFictitiousFunctionClassFactory;
            if (aVar == null) {
                return false;
            }
            return aVar.MyBillsEntityDataFactory();
        }
    }

    public static void MyBillsEntityDataFactory() {
        synchronized (bc.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("[Alarm] stop alarm.");
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static void getAuthRequestContext(Context context, int i) {
        synchronized (bc.class) {
            int i2 = getAuthRequestContext;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    getAuthRequestContext = 2;
                } else {
                    getAuthRequestContext = 0;
                }
            }
            int i3 = getAuthRequestContext;
            if (i2 != i3 && i3 == 2) {
                MyBillsEntityDataFactory();
                BuiltInFictitiousFunctionClassFactory = new bf(context);
            }
        }
    }
}
