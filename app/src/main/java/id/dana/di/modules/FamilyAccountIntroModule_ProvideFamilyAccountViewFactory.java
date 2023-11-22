package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyActivationContract;

/* loaded from: classes4.dex */
public final class FamilyAccountIntroModule_ProvideFamilyAccountViewFactory implements Factory<FamilyActivationContract.View> {
    private final FamilyAccountIntroModule MyBillsEntityDataFactory;

    private FamilyAccountIntroModule_ProvideFamilyAccountViewFactory(FamilyAccountIntroModule familyAccountIntroModule) {
        this.MyBillsEntityDataFactory = familyAccountIntroModule;
    }

    public static FamilyAccountIntroModule_ProvideFamilyAccountViewFactory KClassImpl$Data$declaredNonStaticMembers$2(FamilyAccountIntroModule familyAccountIntroModule) {
        return new FamilyAccountIntroModule_ProvideFamilyAccountViewFactory(familyAccountIntroModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyActivationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getPlaceComponentResult());
    }
}
