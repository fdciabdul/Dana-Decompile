package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateProfile_Factory implements Factory<CreateProfile> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public CreateProfile_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateProfile get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static CreateProfile_Factory create(Provider<RegistrationRepository> provider) {
        return new CreateProfile_Factory(provider);
    }

    public static CreateProfile newInstance(RegistrationRepository registrationRepository) {
        return new CreateProfile(registrationRepository);
    }
}
