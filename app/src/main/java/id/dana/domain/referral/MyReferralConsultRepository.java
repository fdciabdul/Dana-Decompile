package id.dana.domain.referral;

import id.dana.domain.promotion.Space;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface MyReferralConsultRepository {
    Observable<MyReferralConsultRpcResponse> getLatestReferralCampaign();

    Observable<Space> getReferralBanner();

    Observable<String> getReferralCode();

    Observable<MyReferralConsultRpcResponse> getReferralConsult();

    Observable<Boolean> saveLastSeenReferralCampaignId(String str);
}
