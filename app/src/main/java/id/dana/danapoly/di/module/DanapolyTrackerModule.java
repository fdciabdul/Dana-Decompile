package id.dana.danapoly.di.module;

import dagger.Binds;
import dagger.Module;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.ui.tracker.DanapolyAnalyticTracker;
import id.dana.danapoly.ui.tracker.DanapolyMixpanelTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/di/module/DanapolyTrackerModule;", "", "Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;", "p0", "Lid/dana/danapoly/ui/tracker/DanapolyAnalyticTracker;", "PlaceComponentResult", "(Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;)Lid/dana/danapoly/ui/tracker/DanapolyAnalyticTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class DanapolyTrackerModule {
    @DanapolyScope
    @Binds
    public abstract DanapolyAnalyticTracker PlaceComponentResult(DanapolyMixpanelTracker p0);
}
