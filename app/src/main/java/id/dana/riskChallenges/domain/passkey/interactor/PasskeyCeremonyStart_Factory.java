package id.dana.riskChallenges.domain.passkey.interactor;

import dagger.internal.Factory;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PasskeyCeremonyStart_Factory implements Factory<PasskeyCeremonyStart> {
    private final Provider<PasskeyRepository> PlaceComponentResult;

    private PasskeyCeremonyStart_Factory(Provider<PasskeyRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static PasskeyCeremonyStart_Factory getAuthRequestContext(Provider<PasskeyRepository> provider) {
        return new PasskeyCeremonyStart_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PasskeyCeremonyStart(this.PlaceComponentResult.get());
    }
}
