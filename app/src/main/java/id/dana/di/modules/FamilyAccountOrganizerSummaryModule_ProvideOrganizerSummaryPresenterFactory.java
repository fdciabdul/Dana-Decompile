package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.OrganizerSummaryContract;
import id.dana.familyaccount.contract.OrganizerSummaryPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory implements Factory<OrganizerSummaryContract.Presenter> {
    private final FamilyAccountOrganizerSummaryModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<OrganizerSummaryPresenter> getAuthRequestContext;

    private FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule, Provider<OrganizerSummaryPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = familyAccountOrganizerSummaryModule;
        this.getAuthRequestContext = provider;
    }

    public static FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory getAuthRequestContext(FamilyAccountOrganizerSummaryModule familyAccountOrganizerSummaryModule, Provider<OrganizerSummaryPresenter> provider) {
        return new FamilyAccountOrganizerSummaryModule_ProvideOrganizerSummaryPresenterFactory(familyAccountOrganizerSummaryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OrganizerSummaryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
