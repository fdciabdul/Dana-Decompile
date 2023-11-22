package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RecordAgreementFamilyAccount_Factory implements Factory<RecordAgreementFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public RecordAgreementFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RecordAgreementFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static RecordAgreementFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new RecordAgreementFamilyAccount_Factory(provider);
    }

    public static RecordAgreementFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new RecordAgreementFamilyAccount(familyAccountRepository);
    }
}
