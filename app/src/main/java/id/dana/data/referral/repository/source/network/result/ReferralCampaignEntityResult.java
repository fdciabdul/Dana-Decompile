package id.dana.data.referral.repository.source.network.result;

import id.dana.domain.user.CurrencyAmount;

/* loaded from: classes4.dex */
public class ReferralCampaignEntityResult {
    private String activityId;
    private boolean campaignEnabled;
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

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }
}
