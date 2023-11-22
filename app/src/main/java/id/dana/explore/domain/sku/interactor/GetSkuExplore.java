package id.dana.explore.domain.sku.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.domain.homeinfo.SkuAttribute;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0014B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u0006\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/explore/domain/sku/interactor/GetSkuExplore;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "getAuthRequestContext", "Lid/dana/domain/services/ServicesRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/services/ServicesRepository;", "p0", "p1", "p2", "<init>", "(Lid/dana/explore/domain/sku/ProductInfoRepository;Lid/dana/domain/services/ServicesRepository;Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetSkuExplore extends BaseUseCase<List<? extends ThirdPartyServiceResponse>, NoParams> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ProductInfoRepository getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ServicesRepository PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GlobalSearchRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends ThirdPartyServiceResponse>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<List<SkuExploreConfig>> PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult();
        final GetSkuExplore$getSkuServices$1 getSkuExplore$getSkuServices$1 = new GetSkuExplore$getSkuServices$1(this);
        Observable<R> flatMap = PlaceComponentResult.flatMap(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetSkuExplore.BuiltInFictitiousFunctionClassFactory(Function1.this, (List) obj);
            }
        });
        final GetSkuExplore$populateSkuWithLastTransactionData$1 getSkuExplore$populateSkuWithLastTransactionData$1 = new GetSkuExplore$populateSkuWithLastTransactionData$1(this);
        Observable flatMap2 = flatMap.flatMap(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetSkuExplore.getAuthRequestContext(Function1.this, (List) obj);
            }
        });
        final Function1<List<? extends ThirdPartyServiceResponse>, List<ThirdPartyServiceResponse>> function1 = new Function1<List<? extends ThirdPartyServiceResponse>, List<ThirdPartyServiceResponse>>() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$takeLatestTransactionFromSameSkuId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ List<ThirdPartyServiceResponse> invoke(List<? extends ThirdPartyServiceResponse> list) {
                return invoke2((List<ThirdPartyServiceResponse>) list);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final List<ThirdPartyServiceResponse> invoke2(List<ThirdPartyServiceResponse> list) {
                Function3 function3;
                Intrinsics.checkNotNullParameter(list, "");
                final List<ThirdPartyServiceResponse> list2 = list;
                Grouping grouping = new Grouping<ThirdPartyServiceResponse, String>() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$takeLatestTransactionFromSameSkuId$1$invoke$$inlined$groupingBy$1
                    @Override // kotlin.collections.Grouping
                    public final Iterator<ThirdPartyServiceResponse> sourceIterator() {
                        return list2.iterator();
                    }

                    @Override // kotlin.collections.Grouping
                    public final String keyOf(ThirdPartyServiceResponse p0) {
                        return p0.getSkuConfigId();
                    }
                };
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                function3 = new Function3<String, ThirdPartyServiceResponse, ThirdPartyServiceResponse, ThirdPartyServiceResponse>() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$reduceToLatestTransactionWithSameSkuId$1
                    @Override // kotlin.jvm.functions.Function3
                    public final ThirdPartyServiceResponse invoke(String str, ThirdPartyServiceResponse thirdPartyServiceResponse, ThirdPartyServiceResponse thirdPartyServiceResponse2) {
                        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                        Intrinsics.checkNotNullParameter(thirdPartyServiceResponse2, "");
                        return (ThirdPartyServiceResponse) ComparisonsKt.maxOf(thirdPartyServiceResponse, thirdPartyServiceResponse2, new Comparator() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$reduceToLatestTransactionWithSameSkuId$1$invoke$$inlined$compareBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                ProductBizId productBizId;
                                String transactionDate;
                                String replace$default;
                                ProductBizId productBizId2;
                                String transactionDate2;
                                String replace$default2;
                                SkuAttribute skuAttr = ((ThirdPartyServiceResponse) t).getSkuAttr();
                                Long valueOf = (skuAttr == null || (productBizId2 = skuAttr.getProductBizId()) == null || (transactionDate2 = productBizId2.getTransactionDate()) == null || (replace$default2 = StringsKt.replace$default(transactionDate2, "\"", "", false, 4, (Object) null)) == null) ? (Comparable) 0L : Long.valueOf(Long.parseLong(replace$default2));
                                SkuAttribute skuAttr2 = ((ThirdPartyServiceResponse) t2).getSkuAttr();
                                return ComparisonsKt.compareValues(valueOf, (skuAttr2 == null || (productBizId = skuAttr2.getProductBizId()) == null || (transactionDate = productBizId.getTransactionDate()) == null || (replace$default = StringsKt.replace$default(transactionDate, "\"", "", false, 4, (Object) null)) == null) ? (Comparable) 0L : Long.valueOf(Long.parseLong(replace$default)));
                            }
                        });
                    }
                };
                Iterator sourceIterator = grouping.sourceIterator();
                while (sourceIterator.hasNext()) {
                    Object next = sourceIterator.next();
                    Object keyOf = grouping.keyOf(next);
                    Object obj = linkedHashMap.get(keyOf);
                    if (!(obj == null && !linkedHashMap.containsKey(keyOf))) {
                        next = function3.invoke(keyOf, obj, next);
                    }
                    linkedHashMap.put(keyOf, next);
                }
                Collection values = linkedHashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "");
                return CollectionsKt.toMutableList(values);
            }
        };
        Observable map = flatMap2.map(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetSkuExplore.MyBillsEntityDataFactory(Function1.this, (List) obj);
            }
        });
        final GetSkuExplore$removeExcessSku$1 getSkuExplore$removeExcessSku$1 = new Function1<List<ThirdPartyServiceResponse>, List<? extends ThirdPartyServiceResponse>>() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$removeExcessSku$1
            @Override // kotlin.jvm.functions.Function1
            public final List<ThirdPartyServiceResponse> invoke(List<ThirdPartyServiceResponse> list) {
                Intrinsics.checkNotNullParameter(list, "");
                return CollectionsKt.take(list, 6);
            }
        };
        Observable<List<? extends ThirdPartyServiceResponse>> map2 = map.map(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetSkuExplore.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        return map2;
    }

    @Inject
    public GetSkuExplore(ProductInfoRepository productInfoRepository, ServicesRepository servicesRepository, GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(productInfoRepository, "");
        Intrinsics.checkNotNullParameter(servicesRepository, "");
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.getAuthRequestContext = productInfoRepository;
        this.PlaceComponentResult = servicesRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSearchRepository;
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (List) function1.invoke(list);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(list);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(list);
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (List) function1.invoke(list);
    }

    public static final /* synthetic */ List MyBillsEntityDataFactory(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SkuAttribute skuAttr = ((ThirdPartyServiceResponse) it.next()).getSkuAttr();
            if (skuAttr != null) {
                List<String> serviceKey = skuAttr.getServiceKey();
                if (serviceKey != null) {
                    arrayList.addAll(serviceKey);
                }
                List<String> prepaidKey = skuAttr.getPrepaidKey();
                if (prepaidKey != null) {
                    arrayList.addAll(prepaidKey);
                }
                List<String> postpaidKey = skuAttr.getPostpaidKey();
                if (postpaidKey != null) {
                    arrayList.addAll(postpaidKey);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0074 A[EDGE_INSN: B:48:0x0074->B:33:0x0074 BREAK  A[LOOP:1: B:6:0x001e->B:51:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[LOOP:1: B:6:0x001e->B:51:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.util.List BuiltInFictitiousFunctionClassFactory(java.util.List r9, java.util.List r10) {
        /*
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L6:
            boolean r0 = r10.hasNext()
            r1 = 1
            if (r0 == 0) goto L82
            java.lang.Object r0 = r10.next()
            id.dana.domain.globalsearch.model.ProductBizId r0 = (id.dana.domain.globalsearch.model.ProductBizId) r0
            java.lang.String r2 = r0.getProfileKey()
            r3 = r9
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L1e:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L73
            java.lang.Object r4 = r3.next()
            r6 = r4
            id.dana.domain.homeinfo.ThirdPartyServiceResponse r6 = (id.dana.domain.homeinfo.ThirdPartyServiceResponse) r6
            id.dana.domain.homeinfo.SkuAttribute r7 = r6.getSkuAttr()
            r8 = 0
            if (r7 == 0) goto L40
            java.util.List r7 = r7.getServiceKey()
            if (r7 == 0) goto L40
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r7 = kotlin.collections.CollectionsKt.contains(r7, r2)
            goto L41
        L40:
            r7 = 0
        L41:
            if (r7 != 0) goto L6f
            id.dana.domain.homeinfo.SkuAttribute r7 = r6.getSkuAttr()
            if (r7 == 0) goto L56
            java.util.List r7 = r7.getPrepaidKey()
            if (r7 == 0) goto L56
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r7 = kotlin.collections.CollectionsKt.contains(r7, r2)
            goto L57
        L56:
            r7 = 0
        L57:
            if (r7 != 0) goto L6f
            id.dana.domain.homeinfo.SkuAttribute r6 = r6.getSkuAttr()
            if (r6 == 0) goto L6c
            java.util.List r6 = r6.getPostpaidKey()
            if (r6 == 0) goto L6c
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r6 = kotlin.collections.CollectionsKt.contains(r6, r2)
            goto L6d
        L6c:
            r6 = 0
        L6d:
            if (r6 == 0) goto L70
        L6f:
            r8 = 1
        L70:
            if (r8 == 0) goto L1e
            goto L74
        L73:
            r4 = r5
        L74:
            id.dana.domain.homeinfo.ThirdPartyServiceResponse r4 = (id.dana.domain.homeinfo.ThirdPartyServiceResponse) r4
            if (r4 == 0) goto L7c
            id.dana.domain.homeinfo.SkuAttribute r5 = r4.getSkuAttr()
        L7c:
            if (r5 == 0) goto L6
            r5.setProductBizId(r0)
            goto L6
        L82:
            int r10 = r9.size()
            if (r10 <= r1) goto L92
            id.dana.explore.domain.sku.interactor.GetSkuExplore$mapBizId$$inlined$sortByDescending$1 r10 = new id.dana.explore.domain.sku.interactor.GetSkuExplore$mapBizId$$inlined$sortByDescending$1
            r10.<init>()
            java.util.Comparator r10 = (java.util.Comparator) r10
            kotlin.collections.CollectionsKt.sortWith(r9, r10)
        L92:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.domain.sku.interactor.GetSkuExplore.BuiltInFictitiousFunctionClassFactory(java.util.List, java.util.List):java.util.List");
    }

    public static final /* synthetic */ Function1 KClassImpl$Data$declaredNonStaticMembers$2(final List list) {
        return new Function1<List<? extends ThirdPartyServiceResponse>, List<ThirdPartyServiceResponse>>() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$populateServiceWithSkuIdForGrouping$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ List<ThirdPartyServiceResponse> invoke(List<? extends ThirdPartyServiceResponse> list2) {
                return invoke2((List<ThirdPartyServiceResponse>) list2);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final List<ThirdPartyServiceResponse> invoke2(List<ThirdPartyServiceResponse> list2) {
                Object obj;
                Intrinsics.checkNotNullParameter(list2, "");
                List<SkuExploreConfig> list3 = list;
                for (ThirdPartyServiceResponse thirdPartyServiceResponse : list2) {
                    Iterator<T> it = list3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual(((SkuExploreConfig) obj).getServiceName(), thirdPartyServiceResponse.getKey())) {
                            break;
                        }
                    }
                    SkuExploreConfig skuExploreConfig = (SkuExploreConfig) obj;
                    String id2 = skuExploreConfig != null ? skuExploreConfig.getId() : null;
                    if (id2 == null) {
                        id2 = "";
                    }
                    thirdPartyServiceResponse.setSkuConfigId(id2);
                }
                return CollectionsKt.toMutableList((Collection) list2);
            }
        };
    }
}
