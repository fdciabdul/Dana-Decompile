package id.dana.domain.merchantmanagement.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetLinkedMerchants_Factory implements Factory<GetLinkedMerchants> {
    private final Provider<MerchantManagementRepository> merchantManagementRepositoryProvider;

    public GetLinkedMerchants_Factory(Provider<MerchantManagementRepository> provider) {
        this.merchantManagementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetLinkedMerchants get() {
        return newInstance(this.merchantManagementRepositoryProvider.get());
    }

    public static GetLinkedMerchants_Factory create(Provider<MerchantManagementRepository> provider) {
        return new GetLinkedMerchants_Factory(provider);
    }

    public static GetLinkedMerchants newInstance(MerchantManagementRepository merchantManagementRepository) {
        return new GetLinkedMerchants(merchantManagementRepository);
    }
}
