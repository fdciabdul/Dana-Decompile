package id.dana.pay;

import id.dana.contract.payasset.ChangePayMethodContract;

/* loaded from: classes5.dex */
public class ChangePayMethodHolder implements ChangePayMethodContract.View {
    private final PayQrFacade MyBillsEntityDataFactory;

    public ChangePayMethodHolder(PayQrFacade payQrFacade) {
        this.MyBillsEntityDataFactory = payQrFacade;
    }

    @Override // id.dana.contract.payasset.ChangePayMethodContract.View
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.lookAheadTest();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        this.MyBillsEntityDataFactory.getAuthRequestContext();
    }
}
