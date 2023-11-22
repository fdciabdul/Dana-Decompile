package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.animation.presenter.HomeTabContract;
import id.dana.animation.presenter.HomeTabPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/HomeTabModules;", "", "Lid/dana/home/presenter/HomeTabPresenter;", "p0", "Lid/dana/home/presenter/HomeTabContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/home/presenter/HomeTabPresenter;)Lid/dana/home/presenter/HomeTabContract$Presenter;", "Lid/dana/home/presenter/HomeTabContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/home/presenter/HomeTabContract$View;", "PlaceComponentResult", "Lid/dana/home/presenter/HomeTabContract$View;", "<init>", "(Lid/dana/home/presenter/HomeTabContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class HomeTabModules {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HomeTabContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public HomeTabModules(HomeTabContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final HomeTabContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    public final HomeTabContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(HomeTabPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
