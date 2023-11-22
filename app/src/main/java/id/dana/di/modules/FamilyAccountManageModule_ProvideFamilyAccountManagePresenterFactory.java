package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyManageContract;
import id.dana.familyaccount.contract.FamilyManagePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory implements Factory<FamilyManageContract.Presenter> {
    private final FamilyAccountManageModule MyBillsEntityDataFactory;
    private final Provider<FamilyManagePresenter> PlaceComponentResult;

    private FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory(FamilyAccountManageModule familyAccountManageModule, Provider<FamilyManagePresenter> provider) {
        this.MyBillsEntityDataFactory = familyAccountManageModule;
        this.PlaceComponentResult = provider;
    }

    public static FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory BuiltInFictitiousFunctionClassFactory(FamilyAccountManageModule familyAccountManageModule, Provider<FamilyManagePresenter> provider) {
        return new FamilyAccountManageModule_ProvideFamilyAccountManagePresenterFactory(familyAccountManageModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyManageContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
