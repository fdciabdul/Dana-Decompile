package id.dana.data.ipg;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.ipg.mapper.IpgRegistrationUrlMapper;
import id.dana.data.ipg.repository.source.IpgRegistrationUrlEntityDataFactory;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class IpgEntityRepository_Factory implements Factory<IpgEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<IpgRegistrationUrlEntityDataFactory> ipgRegistrationUrlEntityDataFactoryProvider;
    private final Provider<IpgRegistrationUrlMapper> ipgRegistrationUrlMapperProvider;
    private final Provider<UserConfigEntityRepository> userConfigEntityRepositoryProvider;

    public IpgEntityRepository_Factory(Provider<UserConfigEntityRepository> provider, Provider<IpgRegistrationUrlEntityDataFactory> provider2, Provider<IpgRegistrationUrlMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.userConfigEntityRepositoryProvider = provider;
        this.ipgRegistrationUrlEntityDataFactoryProvider = provider2;
        this.ipgRegistrationUrlMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final IpgEntityRepository get() {
        return newInstance(this.userConfigEntityRepositoryProvider.get(), this.ipgRegistrationUrlEntityDataFactoryProvider.get(), this.ipgRegistrationUrlMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static IpgEntityRepository_Factory create(Provider<UserConfigEntityRepository> provider, Provider<IpgRegistrationUrlEntityDataFactory> provider2, Provider<IpgRegistrationUrlMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new IpgEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static IpgEntityRepository newInstance(UserConfigEntityRepository userConfigEntityRepository, IpgRegistrationUrlEntityDataFactory ipgRegistrationUrlEntityDataFactory, IpgRegistrationUrlMapper ipgRegistrationUrlMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new IpgEntityRepository(userConfigEntityRepository, ipgRegistrationUrlEntityDataFactory, ipgRegistrationUrlMapper, holdLoginV1EntityRepository);
    }
}
