package id.dana.domain.referral.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class VerifyReferralCodeResponse extends BaseRpcResponse {
    private boolean valid;

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean z) {
        this.valid = z;
    }
}
