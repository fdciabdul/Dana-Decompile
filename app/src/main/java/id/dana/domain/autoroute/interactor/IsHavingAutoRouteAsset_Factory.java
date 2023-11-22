package id.dana.domain.autoroute.interactor;

import dagger.internal.Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class IsHavingAutoRouteAsset_Factory implements Factory<IsHavingAutoRouteAsset> {
    private final Provider<AutoRouteRepository> autoRouteRepositoryProvider;

    public IsHavingAutoRouteAsset_Factory(Provider<AutoRouteRepository> provider) {
        this.autoRouteRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsHavingAutoRouteAsset get() {
        return newInstance(this.autoRouteRepositoryProvider.get());
    }

    public static IsHavingAutoRouteAsset_Factory create(Provider<AutoRouteRepository> provider) {
        return new IsHavingAutoRouteAsset_Factory(provider);
    }

    public static IsHavingAutoRouteAsset newInstance(AutoRouteRepository autoRouteRepository) {
        return new IsHavingAutoRouteAsset(autoRouteRepository);
    }
}
