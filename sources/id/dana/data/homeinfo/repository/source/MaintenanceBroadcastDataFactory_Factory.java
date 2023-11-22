package id.dana.data.homeinfo.repository.source;

import dagger.internal.Factory;
import id.dana.data.homeinfo.repository.source.local.MaintenanceBroadcastPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MaintenanceBroadcastDataFactory_Factory implements Factory<MaintenanceBroadcastDataFactory> {
    private final Provider<MaintenanceBroadcastPreference> maintenanceBroadcastPreferenceProvider;

    public MaintenanceBroadcastDataFactory_Factory(Provider<MaintenanceBroadcastPreference> provider) {
        this.maintenanceBroadcastPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MaintenanceBroadcastDataFactory get() {
        return newInstance(this.maintenanceBroadcastPreferenceProvider.get());
    }

    public static MaintenanceBroadcastDataFactory_Factory create(Provider<MaintenanceBroadcastPreference> provider) {
        return new MaintenanceBroadcastDataFactory_Factory(provider);
    }

    public static MaintenanceBroadcastDataFactory newInstance(MaintenanceBroadcastPreference maintenanceBroadcastPreference) {
        return new MaintenanceBroadcastDataFactory(maintenanceBroadcastPreference);
    }
}
