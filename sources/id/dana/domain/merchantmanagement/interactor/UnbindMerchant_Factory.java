package id.dana.domain.merchantmanagement.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UnbindMerchant_Factory implements Factory<UnbindMerchant> {
    private final Provider<MerchantManagementRepository> merchantManagementRepositoryProvider;

    public UnbindMerchant_Factory(Provider<MerchantManagementRepository> provider) {
        this.merchantManagementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UnbindMerchant get() {
        return newInstance(this.merchantManagementRepositoryProvider.get());
    }

    public static UnbindMerchant_Factory create(Provider<MerchantManagementRepository> provider) {
        return new UnbindMerchant_Factory(provider);
    }

    public static UnbindMerchant newInstance(MerchantManagementRepository merchantManagementRepository) {
        return new UnbindMerchant(merchantManagementRepository);
    }
}
