package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class GetGyroscopeData_Factory implements Factory<GetGyroscopeData> {
    private final Provider<RiskTrackerRepository> BuiltInFictitiousFunctionClassFactory;

    private GetGyroscopeData_Factory(Provider<RiskTrackerRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetGyroscopeData_Factory MyBillsEntityDataFactory(Provider<RiskTrackerRepository> provider) {
        return new GetGyroscopeData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGyroscopeData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
