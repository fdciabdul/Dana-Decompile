package id.dana.domain.autoroute.interactor;

import dagger.internal.Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAutoRouteInitialSetting_Factory implements Factory<GetAutoRouteInitialSetting> {
    private final Provider<AutoRouteRepository> autoRouteRepositoryProvider;

    public GetAutoRouteInitialSetting_Factory(Provider<AutoRouteRepository> provider) {
        this.autoRouteRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAutoRouteInitialSetting get() {
        return newInstance(this.autoRouteRepositoryProvider.get());
    }

    public static GetAutoRouteInitialSetting_Factory create(Provider<AutoRouteRepository> provider) {
        return new GetAutoRouteInitialSetting_Factory(provider);
    }

    public static GetAutoRouteInitialSetting newInstance(AutoRouteRepository autoRouteRepository) {
        return new GetAutoRouteInitialSetting(autoRouteRepository);
    }
}
