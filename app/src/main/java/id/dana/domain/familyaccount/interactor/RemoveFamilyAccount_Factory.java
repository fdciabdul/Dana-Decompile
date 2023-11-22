package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveFamilyAccount_Factory implements Factory<RemoveFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public RemoveFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static RemoveFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new RemoveFamilyAccount_Factory(provider);
    }

    public static RemoveFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new RemoveFamilyAccount(familyAccountRepository);
    }
}
