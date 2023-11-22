package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetPhoneNumberAttempt_Factory implements Factory<GetPhoneNumberAttempt> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetPhoneNumberAttempt_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPhoneNumberAttempt get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetPhoneNumberAttempt_Factory create(Provider<RegistrationRepository> provider) {
        return new GetPhoneNumberAttempt_Factory(provider);
    }

    public static GetPhoneNumberAttempt newInstance(RegistrationRepository registrationRepository) {
        return new GetPhoneNumberAttempt(registrationRepository);
    }
}
