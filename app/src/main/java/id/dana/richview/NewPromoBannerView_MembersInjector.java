package id.dana.richview;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.promobanner.NewPromoBannerContract;
import id.dana.animation.tracker.HomeTrackerImpl;

/* loaded from: classes5.dex */
public final class NewPromoBannerView_MembersInjector implements MembersInjector<NewPromoBannerView> {
    public static void getAuthRequestContext(NewPromoBannerView newPromoBannerView, Lazy<NewPromoBannerContract.Presenter> lazy) {
        newPromoBannerView.promoBannerPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(NewPromoBannerView newPromoBannerView, Lazy<HomeTrackerImpl> lazy) {
        newPromoBannerView.homeTrackerImpl = lazy;
    }
}
