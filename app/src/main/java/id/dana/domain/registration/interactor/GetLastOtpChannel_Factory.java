package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetLastOtpChannel_Factory implements Factory<GetLastOtpChannel> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetLastOtpChannel_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLastOtpChannel get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetLastOtpChannel_Factory create(Provider<RegistrationRepository> provider) {
        return new GetLastOtpChannel_Factory(provider);
    }

    public static GetLastOtpChannel newInstance(RegistrationRepository registrationRepository) {
        return new GetLastOtpChannel(registrationRepository);
    }
}
