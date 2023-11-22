package id.dana.cashier.topupandpay.fragment;

import dagger.MembersInjector;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.data.config.DeviceInformationProvider;

/* loaded from: classes4.dex */
public final class TopUpAndPayInputFragment_MembersInjector implements MembersInjector<TopUpAndPayInputFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(TopUpAndPayInputFragment topUpAndPayInputFragment, TopUpAndPayContract.Presenter presenter) {
        topUpAndPayInputFragment.topUpAndPayPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(TopUpAndPayInputFragment topUpAndPayInputFragment, DeviceInformationProvider deviceInformationProvider) {
        topUpAndPayInputFragment.deviceInformationProvider = deviceInformationProvider;
    }

    public static void getAuthRequestContext(TopUpAndPayInputFragment topUpAndPayInputFragment, CashierAnalyticTracker cashierAnalyticTracker) {
        topUpAndPayInputFragment.cashierAnalyticTracker = cashierAnalyticTracker;
    }
}
