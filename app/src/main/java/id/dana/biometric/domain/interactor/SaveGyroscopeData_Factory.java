package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SaveGyroscopeData_Factory implements Factory<SaveGyroscopeData> {
    private final Provider<RiskTrackerRepository> getAuthRequestContext;

    private SaveGyroscopeData_Factory(Provider<RiskTrackerRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static SaveGyroscopeData_Factory PlaceComponentResult(Provider<RiskTrackerRepository> provider) {
        return new SaveGyroscopeData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveGyroscopeData(this.getAuthRequestContext.get());
    }
}
