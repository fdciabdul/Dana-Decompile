package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingTopUpContract;

/* loaded from: classes4.dex */
public final class SavingTopUpModule_ProvideSavingTopUpViewFactory implements Factory<SavingTopUpContract.View> {
    private final SavingTopUpModule PlaceComponentResult;

    private SavingTopUpModule_ProvideSavingTopUpViewFactory(SavingTopUpModule savingTopUpModule) {
        this.PlaceComponentResult = savingTopUpModule;
    }

    public static SavingTopUpModule_ProvideSavingTopUpViewFactory MyBillsEntityDataFactory(SavingTopUpModule savingTopUpModule) {
        return new SavingTopUpModule_ProvideSavingTopUpViewFactory(savingTopUpModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingTopUpContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getMyBillsEntityDataFactory());
    }
}
