package id.dana.data.homeinfo.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MaintenanceBroadcastEntityData_Factory implements Factory<MaintenanceBroadcastEntityData> {
    private final Provider<MaintenanceBroadcastPreference> maintenanceBroadcastPreferenceProvider;

    public MaintenanceBroadcastEntityData_Factory(Provider<MaintenanceBroadcastPreference> provider) {
        this.maintenanceBroadcastPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MaintenanceBroadcastEntityData get() {
        return newInstance(this.maintenanceBroadcastPreferenceProvider.get());
    }

    public static MaintenanceBroadcastEntityData_Factory create(Provider<MaintenanceBroadcastPreference> provider) {
        return new MaintenanceBroadcastEntityData_Factory(provider);
    }

    public static MaintenanceBroadcastEntityData newInstance(MaintenanceBroadcastPreference maintenanceBroadcastPreference) {
        return new MaintenanceBroadcastEntityData(maintenanceBroadcastPreference);
    }
}
