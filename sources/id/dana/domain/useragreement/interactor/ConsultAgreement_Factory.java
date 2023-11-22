package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultAgreement_Factory implements Factory<ConsultAgreement> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public ConsultAgreement_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultAgreement get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static ConsultAgreement_Factory create(Provider<UserConsentRepository> provider) {
        return new ConsultAgreement_Factory(provider);
    }

    public static ConsultAgreement newInstance(UserConsentRepository userConsentRepository) {
        return new ConsultAgreement(userConsentRepository);
    }
}
