package id.dana.richview.profile.paymentauth;

import dagger.MembersInjector;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;

/* loaded from: classes5.dex */
public final class PaymentAuthenticationView_MembersInjector implements MembersInjector<PaymentAuthenticationView> {
    public static void PlaceComponentResult(PaymentAuthenticationView paymentAuthenticationView, PaymentAuthenticationContract.Presenter presenter) {
        paymentAuthenticationView.presenter = presenter;
    }
}
