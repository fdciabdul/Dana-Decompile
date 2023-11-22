package id.dana.domain.referral.model;

import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class ReferralCampaignInfoResponse {
    private boolean campaignEnabled;
    private String campaignId;
    private CurrencyAmount prizeAmount;
    private String prizeName;

    public boolean isCampaignEnabled() {
        return this.campaignEnabled;
    }

    public void setCampaignEnabled(boolean z) {
        this.campaignEnabled = z;
    }

    public CurrencyAmount getPrizeAmount() {
        return this.prizeAmount;
    }

    public void setPrizeAmount(CurrencyAmount currencyAmount) {
        this.prizeAmount = currencyAmount;
    }

    public String getPrizeName() {
        return this.prizeName;
    }

    public void setPrizeName(String str) {
        this.prizeName = str;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }
}
