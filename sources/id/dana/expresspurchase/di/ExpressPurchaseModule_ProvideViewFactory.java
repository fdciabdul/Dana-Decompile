package id.dana.expresspurchase.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;

/* loaded from: classes5.dex */
public final class ExpressPurchaseModule_ProvideViewFactory implements Factory<ExpressPurchaseContract.View> {
    private final ExpressPurchaseModule BuiltInFictitiousFunctionClassFactory;

    private ExpressPurchaseModule_ProvideViewFactory(ExpressPurchaseModule expressPurchaseModule) {
        this.BuiltInFictitiousFunctionClassFactory = expressPurchaseModule;
    }

    public static ExpressPurchaseModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(ExpressPurchaseModule expressPurchaseModule) {
        return new ExpressPurchaseModule_ProvideViewFactory(expressPurchaseModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpressPurchaseContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
