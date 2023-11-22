package id.dana.richview.profile.paymentauth;

import id.dana.base.AbstractContract;
import id.dana.myprofile.model.PaymentSecurityInitModel;
import id.dana.myprofile.model.PaymentSecuritySwitchModel;

/* loaded from: classes5.dex */
public interface PaymentAuthenticationContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult(boolean z, String str);
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void challengePassword(PaymentSecuritySwitchModel paymentSecuritySwitchModel);

        void dismissSwitchLoading();

        void onErrorInitPaymentAuth();

        void onErrorSwitchPaymentAuth();

        void onSuccesSwitchPaymentControl(PaymentSecuritySwitchModel paymentSecuritySwitchModel);

        void onSuccessInitPaymentControl(PaymentSecurityInitModel paymentSecurityInitModel);

        void showSwitchLoading();
    }
}
