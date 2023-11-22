package id.dana.data.merchantmanagement.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.merchantmanagement.repository.source.MerchantManagementEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantManagementEntityRepository_Factory implements Factory<MerchantManagementEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<MerchantManagementEntityDataFactory> merchantManagementEntityDataFactoryProvider;

    public MerchantManagementEntityRepository_Factory(Provider<MerchantManagementEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.merchantManagementEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MerchantManagementEntityRepository get() {
        return newInstance(this.merchantManagementEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static MerchantManagementEntityRepository_Factory create(Provider<MerchantManagementEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new MerchantManagementEntityRepository_Factory(provider, provider2);
    }

    public static MerchantManagementEntityRepository newInstance(MerchantManagementEntityDataFactory merchantManagementEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new MerchantManagementEntityRepository(merchantManagementEntityDataFactory, holdLoginV1EntityRepository);
    }
}
