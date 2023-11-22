package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingUpdateContract;

/* loaded from: classes4.dex */
public final class SavingUpdateModule_ProvideSavingUpdateViewFactory implements Factory<SavingUpdateContract.View> {
    private final SavingUpdateModule MyBillsEntityDataFactory;

    private SavingUpdateModule_ProvideSavingUpdateViewFactory(SavingUpdateModule savingUpdateModule) {
        this.MyBillsEntityDataFactory = savingUpdateModule;
    }

    public static SavingUpdateModule_ProvideSavingUpdateViewFactory BuiltInFictitiousFunctionClassFactory(SavingUpdateModule savingUpdateModule) {
        return new SavingUpdateModule_ProvideSavingUpdateViewFactory(savingUpdateModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingUpdateContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
