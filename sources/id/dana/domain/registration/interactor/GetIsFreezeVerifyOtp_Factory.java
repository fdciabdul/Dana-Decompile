package id.dana.domain.registration.interactor;

import dagger.internal.Factory;
import id.dana.domain.registration.RegistrationRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsFreezeVerifyOtp_Factory implements Factory<GetIsFreezeVerifyOtp> {
    private final Provider<RegistrationRepository> registrationRepositoryProvider;

    public GetIsFreezeVerifyOtp_Factory(Provider<RegistrationRepository> provider) {
        this.registrationRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIsFreezeVerifyOtp get() {
        return newInstance(this.registrationRepositoryProvider.get());
    }

    public static GetIsFreezeVerifyOtp_Factory create(Provider<RegistrationRepository> provider) {
        return new GetIsFreezeVerifyOtp_Factory(provider);
    }

    public static GetIsFreezeVerifyOtp newInstance(RegistrationRepository registrationRepository) {
        return new GetIsFreezeVerifyOtp(registrationRepository);
    }
}
