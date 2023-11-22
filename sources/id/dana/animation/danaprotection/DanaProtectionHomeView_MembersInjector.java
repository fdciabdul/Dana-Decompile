package id.dana.animation.danaprotection;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.animation.danaprotection.tracker.DanaProtectionTrackerImpl;

/* loaded from: classes5.dex */
public final class DanaProtectionHomeView_MembersInjector implements MembersInjector<DanaProtectionHomeView> {
    public static void getAuthRequestContext(DanaProtectionHomeView danaProtectionHomeView, Lazy<DanaProtectionContract.Presenter> lazy) {
        danaProtectionHomeView.danaProtectionPresenter = lazy;
    }

    public static void PlaceComponentResult(DanaProtectionHomeView danaProtectionHomeView, Lazy<DanaProtectionTrackerImpl> lazy) {
        danaProtectionHomeView.danaProtectionTracker = lazy;
    }
}
