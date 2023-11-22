package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.domain.account.Account;

/* loaded from: classes5.dex */
public interface SplitBillContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void getAuthRequestContext(Account account);
    }
}
