package id.dana.di.modules;

import dagger.Binds;
import dagger.Module;
import id.dana.contract.deeplink.tracker.AbstractDeeplinkTrackerFactory;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.contract.deeplink.tracker.DeeplinkTrackerFactory;
import id.dana.contract.deeplink.tracker.FullstoryDeeplinkTracker;
import id.dana.contract.deeplink.tracker.MixpanelDeeplinkTracker;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Named;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/di/modules/DeeplinkTrackerModule;", "", "Lid/dana/contract/deeplink/tracker/DeeplinkTrackerFactory;", "p0", "Lid/dana/contract/deeplink/tracker/AbstractDeeplinkTrackerFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/contract/deeplink/tracker/DeeplinkTrackerFactory;)Lid/dana/contract/deeplink/tracker/AbstractDeeplinkTrackerFactory;", "Lid/dana/contract/deeplink/tracker/FullstoryDeeplinkTracker;", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "(Lid/dana/contract/deeplink/tracker/FullstoryDeeplinkTracker;)Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "Lid/dana/contract/deeplink/tracker/MixpanelDeeplinkTracker;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/contract/deeplink/tracker/MixpanelDeeplinkTracker;)Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class DeeplinkTrackerModule {
    @Binds
    public abstract DeeplinkTracker BuiltInFictitiousFunctionClassFactory(MixpanelDeeplinkTracker p0);

    @Binds
    public abstract AbstractDeeplinkTrackerFactory KClassImpl$Data$declaredNonStaticMembers$2(DeeplinkTrackerFactory p0);

    @Binds
    @Named(TrackerType.FULLSTORY)
    public abstract DeeplinkTracker KClassImpl$Data$declaredNonStaticMembers$2(FullstoryDeeplinkTracker p0);
}
