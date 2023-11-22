package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RejectSendMoneyFamilyAccount_Factory implements Factory<RejectSendMoneyFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public RejectSendMoneyFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RejectSendMoneyFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static RejectSendMoneyFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new RejectSendMoneyFamilyAccount_Factory(provider);
    }

    public static RejectSendMoneyFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new RejectSendMoneyFamilyAccount(familyAccountRepository);
    }
}
