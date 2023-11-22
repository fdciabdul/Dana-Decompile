package id.dana.data.referral.repository;

import id.dana.data.referral.mapper.MyReferralConsultEntityMapper;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class MyReferralConsultEntityRepository$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ MyReferralConsultEntityMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transformMyReferral((MyReferralConsultEntityResult) obj);
    }
}
