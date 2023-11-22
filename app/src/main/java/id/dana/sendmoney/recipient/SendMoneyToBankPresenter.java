package id.dana.sendmoney.recipient;

import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.CheckTransferToBankFeature;
import id.dana.sendmoney.recipient.SendMoneyToBankContract;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class SendMoneyToBankPresenter implements SendMoneyToBankContract.Presenter {
    private final SendMoneyToBankContract.View PlaceComponentResult;
    private final CheckTransferToBankFeature getAuthRequestContext;

    @Inject
    public SendMoneyToBankPresenter(SendMoneyToBankContract.View view, CheckTransferToBankFeature checkTransferToBankFeature) {
        this.PlaceComponentResult = view;
        this.getAuthRequestContext = checkTransferToBankFeature;
    }

    /* renamed from: id.dana.sendmoney.recipient.SendMoneyToBankPresenter$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 extends DefaultObserver<Boolean> {
        final /* synthetic */ SendMoneyToBankPresenter PlaceComponentResult;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            Boolean bool = (Boolean) obj;
            SendMoneyToBankContract.View unused = this.PlaceComponentResult.PlaceComponentResult;
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
