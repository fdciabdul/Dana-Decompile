package id.dana.domain.referral;

import id.dana.domain.referral.model.ReferralConsultResponse;
import id.dana.domain.referral.model.ReferralEngagementDialogCache;
import id.dana.domain.referral.model.ReferralEngagementDialogConfig;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.domain.referral.model.VerifyReferralCodeResponse;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface ReferralRepository {
    Observable<ReferralConsultResponse> consult();

    Observable<List<ReferralEngagementDialogCache>> getDialogCaches();

    Observable<ReferralEngagementDialogConfig> getReferralEngagementDialogConfig();

    Observable<Boolean> saveDialogCache(List<ReferralEngagementDialogCache> list);

    Observable<ReferralStatusConsultResponse> statusConsult();

    Observable<VerifyReferralCodeResponse> verify(String str);
}
