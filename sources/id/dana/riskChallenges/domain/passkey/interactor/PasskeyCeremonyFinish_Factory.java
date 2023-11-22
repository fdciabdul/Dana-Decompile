package id.dana.riskChallenges.domain.passkey.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyCeremonyFinish_Factory implements Factory<PasskeyCeremonyFinish> {
    private final Provider<PasskeyRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private PasskeyCeremonyFinish_Factory(Provider<PasskeyRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PasskeyCeremonyFinish_Factory PlaceComponentResult(Provider<PasskeyRepository> provider) {
        return new PasskeyCeremonyFinish_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyCeremonyFinish(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
