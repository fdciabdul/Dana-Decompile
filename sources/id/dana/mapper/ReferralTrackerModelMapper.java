package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.referraltracker.model.ReferralSummaryDTO;
import id.dana.domain.referraltracker.model.ReferralTracker;
import id.dana.domain.referraltracker.model.ReferredTaskStatus;
import id.dana.referral.referraltracker.ReferralTaskStatus;
import id.dana.referral.referraltracker.model.ReferralSummaryDTOModel;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ReferralTrackerModelMapper extends BaseMapper<ReferralTracker, ReferralTrackerModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ ReferralTrackerModel map(ReferralTracker referralTracker) {
        ReferralSummaryDTOModel referralSummaryDTOModel;
        ReferralTracker referralTracker2 = referralTracker;
        ArrayList arrayList = null;
        if (referralTracker2 != null) {
            ReferralTrackerModel referralTrackerModel = new ReferralTrackerModel();
            referralTrackerModel.PlaceComponentResult = referralTracker2.isHasMore();
            List<ReferralSummaryDTO> referralSummaryDTOList = referralTracker2.getReferralSummaryDTOList();
            if (referralSummaryDTOList != null) {
                ArrayList arrayList2 = new ArrayList();
                for (ReferralSummaryDTO referralSummaryDTO : referralSummaryDTOList) {
                    if (referralSummaryDTO != null) {
                        referralSummaryDTOModel = new ReferralSummaryDTOModel();
                        referralSummaryDTOModel.MyBillsEntityDataFactory = referralSummaryDTO.getNickName();
                        referralSummaryDTOModel.BuiltInFictitiousFunctionClassFactory = referralSummaryDTO.getMaskedPhoneNumber();
                        referralSummaryDTOModel.moveToNextValue = referralSummaryDTO.isShowReward();
                        List<ReferredTaskStatus> referredTaskStatusList = referralSummaryDTO.getReferredTaskStatusList();
                        for (int i = 0; i < referredTaskStatusList.size(); i++) {
                            if (i == 0) {
                                referralSummaryDTOModel.PlaceComponentResult = MyBillsEntityDataFactory(referredTaskStatusList, i);
                            } else if (i == 1) {
                                referralSummaryDTOModel.lookAheadTest = MyBillsEntityDataFactory(referredTaskStatusList, i);
                            } else if (i == 2) {
                                referralSummaryDTOModel.getErrorConfigVersion = MyBillsEntityDataFactory(referredTaskStatusList, i);
                            }
                        }
                    } else {
                        referralSummaryDTOModel = null;
                    }
                    arrayList2.add(referralSummaryDTOModel);
                }
                arrayList = arrayList2;
            }
            referralTrackerModel.getAuthRequestContext = arrayList;
            return referralTrackerModel;
        }
        return null;
    }

    @Inject
    public ReferralTrackerModelMapper() {
    }

    private static ReferralTaskStatus MyBillsEntityDataFactory(List<ReferredTaskStatus> list, int i) {
        if (list != null) {
            ReferralTaskStatus referralTaskStatus = new ReferralTaskStatus();
            referralTaskStatus.PlaceComponentResult = list.get(i).getFailReason();
            referralTaskStatus.MyBillsEntityDataFactory = list.get(i).getLabel();
            referralTaskStatus.BuiltInFictitiousFunctionClassFactory = list.get(i).isCompleted();
            return referralTaskStatus;
        }
        return null;
    }
}
