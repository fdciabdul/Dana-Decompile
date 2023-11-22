package id.dana.explore.presenter;

import android.location.Location;
import id.dana.data.promocenter.PromoCenterSource;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore;
import id.dana.explore.view.PromoExploreContract;
import id.dana.promocenter.mapper.PromoAdsModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/explore/presenter/PromoExplorePresenter;", "Lid/dana/explore/view/PromoExploreContract$Presenter;", "Landroid/location/Location;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/location/Location;)V", "onDestroy", "()V", "Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore;", "getAuthRequestContext", "Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore;", "Lid/dana/promocenter/mapper/PromoAdsModelMapper;", "PlaceComponentResult", "Lid/dana/promocenter/mapper/PromoAdsModelMapper;", "Lid/dana/explore/view/PromoExploreContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/view/PromoExploreContract$View;", "p1", "p2", "<init>", "(Lid/dana/explore/view/PromoExploreContract$View;Lid/dana/explore/domain/globalsearch/interactor/GetPromoAdsExplore;Lid/dana/promocenter/mapper/PromoAdsModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoExplorePresenter implements PromoExploreContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PromoExploreContract.View getAuthRequestContext;
    private final PromoAdsModelMapper PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetPromoAdsExplore MyBillsEntityDataFactory;

    @Inject
    public PromoExplorePresenter(PromoExploreContract.View view, GetPromoAdsExplore getPromoAdsExplore, PromoAdsModelMapper promoAdsModelMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getPromoAdsExplore, "");
        Intrinsics.checkNotNullParameter(promoAdsModelMapper, "");
        this.getAuthRequestContext = view;
        this.MyBillsEntityDataFactory = getPromoAdsExplore;
        this.PlaceComponentResult = promoAdsModelMapper;
    }

    @Override // id.dana.explore.view.PromoExploreContract.Presenter
    public final void MyBillsEntityDataFactory(Location p0) {
        this.MyBillsEntityDataFactory.execute(new GetPromoAdsExplore.PromoAdsExploreParams(p0 != null ? Double.valueOf(p0.getLatitude()) : null, p0 != null ? Double.valueOf(p0.getLongitude()) : null, PromoCenterSource.PROMO_CENTER_EXPLORE_PAGE), new Function1<PromoAds, Unit>() { // from class: id.dana.explore.presenter.PromoExplorePresenter$getPromoAds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoAds promoAds) {
                invoke2(promoAds);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoAds promoAds) {
                PromoExploreContract.View view;
                PromoAdsModelMapper unused;
                Intrinsics.checkNotNullParameter(promoAds, "");
                view = PromoExplorePresenter.this.getAuthRequestContext;
                unused = PromoExplorePresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2(PromoAdsModelMapper.getAuthRequestContext(promoAds.getAdsList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.explore.presenter.PromoExplorePresenter$getPromoAds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                PromoExploreContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PromoExplorePresenter.this.getAuthRequestContext;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
