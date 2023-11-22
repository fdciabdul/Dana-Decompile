package id.dana.pay;

import id.dana.animation.view.QrRefreshNotification;
import id.dana.contract.payqr.PayQrContract;

/* loaded from: classes5.dex */
public class PaymentCodeHolder implements PayQrContract.View {
    private final PayQrFacade PlaceComponentResult;

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void PlaceComponentResult() {
    }

    public PaymentCodeHolder(PayQrFacade payQrFacade) {
        this.PlaceComponentResult = payQrFacade;
    }

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        this.PlaceComponentResult.getAuthRequestContext(str);
        this.PlaceComponentResult.PlaceComponentResult("SUCCESS", str);
    }

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.getAuthRequestContext();
        this.PlaceComponentResult.PlaceComponentResult("FAILED", null);
    }

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.getAuthRequestContext();
        this.PlaceComponentResult.PlaceComponentResult(QrRefreshNotification.StateType.ONPAUSED, null);
    }

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.getAuthRequestContext();
        this.PlaceComponentResult.PlaceComponentResult(QrRefreshNotification.StateType.ONSTOPPED, null);
    }

    @Override // id.dana.contract.payqr.PayQrContract.View
    public final void MyBillsEntityDataFactory(String str) {
        this.PlaceComponentResult.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2();
        this.PlaceComponentResult.PlaceComponentResult(QrRefreshNotification.StateType.SHOWPROGRESS, null);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1();
        this.PlaceComponentResult.PlaceComponentResult(QrRefreshNotification.StateType.DISMISSPROGRESS, null);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        this.PlaceComponentResult.getAuthRequestContext();
        this.PlaceComponentResult.PlaceComponentResult("ERROR", null);
    }
}
