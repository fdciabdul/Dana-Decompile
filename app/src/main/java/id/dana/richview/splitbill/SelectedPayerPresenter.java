package id.dana.richview.splitbill;

import id.dana.domain.DefaultObserver;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.requestmoney.splitbill.mapper.SplitBillRecentPayerMapper;
import id.dana.richview.splitbill.SelectedPayerContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SelectedPayerPresenter implements SelectedPayerContract.Presenter {
    private final SelectedPayerContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final SplitBillRecentPayerMapper MyBillsEntityDataFactory;
    private final GetRecentRecipient getAuthRequestContext;

    @Inject
    public SelectedPayerPresenter(SelectedPayerContract.View view, GetRecentRecipient getRecentRecipient, SplitBillRecentPayerMapper splitBillRecentPayerMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.getAuthRequestContext = getRecentRecipient;
        this.MyBillsEntityDataFactory = splitBillRecentPayerMapper;
    }

    @Override // id.dana.richview.splitbill.SelectedPayerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.execute(new DefaultObserver<List<RecentRecipient>>() { // from class: id.dana.richview.splitbill.SelectedPayerPresenter.1
            final /* synthetic */ int MyBillsEntityDataFactory = 2;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SelectedPayerContract.View view = SelectedPayerPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                SplitBillRecentPayerMapper unused = SelectedPayerPresenter.this.MyBillsEntityDataFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2(SplitBillRecentPayerMapper.getAuthRequestContext((List) obj, this.MyBillsEntityDataFactory));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SELECTED_PAYER_TAG, sb.toString());
            }
        }, GetRecentRecipient.Params.forGetRecentRecipient(10, 2, 2));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
