package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InviteFamilyAccount_Factory implements Factory<InviteFamilyAccount> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public InviteFamilyAccount_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InviteFamilyAccount get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static InviteFamilyAccount_Factory create(Provider<FamilyAccountRepository> provider) {
        return new InviteFamilyAccount_Factory(provider);
    }

    public static InviteFamilyAccount newInstance(FamilyAccountRepository familyAccountRepository) {
        return new InviteFamilyAccount(familyAccountRepository);
    }
}
