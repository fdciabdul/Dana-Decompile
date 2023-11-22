package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.bv;
import com.appsflyer.internal.k;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class LinkGenerator {
    String AFInAppEventParameterName;
    private String AFInAppEventType;
    private String AFKeystoreWrapper;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private String getLevel;
    private String init;
    private Map<String, String> onAppOpenAttributionNative = new HashMap();
    private Map<String, String> onDeepLinkingNative = new HashMap();
    private String onInstallConversionDataLoadedNative;
    private String onInstallConversionFailureNative;
    String valueOf;
    private String values;

    public LinkGenerator(String str) {
        this.AFInAppEventType = str;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.onInstallConversionFailureNative = str;
        return this;
    }

    public String getBrandDomain() {
        return this.onInstallConversionFailureNative;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.AFLogger$LogLevel = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.onInstallConversionDataLoadedNative = str;
        return this;
    }

    public String getChannel() {
        return this.AFKeystoreWrapper;
    }

    public LinkGenerator setChannel(String str) {
        this.AFKeystoreWrapper = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.getLevel = str;
        return this;
    }

    public String getMediaSource() {
        return this.AFInAppEventType;
    }

    public Map<String, String> getParameters() {
        return this.onAppOpenAttributionNative;
    }

    public String getCampaign() {
        return this.values;
    }

    public LinkGenerator setCampaign(String str) {
        this.values = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.onAppOpenAttributionNative.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.onAppOpenAttributionNative.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.init = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.AppsFlyer2dXConversionCallback = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.AFVersionDeclaration = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFInAppEventParameterName = String.format("https://%s/%s", String.format("%sapp.%s", AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()), str3);
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.AFInAppEventParameterName = String.format("https://%s/%s", str2, str);
        }
        return this;
    }

    private StringBuilder AFKeystoreWrapper() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFInAppEventParameterName;
        if (str != null && str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            sb.append(this.AFInAppEventParameterName);
        } else {
            sb.append(String.format(bv.AFKeystoreWrapper, AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()));
        }
        if (this.valueOf != null) {
            sb.append('/');
            sb.append(this.valueOf);
        }
        this.onDeepLinkingNative.put("pid", this.AFInAppEventType);
        sb.append('?');
        sb.append("pid=");
        sb.append(values(this.AFInAppEventType, "media source"));
        String str2 = this.init;
        if (str2 != null) {
            this.onDeepLinkingNative.put("af_referrer_uid", str2);
            sb.append(Typography.amp);
            sb.append("af_referrer_uid=");
            sb.append(values(this.init, "referrerUID"));
        }
        String str3 = this.AFKeystoreWrapper;
        if (str3 != null) {
            this.onDeepLinkingNative.put(AFInAppEventParameterName.AF_CHANNEL, str3);
            sb.append(Typography.amp);
            sb.append("af_channel=");
            sb.append(values(this.AFKeystoreWrapper, "channel"));
        }
        String str4 = this.getLevel;
        if (str4 != null) {
            this.onDeepLinkingNative.put("af_referrer_customer_id", str4);
            sb.append(Typography.amp);
            sb.append("af_referrer_customer_id=");
            sb.append(values(this.getLevel, "referrerCustomerId"));
        }
        String str5 = this.values;
        if (str5 != null) {
            this.onDeepLinkingNative.put("c", str5);
            sb.append(Typography.amp);
            sb.append("c=");
            sb.append(values(this.values, "campaign"));
        }
        String str6 = this.AppsFlyer2dXConversionCallback;
        if (str6 != null) {
            this.onDeepLinkingNative.put("af_referrer_name", str6);
            sb.append(Typography.amp);
            sb.append("af_referrer_name=");
            sb.append(values(this.AppsFlyer2dXConversionCallback, "referrerName"));
        }
        String str7 = this.AFVersionDeclaration;
        if (str7 != null) {
            this.onDeepLinkingNative.put("af_referrer_image_url", str7);
            sb.append(Typography.amp);
            sb.append("af_referrer_image_url=");
            sb.append(values(this.AFVersionDeclaration, "referrerImageURL"));
        }
        if (this.onInstallConversionDataLoadedNative != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.onInstallConversionDataLoadedNative);
            sb2.append(this.onInstallConversionDataLoadedNative.endsWith("/") ? "" : "/");
            String str8 = this.AFLogger$LogLevel;
            if (str8 != null) {
                sb2.append(str8);
            }
            this.onDeepLinkingNative.put("af_dp", sb2.toString());
            sb.append(Typography.amp);
            sb.append("af_dp=");
            sb.append(values(this.onInstallConversionDataLoadedNative, "baseDeeplink"));
            if (this.AFLogger$LogLevel != null) {
                sb.append(this.onInstallConversionDataLoadedNative.endsWith("/") ? "" : "%2F");
                sb.append(values(this.AFLogger$LogLevel, "deeplinkPath"));
            }
        }
        for (String str9 : this.onAppOpenAttributionNative.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str9);
            sb3.append("=");
            sb3.append(values(this.onAppOpenAttributionNative.get(str9), str9));
            if (!obj.contains(sb3.toString())) {
                sb.append(Typography.amp);
                sb.append(str9);
                sb.append('=');
                sb.append(values(this.onAppOpenAttributionNative.get(str9), str9));
            }
        }
        return sb;
    }

    private static String values(String str, String str2) {
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.AFInAppEventType(sb.toString(), e);
            return "";
        } catch (Throwable th) {
            AFLogger.values(th);
            return "";
        }
    }

    public String generateLink() {
        return AFKeystoreWrapper().toString();
    }

    public void generateLink(Context context, CreateOneLinkHttpTask.ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.onAppOpenAttributionNative.isEmpty()) {
            for (Map.Entry<String, String> entry : this.onAppOpenAttributionNative.entrySet()) {
                this.onDeepLinkingNative.put(entry.getKey(), entry.getValue());
            }
        }
        AFKeystoreWrapper();
        String str = this.onInstallConversionFailureNative;
        Map<String, String> map = this.onDeepLinkingNative;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.AFInAppEventType("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, map, ae.values(), context);
        createOneLinkHttpTask.values = responseListener;
        createOneLinkHttpTask.valueOf = str;
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        k.valueOf.valueOf().execute(createOneLinkHttpTask);
    }
}
