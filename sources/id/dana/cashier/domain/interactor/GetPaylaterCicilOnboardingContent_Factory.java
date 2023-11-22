package id.dana.cashier.domain.interactor;

import dagger.internal.Factory;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPaylaterCicilOnboardingContent_Factory implements Factory<GetPaylaterCicilOnboardingContent> {
    private final Provider<PaylaterRepository> paylaterRepositoryProvider;
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public GetPaylaterCicilOnboardingContent_Factory(Provider<UserConsentRepository> provider, Provider<PaylaterRepository> provider2) {
        this.userConsentRepositoryProvider = provider;
        this.paylaterRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetPaylaterCicilOnboardingContent get() {
        return newInstance(this.userConsentRepositoryProvider.get(), this.paylaterRepositoryProvider.get());
    }

    public static GetPaylaterCicilOnboardingContent_Factory create(Provider<UserConsentRepository> provider, Provider<PaylaterRepository> provider2) {
        return new GetPaylaterCicilOnboardingContent_Factory(provider, provider2);
    }

    public static GetPaylaterCicilOnboardingContent newInstance(UserConsentRepository userConsentRepository, PaylaterRepository paylaterRepository) {
        return new GetPaylaterCicilOnboardingContent(userConsentRepository, paylaterRepository);
    }
}
