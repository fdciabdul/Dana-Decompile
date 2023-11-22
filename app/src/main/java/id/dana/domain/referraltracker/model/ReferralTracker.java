package id.dana.domain.referraltracker.model;

import java.util.List;

/* loaded from: classes4.dex */
public class ReferralTracker {
    private boolean hasMore;
    private List<ReferralSummaryDTO> referralSummaryDTOList;

    public List<ReferralSummaryDTO> getReferralSummaryDTOList() {
        return this.referralSummaryDTOList;
    }

    public void setReferralSummaryDTOList(List<ReferralSummaryDTO> list) {
        this.referralSummaryDTOList = list;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}
