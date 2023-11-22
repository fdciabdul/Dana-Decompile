package id.dana.data.referral.repository;

import dagger.internal.Factory;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.referral.mapper.MyReferralConsultEntityMapper;
import id.dana.data.referral.repository.source.MyReferralConsultEntityDataFactory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MyReferralConsultEntityRepository_Factory implements Factory<MyReferralConsultEntityRepository> {
    private final Provider<ContentDeliveryCacheEntityDataFactory> contentDeliveryCacheEntityDataFactoryProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<MyReferralConsultEntityDataFactory> factoryProvider;
    private final Provider<GeneralPreferences> generalPreferencesProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<MyReferralConsultEntityMapper> mapperProvider;
    private final Provider<SpaceResultMapper> spaceResultMapperProvider;

    public MyReferralConsultEntityRepository_Factory(Provider<MyReferralConsultEntityDataFactory> provider, Provider<MyReferralConsultEntityMapper> provider2, Provider<GeneralPreferences> provider3, Provider<ContentDeliveryCacheEntityDataFactory> provider4, Provider<ContentDeliveryEntityDataFactory> provider5, Provider<SpaceResultMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.factoryProvider = provider;
        this.mapperProvider = provider2;
        this.generalPreferencesProvider = provider3;
        this.contentDeliveryCacheEntityDataFactoryProvider = provider4;
        this.contentDeliveryEntityDataFactoryProvider = provider5;
        this.spaceResultMapperProvider = provider6;
        this.holdLoginV1EntityRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final MyReferralConsultEntityRepository get() {
        return newInstance(this.factoryProvider.get(), this.mapperProvider.get(), this.generalPreferencesProvider.get(), this.contentDeliveryCacheEntityDataFactoryProvider.get(), this.contentDeliveryEntityDataFactoryProvider.get(), this.spaceResultMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static MyReferralConsultEntityRepository_Factory create(Provider<MyReferralConsultEntityDataFactory> provider, Provider<MyReferralConsultEntityMapper> provider2, Provider<GeneralPreferences> provider3, Provider<ContentDeliveryCacheEntityDataFactory> provider4, Provider<ContentDeliveryEntityDataFactory> provider5, Provider<SpaceResultMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new MyReferralConsultEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static MyReferralConsultEntityRepository newInstance(MyReferralConsultEntityDataFactory myReferralConsultEntityDataFactory, MyReferralConsultEntityMapper myReferralConsultEntityMapper, GeneralPreferences generalPreferences, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new MyReferralConsultEntityRepository(myReferralConsultEntityDataFactory, myReferralConsultEntityMapper, generalPreferences, contentDeliveryCacheEntityDataFactory, contentDeliveryEntityDataFactory, spaceResultMapper, holdLoginV1EntityRepository);
    }
}
