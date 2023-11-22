package id.dana.domain.installedapp.interactor;

import dagger.internal.Factory;
import id.dana.domain.installedapp.InstalledAppRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SaveNeedToSendInstalledApp_Factory implements Factory<SaveNeedToSendInstalledApp> {
    private final Provider<InstalledAppRepository> installedAppRepositoryProvider;

    public SaveNeedToSendInstalledApp_Factory(Provider<InstalledAppRepository> provider) {
        this.installedAppRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveNeedToSendInstalledApp get() {
        return newInstance(this.installedAppRepositoryProvider.get());
    }

    public static SaveNeedToSendInstalledApp_Factory create(Provider<InstalledAppRepository> provider) {
        return new SaveNeedToSendInstalledApp_Factory(provider);
    }

    public static SaveNeedToSendInstalledApp newInstance(InstalledAppRepository installedAppRepository) {
        return new SaveNeedToSendInstalledApp(installedAppRepository);
    }
}
