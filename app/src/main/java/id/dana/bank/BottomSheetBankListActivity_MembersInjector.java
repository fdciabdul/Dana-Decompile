package id.dana.bank;

import dagger.MembersInjector;
import id.dana.bank.contract.BankListContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes4.dex */
public final class BottomSheetBankListActivity_MembersInjector implements MembersInjector<BottomSheetBankListActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(BottomSheetBankListActivity bottomSheetBankListActivity, BankListContract.Presenter presenter) {
        bottomSheetBankListActivity.bankListPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(BottomSheetBankListActivity bottomSheetBankListActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        bottomSheetBankListActivity.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }
}
