package id.dana.data.h5event.changephone;

/* loaded from: classes2.dex */
public class ChangePhoneFinishEntity {
    private boolean apiSuccess;
    private boolean riskVerificationOldNumber;

    public boolean isApiSuccess() {
        return this.apiSuccess;
    }

    public void setApiSuccess(boolean z) {
        this.apiSuccess = z;
    }

    public boolean isRiskVerificationOldNumber() {
        return this.riskVerificationOldNumber;
    }

    public void setRiskVerificationOldNumber(boolean z) {
        this.riskVerificationOldNumber = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangePhoneFinishEntity{apiSuccess='");
        sb.append(this.apiSuccess);
        sb.append('\'');
        sb.append(", riskVerificationOldNumber=");
        sb.append(this.riskVerificationOldNumber);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
