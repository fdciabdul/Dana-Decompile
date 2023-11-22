package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public PackageInfo f6790a = null;
    private JSONObject b = null;
    private String c;

    public a(String str) {
        this.c = str;
    }

    public String a(String str) {
        try {
            return b().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean a() {
        try {
            return new File(this.c).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.pm.PackageInfo r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "thirdpartyso"
            java.lang.String r1 = "reversedependencies"
            java.lang.String r2 = "weakdependencies"
            java.lang.String r3 = "dependencies"
            java.lang.String r4 = "pluginclass"
            java.lang.String r5 = "pluginname"
            java.lang.String r6 = "hasso"
            r7 = 0
            if (r11 == 0) goto L99
            if (r12 != 0) goto L15
            goto L99
        L15:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r8 = "version"
            java.lang.String r9 = r11.versionName     // Catch: java.lang.Exception -> L98
            r12.put(r8, r9)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r8 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r8 = r8.metaData     // Catch: java.lang.Exception -> L98
            boolean r8 = r8.getBoolean(r6, r7)     // Catch: java.lang.Exception -> L98
            r12.put(r6, r8)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r6 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r6 = r6.metaData     // Catch: java.lang.Exception -> L98
            java.lang.String r6 = r6.getString(r5)     // Catch: java.lang.Exception -> L98
            r12.put(r5, r6)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r5 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r5 = r5.metaData     // Catch: java.lang.Exception -> L98
            java.lang.String r5 = r5.getString(r4)     // Catch: java.lang.Exception -> L98
            r12.put(r4, r5)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r4 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r4 = r4.metaData     // Catch: java.lang.Exception -> L98
            java.lang.String r4 = r4.getString(r3)     // Catch: java.lang.Exception -> L98
            r12.put(r3, r4)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r3 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r3 = r3.metaData     // Catch: java.lang.Exception -> L98
            java.lang.String r3 = r3.getString(r2)     // Catch: java.lang.Exception -> L98
            r12.put(r2, r3)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r2 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r2 = r2.metaData     // Catch: java.lang.Exception -> L98
            java.lang.String r2 = r2.getString(r1)     // Catch: java.lang.Exception -> L98
            r12.put(r1, r2)     // Catch: java.lang.Exception -> L98
            android.content.pm.ApplicationInfo r11 = r11.applicationInfo     // Catch: java.lang.Exception -> L98
            android.os.Bundle r11 = r11.metaData     // Catch: java.lang.Exception -> L98
            boolean r11 = r11.getBoolean(r0)     // Catch: java.lang.Exception -> L98
            r12.put(r0, r11)     // Catch: java.lang.Exception -> L98
            java.io.File r11 = new java.io.File     // Catch: java.lang.Exception -> L81
            java.lang.String r0 = r10.c     // Catch: java.lang.Exception -> L81
            r11.<init>(r0)     // Catch: java.lang.Exception -> L81
            boolean r0 = r11.exists()     // Catch: java.lang.Exception -> L7f
            if (r0 != 0) goto L8d
            r11.createNewFile()     // Catch: java.lang.Exception -> L7f
            goto L8d
        L7f:
            goto L82
        L81:
            r11 = 0
        L82:
            boolean r0 = r11.exists()
            if (r0 != 0) goto L8d
            r11.createNewFile()     // Catch: java.lang.Exception -> L8c
            goto L8d
        L8c:
        L8d:
            java.lang.String r12 = r12.toString()
            boolean r11 = com.alibaba.wireless.security.framework.utils.b.a(r11, r12)
            if (r11 != 0) goto L98
            goto L99
        L98:
            r7 = 1
        L99:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.a.a(android.content.pm.PackageInfo, java.lang.String):boolean");
    }

    public JSONObject b() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = null;
        try {
            String a2 = com.alibaba.wireless.security.framework.utils.b.a(new File(this.c));
            if (a2 != null && a2.length() > 0) {
                jSONObject2 = new JSONObject(a2);
            }
        } catch (Exception unused) {
        }
        this.b = jSONObject2;
        return jSONObject2;
    }
}
