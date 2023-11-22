package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHelpButtonOtpLimitDevice_Factory implements Factory<GetHelpButtonOtpLimitDevice> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetHelpButtonOtpLimitDevice_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHelpButtonOtpLimitDevice get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetHelpButtonOtpLimitDevice_Factory create(Provider<RegistrationRepository> provider) {
        return new GetHelpButtonOtpLimitDevice_Factory(provider);
    }

    public static GetHelpButtonOtpLimitDevice newInstance(RegistrationRepository registrationRepository) {
        return new GetHelpButtonOtpLimitDevice(registrationRepository);
    }
}
