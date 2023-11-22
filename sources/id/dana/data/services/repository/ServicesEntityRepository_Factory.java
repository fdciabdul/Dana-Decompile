package id.dana.data.services.repository;

import dagger.internal.Factory;
import id.dana.data.favoriteservice.mapper.FavoriteServicesResultMapper;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.services.repository.source.ServicesEntityDataFactory;
import id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ServicesEntityRepository_Factory implements Factory<ServicesEntityRepository> {
    private final Provider<FavoriteServicesResultMapper> favoriteServicesResultMapperProvider;
    private final Provider<HomeInfoResultMapper> homeInfoResultMapperProvider;
    private final Provider<PreferenceFavoriteServicesEntityData> preferenceFavoriteServicesEntityDataProvider;
    private final Provider<ServicesEntityDataFactory> servicesEntityDataFactoryProvider;
    private final Provider<UserConfigEntityRepository> userConfigEntityRepositoryProvider;

    public ServicesEntityRepository_Factory(Provider<ServicesEntityDataFactory> provider, Provider<HomeInfoResultMapper> provider2, Provider<FavoriteServicesResultMapper> provider3, Provider<UserConfigEntityRepository> provider4, Provider<PreferenceFavoriteServicesEntityData> provider5) {
        this.servicesEntityDataFactoryProvider = provider;
        this.homeInfoResultMapperProvider = provider2;
        this.favoriteServicesResultMapperProvider = provider3;
        this.userConfigEntityRepositoryProvider = provider4;
        this.preferenceFavoriteServicesEntityDataProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final ServicesEntityRepository get() {
        return newInstance(this.servicesEntityDataFactoryProvider.get(), this.homeInfoResultMapperProvider.get(), this.favoriteServicesResultMapperProvider.get(), this.userConfigEntityRepositoryProvider.get(), this.preferenceFavoriteServicesEntityDataProvider.get());
    }

    public static ServicesEntityRepository_Factory create(Provider<ServicesEntityDataFactory> provider, Provider<HomeInfoResultMapper> provider2, Provider<FavoriteServicesResultMapper> provider3, Provider<UserConfigEntityRepository> provider4, Provider<PreferenceFavoriteServicesEntityData> provider5) {
        return new ServicesEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ServicesEntityRepository newInstance(ServicesEntityDataFactory servicesEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper, FavoriteServicesResultMapper favoriteServicesResultMapper, UserConfigEntityRepository userConfigEntityRepository, PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData) {
        return new ServicesEntityRepository(servicesEntityDataFactory, homeInfoResultMapper, favoriteServicesResultMapper, userConfigEntityRepository, preferenceFavoriteServicesEntityData);
    }
}
