package id.dana.domain.merchantmanagement.interactor;

import dagger.internal.Factory;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ConsultUnbind_Factory implements Factory<ConsultUnbind> {
    private final Provider<MerchantManagementRepository> merchantManagementRepositoryProvider;

    public ConsultUnbind_Factory(Provider<MerchantManagementRepository> provider) {
        this.merchantManagementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultUnbind get() {
        return newInstance(this.merchantManagementRepositoryProvider.get());
    }

    public static ConsultUnbind_Factory create(Provider<MerchantManagementRepository> provider) {
        return new ConsultUnbind_Factory(provider);
    }

    public static ConsultUnbind newInstance(MerchantManagementRepository merchantManagementRepository) {
        return new ConsultUnbind(merchantManagementRepository);
    }
}
