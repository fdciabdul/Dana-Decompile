package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class RecordAgreement_Factory implements Factory<RecordAgreement> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public RecordAgreement_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecordAgreement get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static RecordAgreement_Factory create(Provider<UserConsentRepository> provider) {
        return new RecordAgreement_Factory(provider);
    }

    public static RecordAgreement newInstance(UserConsentRepository userConsentRepository) {
        return new RecordAgreement(userConsentRepository);
    }
}
