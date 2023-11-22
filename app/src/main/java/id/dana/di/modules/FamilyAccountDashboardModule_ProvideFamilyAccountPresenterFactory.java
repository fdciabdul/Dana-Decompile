package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.contract.FamilyDashboardPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory implements Factory<FamilyDashboardContract.Presenter> {
    private final FamilyAccountDashboardModule MyBillsEntityDataFactory;
    private final Provider<FamilyDashboardPresenter> PlaceComponentResult;

    private FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory(FamilyAccountDashboardModule familyAccountDashboardModule, Provider<FamilyDashboardPresenter> provider) {
        this.MyBillsEntityDataFactory = familyAccountDashboardModule;
        this.PlaceComponentResult = provider;
    }

    public static FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory MyBillsEntityDataFactory(FamilyAccountDashboardModule familyAccountDashboardModule, Provider<FamilyDashboardPresenter> provider) {
        return new FamilyAccountDashboardModule_ProvideFamilyAccountPresenterFactory(familyAccountDashboardModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyDashboardContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
