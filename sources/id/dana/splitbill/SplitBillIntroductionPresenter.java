package id.dana.splitbill;

import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillIntroductionPresenter implements SplitBillIntroductionContract.Presenter {
    private SplitBillIntroductionContract.View BuiltInFictitiousFunctionClassFactory;
    private RequestMoneyInfoModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private GetRequestMoneyInfoFeature MyBillsEntityDataFactory;
    private GetSplitBillConfig PlaceComponentResult;
    private int getAuthRequestContext;

    @Inject
    public SplitBillIntroductionPresenter(SplitBillIntroductionContract.View view, GetSplitBillConfig getSplitBillConfig, GetRequestMoneyInfoFeature getRequestMoneyInfoFeature, RequestMoneyInfoModelMapper requestMoneyInfoModelMapper) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = getSplitBillConfig;
        this.MyBillsEntityDataFactory = getRequestMoneyInfoFeature;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = requestMoneyInfoModelMapper;
    }

    @Override // id.dana.splitbill.SplitBillIntroductionContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.execute(new DefaultObserver<SplitBillConfig>() { // from class: id.dana.splitbill.SplitBillIntroductionPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillIntroductionPresenter.this.getAuthRequestContext = ((SplitBillConfig) obj).getMaxRecipient();
                SplitBillIntroductionPresenter.BuiltInFictitiousFunctionClassFactory(SplitBillIntroductionPresenter.this);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, sb.toString());
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SplitBillIntroductionPresenter splitBillIntroductionPresenter) {
        splitBillIntroductionPresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<RequestMoneyInfo>() { // from class: id.dana.splitbill.SplitBillIntroductionPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillIntroductionPresenter.this.BuiltInFictitiousFunctionClassFactory.onFinishGetSplitBillConfig(SplitBillIntroductionPresenter.this.getAuthRequestContext, SplitBillIntroductionPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.apply((RequestMoneyInfo) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SPLIT_BILL_TAG, sb.toString());
            }
        });
    }
}
