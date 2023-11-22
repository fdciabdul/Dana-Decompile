package id.dana.domain.profilemenu.model;

import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class AuthenticationTypeOption {
    private CurrencyAmount authenticationMinAmount;
    private String authenticationType;

    public String getAuthenticationType() {
        return this.authenticationType;
    }

    public void setAuthenticationType(String str) {
        this.authenticationType = str;
    }

    public CurrencyAmount getAuthenticationMinAmount() {
        return this.authenticationMinAmount;
    }

    public void setAuthenticationMinAmount(CurrencyAmount currencyAmount) {
        this.authenticationMinAmount = currencyAmount;
    }
}
