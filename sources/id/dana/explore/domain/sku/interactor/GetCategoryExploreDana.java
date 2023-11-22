package id.dana.explore.domain.sku.interactor;

import id.dana.danah5.DanaH5;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.enums.RecommendationCategory;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.sku.mapper.ExploreServiceMapperKt;
import id.dana.explore.domain.sku.model.CategoryExploreModel;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f"}, d2 = {"Lid/dana/explore/domain/sku/interactor/GetCategoryExploreDana;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/explore/domain/sku/model/ExploreServiceModel;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "getAuthRequestContext", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "PlaceComponentResult", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "Lid/dana/domain/services/ServicesRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/services/ServicesRepository;", "p0", "p1", "p2", "<init>", "(Lid/dana/explore/domain/sku/ProductInfoRepository;Lid/dana/domain/services/ServicesRepository;Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetCategoryExploreDana extends BaseUseCase<List<? extends ExploreServiceModel>, NoParams> {
    public final List<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ServicesRepository MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GlobalSearchRepository getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ProductInfoRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends ExploreServiceModel>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable flatMap = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetCategoryExploreDana$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetCategoryExploreDana.KClassImpl$Data$declaredNonStaticMembers$2(GetCategoryExploreDana.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public GetCategoryExploreDana(ProductInfoRepository productInfoRepository, ServicesRepository servicesRepository, GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(productInfoRepository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.PlaceComponentResult = productInfoRepository;
        this.MyBillsEntityDataFactory = servicesRepository;
        this.getAuthRequestContext = globalSearchRepository;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetCategoryExploreDana getCategoryExploreDana, List list) {
        Intrinsics.checkNotNullParameter(getCategoryExploreDana, "");
        Intrinsics.checkNotNullParameter(list, "");
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(mutableList, 10)), 16));
        for (Object obj : mutableList) {
            List<ThirdPartyServiceResponse> thirdPartyServices = ((ThirdPartyCategoryService) obj).getThirdPartyServices();
            Intrinsics.checkNotNullExpressionValue(thirdPartyServices, "");
            linkedHashMap.put(((ThirdPartyServiceResponse) CollectionsKt.first((List) thirdPartyServices)).getKey(), obj);
        }
        List<String> list2 = getCategoryExploreDana.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ThirdPartyCategoryService thirdPartyCategoryService = (ThirdPartyCategoryService) linkedHashMap.get((String) it.next());
            if (thirdPartyCategoryService != null) {
                arrayList.add(thirdPartyCategoryService);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(ExploreServiceMapperKt.BuiltInFictitiousFunctionClassFactory((ThirdPartyCategoryService) it2.next()));
        }
        Observable just = Observable.just(CollectionsKt.take(arrayList3, 3));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final GetCategoryExploreDana getCategoryExploreDana, List list) {
        Intrinsics.checkNotNullParameter(getCategoryExploreDana, "");
        Intrinsics.checkNotNullParameter(list, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = ((PaySearchInfo) it.next()).getInfo().get(DanaH5.SERVICE_KEY);
            if (str != null) {
                getCategoryExploreDana.BuiltInFictitiousFunctionClassFactory.add(str);
            }
        }
        getCategoryExploreDana.BuiltInFictitiousFunctionClassFactory.addAll(getCategoryExploreDana.KClassImpl$Data$declaredNonStaticMembers$2);
        return getCategoryExploreDana.MyBillsEntityDataFactory.getEnabledServicesByKey(CollectionsKt.distinct(getCategoryExploreDana.BuiltInFictitiousFunctionClassFactory)).onErrorReturnItem(CollectionsKt.emptyList()).flatMap(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetCategoryExploreDana$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetCategoryExploreDana.PlaceComponentResult(GetCategoryExploreDana.this, (List) obj);
            }
        });
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(final GetCategoryExploreDana getCategoryExploreDana, List list) {
        Observable MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(getCategoryExploreDana, "");
        Intrinsics.checkNotNullParameter(list, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CategoryExploreModel categoryExploreModel = (CategoryExploreModel) it.next();
            if (categoryExploreModel.getHighlight()) {
                getCategoryExploreDana.BuiltInFictitiousFunctionClassFactory.add(categoryExploreModel.getServiceKey());
            } else {
                getCategoryExploreDana.KClassImpl$Data$declaredNonStaticMembers$2.add(categoryExploreModel.getServiceKey());
            }
        }
        MyBillsEntityDataFactory = getCategoryExploreDana.getAuthRequestContext.MyBillsEntityDataFactory(RecommendationCategory.SERVICES);
        Observable onErrorReturnItem = MyBillsEntityDataFactory.onErrorReturnItem(CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem.flatMap(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetCategoryExploreDana$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetCategoryExploreDana.MyBillsEntityDataFactory(GetCategoryExploreDana.this, (List) obj);
            }
        });
    }
}
