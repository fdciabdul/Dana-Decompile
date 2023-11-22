package id.dana.data.referral.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class MyReferralConsultEntityResult extends BaseRpcResult {
    private boolean campaignUpdated;
    private String howToUrl;
    private String referralCode;
    private ReferralCampaignEntityResult referredCampaignInfo;
    private ReferralCampaignEntityResult referrerCampaignInfo;

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

    public ReferralCampaignEntityResult getReferredCampaignInfo() {
        return this.referredCampaignInfo;
    }

    public void setReferredCampaignInfo(ReferralCampaignEntityResult referralCampaignEntityResult) {
        this.referredCampaignInfo = referralCampaignEntityResult;
    }

    public ReferralCampaignEntityResult getReferrerCampaignInfo() {
        return this.referrerCampaignInfo;
    }

    public void setReferrerCampaignInfo(ReferralCampaignEntityResult referralCampaignEntityResult) {
        this.referrerCampaignInfo = referralCampaignEntityResult;
    }

    public boolean isCampaignUpdated() {
        return this.campaignUpdated;
    }

    public void setCampaignUpdated(boolean z) {
        this.campaignUpdated = z;
    }
}
