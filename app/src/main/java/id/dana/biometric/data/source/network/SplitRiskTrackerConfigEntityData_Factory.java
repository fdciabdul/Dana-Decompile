package id.dana.biometric.data.source.network;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitRiskTrackerConfigEntityData_Factory implements Factory<SplitRiskTrackerConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitRiskTrackerConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitRiskTrackerConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitRiskTrackerConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitRiskTrackerConfigEntityData_Factory(provider);
    }

    public static SplitRiskTrackerConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitRiskTrackerConfigEntityData(splitFacade);
    }
}
