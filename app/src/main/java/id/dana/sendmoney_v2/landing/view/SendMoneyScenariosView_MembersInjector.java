package id.dana.sendmoney_v2.landing.view;

import dagger.MembersInjector;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;

/* loaded from: classes5.dex */
public final class SendMoneyScenariosView_MembersInjector implements MembersInjector<SendMoneyScenariosView> {
    public static void PlaceComponentResult(SendMoneyScenariosView sendMoneyScenariosView, SendMoneyScenariosContract.Presenter presenter) {
        sendMoneyScenariosView.sendMoneyScenarioPresenter = presenter;
    }
}
