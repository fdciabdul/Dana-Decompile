package id.dana.sendmoney_v2.recipient.activity;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class ContactRecipientActivity_MembersInjector implements MembersInjector<ContactRecipientActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(ContactRecipientActivity contactRecipientActivity, SendMoneyContract.Presenter presenter) {
        contactRecipientActivity.calculatorPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(ContactRecipientActivity contactRecipientActivity, SendMoneyCoreContract.Presenter presenter) {
        contactRecipientActivity.sendMoneyCorePresenter = presenter;
    }

    public static void getAuthRequestContext(ContactRecipientActivity contactRecipientActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        contactRecipientActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
