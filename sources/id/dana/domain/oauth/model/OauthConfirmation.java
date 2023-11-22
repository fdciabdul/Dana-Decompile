package id.dana.domain.oauth.model;

/* loaded from: classes4.dex */
public class OauthConfirmation {
    private String mobileAuthCode;
    private String serverAuthCode;

    public String getServerAuthCode() {
        return this.serverAuthCode;
    }

    public void setServerAuthCode(String str) {
        this.serverAuthCode = str;
    }

    public String getMobileAuthCode() {
        return this.mobileAuthCode;
    }

    public void setMobileAuthCode(String str) {
        this.mobileAuthCode = str;
    }
}
