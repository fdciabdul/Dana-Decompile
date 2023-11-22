package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/di/module/NearbyTrackerModule;", "", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailMixpanelTrackers;", "p0", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailMixpanelTrackers;)Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/tracker/NearbyDefaultTracker;)Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class NearbyTrackerModule {
    @Provides
    @PerActivity
    public final NearbyAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(NearbyDefaultTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final MerchantDetailAnalyticTracker getAuthRequestContext(MerchantDetailMixpanelTrackers p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
