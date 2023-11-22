package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ResendOtp_Factory implements Factory<ResendOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public ResendOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ResendOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static ResendOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new ResendOtp_Factory(provider);
    }

    public static ResendOtp newInstance(RegistrationRepository registrationRepository) {
        return new ResendOtp(registrationRepository);
    }
}
