package id.dana.biometric.data.source;

import dagger.internal.Factory;
import id.dana.biometric.data.source.local.LocalRiskTrackerEntityData;
import id.dana.biometric.data.source.network.NetworkRiskTrackerEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskTrackerEntityDataFactory_Factory implements Factory<RiskTrackerEntityDataFactory> {
    private final Provider<LocalRiskTrackerEntityData> localRiskTrackerEntityDataProvider;
    private final Provider<NetworkRiskTrackerEntityData> networkRiskTrackerEntityDataProvider;

    public RiskTrackerEntityDataFactory_Factory(Provider<LocalRiskTrackerEntityData> provider, Provider<NetworkRiskTrackerEntityData> provider2) {
        this.localRiskTrackerEntityDataProvider = provider;
        this.networkRiskTrackerEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final RiskTrackerEntityDataFactory get() {
        return newInstance(this.localRiskTrackerEntityDataProvider.get(), this.networkRiskTrackerEntityDataProvider.get());
    }

    public static RiskTrackerEntityDataFactory_Factory create(Provider<LocalRiskTrackerEntityData> provider, Provider<NetworkRiskTrackerEntityData> provider2) {
        return new RiskTrackerEntityDataFactory_Factory(provider, provider2);
    }

    public static RiskTrackerEntityDataFactory newInstance(LocalRiskTrackerEntityData localRiskTrackerEntityData, NetworkRiskTrackerEntityData networkRiskTrackerEntityData) {
        return new RiskTrackerEntityDataFactory(localRiskTrackerEntityData, networkRiskTrackerEntityData);
    }
}
