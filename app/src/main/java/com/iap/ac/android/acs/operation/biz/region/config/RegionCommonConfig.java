package com.iap.ac.android.acs.operation.biz.region.config;

/* loaded from: classes3.dex */
public class RegionCommonConfig {
    public String appId;
    public String envType;
    public String gatewayUrl;
    public String gpSignature;
    public RegionGatewayUrl regionGatewayUrl;
    public String workerSpaceId;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setEnvType(String str) {
        char c;
        this.envType = str;
        str.hashCode();
        switch (str.hashCode()) {
            case -1711584601:
                if (str.equals("SANDBOX")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 67573:
                if (str.equals("DEV")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 79491:
                if (str.equals("PRE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 82110:
                if (str.equals("SIT")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2464599:
                if (str.equals("PROD")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.gatewayUrl = this.regionGatewayUrl.SANDBOX;
        } else if (c == 1) {
            this.gatewayUrl = this.regionGatewayUrl.DEV;
        } else if (c == 2) {
            this.gatewayUrl = this.regionGatewayUrl.PRE;
        } else if (c == 3) {
            this.gatewayUrl = this.regionGatewayUrl.SIT;
        } else if (c != 4) {
        } else {
            this.gatewayUrl = this.regionGatewayUrl.PROD;
        }
    }
}
