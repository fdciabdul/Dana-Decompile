package id.dana.data.homeinfo.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.homeinfo.mapper.HomeDataResultMapper;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.homeinfo.repository.source.HomeInfoEntityDataFactory;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomeInfoEntityRepository_Factory implements Factory<HomeInfoEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<HomeDataResultMapper> homeDataResultMapperProvider;
    private final Provider<HomeInfoEntityDataFactory> homeInfoEntityDataFactoryProvider;
    private final Provider<HomeInfoResultMapper> mapperProvider;
    private final Provider<SSLQuakeInterceptor> sslQuakeInterceptorProvider;

    public HomeInfoEntityRepository_Factory(Provider<HomeInfoEntityDataFactory> provider, Provider<HomeInfoResultMapper> provider2, Provider<HomeDataResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4, Provider<SSLQuakeInterceptor> provider5) {
        this.homeInfoEntityDataFactoryProvider = provider;
        this.mapperProvider = provider2;
        this.homeDataResultMapperProvider = provider3;
        this.holdLoginV1EntityRepositoryProvider = provider4;
        this.sslQuakeInterceptorProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final HomeInfoEntityRepository get() {
        return newInstance(this.homeInfoEntityDataFactoryProvider.get(), this.mapperProvider.get(), this.homeDataResultMapperProvider.get(), this.holdLoginV1EntityRepositoryProvider.get(), this.sslQuakeInterceptorProvider.get());
    }

    public static HomeInfoEntityRepository_Factory create(Provider<HomeInfoEntityDataFactory> provider, Provider<HomeInfoResultMapper> provider2, Provider<HomeDataResultMapper> provider3, Provider<HoldLoginV1EntityRepository> provider4, Provider<SSLQuakeInterceptor> provider5) {
        return new HomeInfoEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static HomeInfoEntityRepository newInstance(HomeInfoEntityDataFactory homeInfoEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper, HomeDataResultMapper homeDataResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository, SSLQuakeInterceptor sSLQuakeInterceptor) {
        return new HomeInfoEntityRepository(homeInfoEntityDataFactory, homeInfoResultMapper, homeDataResultMapper, holdLoginV1EntityRepository, sSLQuakeInterceptor);
    }
}
