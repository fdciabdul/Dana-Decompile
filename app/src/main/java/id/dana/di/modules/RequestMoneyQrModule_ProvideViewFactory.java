package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.requestmoney.RequestMoneyQrContract;

/* loaded from: classes4.dex */
public final class RequestMoneyQrModule_ProvideViewFactory implements Factory<RequestMoneyQrContract.View> {
    private final RequestMoneyQrModule MyBillsEntityDataFactory;

    public static RequestMoneyQrContract.View KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyQrModule requestMoneyQrModule) {
        return (RequestMoneyQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(requestMoneyQrModule.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RequestMoneyQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
