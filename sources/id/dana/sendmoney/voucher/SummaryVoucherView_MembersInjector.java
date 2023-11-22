package id.dana.sendmoney.voucher;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.voucher.ChangeVoucherContract;

/* loaded from: classes5.dex */
public final class SummaryVoucherView_MembersInjector implements MembersInjector<SummaryVoucherView> {
    public static void getAuthRequestContext(SummaryVoucherView summaryVoucherView, ChangeVoucherContract.Presenter presenter) {
        summaryVoucherView.voucherPresenter = presenter;
    }
}
