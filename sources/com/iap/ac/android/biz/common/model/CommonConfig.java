package com.iap.ac.android.biz.common.model;

import android.text.TextUtils;
import com.iap.ac.android.biz.common.BuildConfig;
import com.iap.ac.android.biz.common.internal.consts.InnerConstants;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class CommonConfig {
    public static final String SANDBOXMOCK = "SANDBOX%s_AC";
    public String appId;
    public String authCode;
    public String cdnUrl;
    public List<String> certList;
    public String clientId;
    public Set<String> crashWhiteListSet;
    public String defaultMobilePhoneRegionCode;
    public String defaultRegion;
    public String pspId;
    public String siteName;
    public String amcsGatewayUrl = "https://imgs-ac.alipay.com/imgw.htm";
    public String envType = "PROD";
    public String gatewayUrl = "https://imgs-ac.alipay.com/imgw.htm";
    public String gpSignature = "";
    public String logGatewayUrl = BuildConfig.GATEWAY_LOG_PROD;
    public String acsAppId = InnerConstants.APP_ID_ACS;
    public String golGoogleUrl = BuildConfig.GOL_GOOGLE_GATEWAY_PROD;
    public boolean acLogDisabled = false;

    public String getLogProductId() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.appId);
        sb.append("_ANDROID-");
        sb.append(this.envType);
        return sb.toString();
    }

    public String getWorkspaceId() {
        return TextUtils.equals("PRE", this.envType) ? "pre" : "default";
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.envType)) ? false : true;
    }

    public void setEnvType(String str) {
        this.envType = str;
        if (TextUtils.isEmpty(str)) {
            this.envType = "PROD";
        }
        String str2 = this.envType;
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1711584601:
                if (str2.equals("SANDBOX")) {
                    c = 0;
                    break;
                }
                break;
            case 67573:
                if (str2.equals("DEV")) {
                    c = 1;
                    break;
                }
                break;
            case 79491:
                if (str2.equals("PRE")) {
                    c = 2;
                    break;
                }
                break;
            case 82110:
                if (str2.equals("SIT")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            this.gatewayUrl = "https://imgs-ac.alipay.com/imgw.htm";
            this.amcsGatewayUrl = "https://imgs-ac.alipay.com/imgw.htm";
        } else if (c == 1) {
            this.gatewayUrl = BuildConfig.GATEWAY_DEV;
            this.amcsGatewayUrl = BuildConfig.AMCS_GATEWAY_DEV;
            this.golGoogleUrl = BuildConfig.GOL_GOOGLE_GATEWAY_DEV;
            this.cdnUrl = "https://render.alipay.com/p/w/ac_cdn_data/static/";
        } else if (c == 2) {
            this.gatewayUrl = "https://imgs-sea-pre.alipay.com/imgw.htm";
            this.amcsGatewayUrl = "https://imgs-sea-pre.alipay.com/imgw.htm";
        } else if (c != 3) {
            this.envType = "PROD";
            this.gatewayUrl = "https://imgs-ac.alipay.com/imgw.htm";
            this.amcsGatewayUrl = BuildConfig.AMCS_GATEWAY_PROD;
            this.logGatewayUrl = BuildConfig.GATEWAY_LOG_PROD;
            this.golGoogleUrl = BuildConfig.GOL_GOOGLE_GATEWAY_PROD;
            this.cdnUrl = "https://render.alipay.com/p/w/ac_cdn_data/static/";
        } else {
            this.gatewayUrl = "https://imgs-sit-sg.dl.alipaydev.com/imgw.htm";
            this.amcsGatewayUrl = "https://imgs-sit-sg.dl.alipaydev.com/imgw.htm";
        }
    }
}
