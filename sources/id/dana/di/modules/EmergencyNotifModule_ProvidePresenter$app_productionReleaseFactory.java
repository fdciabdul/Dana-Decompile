package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.maintenance.EmergencyNotifContract;
import id.dana.maintenance.EmergencyNotifPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class EmergencyNotifModule_ProvidePresenter$app_productionReleaseFactory implements Factory<EmergencyNotifContract.Presenter> {
    private final EmergencyNotifModule MyBillsEntityDataFactory;
    private final Provider<EmergencyNotifPresenter> getAuthRequestContext;

    public static EmergencyNotifContract.Presenter MyBillsEntityDataFactory(EmergencyNotifModule emergencyNotifModule, EmergencyNotifPresenter emergencyNotifPresenter) {
        return (EmergencyNotifContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(emergencyNotifModule.BuiltInFictitiousFunctionClassFactory(emergencyNotifPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (EmergencyNotifContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
