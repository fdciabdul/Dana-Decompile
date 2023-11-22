package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DeleteScoringDeviceData_Factory implements Factory<DeleteScoringDeviceData> {
    private final Provider<RiskTrackerRepository> BuiltInFictitiousFunctionClassFactory;

    private DeleteScoringDeviceData_Factory(Provider<RiskTrackerRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static DeleteScoringDeviceData_Factory BuiltInFictitiousFunctionClassFactory(Provider<RiskTrackerRepository> provider) {
        return new DeleteScoringDeviceData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteScoringDeviceData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
