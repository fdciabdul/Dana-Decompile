package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.constant.BranchLinkConstant;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ad implements Runnable {
    private static String AFInAppEventParameterName = "https://%ssdk-services.%s/validate-android-signature";
    private static String AFInAppEventType;
    private String AFKeystoreWrapper;
    private Map<String, String> AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private String getLevel;
    private String init;
    private WeakReference<Context> valueOf;
    private String values;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(ae.AFInAppEventType);
        sb.append("/androidevent?buildnumber=6.3.2&app_id=");
        AFInAppEventType = sb.toString();
    }

    public ad(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.valueOf = new WeakReference<>(context);
        this.values = str;
        this.AFKeystoreWrapper = str2;
        this.init = str4;
        this.getLevel = str5;
        this.AFVersionDeclaration = str6;
        this.AFLogger$LogLevel = map;
        this.AppsFlyer2dXConversionCallback = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.values;
        if (str == null || str.length() == 0 || AppsFlyerLib.getInstance().isStopped()) {
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            Context context = this.valueOf.get();
            if (context == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("public-key", this.AFKeystoreWrapper);
            hashMap.put("sig-data", this.init);
            hashMap.put(BranchLinkConstant.OauthParams.SIGNATURE, this.AppsFlyer2dXConversionCallback);
            final HashMap hashMap2 = new HashMap(hashMap);
            new Thread(new Runnable() { // from class: com.appsflyer.internal.ad.4
                {
                    ad.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ad adVar = ad.this;
                    ad.AFInAppEventParameterName(adVar, hashMap2, adVar.AFLogger$LogLevel, ad.this.valueOf);
                }
            }).start();
            hashMap.put("dev_key", this.values);
            hashMap.put("app_id", context.getPackageName());
            hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string != null) {
                hashMap.put("advertiserId", string);
            }
            String jSONObject = new JSONObject(hashMap).toString();
            String format = String.format(AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName());
            aj.valueOf().AFInAppEventType("server_request", format, jSONObject);
            HttpURLConnection AFKeystoreWrapper = AFKeystoreWrapper((bk) new bm().valueOf(hashMap).AFInAppEventParameterName(format));
            int responseCode = AFKeystoreWrapper != null ? AFKeystoreWrapper.getResponseCode() : -1;
            ae.values();
            String AFKeystoreWrapper2 = ae.AFKeystoreWrapper(AFKeystoreWrapper);
            aj.valueOf().AFInAppEventType("server_response", format, String.valueOf(responseCode), AFKeystoreWrapper2);
            JSONObject jSONObject2 = new JSONObject(AFKeystoreWrapper2);
            jSONObject2.put("code", responseCode);
            if (responseCode == 200) {
                StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                sb.append(jSONObject2.toString());
                AFLogger.AFKeystoreWrapper(sb.toString());
                valueOf(jSONObject2.optBoolean("result"), this.init, this.getLevel, this.AFVersionDeclaration, jSONObject2.toString());
            } else {
                AFLogger.AFKeystoreWrapper("Failed Validate request");
                valueOf(false, this.init, this.getLevel, this.AFVersionDeclaration, jSONObject2.toString());
            }
            if (AFKeystoreWrapper != null) {
                AFKeystoreWrapper.disconnect();
            }
        } catch (Throwable th) {
            try {
                if (ae.values != null) {
                    AFLogger.AFInAppEventType("Failed Validate request + ex", th);
                    valueOf(false, this.init, this.getLevel, this.AFVersionDeclaration, th.getMessage());
                }
                AFLogger.AFInAppEventType(th.getMessage(), th);
            } finally {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }

    private static HttpURLConnection AFKeystoreWrapper(bk bkVar) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(bkVar.onAppOpenAttributionNative);
        AFLogger.values(sb.toString());
        bkVar.onConversionDataFail = AppsFlyerLib.getInstance().isStopped();
        return new m(bkVar).AFInAppEventType();
    }

    private static void valueOf(boolean z, String str, String str2, String str3, String str4) {
        if (ae.values != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            AFLogger.values(sb.toString());
            if (z) {
                AFLogger.values("Validate in app purchase success: ".concat(String.valueOf(str4)));
                ae.values.onValidateInApp();
                return;
            }
            AFLogger.values("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = ae.values;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    static /* synthetic */ void AFInAppEventParameterName(ad adVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            z.AFKeystoreWrapper((Context) weakReference.get()).AFInAppEventType();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = ae.values((Context) weakReference.get()).getString("referrer", "");
            g bnVar = new bn((Context) weakReference.get());
            bnVar.AFVersionDeclaration = adVar.values;
            bnVar.init = string;
            bn bnVar2 = (bn) bnVar;
            ae values = ae.values();
            Map<String, Object> values2 = values.values(bnVar);
            values2.put(FirebaseAnalytics.Param.PRICE, adVar.getLevel);
            values2.put(FirebaseAnalytics.Param.CURRENCY, adVar.AFVersionDeclaration);
            values2.put("receipt_data", map);
            if (map2 != null) {
                values2.put("extra_prms", map2);
            }
            values2.putAll(values.AFInAppEventParameterName());
            aj.valueOf().AFInAppEventType("server_request", obj, new JSONObject(values2).toString());
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = AFKeystoreWrapper((bk) bnVar.valueOf(values2).AFInAppEventParameterName(obj));
                int responseCode = httpURLConnection != null ? httpURLConnection.getResponseCode() : -1;
                String AFKeystoreWrapper = ae.AFKeystoreWrapper(httpURLConnection);
                aj.valueOf().AFInAppEventType("server_response", obj, String.valueOf(responseCode), AFKeystoreWrapper);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(responseCode);
                sb2.append(": ");
                sb2.append(new JSONObject(AFKeystoreWrapper).toString());
                AFLogger.AFKeystoreWrapper(sb2.toString());
            } catch (Throwable th) {
                try {
                    AFLogger.AFInAppEventType(th.getMessage(), th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }
    }
}
