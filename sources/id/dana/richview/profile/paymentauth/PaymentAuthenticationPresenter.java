package id.dana.richview.profile.paymentauth;

import id.dana.domain.DefaultObserver;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper;
import id.dana.richview.profile.paymentauth.PaymentAuthenticationContract;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class PaymentAuthenticationPresenter implements PaymentAuthenticationContract.Presenter {
    private final PaymentAuthenticationContract.View BuiltInFictitiousFunctionClassFactory;
    private final InitPaymentAuthentication KClassImpl$Data$declaredNonStaticMembers$2;
    private final PaymentSecurityInitMapper MyBillsEntityDataFactory;
    private final PaymentSecuritySwitchMapper PlaceComponentResult;
    private final ControlSwitchPaymentAuthentication getAuthRequestContext;

    @Inject
    public PaymentAuthenticationPresenter(PaymentAuthenticationContract.View view, InitPaymentAuthentication initPaymentAuthentication, PaymentSecurityInitMapper paymentSecurityInitMapper, ControlSwitchPaymentAuthentication controlSwitchPaymentAuthentication, PaymentSecuritySwitchMapper paymentSecuritySwitchMapper) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = initPaymentAuthentication;
        this.MyBillsEntityDataFactory = paymentSecurityInitMapper;
        this.getAuthRequestContext = controlSwitchPaymentAuthentication;
        this.PlaceComponentResult = paymentSecuritySwitchMapper;
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<PaymentSecurityInit>() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccessInitPaymentControl(PaymentAuthenticationPresenter.this.MyBillsEntityDataFactory.apply((PaymentSecurityInit) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.onErrorInitPaymentAuth();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.INIT_PAYMENT_CONTROL, DanaLogConstants.ExceptionType.PAYMENT_AUTH_EXCEPTION, th);
            }
        });
    }

    @Override // id.dana.richview.profile.paymentauth.PaymentAuthenticationContract.Presenter
    public final void PlaceComponentResult(boolean z, String str) {
        this.BuiltInFictitiousFunctionClassFactory.showSwitchLoading();
        this.getAuthRequestContext.execute(new DefaultObserver<PaymentSecuritySwitch>() { // from class: id.dana.richview.profile.paymentauth.PaymentAuthenticationPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PaymentSecuritySwitch paymentSecuritySwitch = (PaymentSecuritySwitch) obj;
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissSwitchLoading();
                if ("ACCEPT".equals(paymentSecuritySwitch.getRisk().getResult())) {
                    PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.onSuccesSwitchPaymentControl(PaymentAuthenticationPresenter.this.PlaceComponentResult.apply(paymentSecuritySwitch));
                } else {
                    PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.challengePassword(PaymentAuthenticationPresenter.this.PlaceComponentResult.apply(paymentSecuritySwitch));
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissSwitchLoading();
                PaymentAuthenticationPresenter.this.BuiltInFictitiousFunctionClassFactory.onErrorSwitchPaymentAuth();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SWITCH_PAYMENT_CONTROL, DanaLogConstants.ExceptionType.PAYMENT_AUTH_EXCEPTION, th);
            }
        }, ControlSwitchPaymentAuthentication.Params.forPaymentSecuritySwitchOn(z, str));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
    }
}
