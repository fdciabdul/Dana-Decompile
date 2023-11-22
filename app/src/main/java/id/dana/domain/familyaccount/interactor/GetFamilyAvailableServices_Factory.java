package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetFamilyAvailableServices_Factory implements Factory<GetFamilyAvailableServices> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public GetFamilyAvailableServices_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetFamilyAvailableServices get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static GetFamilyAvailableServices_Factory create(Provider<FamilyAccountRepository> provider) {
        return new GetFamilyAvailableServices_Factory(provider);
    }

    public static GetFamilyAvailableServices newInstance(FamilyAccountRepository familyAccountRepository) {
        return new GetFamilyAvailableServices(familyAccountRepository);
    }
}
