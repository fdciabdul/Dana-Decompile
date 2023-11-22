package id.dana.riskChallenges.domain.passkey.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PasskeyEligibility_Factory implements Factory<PasskeyEligibility> {
    private final Provider<PasskeyRepository> MyBillsEntityDataFactory;
    private final Provider<FeatureConfigRepository> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyEligibility(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
