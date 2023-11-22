package id.dana.domain.profilemenu.model;

/* loaded from: classes4.dex */
public class PaymentSecuritySwitch {
    private Risk risk;
    private SecurityContext securityContext;
    private boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public Risk getRisk() {
        return this.risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public SecurityContext getSecurityContext() {
        return this.securityContext;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }
}
