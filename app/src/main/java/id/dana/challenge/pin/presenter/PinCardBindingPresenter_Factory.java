package id.dana.challenge.pin.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cashier.domain.interactor.PayCashier;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.challenge.pin.AbstractPinContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinCardBindingPresenter_Factory implements Factory<PinCardBindingPresenter> {
    private final Provider<AbstractPinContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PayQueryCashier> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CashierPayModelMapper> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<PayCashier> getAuthRequestContext;

    private PinCardBindingPresenter_Factory(Provider<Context> provider, Provider<PayCashier> provider2, Provider<PayQueryCashier> provider3, Provider<CashierPayModelMapper> provider4, Provider<AbstractPinContract.View> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
    }

    public static PinCardBindingPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<PayCashier> provider2, Provider<PayQueryCashier> provider3, Provider<CashierPayModelMapper> provider4, Provider<AbstractPinContract.View> provider5) {
        return new PinCardBindingPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinCardBindingPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
