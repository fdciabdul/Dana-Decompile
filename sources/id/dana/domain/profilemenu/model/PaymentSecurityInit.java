package id.dana.domain.profilemenu.model;

import id.dana.domain.user.CurrencyAmount;
import java.util.List;

/* loaded from: classes4.dex */
public class PaymentSecurityInit {
    private boolean authenticationFeatureStatus;
    private CurrencyAmount authenticationMinAmount;
    private List<AuthenticationTypeOption> authenticationSettingOptions;
    private boolean authenticationStatus;
    private String authenticationType;

    public CurrencyAmount getAuthenticationMinAmount() {
        return this.authenticationMinAmount;
    }

    public void setAuthenticationMinAmount(CurrencyAmount currencyAmount) {
        this.authenticationMinAmount = currencyAmount;
    }

    public boolean isAuthenticationStatus() {
        return this.authenticationStatus;
    }

    public void setAuthenticationStatus(boolean z) {
        this.authenticationStatus = z;
    }

    public String getAuthenticationType() {
        return this.authenticationType;
    }

    public void setAuthenticationType(String str) {
        this.authenticationType = str;
    }

    public boolean isAuthenticationFeatureStatus() {
        return this.authenticationFeatureStatus;
    }

    public void setAuthenticationFeatureStatus(boolean z) {
        this.authenticationFeatureStatus = z;
    }

    public List<AuthenticationTypeOption> getAuthenticationTypeOption() {
        return this.authenticationSettingOptions;
    }

    public void setAuthenticationTypeOption(List<AuthenticationTypeOption> list) {
        this.authenticationSettingOptions = list;
    }
}
