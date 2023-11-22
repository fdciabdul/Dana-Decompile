package id.dana.animation.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.personalizedhome.HomePersonalizationContract;

/* loaded from: classes5.dex */
public final class HomePersonalizationView_MembersInjector implements MembersInjector<HomePersonalizationView> {
    public static void getAuthRequestContext(HomePersonalizationView homePersonalizationView, Lazy<HomePersonalizationContract.Presenter> lazy) {
        homePersonalizationView.homePersonalizationPresenter = lazy;
    }
}
