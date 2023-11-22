package id.dana.myprofile;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.h5event.ChangePhoneNumberH5EventContract;
import id.dana.lib.bio.productpage.ProductPageManager;

/* loaded from: classes5.dex */
public final class SettingMoreProfileActivity_MembersInjector implements MembersInjector<SettingMoreProfileActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(SettingMoreProfileActivity settingMoreProfileActivity, FriendshipAnalyticTracker friendshipAnalyticTracker) {
        settingMoreProfileActivity.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(SettingMoreProfileActivity settingMoreProfileActivity, ProductPageManager productPageManager) {
        settingMoreProfileActivity.productPageManager = productPageManager;
    }

    public static void PlaceComponentResult(SettingMoreProfileActivity settingMoreProfileActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        settingMoreProfileActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void getAuthRequestContext(SettingMoreProfileActivity settingMoreProfileActivity, ChangePhoneNumberH5EventContract.Presenter presenter) {
        settingMoreProfileActivity.changePhoneNumberH5EventPresenter = presenter;
    }
}
