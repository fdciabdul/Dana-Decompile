package id.dana.myprofile.mepagerevamp.securitysettings.view;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter;

/* loaded from: classes5.dex */
public final class NewSwitchFaceAuthenticationView_MembersInjector implements MembersInjector<NewSwitchFaceAuthenticationView> {
    public static void PlaceComponentResult(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, SwitchFaceAuthPresenter switchFaceAuthPresenter) {
        newSwitchFaceAuthenticationView.switchFaceAuthPresenter = switchFaceAuthPresenter;
    }

    public static void MyBillsEntityDataFactory(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, DynamicUrlWrapper dynamicUrlWrapper) {
        newSwitchFaceAuthenticationView.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
