package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.savings.contract.SavingContract;

/* loaded from: classes4.dex */
public final class SavingModule_ProvideSavingViewFactory implements Factory<SavingContract.View> {
    private final SavingModule getAuthRequestContext;

    private SavingModule_ProvideSavingViewFactory(SavingModule savingModule) {
        this.getAuthRequestContext = savingModule;
    }

    public static SavingModule_ProvideSavingViewFactory MyBillsEntityDataFactory(SavingModule savingModule) {
        return new SavingModule_ProvideSavingViewFactory(savingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
