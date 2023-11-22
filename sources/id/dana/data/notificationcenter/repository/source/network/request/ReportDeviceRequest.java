package id.dana.data.notificationcenter.repository.source.network.request;

import android.os.Build;

/* loaded from: classes4.dex */
public class ReportDeviceRequest {
    private String connectType;
    private String deliveryToken;
    private String thirdChannelDeviceToken;
    private final String appId = "6CC59C4231550";
    private final int osType = 1;
    private final String workspaceId = "prod";
    private String imei = "";
    private String imsi = "";
    private final String appVersion = "2470106";
    private final String model = Build.MODEL;
    private final int thirdChannel = 6;
    private final String channel = "Google Play";
    private final String pushVersion = "";

    public String getAppId() {
        return "6CC59C4231550";
    }

    public String getAppVersion() {
        return "2470106";
    }

    public String getChannel() {
        return "Google Play";
    }

    public int getOsType() {
        return 1;
    }

    public String getPushVersion() {
        return "";
    }

    public int getThirdChannel() {
        return 6;
    }

    public String getWorkspaceId() {
        return "prod";
    }

    public void setDeliveryToken(String str) {
        this.deliveryToken = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setConnectType(String str) {
        this.connectType = str;
    }

    public void setThirdChannelDeviceToken(String str) {
        this.thirdChannelDeviceToken = str;
    }

    public String getDeliveryToken() {
        return this.deliveryToken;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getConnectType() {
        return this.connectType;
    }

    public String getModel() {
        return this.model;
    }

    public String getThirdChannelDeviceToken() {
        return this.thirdChannelDeviceToken;
    }
}
