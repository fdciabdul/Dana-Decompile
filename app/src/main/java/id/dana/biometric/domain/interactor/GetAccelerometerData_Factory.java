package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class GetAccelerometerData_Factory implements Factory<GetAccelerometerData> {
    private final Provider<RiskTrackerRepository> BuiltInFictitiousFunctionClassFactory;

    private GetAccelerometerData_Factory(Provider<RiskTrackerRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetAccelerometerData_Factory MyBillsEntityDataFactory(Provider<RiskTrackerRepository> provider) {
        return new GetAccelerometerData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetAccelerometerData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
