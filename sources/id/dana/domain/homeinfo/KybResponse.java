package id.dana.domain.homeinfo;

/* loaded from: classes2.dex */
public class KybResponse {
    private String certificateTier;
    private boolean enableCertificateTier;
    private String failedReason;
    private String kybLevel;
    private String orderStatus;

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getKybLevel() {
        return this.kybLevel;
    }

    public void setKybLevel(String str) {
        this.kybLevel = str;
    }

    public String getFailedReason() {
        return this.failedReason;
    }

    public void setFailedReason(String str) {
        this.failedReason = str;
    }

    public String getCertificateTier() {
        return this.certificateTier;
    }

    public void setCertificateTier(String str) {
        this.certificateTier = str;
    }

    public boolean isEnableCertificateTier() {
        return this.enableCertificateTier;
    }

    public void setEnableCertificateTier(boolean z) {
        this.enableCertificateTier = z;
    }
}
