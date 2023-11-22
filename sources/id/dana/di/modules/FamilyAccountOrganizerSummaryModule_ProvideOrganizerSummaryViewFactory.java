package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.OrganizerSummaryContract;

/* loaded from: classes4.dex */
public final class FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory implements Factory<OrganizerSummaryContract.View> {
    private final FamilyAccountOrganizerSummaryModule PlaceComponentResult;

    private FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule) {
        this.PlaceComponentResult = familyAccountOrganizerSummaryModule;
    }

    public static FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory BuiltInFictitiousFunctionClassFactory(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule) {
        return new FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryViewFactory(familyAccountOrganizerSummaryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OrganizerSummaryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getBuiltInFictitiousFunctionClassFactory());
    }
}
