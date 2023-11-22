package id.dana.animation.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.tracker.HomeTrackerImpl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;

/* loaded from: classes5.dex */
public final class FourKingView_MembersInjector implements MembersInjector<FourKingView> {
    public static void MyBillsEntityDataFactory(FourKingView fourKingView, Lazy<DynamicUrlWrapper> lazy) {
        fourKingView.dynamicUrlWrapper = lazy;
    }

    public static void getAuthRequestContext(FourKingView fourKingView, Lazy<HomeTrackerImpl> lazy) {
        fourKingView.homeTrackerImpl = lazy;
    }
}
