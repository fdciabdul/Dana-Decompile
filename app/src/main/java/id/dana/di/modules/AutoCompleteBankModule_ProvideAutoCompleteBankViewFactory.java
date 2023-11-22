package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.bank.AutoCompleteBankContract;

/* loaded from: classes8.dex */
public final class AutoCompleteBankModule_ProvideAutoCompleteBankViewFactory implements Factory<AutoCompleteBankContract.View> {
    private final AutoCompleteBankModule BuiltInFictitiousFunctionClassFactory;

    public static AutoCompleteBankContract.View MyBillsEntityDataFactory(AutoCompleteBankModule autoCompleteBankModule) {
        return (AutoCompleteBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(autoCompleteBankModule.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AutoCompleteBankContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
