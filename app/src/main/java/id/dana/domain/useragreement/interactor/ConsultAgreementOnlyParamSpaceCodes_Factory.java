package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultAgreementOnlyParamSpaceCodes_Factory implements Factory<ConsultAgreementOnlyParamSpaceCodes> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public ConsultAgreementOnlyParamSpaceCodes_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultAgreementOnlyParamSpaceCodes get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static ConsultAgreementOnlyParamSpaceCodes_Factory create(Provider<UserConsentRepository> provider) {
        return new ConsultAgreementOnlyParamSpaceCodes_Factory(provider);
    }

    public static ConsultAgreementOnlyParamSpaceCodes newInstance(UserConsentRepository userConsentRepository) {
        return new ConsultAgreementOnlyParamSpaceCodes(userConsentRepository);
    }
}
