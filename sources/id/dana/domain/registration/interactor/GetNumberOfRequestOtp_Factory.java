package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetNumberOfRequestOtp_Factory implements Factory<GetNumberOfRequestOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetNumberOfRequestOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetNumberOfRequestOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetNumberOfRequestOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new GetNumberOfRequestOtp_Factory(provider);
    }

    public static GetNumberOfRequestOtp newInstance(RegistrationRepository registrationRepository) {
        return new GetNumberOfRequestOtp(registrationRepository);
    }
}
