package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j {
    static final int AFInAppEventType = (int) TimeUnit.SECONDS.toMillis(2);
    static String[] AFKeystoreWrapper;
    static String[] AppsFlyer2dXConversionCallback;
    private static j init;
    static volatile boolean valueOf;
    public static Intent values;
    public DeepLinkListener AFInAppEventParameterName;
    public Map<String, String> AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public List<List<String>> getLevel = new ArrayList();

    public static j AFInAppEventType() {
        if (init == null) {
            init = new j();
        }
        return init;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AFKeystoreWrapper(java.util.Map<java.lang.String, java.lang.Object> r5, com.appsflyer.internal.au r6, android.content.Intent r7, android.content.Context r8) {
        /*
            r4 = this;
            android.content.SharedPreferences r0 = com.appsflyer.internal.ae.values(r8)
            boolean r5 = r4.AFKeystoreWrapper(r7, r8, r5)
            java.lang.String r7 = "ddl_sent"
            if (r5 != 0) goto L97
            com.appsflyer.deeplink.DeepLinkListener r5 = r4.AFInAppEventParameterName
            if (r5 == 0) goto L97
            com.appsflyer.internal.ae.values()
            r5 = 0
            java.lang.String r1 = "appsFlyerCount"
            int r1 = com.appsflyer.internal.ae.valueOf(r0, r1, r5)
            if (r1 != 0) goto L97
            boolean r5 = r0.getBoolean(r7, r5)
            if (r5 != 0) goto L97
            com.appsflyer.internal.aq r5 = new com.appsflyer.internal.aq
            r5.<init>(r8, r6)
            java.lang.String r6 = "[DDL] start"
            com.appsflyer.AFLogger.values(r6)
            java.util.concurrent.FutureTask r6 = new java.util.concurrent.FutureTask
            com.appsflyer.internal.aq$3 r8 = new com.appsflyer.internal.aq$3
            r8.<init>()
            r6.<init>(r8)
            java.lang.Thread r8 = new java.lang.Thread
            r8.<init>(r6)
            r8.start()
            r8 = 0
            long r1 = com.appsflyer.internal.aq.onInstallConversionDataLoadedNative     // Catch: java.util.concurrent.TimeoutException -> L4d java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L4d java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c
            java.lang.Object r6 = r6.get(r1, r3)     // Catch: java.util.concurrent.TimeoutException -> L4d java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c
            com.appsflyer.deeplink.DeepLinkResult r6 = (com.appsflyer.deeplink.DeepLinkResult) r6     // Catch: java.util.concurrent.TimeoutException -> L4d java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c
            r5.values(r6)     // Catch: java.util.concurrent.TimeoutException -> L4d java.lang.InterruptedException -> L7a java.util.concurrent.ExecutionException -> L7c
            goto L97
        L4d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "[DDL] Timeout, didn't manage to find deferred deep link after "
            r6.<init>(r1)
            int r1 = r5.onDeepLinkingNative
            r6.append(r1)
            java.lang.String r1 = " attempt(s) within "
            r6.append(r1)
            long r1 = com.appsflyer.internal.aq.onInstallConversionDataLoadedNative
            r6.append(r1)
            java.lang.String r1 = " milliseconds"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.appsflyer.AFLogger.values(r6)
            com.appsflyer.deeplink.DeepLinkResult r6 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r1 = com.appsflyer.deeplink.DeepLinkResult.Error.TIMEOUT
            r6.<init>(r8, r1)
            r5.values(r6)
            goto L97
        L7a:
            r6 = move-exception
            goto L7d
        L7c:
            r6 = move-exception
        L7d:
            java.lang.String r1 = "[DDL] Error occurred"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1, r6)
            java.lang.Throwable r6 = r6.getCause()
            boolean r6 = r6 instanceof java.io.IOException
            if (r6 == 0) goto L8d
            com.appsflyer.deeplink.DeepLinkResult$Error r6 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            goto L8f
        L8d:
            com.appsflyer.deeplink.DeepLinkResult$Error r6 = com.appsflyer.deeplink.DeepLinkResult.Error.UNEXPECTED
        L8f:
            com.appsflyer.deeplink.DeepLinkResult r1 = new com.appsflyer.deeplink.DeepLinkResult
            r1.<init>(r8, r6)
            r5.values(r1)
        L97:
            android.content.SharedPreferences$Editor r5 = r0.edit()
            r6 = 1
            android.content.SharedPreferences$Editor r5 = r5.putBoolean(r7, r6)
            r5.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.j.AFKeystoreWrapper(java.util.Map, com.appsflyer.internal.au, android.content.Intent, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean AFInAppEventParameterName(String str) {
        if (AFKeystoreWrapper == null || str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate if link ");
        sb.append(str);
        sb.append(" belongs to ESP domains: ");
        sb.append(Arrays.asList(AFKeystoreWrapper));
        AFLogger.AFInAppEventParameterName(sb.toString());
        try {
            return Arrays.asList(AFKeystoreWrapper).contains(new URL(str).getHost());
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void AFInAppEventType(final Context context, final Map<String, Object> map, final Uri uri) {
        if (AFInAppEventParameterName(uri.toString())) {
            valueOf = true;
            if (k.valueOf == null) {
                k.valueOf = new k();
            }
            k kVar = k.valueOf;
            if (kVar.AFInAppEventParameterName == null) {
                kVar.AFInAppEventParameterName = Executors.newSingleThreadScheduledExecutor(kVar.AFInAppEventType);
            }
            kVar.AFInAppEventParameterName.execute(new Runnable() { // from class: com.appsflyer.internal.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    String obj = uri.toString();
                    ArrayList arrayList = new ArrayList();
                    Integer num = null;
                    String str = null;
                    int i = 0;
                    while (i < 5) {
                        Map<String, Object> AFInAppEventType2 = AFInAppEventType(Uri.parse(obj));
                        String str2 = (String) AFInAppEventType2.get("res");
                        Integer num2 = (Integer) AFInAppEventType2.get("status");
                        String str3 = (String) AFInAppEventType2.get("error");
                        if (str2 == null || !j.AFInAppEventParameterName(str2)) {
                            str = str3;
                            obj = str2;
                            num = num2;
                            break;
                        }
                        if (i < 4) {
                            arrayList.add(str2);
                        }
                        i++;
                        str = str3;
                        obj = str2;
                        num = num2;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("res", obj != null ? obj : "");
                    hashMap.put("status", Integer.valueOf(num != null ? num.intValue() : -1));
                    if (str != null) {
                        hashMap.put("error", str);
                    }
                    if (!arrayList.isEmpty()) {
                        hashMap.put("redirects", arrayList);
                    }
                    hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    synchronized (map) {
                        map.put("af_deeplink_r", hashMap);
                        map.put("af_deeplink", uri.toString());
                    }
                    ae.values().AFInAppEventParameterName(context, map, obj != null ? Uri.parse(obj) : uri);
                    j.valueOf = false;
                }

                private static Map<String, Object> AFInAppEventType(Uri uri2) {
                    HashMap hashMap = new HashMap();
                    try {
                        StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
                        sb.append(uri2.toString());
                        AFLogger.values(sb.toString());
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(uri2.toString()).openConnection())));
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setReadTimeout(j.AFInAppEventType);
                        httpURLConnection.setConnectTimeout(j.AFInAppEventType);
                        httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                        httpURLConnection.setRequestProperty("af-esp", "6.3.2");
                        int responseCode = httpURLConnection.getResponseCode();
                        hashMap.put("status", Integer.valueOf(responseCode));
                        if (300 <= responseCode && responseCode <= 305) {
                            hashMap.put("res", httpURLConnection.getHeaderField("Location"));
                        }
                        httpURLConnection.disconnect();
                        AFLogger.values("ESP deeplink resolving is finished");
                    } catch (Throwable th) {
                        hashMap.put("error", th.getLocalizedMessage());
                        AFLogger.AFInAppEventType(th.getMessage(), th);
                    }
                    return hashMap;
                }
            });
        } else {
            ae.values().AFInAppEventParameterName(context, map, uri);
        }
        values = null;
    }

    private Uri AFInAppEventType(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri AFInAppEventType(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[LOOP:0: B:21:0x0040->B:62:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean AFKeystoreWrapper(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.j.AFKeystoreWrapper(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }
}
