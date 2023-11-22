package id.dana.explore.popularplaces;

import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace;
import id.dana.explore.domain.globalsearch.model.ExploreRecommendedPopularPlaces;
import id.dana.explore.popularplaces.PopularPlacesContract;
import id.dana.explore.popularplaces.mapper.ExplorePopularPlacesConfigModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/explore/popularplaces/PopularPlacesPresenter;", "Lid/dana/explore/popularplaces/PopularPlacesContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Lid/dana/explore/domain/globalsearch/interactor/GetExploreRecommendedPopularPlace;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/domain/globalsearch/interactor/GetExploreRecommendedPopularPlace;", "PlaceComponentResult", "Lid/dana/explore/popularplaces/PopularPlacesContract$View;", "Lid/dana/explore/popularplaces/PopularPlacesContract$View;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/explore/popularplaces/PopularPlacesContract$View;Lid/dana/explore/domain/globalsearch/interactor/GetExploreRecommendedPopularPlace;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopularPlacesPresenter implements PopularPlacesContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetExploreRecommendedPopularPlace PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PopularPlacesContract.View MyBillsEntityDataFactory;

    @Inject
    public PopularPlacesPresenter(PopularPlacesContract.View view, GetExploreRecommendedPopularPlace getExploreRecommendedPopularPlace) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getExploreRecommendedPopularPlace, "");
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = getExploreRecommendedPopularPlace;
    }

    @Override // id.dana.explore.popularplaces.PopularPlacesContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<ExploreRecommendedPopularPlaces, Unit>() { // from class: id.dana.explore.popularplaces.PopularPlacesPresenter$getExplorePopularPlaces$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ExploreRecommendedPopularPlaces exploreRecommendedPopularPlaces) {
                invoke2(exploreRecommendedPopularPlaces);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ExploreRecommendedPopularPlaces exploreRecommendedPopularPlaces) {
                PopularPlacesContract.View view;
                PopularPlacesContract.View view2;
                Intrinsics.checkNotNullParameter(exploreRecommendedPopularPlaces, "");
                if (!exploreRecommendedPopularPlaces.getShowRecommendedPlacesWidget() || (!exploreRecommendedPopularPlaces.getPopularPlaces().isEmpty()) == false) {
                    view = PopularPlacesPresenter.this.MyBillsEntityDataFactory;
                    view.MyBillsEntityDataFactory();
                    return;
                }
                view2 = PopularPlacesPresenter.this.MyBillsEntityDataFactory;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(ExplorePopularPlacesConfigModelMapperKt.getAuthRequestContext(exploreRecommendedPopularPlaces.getPopularPlaces()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.explore.popularplaces.PopularPlacesPresenter$getExplorePopularPlaces$2
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
                PopularPlacesContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PopularPlacesPresenter.this.MyBillsEntityDataFactory;
                view.MyBillsEntityDataFactory();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_EXPLORE_POPULAR_PLACES_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }
}
