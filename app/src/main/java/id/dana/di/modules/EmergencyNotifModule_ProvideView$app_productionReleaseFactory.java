package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.maintenance.EmergencyNotifContract;

/* loaded from: classes4.dex */
public final class EmergencyNotifModule_ProvideView$app_productionReleaseFactory implements Factory<EmergencyNotifContract.View> {
    private final EmergencyNotifModule PlaceComponentResult;

    public static EmergencyNotifContract.View MyBillsEntityDataFactory(EmergencyNotifModule emergencyNotifModule) {
        return (EmergencyNotifContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(emergencyNotifModule.getPlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (EmergencyNotifContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPlaceComponentResult());
    }
}
