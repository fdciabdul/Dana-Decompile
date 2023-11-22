package id.dana.data.nearbyme.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.nearbyme.mapper.DanaDealsVoucherOrderMapper;
import id.dana.data.nearbyme.mapper.NearbyShopsResultMapper;
import id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData;
import id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.session.LocalMerchantInfoEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantInfoEntityRepository_Factory implements Factory<MerchantInfoEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataProvider;
    private final Provider<DanaDealsVoucherOrderMapper> danaDealsVoucherOrderMapperProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<LocalMerchantInfoEntityData> localMerchantInfoEntityDataProvider;
    private final Provider<NearbyMeEntityRepository> nearbyMeEntityRepositoryProvider;
    private final Provider<NearbyShopsResultMapper> nearbyShopsResultMapperProvider;
    private final Provider<NetworkMerchantInfoEntityData> networkMerchantInfoEntityDataProvider;
    private final Provider<NetworkNearbyMeEntityData> networkNearbyMeEntityDataProvider;
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public MerchantInfoEntityRepository_Factory(Provider<DanaDealsVoucherOrderMapper> provider, Provider<LocalMerchantInfoEntityData> provider2, Provider<NetworkMerchantInfoEntityData> provider3, Provider<NetworkNearbyMeEntityData> provider4, Provider<AccountEntityDataFactory> provider5, Provider<NearbyShopsResultMapper> provider6, Provider<NearbyMeEntityRepository> provider7, Provider<SplitConfigEntityData> provider8, Provider<HoldLoginV1EntityRepository> provider9) {
        this.danaDealsVoucherOrderMapperProvider = provider;
        this.localMerchantInfoEntityDataProvider = provider2;
        this.networkMerchantInfoEntityDataProvider = provider3;
        this.networkNearbyMeEntityDataProvider = provider4;
        this.accountEntityDataProvider = provider5;
        this.nearbyShopsResultMapperProvider = provider6;
        this.nearbyMeEntityRepositoryProvider = provider7;
        this.splitConfigEntityDataProvider = provider8;
        this.holdLoginV1EntityRepositoryProvider = provider9;
    }

    @Override // javax.inject.Provider
    public final MerchantInfoEntityRepository get() {
        return newInstance(this.danaDealsVoucherOrderMapperProvider.get(), this.localMerchantInfoEntityDataProvider.get(), this.networkMerchantInfoEntityDataProvider.get(), this.networkNearbyMeEntityDataProvider.get(), this.accountEntityDataProvider.get(), this.nearbyShopsResultMapperProvider.get(), this.nearbyMeEntityRepositoryProvider.get(), this.splitConfigEntityDataProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static MerchantInfoEntityRepository_Factory create(Provider<DanaDealsVoucherOrderMapper> provider, Provider<LocalMerchantInfoEntityData> provider2, Provider<NetworkMerchantInfoEntityData> provider3, Provider<NetworkNearbyMeEntityData> provider4, Provider<AccountEntityDataFactory> provider5, Provider<NearbyShopsResultMapper> provider6, Provider<NearbyMeEntityRepository> provider7, Provider<SplitConfigEntityData> provider8, Provider<HoldLoginV1EntityRepository> provider9) {
        return new MerchantInfoEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static MerchantInfoEntityRepository newInstance(DanaDealsVoucherOrderMapper danaDealsVoucherOrderMapper, LocalMerchantInfoEntityData localMerchantInfoEntityData, NetworkMerchantInfoEntityData networkMerchantInfoEntityData, NetworkNearbyMeEntityData networkNearbyMeEntityData, AccountEntityDataFactory accountEntityDataFactory, NearbyShopsResultMapper nearbyShopsResultMapper, NearbyMeEntityRepository nearbyMeEntityRepository, SplitConfigEntityData splitConfigEntityData, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new MerchantInfoEntityRepository(danaDealsVoucherOrderMapper, localMerchantInfoEntityData, networkMerchantInfoEntityData, networkNearbyMeEntityData, accountEntityDataFactory, nearbyShopsResultMapper, nearbyMeEntityRepository, splitConfigEntityData, holdLoginV1EntityRepository);
    }
}
