package id.dana.referral;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.referraltracker.ReferralTrackerContract;

/* loaded from: classes5.dex */
public final class MyReferralDetailActivity_MembersInjector implements MembersInjector<MyReferralDetailActivity> {
    public static void PlaceComponentResult(MyReferralDetailActivity myReferralDetailActivity, ReferralTrackerContract.Presenter presenter) {
        myReferralDetailActivity.referralTrackerPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MyReferralDetailActivity myReferralDetailActivity, ReadLinkPropertiesContract.Presenter presenter) {
        myReferralDetailActivity.readDeepLinkPropertiesPresenter = presenter;
    }
}
