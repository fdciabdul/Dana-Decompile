package id.dana.data.referral.repository.source;

import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface MyReferralConsultEntityData {
    Observable<MyReferralConsultEntityResult> getMyReferralConsult();

    Observable<String> getReferralCode();

    void saveReferralCode(String str);
}
