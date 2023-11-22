package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.contract.sendmoney.PayMethodPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayMethodModule_ProvidePresenterFactory implements Factory<PayMethodContract.Presenter> {
    private final Provider<PayMethodPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PayMethodModule PlaceComponentResult;

    public static PayMethodContract.Presenter getAuthRequestContext(PayMethodModule payMethodModule, PayMethodPresenter payMethodPresenter) {
        return (PayMethodContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(payMethodModule.BuiltInFictitiousFunctionClassFactory(payMethodPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayMethodContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
