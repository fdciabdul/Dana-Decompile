package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RejectFamilyInvitation_Factory implements Factory<RejectFamilyInvitation> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public RejectFamilyInvitation_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RejectFamilyInvitation get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static RejectFamilyInvitation_Factory create(Provider<FamilyAccountRepository> provider) {
        return new RejectFamilyInvitation_Factory(provider);
    }

    public static RejectFamilyInvitation newInstance(FamilyAccountRepository familyAccountRepository) {
        return new RejectFamilyInvitation(familyAccountRepository);
    }
}
