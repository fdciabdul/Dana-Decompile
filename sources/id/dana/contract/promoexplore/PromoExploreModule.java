package id.dana.contract.promoexplore;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.explore.presenter.PromoExplorePresenter;
import id.dana.explore.view.PromoExploreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/contract/promoexplore/PromoExploreModule;", "", "Lid/dana/explore/presenter/PromoExplorePresenter;", "p0", "Lid/dana/explore/view/PromoExploreContract$Presenter;", "getAuthRequestContext", "(Lid/dana/explore/presenter/PromoExplorePresenter;)Lid/dana/explore/view/PromoExploreContract$Presenter;", "Lid/dana/explore/view/PromoExploreContract$View;", "()Lid/dana/explore/view/PromoExploreContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/view/PromoExploreContract$View;", "PlaceComponentResult", "<init>", "(Lid/dana/explore/view/PromoExploreContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class PromoExploreModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PromoExploreContract.View PlaceComponentResult;

    public PromoExploreModule(PromoExploreContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final PromoExploreContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final PromoExploreContract.Presenter getAuthRequestContext(PromoExplorePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
