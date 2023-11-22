package id.dana.data.referraltracker.source.mock;

import id.dana.data.referraltracker.source.ReferralTrackerEntityData;
import id.dana.data.referraltracker.source.model.ReferralSummaryDTOResult;
import id.dana.data.referraltracker.source.model.ReferredTaskStatusResult;
import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class MockReferralTrackerEntityData implements ReferralTrackerEntityData {
    @Inject
    public MockReferralTrackerEntityData() {
    }

    @Override // id.dana.data.referraltracker.source.ReferralTrackerEntityData
    public Observable<ReferralTrackerRpcResult> getReferralTracker(int i, int i2) {
        ReferralTrackerRpcResult referralTrackerRpcResult = new ReferralTrackerRpcResult();
        referralTrackerRpcResult.setHasMore(true);
        referralTrackerRpcResult.setReferredList(createCompleteReferralSummaryDTO());
        return Observable.just(referralTrackerRpcResult);
    }

    private List<ReferralSummaryDTOResult> createCompleteReferralSummaryDTO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createReferralSummaryDTO());
        arrayList.add(createReferralSummaryDTO2());
        arrayList.add(createReferralSummaryDTO3());
        arrayList.add(createReferralSummaryDTO());
        arrayList.add(createReferralSummaryDTO2());
        arrayList.add(createReferralSummaryDTO3());
        arrayList.add(createReferralSummaryDTO());
        arrayList.add(createReferralSummaryDTO2());
        arrayList.add(createReferralSummaryDTO3());
        arrayList.add(createReferralSummaryDTO());
        return arrayList;
    }

    private ReferralSummaryDTOResult createReferralSummaryDTO() {
        ReferralSummaryDTOResult referralSummaryDTOResult = new ReferralSummaryDTOResult();
        referralSummaryDTOResult.setMaskedPhoneNumber("0821****0222");
        referralSummaryDTOResult.setNickName("Kalebu");
        referralSummaryDTOResult.setShowReward(true);
        referralSummaryDTOResult.setReferredTaskStatusList(createCompleteReferredTaskStatuses());
        return referralSummaryDTOResult;
    }

    private List<ReferredTaskStatusResult> createCompleteReferredTaskStatuses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createReferredTaskStatusRegisterCompleted());
        arrayList.add(createReferredTaskStatusActiveCompleted());
        arrayList.add(createReferredTaskStatusRewardCompleted());
        return arrayList;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRegisterCompleted() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Registration");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusActiveCompleted() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Active");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRewardCompleted() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Reward");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferralSummaryDTOResult createReferralSummaryDTO2() {
        ReferralSummaryDTOResult referralSummaryDTOResult = new ReferralSummaryDTOResult();
        referralSummaryDTOResult.setMaskedPhoneNumber("0821****0676");
        referralSummaryDTOResult.setNickName("INI TEXT SIH HARUSNYA KEPANJANGAN YA TAPI GA TAU LAGI");
        referralSummaryDTOResult.setShowReward(true);
        referralSummaryDTOResult.setReferredTaskStatusList(createCompleteReferredTaskStatuses2());
        return referralSummaryDTOResult;
    }

    private List<ReferredTaskStatusResult> createCompleteReferredTaskStatuses2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createReferredTaskStatusRegisterCompleted2());
        arrayList.add(createReferredTaskStatusActiveCompleted2());
        arrayList.add(createReferredTaskStatusRewardCompleted2());
        return arrayList;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRegisterCompleted2() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Registration");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusActiveCompleted2() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Ini Kepanjangan juga");
        referredTaskStatusResult.setCompleted(false);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRewardCompleted2() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Reward");
        referredTaskStatusResult.setCompleted(false);
        return referredTaskStatusResult;
    }

    private ReferralSummaryDTOResult createReferralSummaryDTO3() {
        ReferralSummaryDTOResult referralSummaryDTOResult = new ReferralSummaryDTOResult();
        referralSummaryDTOResult.setMaskedPhoneNumber("0821****0777");
        referralSummaryDTOResult.setShowReward(true);
        referralSummaryDTOResult.setReferredTaskStatusList(createCompleteReferredTaskStatuses3());
        return referralSummaryDTOResult;
    }

    private List<ReferredTaskStatusResult> createCompleteReferredTaskStatuses3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createReferredTaskStatusRegisterCompleted3());
        arrayList.add(createReferredTaskStatusActiveCompleted3());
        arrayList.add(createReferredTaskStatusRewardCompleted3());
        return arrayList;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRegisterCompleted3() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Registration");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusActiveCompleted3() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Active");
        referredTaskStatusResult.setCompleted(true);
        return referredTaskStatusResult;
    }

    private ReferredTaskStatusResult createReferredTaskStatusRewardCompleted3() {
        ReferredTaskStatusResult referredTaskStatusResult = new ReferredTaskStatusResult();
        referredTaskStatusResult.setLabel("Reward");
        referredTaskStatusResult.setCompleted(true);
        referredTaskStatusResult.setFailReason("Panjaaaaaaaaaaaaaaaaaaaaaaaaaaaaaang");
        return referredTaskStatusResult;
    }
}
