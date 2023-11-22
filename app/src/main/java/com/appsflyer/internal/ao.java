package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.oauth.OauthConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ao extends ak {
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    boolean valueOf;
    b values;

    /* loaded from: classes.dex */
    public interface b {
        void AFInAppEventParameterName(String str);

        void AFInAppEventParameterName(Map<String, String> map);
    }

    public ao(Uri uri, ae aeVar, Context context) {
        super(aeVar, context, "GET");
        this.valueOf = false;
        if (TextUtils.isEmpty(uri.getHost()) || TextUtils.isEmpty(uri.getPath())) {
            return;
        }
        String[] strArr = {"onelink.me", "onelnk.com", "app.aflink.com"};
        boolean z = false;
        for (int i = 0; i < 3; i++) {
            if (uri.getHost().contains(strArr[i])) {
                z = true;
            }
        }
        if (j.AppsFlyer2dXConversionCallback != null) {
            StringBuilder sb = new StringBuilder("Validate if link ");
            sb.append(uri);
            sb.append(" belongs to custom domains: ");
            sb.append(Arrays.asList(j.AppsFlyer2dXConversionCallback));
            AFLogger.AFInAppEventParameterName(sb.toString());
            for (String str : j.AppsFlyer2dXConversionCallback) {
                if (uri.getHost().contains(str) && !TextUtils.isEmpty(str)) {
                    AFLogger.values("Link matches custom domain: ".concat(String.valueOf(str)));
                    this.valueOf = true;
                    z = true;
                }
            }
        }
        String[] split = uri.getPath().split("/");
        if (z && split.length == 3) {
            this.AFKeystoreWrapper = split[1];
            this.AFVersionDeclaration = split[2];
            this.AFLogger$LogLevel = uri.toString();
        }
    }

    public final boolean AFKeystoreWrapper() {
        return (TextUtils.isEmpty(this.AFKeystoreWrapper) || TextUtils.isEmpty(this.AFVersionDeclaration) || this.AFKeystoreWrapper.equals(GriverOnPreloadExtension.PARAMS_APP)) ? false : true;
    }

    @Override // com.appsflyer.internal.ak
    protected final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Af-UUID", this.AppsFlyer2dXConversionCallback);
        String valueOf = String.valueOf(this.getLevel.get("build_number"));
        httpsURLConnection.setRequestProperty("Af-Meta-Sdk-Ver", valueOf);
        httpsURLConnection.setRequestProperty("Af-Meta-Counter", String.valueOf(this.getLevel.get("counter")));
        httpsURLConnection.setRequestProperty("Af-Meta-Model", String.valueOf(this.getLevel.get(H5GetLogInfoBridge.RESULT_MODEL)));
        httpsURLConnection.setRequestProperty("Af-Meta-Platform", String.valueOf(this.getLevel.get("platformextension")));
        httpsURLConnection.setRequestProperty("Af-Meta-System-Version", String.valueOf(this.getLevel.get(OauthConstant.OauthType.SDK_TYPE)));
        values(httpsURLConnection, this.AFInAppEventType, this.AppsFlyer2dXConversionCallback, this.AFKeystoreWrapper, this.AFVersionDeclaration, valueOf);
    }

    @Override // com.appsflyer.internal.ak
    protected final String AFInAppEventParameterName() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()));
        sb.append("/");
        sb.append(this.AFKeystoreWrapper);
        sb.append("?id=");
        sb.append(this.AFVersionDeclaration);
        return sb.toString();
    }

    @Override // com.appsflyer.internal.ak
    protected final void AFKeystoreWrapper(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.values.AFInAppEventParameterName(hashMap);
        } catch (JSONException e) {
            this.values.AFInAppEventParameterName("Can't parse OneLink data");
            AFLogger.AFInAppEventType("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.appsflyer.internal.ak
    protected final void AFInAppEventType() {
        String str = this.AFLogger$LogLevel;
        if (str == null) {
            str = "Can't get OneLink data";
        }
        this.values.AFInAppEventParameterName(str);
    }
}
