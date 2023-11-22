package id.dana.data.referral;

import dagger.MembersInjector;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.referral.source.ReferralEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReferralEntityRepository_MembersInjector implements MembersInjector<ReferralEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<GeocodeEntityRepository> geocodeEntityRepositoryProvider;
    private final Provider<ReferralEntityDataFactory> referralEntityDataFactoryProvider;

    public ReferralEntityRepository_MembersInjector(Provider<GeocodeEntityRepository> provider, Provider<ReferralEntityDataFactory> provider2, Provider<ConfigEntityDataFactory> provider3) {
        this.geocodeEntityRepositoryProvider = provider;
        this.referralEntityDataFactoryProvider = provider2;
        this.configEntityDataFactoryProvider = provider3;
    }

    public static MembersInjector<ReferralEntityRepository> create(Provider<GeocodeEntityRepository> provider, Provider<ReferralEntityDataFactory> provider2, Provider<ConfigEntityDataFactory> provider3) {
        return new ReferralEntityRepository_MembersInjector(provider, provider2, provider3);
    }

    public final void injectMembers(ReferralEntityRepository referralEntityRepository) {
        injectInjectDataFactory(referralEntityRepository, this.geocodeEntityRepositoryProvider.get(), this.referralEntityDataFactoryProvider.get(), this.configEntityDataFactoryProvider.get());
    }

    public static void injectInjectDataFactory(ReferralEntityRepository referralEntityRepository, GeocodeEntityRepository geocodeEntityRepository, ReferralEntityDataFactory referralEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory) {
        referralEntityRepository.injectDataFactory(geocodeEntityRepository, referralEntityDataFactory, configEntityDataFactory);
    }
}
