package id.dana.data.referraltracker;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.referraltracker.mapper.ReferralTrackerResultMapper;
import id.dana.data.referraltracker.source.ReferralTrackerEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralTrackerEntityRepository_Factory implements Factory<ReferralTrackerEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<ReferralTrackerResultMapper> mapperProvider;
    private final Provider<ReferralTrackerEntityDataFactory> referralTrackerEntityDataFactoryProvider;

    public ReferralTrackerEntityRepository_Factory(Provider<ReferralTrackerEntityDataFactory> provider, Provider<ReferralTrackerResultMapper> provider2, Provider<ConfigEntityDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.referralTrackerEntityDataFactoryProvider = provider;
        this.mapperProvider = provider2;
        this.configEntityDataFactoryProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final ReferralTrackerEntityRepository get() {
        return newInstance(this.referralTrackerEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.configEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static ReferralTrackerEntityRepository_Factory create(Provider<ReferralTrackerEntityDataFactory> provider, Provider<ReferralTrackerResultMapper> provider2, Provider<ConfigEntityDataFactory> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new ReferralTrackerEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static ReferralTrackerEntityRepository newInstance(ReferralTrackerEntityDataFactory referralTrackerEntityDataFactory, ReferralTrackerResultMapper referralTrackerResultMapper, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new ReferralTrackerEntityRepository(referralTrackerEntityDataFactory, referralTrackerResultMapper, configEntityDataFactory, holdLoginV1EntityRepository);
    }
}
