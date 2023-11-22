package id.dana.data.installedapp.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalInstalledAppEntityData_Factory implements Factory<LocalInstalledAppEntityData> {
    private final Provider<InstalledAppPreference> PlaceComponentResult;

    private LocalInstalledAppEntityData_Factory(Provider<InstalledAppPreference> provider) {
        this.PlaceComponentResult = provider;
    }

    public static LocalInstalledAppEntityData_Factory PlaceComponentResult(Provider<InstalledAppPreference> provider) {
        return new LocalInstalledAppEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalInstalledAppEntityData(this.PlaceComponentResult.get());
    }
}
