package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingConfigContract;

/* loaded from: classes4.dex */
public final class SavingConfigModule_ProvideSavingViewFactory implements Factory<SavingConfigContract.View> {
    private final SavingConfigModule MyBillsEntityDataFactory;

    private SavingConfigModule_ProvideSavingViewFactory(SavingConfigModule savingConfigModule) {
        this.MyBillsEntityDataFactory = savingConfigModule;
    }

    public static SavingConfigModule_ProvideSavingViewFactory BuiltInFictitiousFunctionClassFactory(SavingConfigModule savingConfigModule) {
        return new SavingConfigModule_ProvideSavingViewFactory(savingConfigModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingConfigContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
