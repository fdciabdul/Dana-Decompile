package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckConsultFamilyAccount_Factory implements Factory<CheckConsultFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public CheckConsultFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckConsultFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static CheckConsultFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new CheckConsultFamilyAccount_Factory(provider);
    }

    public static CheckConsultFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new CheckConsultFamilyAccount(familyAccountRepository);
    }
}
