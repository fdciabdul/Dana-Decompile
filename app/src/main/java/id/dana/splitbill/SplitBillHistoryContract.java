package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.domain.account.Account;
import id.dana.domain.splitbill.model.SplitBillHistory;
import java.util.List;

/* loaded from: classes5.dex */
public interface SplitBillHistoryContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void hideSplitBillHistories();

        void onSuccessGetAccount(Account account);

        void onSuccessGetSplitBillHistory(List<SplitBillHistory> list);

        void onTrackDisplayedError(String str, String str2, String str3, String str4, String str5);
    }
}
