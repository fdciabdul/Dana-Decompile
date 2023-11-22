package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTempRegistrationPhoneNumber_Factory implements Factory<GetTempRegistrationPhoneNumber> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public GetTempRegistrationPhoneNumber_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTempRegistrationPhoneNumber get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static GetTempRegistrationPhoneNumber_Factory create(Provider<ResetPinRepository> provider) {
        return new GetTempRegistrationPhoneNumber_Factory(provider);
    }

    public static GetTempRegistrationPhoneNumber newInstance(ResetPinRepository resetPinRepository) {
        return new GetTempRegistrationPhoneNumber(resetPinRepository);
    }
}
