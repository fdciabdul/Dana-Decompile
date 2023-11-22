package id.dana.animation.danaprotection.tracker;

import dagger.Lazy;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/home/danaprotection/tracker/DanaProtectionTrackerImpl;", "Lid/dana/home/danaprotection/tracker/DanaProtectionTracker;", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "PlaceComponentResult", "Ldagger/Lazy;", "p0", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaProtectionTrackerImpl implements DanaProtectionTracker {
    public final Lazy<AnalyticsTrackerFactory> PlaceComponentResult;

    @Inject
    public DanaProtectionTrackerImpl(Lazy<AnalyticsTrackerFactory> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.PlaceComponentResult = lazy;
    }
}
