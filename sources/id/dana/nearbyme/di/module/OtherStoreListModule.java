package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.contract.nearbyme.OtherStoreListPresenter;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyDefaultTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/nearbyme/di/module/OtherStoreListModule;", "", "Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "p0", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/tracker/NearbyDefaultTracker;)Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "Lid/dana/contract/nearbyme/OtherStoreListPresenter;", "Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/contract/nearbyme/OtherStoreListPresenter;)Lid/dana/contract/nearbyme/OtherStoreListContract$Presenter;", "PlaceComponentResult", "Lid/dana/contract/nearbyme/OtherStoreListContract$View;", "<init>", "(Lid/dana/contract/nearbyme/OtherStoreListContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class OtherStoreListModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OtherStoreListContract.View BuiltInFictitiousFunctionClassFactory;

    public OtherStoreListModule(OtherStoreListContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final OtherStoreListContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    public final OtherStoreListContract.Presenter MyBillsEntityDataFactory(OtherStoreListPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final NearbyAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(NearbyDefaultTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
