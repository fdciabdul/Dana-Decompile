package id.dana.challenge.pin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class PinPaymentAuthPresenter implements AbstractPinContract.Presenter {
    private final ControlSwitchPaymentAuthentication BuiltInFictitiousFunctionClassFactory;
    private final AbstractPinContract.View MyBillsEntityDataFactory;
    private final Context getAuthRequestContext;

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        AbstractPinContract.Presenter.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        AbstractPinContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginModel trust2RiskLoginModel) {
        AbstractPinContract.Presenter.CC.getErrorConfigVersion();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        AbstractPinContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        AbstractPinContract.Presenter.CC.moveToNextValue();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void MyBillsEntityDataFactory(String str, String str2) {
        AbstractPinContract.Presenter.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void MyBillsEntityDataFactory(String str, String str2, String str3, String str4) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void PlaceComponentResult() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void getAuthRequestContext(String str) {
        AbstractPinContract.Presenter.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void getAuthRequestContext(String str, String str2, String str3, Boolean bool, Activity activity) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void getAuthRequestContext(String str, String str2, String str3, boolean z) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public /* synthetic */ void getAuthRequestContext(String str, String str2, boolean z, boolean z2) {
        AbstractPinContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void getAuthRequestContext(String str, boolean z) {
    }

    @Inject
    public PinPaymentAuthPresenter(Context context, AbstractPinContract.View view, ControlSwitchPaymentAuthentication controlSwitchPaymentAuthentication) {
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = controlSwitchPaymentAuthentication;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public void PlaceComponentResult(String str, String str2, boolean z, String str3, String str4) {
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<PaymentSecuritySwitch>() { // from class: id.dana.challenge.pin.PinPaymentAuthPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PaymentSecuritySwitch paymentSecuritySwitch = (PaymentSecuritySwitch) obj;
                PinPaymentAuthPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                PinPaymentAuthPresenter.this.MyBillsEntityDataFactory.getAuthRequestContext();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                PinPaymentAuthPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                if (!(th instanceof NetworkException)) {
                    PinPaymentAuthPresenter.this.MyBillsEntityDataFactory.onError(ErrorUtil.PlaceComponentResult(th, PinPaymentAuthPresenter.this.getAuthRequestContext));
                } else {
                    NetworkException networkException = (NetworkException) th;
                    PinPaymentAuthPresenter.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                }
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SWITCH_PAYMENT_CONTROL, DanaLogConstants.ExceptionType.PAYMENT_AUTH_EXCEPTION, th);
            }
        }, ControlSwitchPaymentAuthentication.Params.forPaymentSecuritySwitchOff(z, str, str2, str4, str3));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
