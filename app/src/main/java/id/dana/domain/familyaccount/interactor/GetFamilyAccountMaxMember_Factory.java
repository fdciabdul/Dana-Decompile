package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFamilyAccountMaxMember_Factory implements Factory<GetFamilyAccountMaxMember> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public GetFamilyAccountMaxMember_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFamilyAccountMaxMember get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static GetFamilyAccountMaxMember_Factory create(Provider<FamilyAccountRepository> provider) {
        return new GetFamilyAccountMaxMember_Factory(provider);
    }

    public static GetFamilyAccountMaxMember newInstance(FamilyAccountRepository familyAccountRepository) {
        return new GetFamilyAccountMaxMember(familyAccountRepository);
    }
}
