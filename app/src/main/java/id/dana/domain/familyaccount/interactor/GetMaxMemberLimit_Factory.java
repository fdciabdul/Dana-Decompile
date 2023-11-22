package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetMaxMemberLimit_Factory implements Factory<GetMaxMemberLimit> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public GetMaxMemberLimit_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMaxMemberLimit get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static GetMaxMemberLimit_Factory create(Provider<FamilyAccountRepository> provider) {
        return new GetMaxMemberLimit_Factory(provider);
    }

    public static GetMaxMemberLimit newInstance(FamilyAccountRepository familyAccountRepository) {
        return new GetMaxMemberLimit(familyAccountRepository);
    }
}
