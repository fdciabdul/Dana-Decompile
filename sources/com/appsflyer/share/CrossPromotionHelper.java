package com.appsflyer.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.bs;
import com.appsflyer.internal.bv;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public class CrossPromotionHelper {
    private static String valueOf = "https://%simpression.%s";

    public static void logAndOpenStore(Context context, String str, String str2) {
        logAndOpenStore(context, str, str2, null);
    }

    public static void logAndOpenStore(Context context, String str, String str2, Map<String, String> map) {
        LinkGenerator AFKeystoreWrapper = AFKeystoreWrapper(context, str, str2, map, String.format(bv.AFKeystoreWrapper, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()));
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.AFInAppEventType("CustomerUserId not set, track And Open Store is disabled", true);
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("af_campaign", str2);
        AppsFlyerLib.getInstance().logEvent(context, "af_cross_promotion", map);
        new Thread(new a(AFKeystoreWrapper.generateLink(), new bs(), context, AppsFlyerLib.getInstance().isStopped())).start();
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2) {
        logCrossPromoteImpression(context, str, str2, null);
    }

    public static void logCrossPromoteImpression(Context context, String str, String str2, Map<String, String> map) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.AFInAppEventType("CustomerUserId not set, Promote Impression is disabled", true);
        } else {
            new Thread(new a(AFKeystoreWrapper(context, str, str2, map, String.format(valueOf, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName())).generateLink(), null, null, AppsFlyerLib.getInstance().isStopped())).start();
        }
    }

    private static LinkGenerator AFKeystoreWrapper(Context context, String str, String str2, Map<String, String> map, String str3) {
        LinkGenerator linkGenerator = new LinkGenerator("af_cross_promotion");
        linkGenerator.AFInAppEventParameterName = str3;
        linkGenerator.valueOf = str;
        linkGenerator.addParameter("af_siteid", context.getPackageName());
        if (str2 != null) {
            linkGenerator.setCampaign(str2);
        }
        if (map != null) {
            linkGenerator.addParameters(map);
        }
        String string = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string != null) {
            linkGenerator.addParameter("advertising_id", string);
        }
        return linkGenerator;
    }

    public static void setUrl(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            char c = 65535;
            int hashCode = key.hashCode();
            if (hashCode != 96801) {
                if (hashCode == 120623625 && key.equals("impression")) {
                    c = 1;
                }
            } else if (key.equals(GriverOnPreloadExtension.PARAMS_APP)) {
                c = 0;
            }
            if (c == 0) {
                bv.AFKeystoreWrapper = value;
            } else if (c == 1) {
                valueOf = value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a implements Runnable {
        private final boolean AFInAppEventParameterName;
        private final String AFInAppEventType;
        private final bs AFKeystoreWrapper;
        private final WeakReference<Context> valueOf;

        a(String str, bs bsVar, Context context, boolean z) {
            this.AFInAppEventType = str;
            this.AFKeystoreWrapper = bsVar;
            this.valueOf = new WeakReference<>(context);
            this.AFInAppEventParameterName = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Throwable th;
            HttpURLConnection httpURLConnection;
            if (this.AFInAppEventParameterName) {
                return;
            }
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(this.AFInAppEventType).openConnection())));
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
            }
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(false);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    StringBuilder sb = new StringBuilder("Cross promotion impressions success: ");
                    sb.append(this.AFInAppEventType);
                    AFLogger.AFInAppEventType(sb.toString(), false);
                } else if (responseCode == 301 || responseCode == 302) {
                    StringBuilder sb2 = new StringBuilder("Cross promotion redirection success: ");
                    sb2.append(this.AFInAppEventType);
                    AFLogger.AFInAppEventType(sb2.toString(), false);
                    if (this.AFKeystoreWrapper != null && this.valueOf.get() != null) {
                        this.AFKeystoreWrapper.AFInAppEventType = httpURLConnection.getHeaderField("Location");
                        bs bsVar = this.AFKeystoreWrapper;
                        Context context = this.valueOf.get();
                        if (bsVar.AFInAppEventType != null) {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bsVar.AFInAppEventType)).setFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                        }
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder("call to ");
                    sb3.append(this.AFInAppEventType);
                    sb3.append(" failed: ");
                    sb3.append(responseCode);
                    AFLogger.AFKeystoreWrapper(sb3.toString());
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    AFLogger.AFInAppEventParameterName(th.getMessage(), th);
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
