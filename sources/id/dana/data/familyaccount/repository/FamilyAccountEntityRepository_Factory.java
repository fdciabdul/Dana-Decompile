package id.dana.data.familyaccount.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.familyaccount.repository.source.network.NetworkFamilyAccountEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.payasset.mapper.PayAssetMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FamilyAccountEntityRepository_Factory implements Factory<FamilyAccountEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<NetworkFamilyAccountEntityData> networkFamilyAccountEntityDataProvider;
    private final Provider<PayAssetMapper> payAssetMapperProvider;

    public FamilyAccountEntityRepository_Factory(Provider<NetworkFamilyAccountEntityData> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PayAssetMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.networkFamilyAccountEntityDataProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.payAssetMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final FamilyAccountEntityRepository get() {
        return newInstance(this.networkFamilyAccountEntityDataProvider.get(), this.configEntityDataFactoryProvider.get(), this.payAssetMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static FamilyAccountEntityRepository_Factory create(Provider<NetworkFamilyAccountEntityData> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PayAssetMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new FamilyAccountEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static FamilyAccountEntityRepository newInstance(NetworkFamilyAccountEntityData networkFamilyAccountEntityData, ConfigEntityDataFactory configEntityDataFactory, PayAssetMapper payAssetMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new FamilyAccountEntityRepository(networkFamilyAccountEntityData, configEntityDataFactory, payAssetMapper, holdLoginV1EntityRepository);
    }
}
