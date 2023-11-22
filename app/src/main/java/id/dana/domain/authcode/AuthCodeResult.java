package id.dana.domain.authcode;

import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.MerchantInfo;
import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes2.dex */
public class AuthCodeResult extends BaseRpcResponse {
    private String action;
    private List<Agreement> agreements;
    private String authCode;
    private MerchantInfo merchantInfo;
    private String merchantRedirectUrl;
    private String mobileAuthCode;
    private String phoneNumber;
    private Boolean queryAuthInfoSuccess;
    private String riskPhoneNumber;
    private String securityId;
    private String state;
    private String traceId;
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

    public MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public List<Agreement> getAgreements() {
        return this.agreements;
    }

    public void setAgreements(List<Agreement> list) {
        this.agreements = list;
    }

    public List<String> getVerificationMethods() {
        return this.verificationMethods;
    }

    public void setVerificationMethods(List<String> list) {
        this.verificationMethods = list;
    }

    public Boolean isQueryAuthInfoSuccess() {
        return this.queryAuthInfoSuccess;
    }

    public void setQueryAuthInfoSuccess(Boolean bool) {
        this.queryAuthInfoSuccess = bool;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
