package id.dana.biometric.data.source;

import dagger.internal.Factory;
import id.dana.biometric.data.source.local.DefaultRiskTrackerConfigEntityData;
import id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskTrackerConfigEntityDataFactory_Factory implements Factory<RiskTrackerConfigEntityDataFactory> {
    private final Provider<DefaultRiskTrackerConfigEntityData> defaultRiskTrackerConfigEntityDataProvider;
    private final Provider<SplitRiskTrackerConfigEntityData> splitRiskTrackerConfigEntityDataProvider;

    public RiskTrackerConfigEntityDataFactory_Factory(Provider<SplitRiskTrackerConfigEntityData> provider, Provider<DefaultRiskTrackerConfigEntityData> provider2) {
        this.splitRiskTrackerConfigEntityDataProvider = provider;
        this.defaultRiskTrackerConfigEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final RiskTrackerConfigEntityDataFactory get() {
        return newInstance(this.splitRiskTrackerConfigEntityDataProvider.get(), this.defaultRiskTrackerConfigEntityDataProvider.get());
    }

    public static RiskTrackerConfigEntityDataFactory_Factory create(Provider<SplitRiskTrackerConfigEntityData> provider, Provider<DefaultRiskTrackerConfigEntityData> provider2) {
        return new RiskTrackerConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static RiskTrackerConfigEntityDataFactory newInstance(SplitRiskTrackerConfigEntityData splitRiskTrackerConfigEntityData, DefaultRiskTrackerConfigEntityData defaultRiskTrackerConfigEntityData) {
        return new RiskTrackerConfigEntityDataFactory(splitRiskTrackerConfigEntityData, defaultRiskTrackerConfigEntityData);
    }
}
