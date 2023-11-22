package id.dana.sendmoney_v2.recipient.activity;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class SearchRecipientActivity_MembersInjector implements MembersInjector<SearchRecipientActivity> {
    public static void getAuthRequestContext(SearchRecipientActivity searchRecipientActivity, BillerX2BContract.Presenter presenter) {
        searchRecipientActivity.billerX2BPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SearchRecipientActivity searchRecipientActivity, SendMoneyContract.Presenter presenter) {
        searchRecipientActivity.calculatorPresenter = presenter;
    }

    public static void PlaceComponentResult(SearchRecipientActivity searchRecipientActivity, SendMoneyCoreContract.Presenter presenter) {
        searchRecipientActivity.sendMoneyCorePresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SearchRecipientActivity searchRecipientActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        searchRecipientActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
