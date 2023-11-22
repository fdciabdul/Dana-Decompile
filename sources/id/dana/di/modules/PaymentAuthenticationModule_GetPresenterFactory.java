package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PaymentAuthenticationModule_GetPresenterFactory implements Factory<PaymentAuthenticationContract.Presenter> {
    private final Provider<PaymentAuthenticationPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PaymentAuthenticationModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static PaymentAuthenticationContract.Presenter getAuthRequestContext(PaymentAuthenticationModule paymentAuthenticationModule, PaymentAuthenticationPresenter paymentAuthenticationPresenter) {
        return (PaymentAuthenticationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(paymentAuthenticationModule.getAuthRequestContext(paymentAuthenticationPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentAuthenticationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
