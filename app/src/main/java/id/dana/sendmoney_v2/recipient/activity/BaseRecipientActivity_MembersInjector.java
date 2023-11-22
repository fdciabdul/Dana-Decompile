package id.dana.sendmoney_v2.recipient.activity;

import dagger.MembersInjector;
import id.dana.contract.sendmoney.RecipientContract;

/* loaded from: classes5.dex */
public final class BaseRecipientActivity_MembersInjector implements MembersInjector<BaseRecipientActivity> {
    public static void MyBillsEntityDataFactory(BaseRecipientActivity baseRecipientActivity, RecipientContract.Presenter presenter) {
        baseRecipientActivity.recipientPresenter = presenter;
    }
}
