package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.drawable.search.NearbySearchContract;
import id.dana.drawable.search.presenter.NearbySearchPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/NearbySearchModule;", "", "Lid/dana/nearbyrevamp/search/presenter/NearbySearchPresenter;", "p0", "Lid/dana/nearbyrevamp/search/NearbySearchContract$Presenter;", "PlaceComponentResult", "(Lid/dana/nearbyrevamp/search/presenter/NearbySearchPresenter;)Lid/dana/nearbyrevamp/search/NearbySearchContract$Presenter;", "Lid/dana/nearbyrevamp/search/NearbySearchContract$View;", "()Lid/dana/nearbyrevamp/search/NearbySearchContract$View;", "getAuthRequestContext", "Lid/dana/nearbyrevamp/search/NearbySearchContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/nearbyrevamp/search/NearbySearchContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class NearbySearchModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final NearbySearchContract.View MyBillsEntityDataFactory;

    public NearbySearchModule(NearbySearchContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final NearbySearchContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    public final NearbySearchContract.Presenter PlaceComponentResult(NearbySearchPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
