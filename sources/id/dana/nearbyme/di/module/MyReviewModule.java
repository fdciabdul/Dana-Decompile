package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.contract.nearbyme.MyReviewPresenter;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r"}, d2 = {"Lid/dana/nearbyme/di/module/MyReviewModule;", "", "Lid/dana/contract/nearbyme/MyReviewPresenter;", "p0", "Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/contract/nearbyme/MyReviewPresenter;)Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "Lid/dana/contract/nearbyme/MyReviewContract$View;", "()Lid/dana/contract/nearbyme/MyReviewContract$View;", "Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "PlaceComponentResult", "(Lid/dana/nearbyme/tracker/NearbyDefaultTracker;)Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lid/dana/contract/nearbyme/MyReviewContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/contract/nearbyme/MyReviewContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class MyReviewModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MyReviewContract.View getAuthRequestContext;

    public MyReviewModule(MyReviewContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final MyReviewContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    public final MyReviewContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(MyReviewPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final NearbyAnalyticTracker PlaceComponentResult(NearbyDefaultTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
