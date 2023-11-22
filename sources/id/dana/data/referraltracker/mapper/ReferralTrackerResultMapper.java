package id.dana.data.referraltracker.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.referraltracker.source.model.ReferralSummaryDTOResult;
import id.dana.data.referraltracker.source.model.ReferredTaskStatusResult;
import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;
import id.dana.domain.referraltracker.model.ReferralSummaryDTO;
import id.dana.domain.referraltracker.model.ReferralTracker;
import id.dana.domain.referraltracker.model.ReferredTaskStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ReferralTrackerResultMapper extends BaseMapper<ReferralTrackerRpcResult, ReferralTracker> {
    @Inject
    public ReferralTrackerResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public ReferralTracker map(ReferralTrackerRpcResult referralTrackerRpcResult) {
        return transform(referralTrackerRpcResult);
    }

    private ReferralTracker transform(ReferralTrackerRpcResult referralTrackerRpcResult) {
        if (referralTrackerRpcResult != null) {
            ReferralTracker referralTracker = new ReferralTracker();
            referralTracker.setHasMore(referralTrackerRpcResult.isHasMore());
            referralTracker.setReferralSummaryDTOList(transform(referralTrackerRpcResult.getReferredList()));
            return referralTracker;
        }
        return null;
    }

    private List<ReferralSummaryDTO> transform(List<ReferralSummaryDTOResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<ReferralSummaryDTOResult> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private ReferralSummaryDTO transform(ReferralSummaryDTOResult referralSummaryDTOResult) {
        if (referralSummaryDTOResult != null) {
            ReferralSummaryDTO referralSummaryDTO = new ReferralSummaryDTO();
            referralSummaryDTO.setNickName(referralSummaryDTOResult.getNickName());
            referralSummaryDTO.setMaskedPhoneNumber(referralSummaryDTOResult.getMaskedPhoneNumber());
            referralSummaryDTO.setShowReward(referralSummaryDTOResult.isShowReward());
            referralSummaryDTO.setReferredTaskStatusList(transformTaskStatus(referralSummaryDTOResult.getReferredTaskStatusList()));
            return referralSummaryDTO;
        }
        return null;
    }

    private List<ReferredTaskStatus> transformTaskStatus(List<ReferredTaskStatusResult> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<ReferredTaskStatusResult> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return null;
    }

    private ReferredTaskStatus transform(ReferredTaskStatusResult referredTaskStatusResult) {
        if (referredTaskStatusResult != null) {
            ReferredTaskStatus referredTaskStatus = new ReferredTaskStatus();
            referredTaskStatus.setLabel(referredTaskStatusResult.getLabel());
            referredTaskStatus.setCompleted(referredTaskStatusResult.isCompleted());
            referredTaskStatus.setFailReason(referredTaskStatusResult.getFailReason());
            return referredTaskStatus;
        }
        return null;
    }
}
