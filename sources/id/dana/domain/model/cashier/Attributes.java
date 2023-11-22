package id.dana.domain.model.cashier;

/* loaded from: classes4.dex */
public class Attributes {
    private boolean loginStatus;
    private String maskedLoginId;
    private PayMethodRisk payMethodRiskResponse;

    public boolean isLoginStatus() {
        return this.loginStatus;
    }

    public void setLoginStatus(boolean z) {
        this.loginStatus = z;
    }

    public String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    public void setMaskedLoginId(String str) {
        this.maskedLoginId = str;
    }

    public PayMethodRisk getPayMethodRiskResponse() {
        return this.payMethodRiskResponse;
    }

    public void setPayMethodRiskResponse(PayMethodRisk payMethodRisk) {
        this.payMethodRiskResponse = payMethodRisk;
    }
}
