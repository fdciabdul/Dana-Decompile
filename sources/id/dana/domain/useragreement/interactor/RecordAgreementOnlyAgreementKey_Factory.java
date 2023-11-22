package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RecordAgreementOnlyAgreementKey_Factory implements Factory<RecordAgreementOnlyAgreementKey> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public RecordAgreementOnlyAgreementKey_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecordAgreementOnlyAgreementKey get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static RecordAgreementOnlyAgreementKey_Factory create(Provider<UserConsentRepository> provider) {
        return new RecordAgreementOnlyAgreementKey_Factory(provider);
    }

    public static RecordAgreementOnlyAgreementKey newInstance(UserConsentRepository userConsentRepository) {
        return new RecordAgreementOnlyAgreementKey(userConsentRepository);
    }
}
