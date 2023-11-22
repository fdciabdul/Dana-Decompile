package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveIsFreezeVerifyOtp_Factory implements Factory<SaveIsFreezeVerifyOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public SaveIsFreezeVerifyOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveIsFreezeVerifyOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static SaveIsFreezeVerifyOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new SaveIsFreezeVerifyOtp_Factory(provider);
    }

    public static SaveIsFreezeVerifyOtp newInstance(RegistrationRepository registrationRepository) {
        return new SaveIsFreezeVerifyOtp(registrationRepository);
    }
}
