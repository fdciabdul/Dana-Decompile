package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.bt;
import com.appsflyer.internal.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class aq extends bf {
    private static String onAttributionFailure = "https://%sdlsdk.%s/v1.0/android/";
    public static long onInstallConversionDataLoadedNative;
    private boolean AppsFlyerConversionListener;
    private int AppsFlyerInAppPurchaseValidatorListener;
    private int AppsFlyerLib;
    private final List<bt> onAppOpenAttribution;
    private final CountDownLatch onConversionDataSuccess;
    private final au onDeepLinking;
    public int onDeepLinkingNative;
    private final JSONObject onValidateInAppFailure;

    public aq(Context context, au auVar) {
        super(null, onAttributionFailure, Boolean.FALSE, Boolean.TRUE, null, context);
        this.onAppOpenAttribution = new ArrayList();
        this.onConversionDataSuccess = new CountDownLatch(1);
        this.onValidateInAppFailure = new JSONObject();
        this.onDeepLinking = auVar;
    }

    public final void values(DeepLinkResult deepLinkResult) {
        try {
            this.onValidateInAppFailure.put("status", deepLinkResult.getStatus().toString());
            this.onValidateInAppFailure.put("timeout_value", onInstallConversionDataLoadedNative);
        } catch (JSONException unused) {
        }
        au auVar = this.onDeepLinking;
        auVar.valueOf.edit().putString("ddl", this.onValidateInAppFailure.toString()).apply();
        ap.AFInAppEventParameterName(deepLinkResult);
    }

    private boolean valueOf() {
        List list = (List) this.AFInAppEventType.get("referrers");
        return (list != null ? list.size() : 0) < this.AppsFlyerLib && !this.AFInAppEventType.containsKey("referrers");
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void AFKeystoreWrapper(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aq.AFKeystoreWrapper(android.content.Context):void");
    }

    /* renamed from: com.appsflyer.internal.aq$1 */
    /* loaded from: classes.dex */
    public static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] valueOf;

        static {
            int[] iArr = new int[bt.e.values().length];
            valueOf = iArr;
            try {
                iArr[bt.e.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                valueOf[bt.e.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void valueOf(bt btVar) {
        if (AFKeystoreWrapper(btVar)) {
            this.onAppOpenAttribution.add(btVar);
            this.onConversionDataSuccess.countDown();
            StringBuilder sb = new StringBuilder("[DDL] Added non-organic ");
            sb.append(btVar.getClass().getSimpleName());
            AFLogger.values(sb.toString());
            return;
        }
        int i = this.AppsFlyerInAppPurchaseValidatorListener + 1;
        this.AppsFlyerInAppPurchaseValidatorListener = i;
        if (i == this.AppsFlyerLib) {
            this.onConversionDataSuccess.countDown();
        }
    }

    private static boolean AFKeystoreWrapper(bt btVar) {
        Long l = (Long) btVar.AFKeystoreWrapper.get("click_ts");
        return l != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1L);
    }

    private Map<String, Object> AFInAppEventParameterName(final d.e.C0089d c0089d) {
        Boolean bool;
        boolean z = false;
        if (c0089d != null && c0089d.values != null && ((bool = c0089d.valueOf) == null || !bool.booleanValue())) {
            z = true;
        }
        if (z) {
            return new HashMap<String, Object>() { // from class: com.appsflyer.internal.aq.5
                {
                    put("type", "unhashed");
                    put("value", c0089d.values);
                }
            };
        }
        return null;
    }

    static /* synthetic */ void AFInAppEventParameterName(aq aqVar) {
        ArrayList<bt> arrayList = new ArrayList();
        for (bt btVar : ae.values().onAppOpenAttributionNative) {
            if (btVar != null && btVar.AFInAppEventParameterName != bt.e.NOT_STARTED) {
                arrayList.add(btVar);
            }
        }
        aqVar.AppsFlyerLib = arrayList.size();
        for (final bt btVar2 : arrayList) {
            int i = AnonymousClass1.valueOf[btVar2.AFInAppEventParameterName.ordinal()];
            if (i == 1) {
                StringBuilder sb = new StringBuilder("[DDL] ");
                sb.append(btVar2.AFKeystoreWrapper.get("source"));
                sb.append(" referrer collected earlier");
                AFLogger.values(sb.toString());
                aqVar.valueOf(btVar2);
            } else if (i == 2) {
                btVar2.addObserver(new Observer() { // from class: com.appsflyer.internal.aq.2
                    {
                        aq.this = aqVar;
                    }

                    @Override // java.util.Observer
                    public final void update(Observable observable, Object obj) {
                        StringBuilder sb2 = new StringBuilder("[DDL] ");
                        sb2.append(btVar2.AFKeystoreWrapper.get("source"));
                        sb2.append(" referrer collected via observer");
                        AFLogger.values(sb2.toString());
                        aq.this.valueOf((bt) observable);
                    }
                });
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00c1, code lost:
    
        return new com.appsflyer.deeplink.DeepLinkResult(null, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ com.appsflyer.deeplink.DeepLinkResult valueOf(com.appsflyer.internal.aq r9, android.content.Context r10) throws java.io.IOException, org.json.JSONException, java.lang.InterruptedException {
        /*
        L0:
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r9.onDeepLinkingNative
            r3 = 1
            if (r2 != r3) goto L1e
            org.json.JSONObject r2 = r9.onValidateInAppFailure
            com.appsflyer.internal.au r4 = r9.onDeepLinking
            android.content.SharedPreferences r4 = r4.valueOf
            r5 = 0
            java.lang.String r7 = "fg_ts"
            long r4 = r4.getLong(r7, r5)
            long r4 = r0 - r4
            java.lang.String r6 = "from_fg"
            r2.put(r6, r4)
        L1e:
            com.appsflyer.internal.m r2 = new com.appsflyer.internal.m
            r2.<init>(r9)
            java.net.HttpURLConnection r2 = r2.AFInAppEventType()
            org.json.JSONObject r4 = r9.onValidateInAppFailure
            java.lang.String r5 = "net"
            org.json.JSONArray r4 = r4.optJSONArray(r5)
            if (r4 != 0) goto L36
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
        L36:
            long r6 = java.lang.System.currentTimeMillis()
            int r8 = r9.onDeepLinkingNative
            int r8 = r8 - r3
            long r0 = r6 - r0
            r4.put(r8, r0)
            org.json.JSONObject r0 = r9.onValidateInAppFailure
            r0.put(r5, r4)
            int r0 = r2.getResponseCode()
            r1 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r0 != r1) goto Lc2
            com.appsflyer.internal.ae.values()
            java.lang.String r0 = com.appsflyer.internal.ae.AFKeystoreWrapper(r2)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r0)
            java.lang.String r0 = "is_second_ping"
            boolean r0 = r1.optBoolean(r0, r3)
            r9.AppsFlyerConversionListener = r0
            java.lang.String r0 = "found"
            boolean r0 = r1.optBoolean(r0)
            if (r0 != 0) goto L6e
            r0 = r4
            goto L7f
        L6e:
            java.lang.String r0 = "click_event"
            org.json.JSONObject r0 = r1.optJSONObject(r0)
            com.appsflyer.deeplink.DeepLink r0 = com.appsflyer.deeplink.DeepLink.AFInAppEventParameterName(r0)
            org.json.JSONObject r1 = r0.AFInAppEventParameterName
            java.lang.String r2 = "is_deferred"
            r1.put(r2, r3)
        L7f:
            if (r0 == 0) goto L87
            com.appsflyer.deeplink.DeepLinkResult r9 = new com.appsflyer.deeplink.DeepLinkResult
            r9.<init>(r0, r4)
            return r9
        L87:
            int r0 = r9.onDeepLinkingNative
            if (r0 > r3) goto Lbc
            boolean r0 = r9.valueOf()
            if (r0 == 0) goto Lbc
            boolean r0 = r9.AppsFlyerConversionListener
            if (r0 == 0) goto Lbc
            java.lang.String r0 = "[DDL] Waiting for referrers..."
            com.appsflyer.AFLogger.values(r0)
            java.util.concurrent.CountDownLatch r0 = r9.onConversionDataSuccess
            r0.await()
            org.json.JSONObject r0 = r9.onValidateInAppFailure
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r6
            java.lang.String r3 = "rfr_wait"
            r0.put(r3, r1)
            int r0 = r9.AppsFlyerInAppPurchaseValidatorListener
            int r1 = r9.AppsFlyerLib
            if (r0 != r1) goto Lb7
            com.appsflyer.deeplink.DeepLinkResult r9 = new com.appsflyer.deeplink.DeepLinkResult
            r9.<init>(r4, r4)
            return r9
        Lb7:
            r9.AFKeystoreWrapper(r10)
            goto L0
        Lbc:
            com.appsflyer.deeplink.DeepLinkResult r9 = new com.appsflyer.deeplink.DeepLinkResult
            r9.<init>(r4, r4)
            return r9
        Lc2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "[DDL] Error occurred. Server response code = "
            r9.<init>(r10)
            int r10 = r2.getResponseCode()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.values(r9)
            com.appsflyer.deeplink.DeepLinkResult r9 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r10 = com.appsflyer.deeplink.DeepLinkResult.Error.HTTP_STATUS_CODE
            r9.<init>(r4, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aq.valueOf(com.appsflyer.internal.aq, android.content.Context):com.appsflyer.deeplink.DeepLinkResult");
    }
}
