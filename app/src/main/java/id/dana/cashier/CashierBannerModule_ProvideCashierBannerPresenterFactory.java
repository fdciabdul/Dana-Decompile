package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.presenter.CashierBannerPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CashierBannerModule_ProvideCashierBannerPresenterFactory implements Factory<CashierBannerContract.Presenter> {
    private final Provider<CashierBannerPresenter> BuiltInFictitiousFunctionClassFactory;
    private final CashierBannerModule getAuthRequestContext;

    private CashierBannerModule_ProvideCashierBannerPresenterFactory(CashierBannerModule cashierBannerModule, Provider<CashierBannerPresenter> provider) {
        this.getAuthRequestContext = cashierBannerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CashierBannerModule_ProvideCashierBannerPresenterFactory getAuthRequestContext(CashierBannerModule cashierBannerModule, Provider<CashierBannerPresenter> provider) {
        return new CashierBannerModule_ProvideCashierBannerPresenterFactory(cashierBannerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierBannerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
