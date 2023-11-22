package id.dana.myprofile.mepagerevamp.smartpay;

import dagger.MembersInjector;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;

/* loaded from: classes5.dex */
public final class SmartPayActivity_MembersInjector implements MembersInjector<SmartPayActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(SmartPayActivity smartPayActivity, MePageRevampContract.Presenter presenter) {
        smartPayActivity.mePageRevampPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SmartPayActivity smartPayActivity, SmartPayContract.Presenter presenter) {
        smartPayActivity.smartPayPresenter = presenter;
    }
}
