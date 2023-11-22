package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.presenter.PayResultPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayResultModule_ProvidesPayResultPresenterFactory implements Factory<PayResultContract.Presenter> {
    private final PayResultModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PayResultPresenter> getAuthRequestContext;

    private PayResultModule_ProvidesPayResultPresenterFactory(PayResultModule payResultModule, Provider<PayResultPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payResultModule;
        this.getAuthRequestContext = provider;
    }

    public static PayResultModule_ProvidesPayResultPresenterFactory BuiltInFictitiousFunctionClassFactory(PayResultModule payResultModule, Provider<PayResultPresenter> provider) {
        return new PayResultModule_ProvidesPayResultPresenterFactory(payResultModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayResultContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
