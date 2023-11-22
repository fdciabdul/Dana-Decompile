package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyDashboardContract;

/* loaded from: classes4.dex */
public final class FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory implements Factory<FamilyDashboardContract.View> {
    private final FamilyAccountDashboardModule PlaceComponentResult;

    private FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory(FamilyAccountDashboardModule familyAccountDashboardModule) {
        this.PlaceComponentResult = familyAccountDashboardModule;
    }

    public static FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory KClassImpl$Data$declaredNonStaticMembers$2(FamilyAccountDashboardModule familyAccountDashboardModule) {
        return new FamilyAccountDashboardModule_ProvideFamilyAccountDashboardViewFactory(familyAccountDashboardModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyDashboardContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
