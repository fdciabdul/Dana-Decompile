package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AcceptFamilyInvitation_Factory implements Factory<AcceptFamilyInvitation> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public AcceptFamilyInvitation_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AcceptFamilyInvitation get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static AcceptFamilyInvitation_Factory create(Provider<FamilyAccountRepository> provider) {
        return new AcceptFamilyInvitation_Factory(provider);
    }

    public static AcceptFamilyInvitation newInstance(FamilyAccountRepository familyAccountRepository) {
        return new AcceptFamilyInvitation(familyAccountRepository);
    }
}
