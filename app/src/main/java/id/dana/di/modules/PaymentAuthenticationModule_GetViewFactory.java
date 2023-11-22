package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;

/* loaded from: classes4.dex */
public final class PaymentAuthenticationModule_GetViewFactory implements Factory<PaymentAuthenticationContract.View> {
    private final PaymentAuthenticationModule getAuthRequestContext;

    public static PaymentAuthenticationContract.View MyBillsEntityDataFactory(PaymentAuthenticationModule paymentAuthenticationModule) {
        return (PaymentAuthenticationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(paymentAuthenticationModule.getAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentAuthenticationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext());
    }
}
