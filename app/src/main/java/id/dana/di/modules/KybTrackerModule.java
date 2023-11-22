package id.dana.di.modules;

import dagger.Binds;
import dagger.Module;
import id.dana.kyb.tracker.KybTracker;
import id.dana.kyb.tracker.MixpanelKybTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/modules/KybTrackerModule;", "", "Lid/dana/kyb/tracker/MixpanelKybTracker;", "p0", "Lid/dana/kyb/tracker/KybTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/tracker/MixpanelKybTracker;)Lid/dana/kyb/tracker/KybTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class KybTrackerModule {
    @Binds
    public abstract KybTracker KClassImpl$Data$declaredNonStaticMembers$2(MixpanelKybTracker p0);
}
