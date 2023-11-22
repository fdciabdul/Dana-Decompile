package id.dana.domain.referral.model;

import id.dana.utils.rpc.response.BaseRpcResponse;

/* loaded from: classes4.dex */
public class MyReferralConsultRpcResponse extends BaseRpcResponse {
    private boolean campaignUpdated;
    private String howToUrl;
    private String referralCode;
    private ReferralCampaignInfoResponse referredCampaignInfo;
    private ReferralCampaignInfoResponse referrerCampaignInfo;

    public String getHowToUrl() {
        return this.howToUrl;
    }

    public void setHowToUrl(String str) {
        this.howToUrl = str;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public ReferralCampaignInfoResponse getReferrerCampaignInfo() {
        return this.referrerCampaignInfo;
    }

    public void setReferrerCampaignInfo(ReferralCampaignInfoResponse referralCampaignInfoResponse) {
        this.referrerCampaignInfo = referralCampaignInfoResponse;
    }

    public ReferralCampaignInfoResponse getReferredCampaignInfo() {
        return this.referredCampaignInfo;
    }

    public void setReferredCampaignInfo(ReferralCampaignInfoResponse referralCampaignInfoResponse) {
        this.referredCampaignInfo = referralCampaignInfoResponse;
    }

    public boolean isCampaignEnable() {
        return getReferrerCampaignInfo() != null && getReferrerCampaignInfo().isCampaignEnabled();
    }

    public boolean isCampaignUpdated() {
        return this.campaignUpdated;
    }

    public void setCampaignUpdated(boolean z) {
        this.campaignUpdated = z;
    }
}
