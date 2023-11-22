package id.dana.data.authcode;

import id.dana.data.oauth.model.AgreementResult;
import id.dana.data.oauth.model.MerchantInfoResult;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;

/* loaded from: classes4.dex */
public class AuthCodeEntity extends BaseRpcResultAphome {
    private String action;
    private List<AgreementResult> agreements;
    private String authCode;
    private MerchantInfoResult merchantInfo;
    private String merchantRedirectUrl;
    private String mobileAuthCode;
    private String phoneNumber;
    private String riskPhoneNumber;
    private String securityId;
    private String state;
    private List<String> verificationMethods;

    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public String getMobileAuthCode() {
        return this.mobileAuthCode;
    }

    public void setMobileAuthCode(String str) {
        this.mobileAuthCode = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getMerchantRedirectUrl() {
        return this.merchantRedirectUrl;
    }

    public void setMerchantRedirectUrl(String str) {
        this.merchantRedirectUrl = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getRiskPhoneNumber() {
        return this.riskPhoneNumber;
    }

    public void setRiskPhoneNumber(String str) {
        this.riskPhoneNumber = str;
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public void setSecurityId(String str) {
        this.securityId = str;
    }

    public MerchantInfoResult getMerchantInfo() {
        return this.merchantInfo;
    }

    public void setMerchantInfo(MerchantInfoResult merchantInfoResult) {
        this.merchantInfo = merchantInfoResult;
    }

    public List<AgreementResult> getAgreements() {
        return this.agreements;
    }

    public void setAgreements(List<AgreementResult> list) {
        this.agreements = list;
    }

    public List<String> getVerificationMethods() {
        return this.verificationMethods;
    }

    public void setVerificationMethods(List<String> list) {
        this.verificationMethods = list;
    }
}
