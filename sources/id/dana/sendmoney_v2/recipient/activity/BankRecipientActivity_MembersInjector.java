package id.dana.sendmoney_v2.recipient.activity;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class BankRecipientActivity_MembersInjector implements MembersInjector<BankRecipientActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(BankRecipientActivity bankRecipientActivity, BillerX2BContract.Presenter presenter) {
        bankRecipientActivity.billerX2BPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(BankRecipientActivity bankRecipientActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        bankRecipientActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
