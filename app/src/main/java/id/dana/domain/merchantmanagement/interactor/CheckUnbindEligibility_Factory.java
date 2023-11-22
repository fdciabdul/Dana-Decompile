package id.dana.domain.merchantmanagement.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class CheckUnbindEligibility_Factory implements Factory<CheckUnbindEligibility> {
    private final Provider<MerchantManagementRepository> merchantManagementRepositoryProvider;

    public CheckUnbindEligibility_Factory(Provider<MerchantManagementRepository> provider) {
        this.merchantManagementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckUnbindEligibility get() {
        return newInstance(this.merchantManagementRepositoryProvider.get());
    }

    public static CheckUnbindEligibility_Factory create(Provider<MerchantManagementRepository> provider) {
        return new CheckUnbindEligibility_Factory(provider);
    }

    public static CheckUnbindEligibility newInstance(MerchantManagementRepository merchantManagementRepository) {
        return new CheckUnbindEligibility(merchantManagementRepository);
    }
}
