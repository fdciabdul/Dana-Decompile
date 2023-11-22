package id.dana.data.deeplink.repository;

import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class GenerateLinkEntityRepository$$ExternalSyntheticLambda2 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return ((MyReferralConsultEntityResult) obj).getReferralCode();
    }
}
