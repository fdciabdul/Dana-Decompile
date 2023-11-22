package id.dana.contract.sendmoney.voucher;

import android.content.Context;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.sendmoney.interactor.GetTransferPrePay;
import id.dana.domain.sendmoney.model.TransferPrepay;
import id.dana.sendmoney.mapper.TransferPrepayMapper;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ChangeVoucherPresenter implements ChangeVoucherContract.Presenter {
    private final GetTransferPrePay BuiltInFictitiousFunctionClassFactory;
    private final ChangeVoucherContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final TransferPrepayMapper PlaceComponentResult;
    private final Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public ChangeVoucherPresenter(GetTransferPrePay getTransferPrePay, ChangeVoucherContract.View view, TransferPrepayMapper transferPrepayMapper, Context context) {
        this.BuiltInFictitiousFunctionClassFactory = getTransferPrePay;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = transferPrepayMapper;
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Override // id.dana.contract.sendmoney.voucher.ChangeVoucherContract.Presenter
    public final void MyBillsEntityDataFactory(String str, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<TransferPrepay>() { // from class: id.dana.contract.sendmoney.voucher.ChangeVoucherPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ChangeVoucherPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                ChangeVoucherPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(ChangeVoucherPresenter.this.PlaceComponentResult.apply((TransferPrepay) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                ChangeVoucherPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
                ChangeVoucherPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onError(ErrorUtil.PlaceComponentResult(th, ChangeVoucherPresenter.this.getAuthRequestContext));
            }
        }, GetTransferPrePay.Params.forPrePay(str, str2));
    }
}
