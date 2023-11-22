package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.domain.interactor.GetQueryPayOption;
import id.dana.cashier.domain.interactor.ProcessEventCheckoutFinish;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayResultPresenter_Factory implements Factory<PayResultPresenter> {
    private final Provider<CashierPayMethodModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetQueryPayOption> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ProcessEventCheckoutFinish> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<PayResultContract.View> getAuthRequestContext;

    private PayResultPresenter_Factory(Provider<Context> provider, Provider<PayResultContract.View> provider2, Provider<CashierPayMethodModelMapper> provider3, Provider<GetQueryPayOption> provider4, Provider<ProcessEventCheckoutFinish> provider5) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static PayResultPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<PayResultContract.View> provider2, Provider<CashierPayMethodModelMapper> provider3, Provider<GetQueryPayOption> provider4, Provider<ProcessEventCheckoutFinish> provider5) {
        return new PayResultPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PayResultPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
