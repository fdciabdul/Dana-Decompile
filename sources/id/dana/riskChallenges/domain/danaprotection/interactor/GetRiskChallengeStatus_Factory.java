package id.dana.riskChallenges.domain.danaprotection.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.danaprotection.DanaProtectionRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetRiskChallengeStatus_Factory implements Factory<GetRiskChallengeStatus> {
    private final Provider<DanaProtectionRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetRiskChallengeStatus(this.PlaceComponentResult.get());
    }
}
