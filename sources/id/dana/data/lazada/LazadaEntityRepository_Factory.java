package id.dana.data.lazada;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.lazada.mapper.LazadaRegistrationUrlMapper;
import id.dana.data.lazada.repository.source.LazadaRegistrationUrlEntityDataFactory;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LazadaEntityRepository_Factory implements Factory<LazadaEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<LazadaRegistrationUrlEntityDataFactory> lazadaRegistrationUrlEntityDataFactoryProvider;
    private final Provider<LazadaRegistrationUrlMapper> lazadaRegistrationUrlMapperProvider;
    private final Provider<UserConfigEntityRepository> userConfigEntityRepositoryProvider;

    public LazadaEntityRepository_Factory(Provider<UserConfigEntityRepository> provider, Provider<LazadaRegistrationUrlEntityDataFactory> provider2, Provider<LazadaRegistrationUrlMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        this.userConfigEntityRepositoryProvider = provider;
        this.lazadaRegistrationUrlEntityDataFactoryProvider = provider2;
        this.lazadaRegistrationUrlMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final LazadaEntityRepository get() {
        return newInstance(this.userConfigEntityRepositoryProvider.get(), this.lazadaRegistrationUrlEntityDataFactoryProvider.get(), this.lazadaRegistrationUrlMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static LazadaEntityRepository_Factory create(Provider<UserConfigEntityRepository> provider, Provider<LazadaRegistrationUrlEntityDataFactory> provider2, Provider<LazadaRegistrationUrlMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4) {
        return new LazadaEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static LazadaEntityRepository newInstance(UserConfigEntityRepository userConfigEntityRepository, LazadaRegistrationUrlEntityDataFactory lazadaRegistrationUrlEntityDataFactory, LazadaRegistrationUrlMapper lazadaRegistrationUrlMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new LazadaEntityRepository(userConfigEntityRepository, lazadaRegistrationUrlEntityDataFactory, lazadaRegistrationUrlMapper, holdLoginV1EntityRepository);
    }
}
