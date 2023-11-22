package id.dana.data.registration.model;

/* loaded from: classes4.dex */
public class LoginAuthenticationOptionResult {
    private String authenticationMethod;
    private boolean enrollFlag;
    private boolean kycFlag;
    private boolean riskFlag;

    public String getAuthenticationMethod() {
        return this.authenticationMethod;
    }

    public void setAuthenticationMethod(String str) {
        this.authenticationMethod = str;
    }

    public boolean isEnrollFlag() {
        return this.enrollFlag;
    }

    public void setEnrollFlag(boolean z) {
        this.enrollFlag = z;
    }

    public boolean isKycFlag() {
        return this.kycFlag;
    }

    public void setKycFlag(boolean z) {
        this.kycFlag = z;
    }

    public boolean isRiskFlag() {
        return this.riskFlag;
    }

    public void setRiskFlag(boolean z) {
        this.riskFlag = z;
    }
}
