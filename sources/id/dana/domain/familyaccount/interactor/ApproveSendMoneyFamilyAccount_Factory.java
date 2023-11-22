package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ApproveSendMoneyFamilyAccount_Factory implements Factory<ApproveSendMoneyFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public ApproveSendMoneyFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ApproveSendMoneyFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static ApproveSendMoneyFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new ApproveSendMoneyFamilyAccount_Factory(provider);
    }

    public static ApproveSendMoneyFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new ApproveSendMoneyFamilyAccount(familyAccountRepository);
    }
}
