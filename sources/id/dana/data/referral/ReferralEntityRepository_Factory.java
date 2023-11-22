package id.dana.data.referral;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.referral.mapper.ReferralMapper;
import id.dana.data.referral.source.ReferralEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralEntityRepository_Factory implements Factory<ReferralEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<GeocodeEntityRepository> geocodeEntityRepositoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<ReferralMapper> mapperProvider;
    private final Provider<ReferralEntityDataFactory> referralEntityDataFactoryProvider;

    public ReferralEntityRepository_Factory(Provider<ReferralMapper> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<GeocodeEntityRepository> provider3, Provider<ReferralEntityDataFactory> provider4, Provider<ConfigEntityDataFactory> provider5) {
        this.mapperProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
        this.geocodeEntityRepositoryProvider = provider3;
        this.referralEntityDataFactoryProvider = provider4;
        this.configEntityDataFactoryProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final ReferralEntityRepository get() {
        ReferralEntityRepository newInstance = newInstance(this.mapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
        ReferralEntityRepository_MembersInjector.injectInjectDataFactory(newInstance, this.geocodeEntityRepositoryProvider.get(), this.referralEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get());
        return newInstance;
    }

    public static ReferralEntityRepository_Factory create(Provider<ReferralMapper> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<GeocodeEntityRepository> provider3, Provider<ReferralEntityDataFactory> provider4, Provider<ConfigEntityDataFactory> provider5) {
        return new ReferralEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ReferralEntityRepository newInstance(ReferralMapper referralMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new ReferralEntityRepository(referralMapper, holdLoginV1EntityRepository);
    }
}
