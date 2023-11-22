package id.dana.expresspurchase.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.presenter.ExpressPurchasePresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ExpressPurchaseModule_ProvidePresenterFactory implements Factory<ExpressPurchaseContract.Presenter> {
    private final Provider<ExpressPurchasePresenter> BuiltInFictitiousFunctionClassFactory;
    private final ExpressPurchaseModule MyBillsEntityDataFactory;

    private ExpressPurchaseModule_ProvidePresenterFactory(ExpressPurchaseModule expressPurchaseModule, Provider<ExpressPurchasePresenter> provider) {
        this.MyBillsEntityDataFactory = expressPurchaseModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ExpressPurchaseModule_ProvidePresenterFactory getAuthRequestContext(ExpressPurchaseModule expressPurchaseModule, Provider<ExpressPurchasePresenter> provider) {
        return new ExpressPurchaseModule_ProvidePresenterFactory(expressPurchaseModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExpressPurchaseContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
