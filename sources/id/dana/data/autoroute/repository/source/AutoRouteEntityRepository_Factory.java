package id.dana.data.autoroute.repository.source;

import dagger.internal.Factory;
import id.dana.data.autoroute.repository.source.local.LocalAutoRouteEntity;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AutoRouteEntityRepository_Factory implements Factory<AutoRouteEntityRepository> {
    private final Provider<AutoRouteDataFactory> autoRouteDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;
    private final Provider<LocalAutoRouteEntity> localAutoRouteEntityProvider;

    public AutoRouteEntityRepository_Factory(Provider<AutoRouteDataFactory> provider, Provider<LocalAutoRouteEntity> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.autoRouteDataFactoryProvider = provider;
        this.localAutoRouteEntityProvider = provider2;
        this.holdLoginV1EntityRepositoryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final AutoRouteEntityRepository get() {
        return newInstance(this.autoRouteDataFactoryProvider.get(), this.localAutoRouteEntityProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static AutoRouteEntityRepository_Factory create(Provider<AutoRouteDataFactory> provider, Provider<LocalAutoRouteEntity> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new AutoRouteEntityRepository_Factory(provider, provider2, provider3);
    }

    public static AutoRouteEntityRepository newInstance(AutoRouteDataFactory autoRouteDataFactory, LocalAutoRouteEntity localAutoRouteEntity, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new AutoRouteEntityRepository(autoRouteDataFactory, localAutoRouteEntity, holdLoginV1EntityRepository);
    }
}
