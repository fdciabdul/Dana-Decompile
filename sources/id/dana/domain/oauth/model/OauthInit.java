package id.dana.domain.oauth.model;

import java.util.List;

/* loaded from: classes4.dex */
public class OauthInit {
    private List<Scope> availableScope;
    private String merchantName;

    public OauthInit() {
    }

    public OauthInit(String str, List<Scope> list) {
        this.merchantName = str;
        this.availableScope = list;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public List<Scope> getAvailableScope() {
        return this.availableScope;
    }

    public void setAvailableScope(List<Scope> list) {
        this.availableScope = list;
    }
}
