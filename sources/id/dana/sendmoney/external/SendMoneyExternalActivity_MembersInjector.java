package id.dana.sendmoney.external;

import dagger.MembersInjector;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class SendMoneyExternalActivity_MembersInjector implements MembersInjector<SendMoneyExternalActivity> {
    public static void PlaceComponentResult(SendMoneyExternalActivity sendMoneyExternalActivity, SendMoneyExternalContract.Presenter presenter) {
        sendMoneyExternalActivity.sendMoneyExternalPresenter = presenter;
    }

    public static void PlaceComponentResult(SendMoneyExternalActivity sendMoneyExternalActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        sendMoneyExternalActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
