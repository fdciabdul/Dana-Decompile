package id.dana.data.referraltracker.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.referraltracker.source.model.ReferralSummaryDTOResult;
import java.util.List;

/* loaded from: classes4.dex */
public class ReferralTrackerRpcResult extends BaseRpcResult {
    private boolean hasMore;
    private List<ReferralSummaryDTOResult> referredList;

    public List<ReferralSummaryDTOResult> getReferredList() {
        return this.referredList;
    }

    public void setReferredList(List<ReferralSummaryDTOResult> list) {
        this.referredList = list;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}
