package com.appsflyer.internal;

import android.app.Application;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class ay implements Runnable {
    private static String valueOf = "https://%sgcdsdk.%s/install_data/v4.0/";
    private static final List<String> values = Arrays.asList("googleplay", "playstore", "googleplaystore");
    private final String AFInAppEventParameterName;
    final ScheduledExecutorService AFInAppEventType;
    private final Application AFKeystoreWrapper;
    private final ae AFLogger$LogLevel;
    private final int AFVersionDeclaration;
    private final AtomicInteger getLevel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ae aeVar, Application application, String str) {
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        this.AFInAppEventType = k.valueOf.AFInAppEventParameterName();
        this.getLevel = new AtomicInteger(0);
        this.AFLogger$LogLevel = aeVar;
        this.AFKeystoreWrapper = application;
        this.AFInAppEventParameterName = str;
        this.AFVersionDeclaration = 0;
    }

    private ay(ay ayVar) {
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        this.AFInAppEventType = k.valueOf.AFInAppEventParameterName();
        this.getLevel = new AtomicInteger(0);
        this.AFLogger$LogLevel = ayVar.AFLogger$LogLevel;
        this.AFKeystoreWrapper = ayVar.AFKeystoreWrapper;
        this.AFInAppEventParameterName = ayVar.AFInAppEventParameterName;
        this.AFVersionDeclaration = ayVar.AFVersionDeclaration + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void AFInAppEventType(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
        sb.append(map.toString());
        AFLogger.values(sb.toString());
        ae.valueOf.onConversionDataSuccess(map);
    }

    public static void AFInAppEventParameterName(String str) {
        if (ae.valueOf != null) {
            AFLogger.values("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            ae.valueOf.onConversionDataFail(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x028d, code lost:
    
        if (r7 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02bd, code lost:
    
        r19.AFInAppEventType.shutdown();
        com.appsflyer.AFLogger.values("[GCD-A03] Server retrieving attempt finished");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02c7, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0199 A[Catch: all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:25:0x00f8, B:35:0x0149, B:32:0x0137, B:34:0x013b, B:36:0x0158, B:38:0x0199, B:40:0x01a7, B:42:0x01c1, B:44:0x01c7, B:45:0x01d4, B:48:0x01de, B:50:0x01e4, B:51:0x01f8, B:52:0x020a, B:54:0x0210, B:55:0x0223, B:58:0x0235, B:60:0x0240, B:62:0x0244, B:64:0x024c, B:66:0x0261, B:70:0x026e, B:69:0x0269, B:59:0x023b), top: B:95:0x00f8, inners: #3 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ay.run():void");
    }
}
