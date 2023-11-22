package com.alipay.iap.android.wallet.acl.onboarding;

import com.alipay.iap.android.wallet.acl.base.BaseResult;

/* loaded from: classes2.dex */
public class TrustLoginInfoFetchResult extends BaseResult {
    private String signedCredential;

    public TrustLoginInfoFetchResult(String str) {
        this.signedCredential = str;
    }

    public String getSignedCredential() {
        return this.signedCredential;
    }

    public void setSignedCredential(String str) {
        this.signedCredential = str;
    }
}
