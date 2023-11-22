package id.dana.contract.deeplink.generation;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.deeplink.interactor.GenerateSplitBillQrDeepLink;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.domain.splitbill.model.SplitBillDeeplink;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class SplitBillQrDeepLinkPresenter implements GenerateDeepLinkContract.SplitBillPresenter {
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final GenerateDeepLinkContract.SplitBillView MyBillsEntityDataFactory;
    private final GenerateSplitBillQrDeepLink PlaceComponentResult;

    @Inject
    public SplitBillQrDeepLinkPresenter(Context context, GenerateSplitBillQrDeepLink generateSplitBillQrDeepLink, GenerateDeepLinkContract.SplitBillView splitBillView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = generateSplitBillQrDeepLink;
        this.MyBillsEntityDataFactory = splitBillView;
    }

    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.SplitBillPresenter
    public final void MyBillsEntityDataFactory(SplitBill splitBill, String str, String str2) {
        this.MyBillsEntityDataFactory.showProgress();
        this.PlaceComponentResult.execute(new DefaultObserver<SplitBillDeeplink>() { // from class: id.dana.contract.deeplink.generation.SplitBillQrDeepLinkPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillDeeplink splitBillDeeplink = (SplitBillDeeplink) obj;
                SplitBillQrDeepLinkPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                SplitBillQrDeepLinkPresenter.this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(splitBillDeeplink.getLink(), splitBillDeeplink.getSplitBillId());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SplitBillQrDeepLinkPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                SplitBillQrDeepLinkPresenter.this.MyBillsEntityDataFactory.onError(ErrorUtil.PlaceComponentResult(th, SplitBillQrDeepLinkPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.SPLIT_BILL_DEEPLINK_PREFIX, DanaLogConstants.ExceptionType.SPLIT_BILL_EXCEPTION, th.getMessage());
                SplitBillQrDeepLinkPresenter.getAuthRequestContext(SplitBillQrDeepLinkPresenter.this, TrackerDataKey.NetworkErrorOperationTypeProperty.SPLIT_BILL_QR, th.getMessage(), th);
            }
        }, GenerateSplitBillQrDeepLink.Params.forParams(splitBill, str, str2));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    static /* synthetic */ void getAuthRequestContext(SplitBillQrDeepLinkPresenter splitBillQrDeepLinkPresenter, String str, String str2, Throwable th) {
        NetworkException networkException = (NetworkException) th.getCause();
        if (networkException != null) {
            GenerateDeepLinkContract.SplitBillView splitBillView = splitBillQrDeepLinkPresenter.MyBillsEntityDataFactory;
            String message = networkException.getMessage();
            networkException.getErrorCode();
            splitBillView.PlaceComponentResult(str, str2, message, networkException.getTraceId());
            return;
        }
        splitBillQrDeepLinkPresenter.MyBillsEntityDataFactory.PlaceComponentResult(str, str2, th.getMessage(), "");
    }
}
