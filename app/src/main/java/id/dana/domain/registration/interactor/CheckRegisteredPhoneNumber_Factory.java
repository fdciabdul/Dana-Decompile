package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckRegisteredPhoneNumber_Factory implements Factory<CheckRegisteredPhoneNumber> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public CheckRegisteredPhoneNumber_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckRegisteredPhoneNumber get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static CheckRegisteredPhoneNumber_Factory create(Provider<RegistrationRepository> provider) {
        return new CheckRegisteredPhoneNumber_Factory(provider);
    }

    public static CheckRegisteredPhoneNumber newInstance(RegistrationRepository registrationRepository) {
        return new CheckRegisteredPhoneNumber(registrationRepository);
    }
}
