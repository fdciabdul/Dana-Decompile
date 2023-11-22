package id.dana.splitbill;

import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.splitbill.interactor.GetSplitBillHistories;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.network.exception.NetworkException;
import id.dana.splitbill.SplitBillHistoryContract;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillHistoryPresenter implements SplitBillHistoryContract.Presenter {
    private final GetAccount BuiltInFictitiousFunctionClassFactory;
    private final SplitBillHistoryContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetSplitBillHistories MyBillsEntityDataFactory;

    @Inject
    public SplitBillHistoryPresenter(SplitBillHistoryContract.View view, GetSplitBillHistories getSplitBillHistories, GetAccount getAccount) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getSplitBillHistories;
        this.BuiltInFictitiousFunctionClassFactory = getAccount;
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<List<SplitBillHistory>>() { // from class: id.dana.splitbill.SplitBillHistoryPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                SplitBillHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccessGetSplitBillHistory((List) obj);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SplitBillHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.hideSplitBillHistories();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.SPLIT_BILL_EXCEPTION, DanaLogConstants.Prefix.GET_SPLIT_BILL_HISTORIES_PREFIX, th);
                SplitBillHistoryPresenter.PlaceComponentResult(SplitBillHistoryPresenter.this, TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_GET_HISTORY, th.getMessage(), th);
            }
        }, GetSplitBillHistories.Params.forPageNum(1));
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<Account>() { // from class: id.dana.splitbill.SplitBillHistoryPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccessGetAccount((Account) obj);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    static /* synthetic */ void PlaceComponentResult(SplitBillHistoryPresenter splitBillHistoryPresenter, String str, String str2, Throwable th) {
        NetworkException networkException = (NetworkException) th.getCause();
        if (networkException != null) {
            splitBillHistoryPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onTrackDisplayedError(str, str2, networkException.getMessage(), networkException.getErrorCode(), networkException.getTraceId());
        } else {
            splitBillHistoryPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onTrackDisplayedError(str, str2, th.getMessage(), "", "");
        }
    }
}
