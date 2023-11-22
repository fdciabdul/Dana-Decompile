package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import id.dana.di.PerActivity;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/di/modules/NearbyMerchantLocationSearchModule;", "", "Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "p0", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/tracker/NearbyDefaultTracker;)Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "getAuthRequestContext", "(Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;)Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "PlaceComponentResult", "()Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "<init>", "(Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class NearbyMerchantLocationSearchModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final NearbyMerchantLocationSearchContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public NearbyMerchantLocationSearchModule(NearbyMerchantLocationSearchContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final NearbyMerchantLocationSearchContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final NearbyMerchantLocationSearchContract.Presenter getAuthRequestContext(NearbyMerchantLocationSearchPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final NearbyAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(NearbyDefaultTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
