package id.dana.splitbill;

import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.DefaultObserver;
import id.dana.domain.splitbill.interactor.ClosePayers;
import id.dana.domain.splitbill.interactor.GetSplitBillDetail;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.network.exception.NetworkException;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.mapper.SplitBillDetailMapper;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillDetailPresenter implements SplitBillDetailContract.Presenter {
    private final GetSplitBillDetail BuiltInFictitiousFunctionClassFactory;
    private final SplitBillDetailMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final SplitBillDetailContract.View PlaceComponentResult;
    private final ClosePayers getAuthRequestContext;

    @Inject
    public SplitBillDetailPresenter(SplitBillDetailContract.View view, GetSplitBillDetail getSplitBillDetail, SplitBillDetailMapper splitBillDetailMapper, ClosePayers closePayers) {
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = getSplitBillDetail;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitBillDetailMapper;
        this.getAuthRequestContext = closePayers;
    }

    @Override // id.dana.splitbill.SplitBillDetailContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.PlaceComponentResult.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<SplitBillHistory>() { // from class: id.dana.splitbill.SplitBillDetailPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillDetailPresenter.this.PlaceComponentResult.dismissProgress();
                SplitBillDetailPresenter.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(SplitBillDetailPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.apply((SplitBillHistory) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.SPLIT_BILL_EXCEPTION, DanaLogConstants.Prefix.GET_SPLIT_BILL_DETAIL, th);
                SplitBillDetailPresenter.this.PlaceComponentResult.dismissProgress();
                SplitBillDetailPresenter.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                SplitBillDetailPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SplitBillDetailPresenter.this, TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_DETAIL, th.getMessage(), th);
            }
        }, GetSplitBillDetail.Params.forSplitBillId(str));
    }

    @Override // id.dana.splitbill.SplitBillDetailContract.Presenter
    public final void getAuthRequestContext(List<String> list, String str) {
        this.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.splitbill.SplitBillDetailPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillDetailPresenter.this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SplitBillDetailPresenter.this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(true);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.SPLIT_BILL_EXCEPTION, DanaLogConstants.Prefix.CLOSE_SPLIT_BILL_PAYER, th);
            }
        }, ClosePayers.Params.forClosePayers(list, str));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillDetailPresenter splitBillDetailPresenter, String str, String str2, Throwable th) {
        NetworkException networkException = (NetworkException) th.getCause();
        if (networkException != null) {
            SplitBillDetailContract.View view = splitBillDetailPresenter.PlaceComponentResult;
            String message = networkException.getMessage();
            networkException.getErrorCode();
            view.MyBillsEntityDataFactory(str, str2, message, networkException.getTraceId());
            return;
        }
        splitBillDetailPresenter.PlaceComponentResult.MyBillsEntityDataFactory(str, str2, th.getMessage(), "");
    }
}
