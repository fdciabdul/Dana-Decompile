package id.dana.richview.socialshare;

import dagger.MembersInjector;
import id.dana.richview.socialshare.SocialShareContract;

/* loaded from: classes5.dex */
public final class SocialShareView_MembersInjector implements MembersInjector<SocialShareView> {
    public static void PlaceComponentResult(SocialShareView socialShareView, SocialShareContract.Presenter presenter) {
        socialShareView.presenter = presenter;
    }
}
