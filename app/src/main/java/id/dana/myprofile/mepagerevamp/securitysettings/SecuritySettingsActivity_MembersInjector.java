package id.dana.myprofile.mepagerevamp.securitysettings;

import dagger.MembersInjector;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;

/* loaded from: classes5.dex */
public final class SecuritySettingsActivity_MembersInjector implements MembersInjector<SecuritySettingsActivity> {
    public static void MyBillsEntityDataFactory(SecuritySettingsActivity securitySettingsActivity, MePageRevampContract.Presenter presenter) {
        securitySettingsActivity.mePageRevampPresenter = presenter;
    }

    public static void getAuthRequestContext(SecuritySettingsActivity securitySettingsActivity, SecuritySettingsContract.Presenter presenter) {
        securitySettingsActivity.securitySettingsPresenter = presenter;
    }

    public static void PlaceComponentResult(SecuritySettingsActivity securitySettingsActivity, ProductPageManager productPageManager) {
        securitySettingsActivity.productPageManager = productPageManager;
    }
}
