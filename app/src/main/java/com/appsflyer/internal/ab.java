package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.d;

/* loaded from: classes.dex */
public final class ab {
    static Boolean AFInAppEventType;
    static String valueOf;

    public static d.e.C0089d AFInAppEventParameterName(ContentResolver contentResolver) {
        String str;
        if (AFKeystoreWrapper() && contentResolver != null && AppsFlyerProperties.getInstance().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i == 0) {
                return new d.e.C0089d(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
            }
            if (i == 2) {
                return null;
            }
            try {
                str = Settings.Secure.getString(contentResolver, "advertising_id");
            } catch (Throwable th) {
                AFLogger.AFInAppEventType("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                str = "";
            }
            return new d.e.C0089d(str, Boolean.TRUE);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.d.e.C0089d values(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = com.appsflyer.internal.ab.valueOf
            r2 = 1
            if (r1 == 0) goto Lb
            r3 = 1
            goto Lc
        Lb:
            r3 = 0
        Lc:
            r4 = 0
            if (r3 == 0) goto L10
            goto L49
        L10:
            java.lang.Boolean r1 = com.appsflyer.internal.ab.AFInAppEventType
            if (r1 == 0) goto L1a
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L26
        L1a:
            java.lang.Boolean r1 = com.appsflyer.internal.ab.AFInAppEventType
            if (r1 != 0) goto L4c
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L4c
        L26:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch: java.lang.Throwable -> L43
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L43
            boolean r5 = r0.isEnableLog()     // Catch: java.lang.Throwable -> L43
            r1.setLogging(r5)     // Catch: java.lang.Throwable -> L43
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch: java.lang.Throwable -> L43
            if (r5 == 0) goto L4c
            java.lang.String r0 = r5.getId()     // Catch: java.lang.Throwable -> L43
            java.lang.Boolean r5 = r5.getLat()     // Catch: java.lang.Throwable -> L41
            goto L4e
        L41:
            r1 = r0
            goto L44
        L43:
            r1 = r4
        L44:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.values(r5)
        L49:
            r0 = r1
            r5 = r4
            goto L4e
        L4c:
            r5 = r4
            r0 = r5
        L4e:
            if (r0 == 0) goto L5c
            com.appsflyer.internal.d$e$d r1 = new com.appsflyer.internal.d$e$d
            r1.<init>(r0, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r1.AFInAppEventParameterName = r5
            return r1
        L5c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.values(android.content.Context):com.appsflyer.internal.d$e$d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x003d, code lost:
    
        if (r7.length() == 0) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.d.e.C0089d valueOf(android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.valueOf(android.content.Context, java.util.Map):com.appsflyer.internal.d$e$d");
    }

    private static boolean AFKeystoreWrapper() {
        Boolean bool = AFInAppEventType;
        return bool == null || bool.booleanValue();
    }
}
