package id.dana.sendmoney.external.outlet;

import dagger.MembersInjector;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;

/* loaded from: classes5.dex */
public final class AddOutletReceiverActivity_MembersInjector implements MembersInjector<AddOutletReceiverActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(AddOutletReceiverActivity addOutletReceiverActivity, AddOutletReceiverContract.Presenter presenter) {
        addOutletReceiverActivity.addOutletReceiverPresenter = presenter;
    }

    public static void PlaceComponentResult(AddOutletReceiverActivity addOutletReceiverActivity, SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        addOutletReceiverActivity.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }
}
