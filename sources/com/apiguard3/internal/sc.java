package com.apiguard3.internal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.apiguard3.APIGuard;
import com.apiguard3.BuildConfig;
import com.apiguard3.internal.ConfigInstance;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class sc implements ConfigInstance.ConfigSerializationProxy {
    private static long AGState = 0;
    private static int parseResponseHeaders = 1;
    private static int values;
    private APIGuard.Callback APIGuard;
    private ConfigInstance.ConfigSerializationProxy.values valueOf = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
    private volatile boolean getSharedInstance = false;

    static {
        AGState();
        ViewConfiguration.getKeyRepeatDelay();
        int i = values + 69;
        parseResponseHeaders = i % 128;
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
    }

    static void AGState() {
        AGState = 3320107868717369934L;
    }

    @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
    public final void AGState(ConfigInstance.ConfigSerializationProxy.values valuesVar) {
        int i = values + 117;
        parseResponseHeaders = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        throw new NullPointerException();
    }

    public sc(APIGuard.Callback callback) {
        this.APIGuard = callback;
    }

    @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
    public final void AGState(ConfigInstance configInstance) {
        Object obj;
        if (this.APIGuard != null) {
            values = (parseResponseHeaders + 39) % 128;
            if (configInstance.values.compareTo(this.valueOf) <= 0) {
                if (BuildConfig.valueOf.booleanValue() && (!(configInstance instanceof UriFilter$UrlMatcherSpec)) != true) {
                    int i = parseResponseHeaders + 91;
                    values = i % 128;
                    if ((i % 2 != 0 ? '2' : Typography.less) != '2') {
                        this.APIGuard.log(configInstance.toString());
                        return;
                    } else {
                        this.APIGuard.log(configInstance.toString());
                        throw new ArithmeticException();
                    }
                }
                Object[] objArr = new Object[1];
                values("쨏㲤✹⸅Ⴕ᭨ɺ瓕", 63149 - View.combineMeasuredStates(0, 0), objArr);
                StringBuilder sb = new StringBuilder(((String) objArr[0]).intern());
                String str = configInstance.APIGuard;
                String str2 = configInstance.valueOf;
                if ((!TextUtils.isEmpty(str) ? (char) 15 : '\r') != '\r') {
                    int i2 = parseResponseHeaders + 93;
                    values = i2 % 128;
                    if ((i2 % 2 != 0 ? 'c' : '4') != '4') {
                        sb.append(str);
                        Object[] objArr2 = new Object[0];
                        values("쩮", (-16754547) % Color.rgb(0, 1, 0), objArr2);
                        obj = objArr2[0];
                    } else {
                        sb.append(str);
                        Object[] objArr3 = new Object[1];
                        values("쩮", (-16754547) - Color.rgb(0, 0, 0), objArr3);
                        obj = objArr3[0];
                    }
                    sb.append(((String) obj).intern());
                }
                if (!TextUtils.isEmpty(str2) && configInstance.values.compareTo(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance) == 0) {
                    sb.append(str2);
                }
                this.APIGuard.log(sb.toString());
                int i3 = values + 81;
                parseResponseHeaders = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                throw new ArithmeticException();
            }
        }
        values = (parseResponseHeaders + 97) % 128;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.apiguard3.internal.setForeground.valueOf
            monitor-enter(r0)
            com.apiguard3.internal.setForeground.APIGuard = r8     // Catch: java.lang.Throwable -> L3d
            int r8 = r7.length     // Catch: java.lang.Throwable -> L3d
            char[] r8 = new char[r8]     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            com.apiguard3.internal.setForeground.values = r1     // Catch: java.lang.Throwable -> L3d
        L13:
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = r7.length     // Catch: java.lang.Throwable -> L3d
            if (r2 >= r3) goto L34
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            char r3 = r7[r3]     // Catch: java.lang.Throwable -> L3d
            int r4 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r5 = com.apiguard3.internal.setForeground.APIGuard     // Catch: java.lang.Throwable -> L3d
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L3d
            long r5 = com.apiguard3.internal.sc.AGState     // Catch: java.lang.Throwable -> L3d
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L3d
            char r3 = (char) r4     // Catch: java.lang.Throwable -> L3d
            r8[r2] = r3     // Catch: java.lang.Throwable -> L3d
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r2 = r2 + 1
            com.apiguard3.internal.setForeground.values = r2     // Catch: java.lang.Throwable -> L3d
            goto L13
        L34:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L3d
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            r9[r1] = r7
            return
        L3d:
            r7 = move-exception
            monitor-exit(r0)
            goto L41
        L40:
            throw r7
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.sc.values(java.lang.String, int, java.lang.Object[]):void");
    }
}
