package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveNumberOfRequestOtp_Factory implements Factory<SaveNumberOfRequestOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public SaveNumberOfRequestOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveNumberOfRequestOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static SaveNumberOfRequestOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new SaveNumberOfRequestOtp_Factory(provider);
    }

    public static SaveNumberOfRequestOtp newInstance(RegistrationRepository registrationRepository) {
        return new SaveNumberOfRequestOtp(registrationRepository);
    }
}
