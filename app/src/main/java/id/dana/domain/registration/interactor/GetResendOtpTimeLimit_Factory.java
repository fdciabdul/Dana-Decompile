package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetResendOtpTimeLimit_Factory implements Factory<GetResendOtpTimeLimit> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetResendOtpTimeLimit_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetResendOtpTimeLimit get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetResendOtpTimeLimit_Factory create(Provider<RegistrationRepository> provider) {
        return new GetResendOtpTimeLimit_Factory(provider);
    }

    public static GetResendOtpTimeLimit newInstance(RegistrationRepository registrationRepository) {
        return new GetResendOtpTimeLimit(registrationRepository);
    }
}
