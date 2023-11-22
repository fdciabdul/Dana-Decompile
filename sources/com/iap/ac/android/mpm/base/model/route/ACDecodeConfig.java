package com.iap.ac.android.mpm.base.model.route;

/* loaded from: classes3.dex */
public class ACDecodeConfig {
    public String acquireId;
    public String minAndroidAcSdkVersion;
    public String minIOSAcSdkVersion;
    public String redirectUrl;
    public String routerType;
    public String ruleId;
    public String userAgent;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ACDecodeConfig{routerType='");
        sb.append(this.routerType);
        sb.append('\'');
        sb.append(", userAgent='");
        sb.append(this.userAgent);
        sb.append('\'');
        sb.append(", minAndroidAcSdkVersion='");
        sb.append(this.minAndroidAcSdkVersion);
        sb.append('\'');
        sb.append(", minIOSAcSdkVersion='");
        sb.append(this.minIOSAcSdkVersion);
        sb.append('\'');
        sb.append(", ruleId='");
        sb.append(this.ruleId);
        sb.append('\'');
        sb.append(", acquireId='");
        sb.append(this.acquireId);
        sb.append('\'');
        sb.append(", redirectUrl='");
        sb.append(this.redirectUrl);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
