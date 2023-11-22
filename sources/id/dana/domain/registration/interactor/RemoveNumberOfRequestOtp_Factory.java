package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveNumberOfRequestOtp_Factory implements Factory<RemoveNumberOfRequestOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public RemoveNumberOfRequestOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveNumberOfRequestOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static RemoveNumberOfRequestOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new RemoveNumberOfRequestOtp_Factory(provider);
    }

    public static RemoveNumberOfRequestOtp newInstance(RegistrationRepository registrationRepository) {
        return new RemoveNumberOfRequestOtp(registrationRepository);
    }
}
