package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.PaymentAuthenticationModule;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationView;

@Component(dependencies = {ApplicationComponent.class}, modules = {PaymentAuthenticationModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PaymentAuthenticationComponent {
    void BuiltInFictitiousFunctionClassFactory(NewPaymentAuthenticationView newPaymentAuthenticationView);

    void BuiltInFictitiousFunctionClassFactory(PaymentAuthenticationView paymentAuthenticationView);
}
