package id.dana.domain.installedapp.interactor;

import dagger.internal.Factory;
import id.dana.domain.installedapp.InstalledAppRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsNeedToSendInstalledApp_Factory implements Factory<IsNeedToSendInstalledApp> {
    private final Provider<InstalledAppRepository> installedAppRepositoryProvider;

    public IsNeedToSendInstalledApp_Factory(Provider<InstalledAppRepository> provider) {
        this.installedAppRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsNeedToSendInstalledApp get() {
        return newInstance(this.installedAppRepositoryProvider.get());
    }

    public static IsNeedToSendInstalledApp_Factory create(Provider<InstalledAppRepository> provider) {
        return new IsNeedToSendInstalledApp_Factory(provider);
    }

    public static IsNeedToSendInstalledApp newInstance(InstalledAppRepository installedAppRepository) {
        return new IsNeedToSendInstalledApp(installedAppRepository);
    }
}
