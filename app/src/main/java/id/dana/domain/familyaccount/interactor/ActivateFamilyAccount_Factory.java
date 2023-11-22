package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ActivateFamilyAccount_Factory implements Factory<ActivateFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public ActivateFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ActivateFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static ActivateFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new ActivateFamilyAccount_Factory(provider);
    }

    public static ActivateFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new ActivateFamilyAccount(familyAccountRepository);
    }
}
