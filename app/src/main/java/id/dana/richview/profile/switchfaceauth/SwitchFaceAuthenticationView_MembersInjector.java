package id.dana.richview.profile.switchfaceauth;

import dagger.MembersInjector;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter;

/* loaded from: classes5.dex */
public final class SwitchFaceAuthenticationView_MembersInjector implements MembersInjector<SwitchFaceAuthenticationView> {
    public static void getAuthRequestContext(SwitchFaceAuthenticationView switchFaceAuthenticationView, SwitchFaceAuthPresenter switchFaceAuthPresenter) {
        switchFaceAuthenticationView.switchFaceAuthPresenter = switchFaceAuthPresenter;
    }

    public static void PlaceComponentResult(SwitchFaceAuthenticationView switchFaceAuthenticationView, DynamicUrlWrapper dynamicUrlWrapper) {
        switchFaceAuthenticationView.dynamicUrlWrapper = dynamicUrlWrapper;
    }
}
