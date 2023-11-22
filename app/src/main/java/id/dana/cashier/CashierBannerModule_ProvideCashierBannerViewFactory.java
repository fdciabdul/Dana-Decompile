package id.dana.cashier;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.CashierBannerContract;

/* loaded from: classes4.dex */
public final class CashierBannerModule_ProvideCashierBannerViewFactory implements Factory<CashierBannerContract.View> {
    private final CashierBannerModule MyBillsEntityDataFactory;

    private CashierBannerModule_ProvideCashierBannerViewFactory(CashierBannerModule cashierBannerModule) {
        this.MyBillsEntityDataFactory = cashierBannerModule;
    }

    public static CashierBannerModule_ProvideCashierBannerViewFactory KClassImpl$Data$declaredNonStaticMembers$2(CashierBannerModule cashierBannerModule) {
        return new CashierBannerModule_ProvideCashierBannerViewFactory(cashierBannerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CashierBannerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
