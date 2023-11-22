package com.alipay.iap.android.wallet.acl.oauth;

import com.alipay.iap.android.wallet.acl.base.BaseResult;

/* loaded from: classes2.dex */
public class OAuthPageConfirmResult extends BaseResult {
    private String referenceAgreementId;

    public OAuthPageConfirmResult(String str) {
        this.referenceAgreementId = str;
    }

    public String getReferenceAgreementId() {
        return this.referenceAgreementId;
    }

    public void setReferenceAgreementId(String str) {
        this.referenceAgreementId = str;
    }
}
