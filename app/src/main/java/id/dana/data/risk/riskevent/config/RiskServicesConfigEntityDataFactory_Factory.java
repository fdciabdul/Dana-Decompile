package id.dana.data.risk.riskevent.config;

import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RiskServicesConfigEntityDataFactory_Factory implements Factory<RiskServicesConfigEntityDataFactory> {
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;

    public RiskServicesConfigEntityDataFactory_Factory(Provider<SplitConfigEntityData> provider) {
        this.splitConfigEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RiskServicesConfigEntityDataFactory get() {
        return newInstance(this.splitConfigEntityDataProvider.get());
    }

    public static RiskServicesConfigEntityDataFactory_Factory create(Provider<SplitConfigEntityData> provider) {
        return new RiskServicesConfigEntityDataFactory_Factory(provider);
    }

    public static RiskServicesConfigEntityDataFactory newInstance(SplitConfigEntityData splitConfigEntityData) {
        return new RiskServicesConfigEntityDataFactory(splitConfigEntityData);
    }
}
