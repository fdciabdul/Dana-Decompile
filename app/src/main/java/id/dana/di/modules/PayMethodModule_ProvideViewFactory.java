package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.PayMethodContract;

/* loaded from: classes4.dex */
public final class PayMethodModule_ProvideViewFactory implements Factory<PayMethodContract.View> {
    private final PayMethodModule getAuthRequestContext;

    private PayMethodModule_ProvideViewFactory(PayMethodModule payMethodModule) {
        this.getAuthRequestContext = payMethodModule;
    }

    public static PayMethodModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(PayMethodModule payMethodModule) {
        return new PayMethodModule_ProvideViewFactory(payMethodModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayMethodContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext());
    }
}
