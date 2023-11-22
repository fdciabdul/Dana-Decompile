package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyActivationContract;
import id.dana.familyaccount.contract.FamilyActivationPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory implements Factory<FamilyActivationContract.Presenter> {
    private final FamilyAccountIntroModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FamilyActivationPresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory(FamilyAccountIntroModule familyAccountIntroModule, Provider<FamilyActivationPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = familyAccountIntroModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory BuiltInFictitiousFunctionClassFactory(FamilyAccountIntroModule familyAccountIntroModule, Provider<FamilyActivationPresenter> provider) {
        return new FamilyAccountIntroModule_ProvideFamilyAccountPresenterFactory(familyAccountIntroModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyActivationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
