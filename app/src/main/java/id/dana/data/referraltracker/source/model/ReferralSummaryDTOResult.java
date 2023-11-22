package id.dana.data.referraltracker.source.model;

import java.util.List;

/* loaded from: classes4.dex */
public class ReferralSummaryDTOResult {
    private String maskedPhoneNumber;
    private String nickName;
    private List<ReferredTaskStatusResult> referredTaskStatusList;
    private boolean showReward;

    public String getMaskedPhoneNumber() {
        return this.maskedPhoneNumber;
    }

    public void setMaskedPhoneNumber(String str) {
        this.maskedPhoneNumber = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public boolean isShowReward() {
        return this.showReward;
    }

    public void setShowReward(boolean z) {
        this.showReward = z;
    }

    public List<ReferredTaskStatusResult> getReferredTaskStatusList() {
        return this.referredTaskStatusList;
    }

    public void setReferredTaskStatusList(List<ReferredTaskStatusResult> list) {
        this.referredTaskStatusList = list;
    }
}
