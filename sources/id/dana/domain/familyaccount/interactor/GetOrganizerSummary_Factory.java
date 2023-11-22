package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetOrganizerSummary_Factory implements Factory<GetOrganizerSummary> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public GetOrganizerSummary_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetOrganizerSummary get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static GetOrganizerSummary_Factory create(Provider<FamilyAccountRepository> provider) {
        return new GetOrganizerSummary_Factory(provider);
    }

    public static GetOrganizerSummary newInstance(FamilyAccountRepository familyAccountRepository) {
        return new GetOrganizerSummary(familyAccountRepository);
    }
}
