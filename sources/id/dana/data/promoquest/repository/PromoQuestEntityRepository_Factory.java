package id.dana.data.promoquest.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promoquest.RedeemQuestEntityMapper;
import id.dana.data.promoquest.mapper.MissionDetailEntityMapper;
import id.dana.data.promoquest.mapper.PromoQuestEntityMapper;
import id.dana.data.promoquest.mapper.PromoQuestMapper;
import id.dana.data.promoquest.repository.source.PromoQuestEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoQuestEntityRepository_Factory implements Factory<PromoQuestEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<MissionDetailEntityMapper> missionDetailEntityMapperProvider;
    private final Provider<PromoQuestEntityDataFactory> promoQuestEntityDataFactoryProvider;
    private final Provider<PromoQuestEntityMapper> promoQuestEntityMapperProvider;
    private final Provider<PromoQuestMapper> promoQuestMapperProvider;
    private final Provider<RedeemQuestEntityMapper> redeemQuestEntityMapperProvider;

    public PromoQuestEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<PromoQuestEntityDataFactory> provider2, Provider<PromoQuestEntityMapper> provider3, Provider<MissionDetailEntityMapper> provider4, Provider<PromoQuestMapper> provider5, Provider<RedeemQuestEntityMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        this.accountEntityDataFactoryProvider = provider;
        this.promoQuestEntityDataFactoryProvider = provider2;
        this.promoQuestEntityMapperProvider = provider3;
        this.missionDetailEntityMapperProvider = provider4;
        this.promoQuestMapperProvider = provider5;
        this.redeemQuestEntityMapperProvider = provider6;
        this.holdLoginV1EntityRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final PromoQuestEntityRepository get() {
        return newInstance(this.accountEntityDataFactoryProvider.get(), this.promoQuestEntityDataFactoryProvider.get(), this.promoQuestEntityMapperProvider.get(), this.missionDetailEntityMapperProvider.get(), this.promoQuestMapperProvider.get(), this.redeemQuestEntityMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static PromoQuestEntityRepository_Factory create(Provider<AccountEntityDataFactory> provider, Provider<PromoQuestEntityDataFactory> provider2, Provider<PromoQuestEntityMapper> provider3, Provider<MissionDetailEntityMapper> provider4, Provider<PromoQuestMapper> provider5, Provider<RedeemQuestEntityMapper> provider6, Provider<HoldLoginV1EntityRepository> provider7) {
        return new PromoQuestEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PromoQuestEntityRepository newInstance(AccountEntityDataFactory accountEntityDataFactory, PromoQuestEntityDataFactory promoQuestEntityDataFactory, PromoQuestEntityMapper promoQuestEntityMapper, MissionDetailEntityMapper missionDetailEntityMapper, PromoQuestMapper promoQuestMapper, RedeemQuestEntityMapper redeemQuestEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new PromoQuestEntityRepository(accountEntityDataFactory, promoQuestEntityDataFactory, promoQuestEntityMapper, missionDetailEntityMapper, promoQuestMapper, redeemQuestEntityMapper, holdLoginV1EntityRepository);
    }
}
