package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.contract.FamilyManageContract;

/* loaded from: classes4.dex */
public final class FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory implements Factory<FamilyManageContract.View> {
    private final FamilyAccountManageModule MyBillsEntityDataFactory;

    private FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory(FamilyAccountManageModule familyAccountManageModule) {
        this.MyBillsEntityDataFactory = familyAccountManageModule;
    }

    public static FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory getAuthRequestContext(FamilyAccountManageModule familyAccountManageModule) {
        return new FamilyAccountManageModule_ProvideFamilyAccountManageViewFactory(familyAccountManageModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyManageContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
