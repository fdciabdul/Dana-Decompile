package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveFamilyMember_Factory implements Factory<RemoveFamilyMember> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public RemoveFamilyMember_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveFamilyMember get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static RemoveFamilyMember_Factory create(Provider<FamilyAccountRepository> provider) {
        return new RemoveFamilyMember_Factory(provider);
    }

    public static RemoveFamilyMember newInstance(FamilyAccountRepository familyAccountRepository) {
        return new RemoveFamilyMember(familyAccountRepository);
    }
}
