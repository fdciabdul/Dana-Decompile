package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SetLimitAndServicesFamilyAccount_Factory implements Factory<SetLimitAndServicesFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public SetLimitAndServicesFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetLimitAndServicesFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static SetLimitAndServicesFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new SetLimitAndServicesFamilyAccount_Factory(provider);
    }

    public static SetLimitAndServicesFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new SetLimitAndServicesFamilyAccount(familyAccountRepository);
    }
}
