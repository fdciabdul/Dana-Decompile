package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.model.ReferralStatus;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class ReferralStatusMapper extends BaseMapper<ReferralStatusConsultResponse, ReferralStatus> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ ReferralStatus map(ReferralStatusConsultResponse referralStatusConsultResponse) {
        ReferralStatusConsultResponse referralStatusConsultResponse2 = referralStatusConsultResponse;
        if (referralStatusConsultResponse2 != null) {
            ReferralStatus referralStatus = new ReferralStatus();
            referralStatus.getAuthRequestContext = referralStatusConsultResponse2.getReferredNextTask();
            referralStatus.BuiltInFictitiousFunctionClassFactory = referralStatusConsultResponse2.getNextTaskRedirectUrl();
            return referralStatus;
        }
        return null;
    }

    @Inject
    public ReferralStatusMapper() {
    }
}
