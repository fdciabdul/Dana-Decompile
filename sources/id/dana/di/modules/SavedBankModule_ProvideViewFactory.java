package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;

/* loaded from: classes4.dex */
public final class SavedBankModule_ProvideViewFactory implements Factory<SavedBankCardContract.View> {
    private final SavedBankModule BuiltInFictitiousFunctionClassFactory;

    private SavedBankModule_ProvideViewFactory(SavedBankModule savedBankModule) {
        this.BuiltInFictitiousFunctionClassFactory = savedBankModule;
    }

    public static SavedBankModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SavedBankModule savedBankModule) {
        return new SavedBankModule_ProvideViewFactory(savedBankModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavedBankCardContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
    }
}
