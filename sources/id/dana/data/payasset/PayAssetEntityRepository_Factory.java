package id.dana.data.payasset;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.payasset.mapper.PayAssetMapper;
import id.dana.data.payasset.source.PayAssetEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayAssetEntityRepository_Factory implements Factory<PayAssetEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<PayAssetEntityDataFactory> payAssetEntityDataFactoryProvider;
    private final Provider<PayAssetMapper> payAssetMapperProvider;

    public PayAssetEntityRepository_Factory(Provider<PayAssetEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PayAssetMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.payAssetEntityDataFactoryProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.payAssetMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final PayAssetEntityRepository get() {
        return newInstance(this.payAssetEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get(), this.payAssetMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PayAssetEntityRepository_Factory create(Provider<PayAssetEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2, Provider<PayAssetMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new PayAssetEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static PayAssetEntityRepository newInstance(PayAssetEntityDataFactory payAssetEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, PayAssetMapper payAssetMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PayAssetEntityRepository(payAssetEntityDataFactory, configEntityDataFactory, payAssetMapper, holdLoginV1EntityRepository);
    }
}
