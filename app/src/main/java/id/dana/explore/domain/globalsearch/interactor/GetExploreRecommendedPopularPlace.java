package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.enums.RecommendationCategory;
import id.dana.explore.domain.globalsearch.mapper.PaySearchInfoMapperKt;
import id.dana.explore.domain.globalsearch.model.ExploreRecommendedPopularPlaces;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetExploreRecommendedPopularPlace;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/explore/domain/globalsearch/model/ExploreRecommendedPopularPlaces;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "", "Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetExploreRecommendedPopularPlace extends BaseUseCase<ExploreRecommendedPopularPlaces, NoParams> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GlobalSearchRepository PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<PopularPlaceInfo> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<PopularPlaceInfo> MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<ExploreRecommendedPopularPlaces> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable flatMap = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().flatMap(new Function() { // from class: id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetExploreRecommendedPopularPlace.getAuthRequestContext(GetExploreRecommendedPopularPlace.this, (GlobalSearchConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public GetExploreRecommendedPopularPlace(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.PlaceComponentResult = globalSearchRepository;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(GetExploreRecommendedPopularPlace getExploreRecommendedPopularPlace, GlobalSearchConfig globalSearchConfig, List list) {
        Intrinsics.checkNotNullParameter(getExploreRecommendedPopularPlace, "");
        Intrinsics.checkNotNullParameter(globalSearchConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        getExploreRecommendedPopularPlace.BuiltInFictitiousFunctionClassFactory.addAll(list);
        getExploreRecommendedPopularPlace.BuiltInFictitiousFunctionClassFactory.addAll(getExploreRecommendedPopularPlace.MyBillsEntityDataFactory);
        boolean exploreShowPopularPlacesWidget = globalSearchConfig.getExploreShowPopularPlacesWidget();
        List<PopularPlaceInfo> list2 = getExploreRecommendedPopularPlace.BuiltInFictitiousFunctionClassFactory;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (hashSet.add(((PopularPlaceInfo) obj).getMerchantId())) {
                arrayList.add(obj);
            }
        }
        return Observable.just(new ExploreRecommendedPopularPlaces(exploreShowPopularPlacesWidget, CollectionsKt.take(arrayList, 10)));
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static /* synthetic */ ObservableSource getAuthRequestContext(final GetExploreRecommendedPopularPlace getExploreRecommendedPopularPlace, final GlobalSearchConfig globalSearchConfig) {
        Observable MyBillsEntityDataFactory;
        Observable flatMap;
        Intrinsics.checkNotNullParameter(getExploreRecommendedPopularPlace, "");
        Intrinsics.checkNotNullParameter(globalSearchConfig, "");
        if (!globalSearchConfig.getExploreShowPopularPlacesWidget()) {
            ?? r1 = 0;
            flatMap = Observable.just(new ExploreRecommendedPopularPlaces(false, r1, 3, r1));
        } else {
            for (PopularPlaceInfo popularPlaceInfo : globalSearchConfig.getExplorePopularPlaces()) {
                if (popularPlaceInfo.getHighlight()) {
                    getExploreRecommendedPopularPlace.BuiltInFictitiousFunctionClassFactory.add(popularPlaceInfo);
                } else {
                    getExploreRecommendedPopularPlace.MyBillsEntityDataFactory.add(popularPlaceInfo);
                }
            }
            MyBillsEntityDataFactory = getExploreRecommendedPopularPlace.PlaceComponentResult.MyBillsEntityDataFactory(RecommendationCategory.POPULAR_PLACES);
            Observable onErrorReturnItem = MyBillsEntityDataFactory.map(new Function() { // from class: id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetExploreRecommendedPopularPlace.BuiltInFictitiousFunctionClassFactory((List) obj);
                }
            }).onErrorReturnItem(CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
            flatMap = onErrorReturnItem.flatMap(new Function() { // from class: id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetExploreRecommendedPopularPlace.KClassImpl$Data$declaredNonStaticMembers$2(GetExploreRecommendedPopularPlace.this, globalSearchConfig, (List) obj);
                }
            });
        }
        return flatMap;
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return PaySearchInfoMapperKt.getAuthRequestContext(list);
    }
}
