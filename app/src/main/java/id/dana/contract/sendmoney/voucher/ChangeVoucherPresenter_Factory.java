package id.dana.contract.sendmoney.voucher;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;
import id.dana.domain.sendmoney.interactor.GetTransferPrePay;
import id.dana.sendmoney.mapper.TransferPrepayMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChangeVoucherPresenter_Factory implements Factory<ChangeVoucherPresenter> {
    private final Provider<ChangeVoucherContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TransferPrepayMapper> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetTransferPrePay> getAuthRequestContext;

    public static ChangeVoucherPresenter getAuthRequestContext(GetTransferPrePay getTransferPrePay, ChangeVoucherContract.View view, TransferPrepayMapper transferPrepayMapper, Context context) {
        return new ChangeVoucherPresenter(getTransferPrePay, view, transferPrepayMapper, context);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ChangeVoucherPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
