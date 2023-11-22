package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SaveAccelerometerData_Factory implements Factory<SaveAccelerometerData> {
    private final Provider<RiskTrackerRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private SaveAccelerometerData_Factory(Provider<RiskTrackerRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SaveAccelerometerData_Factory PlaceComponentResult(Provider<RiskTrackerRepository> provider) {
        return new SaveAccelerometerData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveAccelerometerData(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
