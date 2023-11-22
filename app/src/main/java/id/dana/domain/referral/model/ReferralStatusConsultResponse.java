package id.dana.domain.referral.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes8.dex */
public class ReferralStatusConsultResponse extends BaseRpcResponse {
    private String nextTaskRedirectUrl;
    private String referredNextTask;

    public String getReferredNextTask() {
        return this.referredNextTask;
    }

    public void setReferredNextTask(String str) {
        this.referredNextTask = str;
    }

    public String getNextTaskRedirectUrl() {
        return this.nextTaskRedirectUrl;
    }

    public void setNextTaskRedirectUrl(String str) {
        this.nextTaskRedirectUrl = str;
    }
}
