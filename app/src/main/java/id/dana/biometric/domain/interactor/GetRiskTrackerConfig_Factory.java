package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class GetRiskTrackerConfig_Factory implements Factory<GetRiskTrackerConfig> {
    private final Provider<RiskTrackerRepository> getAuthRequestContext;

    private GetRiskTrackerConfig_Factory(Provider<RiskTrackerRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetRiskTrackerConfig_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RiskTrackerRepository> provider) {
        return new GetRiskTrackerConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetRiskTrackerConfig(this.getAuthRequestContext.get());
    }
}
