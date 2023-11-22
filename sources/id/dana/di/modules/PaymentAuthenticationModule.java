package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationPresenter;

@Module
/* loaded from: classes4.dex */
public class PaymentAuthenticationModule {
    private PaymentAuthenticationContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PaymentAuthenticationContract.Presenter getAuthRequestContext(PaymentAuthenticationPresenter paymentAuthenticationPresenter) {
        return paymentAuthenticationPresenter;
    }

    public PaymentAuthenticationModule(PaymentAuthenticationContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public PaymentAuthenticationContract.View getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
