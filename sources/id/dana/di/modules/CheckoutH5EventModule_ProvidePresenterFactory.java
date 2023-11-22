package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.h5event.CheckoutH5EventPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckoutH5EventModule_ProvidePresenterFactory implements Factory<CheckoutH5EventContract.Presenter> {
    private final CheckoutH5EventModule PlaceComponentResult;
    private final Provider<CheckoutH5EventPresenter> getAuthRequestContext;

    private CheckoutH5EventModule_ProvidePresenterFactory(CheckoutH5EventModule checkoutH5EventModule, Provider<CheckoutH5EventPresenter> provider) {
        this.PlaceComponentResult = checkoutH5EventModule;
        this.getAuthRequestContext = provider;
    }

    public static CheckoutH5EventModule_ProvidePresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(CheckoutH5EventModule checkoutH5EventModule, Provider<CheckoutH5EventPresenter> provider) {
        return new CheckoutH5EventModule_ProvidePresenterFactory(checkoutH5EventModule, provider);
    }

    public static CheckoutH5EventContract.Presenter MyBillsEntityDataFactory(CheckoutH5EventModule checkoutH5EventModule, CheckoutH5EventPresenter checkoutH5EventPresenter) {
        return (CheckoutH5EventContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(checkoutH5EventModule.PlaceComponentResult(checkoutH5EventPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CheckoutH5EventContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
