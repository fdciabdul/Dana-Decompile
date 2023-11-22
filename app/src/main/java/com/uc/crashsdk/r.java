package com.uc.crashsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes8.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static PendingIntent f7734a;

    public static void a() {
        if (f7734a == null && p.h() >= 0) {
            try {
                Context a2 = e.a();
                Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
                launchIntentForPackage.addFlags(335544320);
                f7734a = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }
    }

    public static boolean b() {
        if (f7734a == null) {
            com.uc.crashsdk.a.c.c("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.c.b("restarting ...");
            ((AlarmManager) e.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, f7734a);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r11) {
        /*
            java.lang.String r0 = "restartBrowser"
            com.uc.crashsdk.a.c.a(r0)
            if (r11 != 0) goto L8
            return
        L8:
            int r11 = c()
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            int r4 = com.uc.crashsdk.p.h()
            r5 = 0
            r6 = 1
            if (r4 < 0) goto L72
            if (r11 <= 0) goto L29
            long r7 = (long) r11
            long r7 = r0 - r7
            int r4 = com.uc.crashsdk.p.h()
            long r9 = (long) r4
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 <= 0) goto L72
        L29:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 / r2
            com.uc.crashsdk.b.m()
            java.io.File r2 = new java.io.File
            java.lang.String r3 = com.uc.crashsdk.b.d()
            r2.<init>(r3)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r4.write(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r4.close()     // Catch: java.io.IOException -> L60
            goto L64
        L4f:
            r11 = move-exception
            goto L67
        L51:
            r2 = move-exception
            r3 = r4
            goto L57
        L54:
            r11 = move-exception
            goto L66
        L56:
            r2 = move-exception
        L57:
            com.uc.crashsdk.a.a.a(r2, r6)     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r2 = move-exception
            com.uc.crashsdk.a.a.a(r2, r6)
        L64:
            r2 = 1
            goto L73
        L66:
            r4 = r3
        L67:
            if (r4 == 0) goto L71
            r4.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r0 = move-exception
            com.uc.crashsdk.a.a.a(r0, r6)
        L71:
            throw r11
        L72:
            r2 = 0
        L73:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "restartBrowser, lastTime: "
            r3.<init>(r4)
            r3.append(r11)
            java.lang.String r11 = ", currentTime: "
            r3.append(r11)
            r3.append(r0)
            java.lang.String r11 = ", needRestart: "
            r3.append(r11)
            r3.append(r2)
            java.lang.String r11 = r3.toString()
            com.uc.crashsdk.a.c.a(r11)
            if (r2 == 0) goto La1
            com.uc.crashsdk.d.a(r6)     // Catch: java.lang.Throwable -> L9a
            goto L9e
        L9a:
            r11 = move-exception
            com.uc.crashsdk.a.a.a(r11, r5)
        L9e:
            b()
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.r.a(android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0046 -> B:38:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c() {
        /*
            java.lang.String r0 = com.uc.crashsdk.b.d()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            r2 = -1
            if (r0 != 0) goto L11
            return r2
        L11:
            r0 = 0
            r3 = 1
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            long r0 = r1.length()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            int r1 = (int) r0     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            byte[] r0 = new byte[r1]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            int r1 = r4.read(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r1 <= 0) goto L2f
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            int r0 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r2 = r0
        L2f:
            r4.close()     // Catch: java.io.IOException -> L45
            goto L49
        L33:
            r0 = move-exception
            goto L4d
        L35:
            r0 = move-exception
            r1 = r0
            r0 = r4
            goto L3c
        L39:
            r1 = move-exception
            goto L4f
        L3b:
            r1 = move-exception
        L3c:
            com.uc.crashsdk.a.a.a(r1, r3)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L49
            r0.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r0 = move-exception
            com.uc.crashsdk.a.a.a(r0, r3)
        L49:
            return r2
        L4a:
            r1 = move-exception
            r4 = r0
            r0 = r1
        L4d:
            r1 = r0
            r0 = r4
        L4f:
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            com.uc.crashsdk.a.a.a(r0, r3)
        L59:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.r.c():int");
    }
}
