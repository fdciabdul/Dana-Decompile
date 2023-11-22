package id.dana.domain.autoroute.interactor;

import dagger.internal.Factory;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SwitchAutoRouting_Factory implements Factory<SwitchAutoRouting> {
    private final Provider<AutoRouteRepository> autoRouteRepositoryProvider;

    public SwitchAutoRouting_Factory(Provider<AutoRouteRepository> provider) {
        this.autoRouteRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SwitchAutoRouting get() {
        return newInstance(this.autoRouteRepositoryProvider.get());
    }

    public static SwitchAutoRouting_Factory create(Provider<AutoRouteRepository> provider) {
        return new SwitchAutoRouting_Factory(provider);
    }

    public static SwitchAutoRouting newInstance(AutoRouteRepository autoRouteRepository) {
        return new SwitchAutoRouting(autoRouteRepository);
    }
}
