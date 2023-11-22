package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetInsuranceAssetList_Factory implements Factory<GetInsuranceAssetList> {
    private final Provider<PersonalTabRepository> personalTabRepositoryProvider;

    public GetInsuranceAssetList_Factory(Provider<PersonalTabRepository> provider) {
        this.personalTabRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetInsuranceAssetList get() {
        return newInstance(this.personalTabRepositoryProvider.get());
    }

    public static GetInsuranceAssetList_Factory create(Provider<PersonalTabRepository> provider) {
        return new GetInsuranceAssetList_Factory(provider);
    }

    public static GetInsuranceAssetList newInstance(PersonalTabRepository personalTabRepository) {
        return new GetInsuranceAssetList(personalTabRepository);
    }
}
