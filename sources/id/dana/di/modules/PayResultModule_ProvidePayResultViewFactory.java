package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.PayResultContract;

/* loaded from: classes4.dex */
public final class PayResultModule_ProvidePayResultViewFactory implements Factory<PayResultContract.View> {
    private final PayResultModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PayResultModule_ProvidePayResultViewFactory(PayResultModule payResultModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payResultModule;
    }

    public static PayResultModule_ProvidePayResultViewFactory MyBillsEntityDataFactory(PayResultModule payResultModule) {
        return new PayResultModule_ProvidePayResultViewFactory(payResultModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayResultContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
