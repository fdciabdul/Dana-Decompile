package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AppsFlyerProperties;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.oauth.OauthConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract class ak implements Runnable {
    protected static String AFInAppEventParameterName = null;
    private static int AFLogger$LogLevel = 0;
    private static int AFVersionDeclaration = 0;
    private static int onAppOpenAttributionNative = 1;
    private static short[] onAttributionFailureNative;
    private static int onDeepLinkingNative;
    private static int onInstallConversionDataLoadedNative;
    private static byte[] onInstallConversionFailureNative;
    private static String valueOf;
    public final String AFInAppEventType;
    public String AFKeystoreWrapper;
    public final String AppsFlyer2dXConversionCallback = UUID.randomUUID().toString();
    public final Map<String, Object> getLevel = valueOf();
    private final Context init;
    private final ae values;

    static void values() {
        AFLogger$LogLevel = 91;
        AFVersionDeclaration = -784549513;
        onDeepLinkingNative = -1400650653;
        onInstallConversionFailureNative = new byte[]{-79, -13, -3, 1, 19, -13, 7, -2, 22, 38, -57, 37};
    }

    protected abstract String AFInAppEventParameterName();

    protected abstract void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    protected abstract void AFInAppEventType();

    protected abstract void AFKeystoreWrapper(String str);

    static {
        values();
        valueOf = "v2";
        StringBuilder sb = new StringBuilder("https://%sonelink.%s/shortlink-sdk/");
        sb.append(valueOf);
        AFInAppEventParameterName = sb.toString();
        int i = onInstallConversionDataLoadedNative + 43;
        onAppOpenAttributionNative = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw new ArithmeticException();
    }

    public ak(ae aeVar, Context context, String str) {
        this.values = aeVar;
        this.init = context;
        this.AFInAppEventType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void values(HttpsURLConnection httpsURLConnection, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, valueOf);
        String join = TextUtils.join("\u2063", arrayList.toArray());
        StringBuilder sb = new StringBuilder();
        sb.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        sb.append(this.AppsFlyer2dXConversionCallback);
        sb.append(valueOf);
        httpsURLConnection.setRequestProperty(valueOf((byte) (ViewConfiguration.getPressedStateDuration() >> 16), 1400650718 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) View.getDefaultSize(0, 0), Color.rgb(0, 0, 0) + 801326729, (-88) - AndroidCharacter.getEastAsianWidth('0')).intern(), af.values(join, sb.toString()));
        onInstallConversionDataLoadedNative = (onAppOpenAttributionNative + 33) % 128;
    }

    private Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.3.2");
        hashMap.put("counter", Integer.valueOf(ae.valueOf(ae.values(this.init), "appsFlyerCount", false)));
        hashMap.put(H5GetLogInfoBridge.RESULT_MODEL, Build.MODEL);
        hashMap.put(H5GetLogInfoBridge.RESULT_BRAND, Build.BRAND);
        hashMap.put(OauthConstant.OauthType.SDK_TYPE, Integer.toString(Build.VERSION.SDK_INT));
        try {
            hashMap.put("app_version_name", this.init.getPackageManager().getPackageInfo(this.init.getPackageName(), 0).versionName);
            onInstallConversionDataLoadedNative = (onAppOpenAttributionNative + 101) % 128;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        hashMap.put("app_id", this.init.getPackageName());
        hashMap.put("platformextension", new al().AFInAppEventParameterName());
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r6.AFInAppEventParameterName()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "oneLinkUrl: "
            java.lang.String r2 = r3.concat(r2)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r2)
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L77
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L77
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L77
            java.net.URLConnection r2 = com.fullstory.instrumentation.InstrumentInjector.urlconnection_wrapInstance(r2)     // Catch: java.lang.Throwable -> L77
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch: java.lang.Throwable -> L77
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch: java.lang.Throwable -> L77
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = "content-type"
            java.lang.String r4 = "application/json"
            r2.setRequestProperty(r3, r4)     // Catch: java.lang.Throwable -> L77
            r3 = 3000(0xbb8, float:4.204E-42)
            r2.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L77
            r2.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L77
            java.lang.String r3 = r6.AFInAppEventType     // Catch: java.lang.Throwable -> L77
            r2.setRequestMethod(r3)     // Catch: java.lang.Throwable -> L77
            r6.AFInAppEventParameterName(r2)     // Catch: java.lang.Throwable -> L77
            int r3 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = com.appsflyer.internal.ae.AFKeystoreWrapper(r2)     // Catch: java.lang.Throwable -> L77
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L4d
            r4 = 1
            goto L4e
        L4d:
            r4 = 0
        L4e:
            if (r4 == 0) goto L5e
            int r3 = com.appsflyer.internal.ak.onInstallConversionDataLoadedNative
            int r3 = r3 + 107
            int r3 = r3 % 128
            com.appsflyer.internal.ak.onAppOpenAttributionNative = r3
            java.lang.String r3 = "Status 200 ok"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r3)     // Catch: java.lang.Throwable -> L75
            goto La0
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            java.lang.String r4 = "Response code = "
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L75
            r0.append(r3)     // Catch: java.lang.Throwable -> L75
            java.lang.String r3 = " content = "
            r0.append(r3)     // Catch: java.lang.Throwable -> L75
            r0.append(r2)     // Catch: java.lang.Throwable -> L75
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L75
            goto La0
        L75:
            r0 = move-exception
            goto L7b
        L77:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L7b:
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.AFInAppEventType(r3, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " stacktrace: "
            r3.append(r1)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        La0:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lb7
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Connection call succeeded: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            r6.AFKeystoreWrapper(r2)
            return
        Lb7:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.init(r0)
            r6.AFInAppEventType()
            int r0 = com.appsflyer.internal.ak.onInstallConversionDataLoadedNative
            int r0 = r0 + 115
            int r0 = r0 % 128
            com.appsflyer.internal.ak.onAppOpenAttributionNative = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ak.run():void");
    }

    private static String valueOf(byte b, int i, short s, int i2, int i3) {
        int i4;
        int i5;
        StringBuilder sb = new StringBuilder();
        int i6 = AFLogger$LogLevel;
        int i7 = i3 + i6;
        int i8 = (i7 == -1 ? (char) 17 : ';') != 17 ? 0 : 1;
        if (i8 != 0) {
            byte[] bArr = onInstallConversionFailureNative;
            if (bArr != null) {
                i7 = (byte) (bArr[AFVersionDeclaration + i2] + i6);
            } else {
                i7 = (short) (onAttributionFailureNative[AFVersionDeclaration + i2] + i6);
            }
        }
        if (i7 > 0) {
            int i9 = ((i2 + i7) - 2) + AFVersionDeclaration + i8;
            char c = (char) (i + onDeepLinkingNative);
            sb.append(c);
            for (int i10 = 1; i10 < i7; i10++) {
                int i11 = onAppOpenAttributionNative;
                onInstallConversionDataLoadedNative = (i11 + 45) % 128;
                byte[] bArr2 = onInstallConversionFailureNative;
                if ((bArr2 != null ? (char) 19 : '.') != 19) {
                    c = (char) (c + (((short) (onAttributionFailureNative[i9] + s)) ^ b));
                    onInstallConversionDataLoadedNative = (i11 + 11) % 128;
                    i9--;
                } else {
                    int i12 = i11 + 17;
                    onInstallConversionDataLoadedNative = i12 % 128;
                    if (i12 % 2 != 0) {
                        i4 = i9 + 119;
                        i5 = c >> (((byte) (bArr2[i9] >>> s)) | b);
                    } else {
                        i4 = i9 - 1;
                        i5 = c + (((byte) (bArr2[i9] + s)) ^ b);
                    }
                    c = (char) i5;
                    i9 = i4;
                }
                sb.append(c);
            }
        }
        String obj = sb.toString();
        onInstallConversionDataLoadedNative = (onAppOpenAttributionNative + 25) % 128;
        return obj;
    }
}
