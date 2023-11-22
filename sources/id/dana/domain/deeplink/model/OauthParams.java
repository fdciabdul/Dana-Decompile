package id.dana.domain.deeplink.model;

import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class OauthParams {
    private String clientId;
    private String codeChallenge;
    private boolean isIpgBinding;
    private String merchantId;
    private String merchantName;
    private boolean needMobileToken;
    private String phoneNumber;
    private String redirectUrl;
    private String referringLink;
    private String responseType;
    private List<String> scope;
    private String state;

    public String getResponseType() {
        return this.responseType;
    }

    public void setResponseType(String str) {
        this.responseType = str;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public List<String> getScope() {
        return this.scope;
    }

    public void setScope(List<String> list) {
        this.scope = list;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getCodeChallenge() {
        return this.codeChallenge;
    }

    public void setCodeChallenge(String str) {
        this.codeChallenge = str;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public boolean isNeedMobileToken() {
        return this.needMobileToken;
    }

    public void setNeedMobileToken(boolean z) {
        this.needMobileToken = z;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getReferringLink() {
        return this.referringLink;
    }

    public void setReferringLink(String str) {
        this.referringLink = str;
    }

    public boolean isIpgBinding() {
        return this.isIpgBinding;
    }

    public void setIpgBinding(boolean z) {
        this.isIpgBinding = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OauthParams oauthParams = (OauthParams) obj;
        return this.needMobileToken == oauthParams.needMobileToken && Objects.equals(this.responseType, oauthParams.responseType) && Objects.equals(this.clientId, oauthParams.clientId) && Objects.equals(this.phoneNumber, oauthParams.phoneNumber) && Objects.equals(this.scope, oauthParams.scope) && Objects.equals(this.state, oauthParams.state) && Objects.equals(this.codeChallenge, oauthParams.codeChallenge) && Objects.equals(this.redirectUrl, oauthParams.redirectUrl);
    }

    public int hashCode() {
        return Objects.hash(this.responseType, this.clientId, this.phoneNumber, this.scope, this.state, this.codeChallenge, this.redirectUrl, Boolean.valueOf(this.needMobileToken));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OauthParams{responseType='");
        sb.append(this.responseType);
        sb.append('\'');
        sb.append(", clientId='");
        sb.append(this.clientId);
        sb.append('\'');
        sb.append(", phoneNumber='");
        sb.append(this.phoneNumber);
        sb.append('\'');
        sb.append(", scope=");
        sb.append(this.scope);
        sb.append(", state='");
        sb.append(this.state);
        sb.append('\'');
        sb.append(", codeChallenge='");
        sb.append(this.codeChallenge);
        sb.append('\'');
        sb.append(", redirectUrl='");
        sb.append(this.redirectUrl);
        sb.append('\'');
        sb.append(", needMobileToken=");
        sb.append(this.needMobileToken);
        sb.append('}');
        return sb.toString();
    }
}
