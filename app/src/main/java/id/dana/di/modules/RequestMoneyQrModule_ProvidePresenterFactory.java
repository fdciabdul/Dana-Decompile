package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.RequestMoneyQrPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RequestMoneyQrModule_ProvidePresenterFactory implements Factory<RequestMoneyQrContract.Presenter> {
    private final Provider<RequestMoneyQrPresenter> MyBillsEntityDataFactory;
    private final RequestMoneyQrModule PlaceComponentResult;

    public static RequestMoneyQrContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyQrModule requestMoneyQrModule, RequestMoneyQrPresenter requestMoneyQrPresenter) {
        return (RequestMoneyQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(requestMoneyQrModule.PlaceComponentResult(requestMoneyQrPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RequestMoneyQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
