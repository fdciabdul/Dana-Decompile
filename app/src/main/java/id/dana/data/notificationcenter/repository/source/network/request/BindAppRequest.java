package id.dana.data.notificationcenter.repository.source.network.request;

/* loaded from: classes4.dex */
public class BindAppRequest {
    private String deliveryToken;
    private String userId;
    private final String appId = "6CC59C4231550";
    private final String workspaceId = "prod";
    private final int osType = 1;

    public String getAppId() {
        return "6CC59C4231550";
    }

    public int getOsType() {
        return 1;
    }

    public String getWorkspaceId() {
        return "prod";
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setDeliveryToken(String str) {
        this.deliveryToken = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getDeliveryToken() {
        return this.deliveryToken;
    }
}
