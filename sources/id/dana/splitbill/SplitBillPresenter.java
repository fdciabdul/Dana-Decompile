package id.dana.splitbill;

import id.dana.domain.DefaultObserver;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.splitbill.SplitBillContract;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillPresenter implements SplitBillContract.Presenter {
    private SplitBillContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private GetAccount MyBillsEntityDataFactory;

    @Inject
    public SplitBillPresenter(SplitBillContract.View view, GetAccount getAccount) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getAccount;
    }

    @Override // id.dana.splitbill.SplitBillContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<Account>() { // from class: id.dana.splitbill.SplitBillPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((Account) obj);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
