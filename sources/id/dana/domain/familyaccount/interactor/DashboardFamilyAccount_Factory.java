package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DashboardFamilyAccount_Factory implements Factory<DashboardFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public DashboardFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DashboardFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static DashboardFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new DashboardFamilyAccount_Factory(provider);
    }

    public static DashboardFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new DashboardFamilyAccount(familyAccountRepository);
    }
}
