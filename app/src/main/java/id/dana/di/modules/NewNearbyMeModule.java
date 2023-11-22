package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.contract.nearbyme.NewNearbyPresenter;
import id.dana.di.PerActivity;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/di/modules/NewNearbyMeModule;", "", "Lid/dana/contract/nearbyme/NewNearbyPresenter;", "p0", "Lid/dana/contract/nearbyme/NewNearbyMeContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/contract/nearbyme/NewNearbyPresenter;)Lid/dana/contract/nearbyme/NewNearbyMeContract$Presenter;", "Lid/dana/contract/nearbyme/NewNearbyMeContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/contract/nearbyme/NewNearbyMeContract$View;", "Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "PlaceComponentResult", "(Lid/dana/nearbyme/tracker/NearbyDefaultTracker;)Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "MyBillsEntityDataFactory", "Lid/dana/contract/nearbyme/NewNearbyMeContract$View;", "<init>", "(Lid/dana/contract/nearbyme/NewNearbyMeContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class NewNearbyMeModule {
    private final NewNearbyMeContract.View MyBillsEntityDataFactory;

    public NewNearbyMeModule(NewNearbyMeContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    public final NearbyAnalyticTracker PlaceComponentResult(NearbyDefaultTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final NewNearbyMeContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final NewNearbyMeContract.Presenter BuiltInFictitiousFunctionClassFactory(NewNearbyPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
