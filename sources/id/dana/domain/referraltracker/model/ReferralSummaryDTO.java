package id.dana.domain.referraltracker.model;

import java.util.List;

/* loaded from: classes4.dex */
public class ReferralSummaryDTO {
    private String maskedPhoneNumber;
    private String nickName;
    private List<ReferredTaskStatus> referredTaskStatusList;
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

    public List<ReferredTaskStatus> getReferredTaskStatusList() {
        return this.referredTaskStatusList;
    }

    public void setReferredTaskStatusList(List<ReferredTaskStatus> list) {
        this.referredTaskStatusList = list;
    }
}
