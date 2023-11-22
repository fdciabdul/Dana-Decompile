package id.dana.explore.domain.sku.interactor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.ServicesRepository;
import id.dana.explore.domain.sku.model.SkuExploreConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00040\u00040\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lid/dana/explore/domain/sku/model/SkuExploreConfig;", "configs", "Lio/reactivex/Observable;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", BridgeDSL.INVOKE, "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class GetSkuExplore$getSkuServices$1 extends Lambda implements Function1<List<? extends SkuExploreConfig>, Observable<List<ThirdPartyServiceResponse>>> {
    final /* synthetic */ GetSkuExplore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSkuExplore$getSkuServices$1(GetSkuExplore getSkuExplore) {
        super(1);
        this.this$0 = getSkuExplore;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Observable<List<ThirdPartyServiceResponse>> invoke(List<? extends SkuExploreConfig> list) {
        return invoke2((List<SkuExploreConfig>) list);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Observable<List<ThirdPartyServiceResponse>> invoke2(List<SkuExploreConfig> list) {
        ServicesRepository servicesRepository;
        Intrinsics.checkNotNullParameter(list, "");
        servicesRepository = this.this$0.PlaceComponentResult;
        List<SkuExploreConfig> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((SkuExploreConfig) it.next()).getServiceName());
        }
        Observable<List<ThirdPartyServiceResponse>> defaultSkuExplore = servicesRepository.getDefaultSkuExplore(arrayList);
        final Function1 KClassImpl$Data$declaredNonStaticMembers$2 = GetSkuExplore.KClassImpl$Data$declaredNonStaticMembers$2(list);
        return defaultSkuExplore.map(new Function() { // from class: id.dana.explore.domain.sku.interactor.GetSkuExplore$getSkuServices$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2579invoke$lambda1;
                m2579invoke$lambda1 = GetSkuExplore$getSkuServices$1.m2579invoke$lambda1(Function1.this, (List) obj);
                return m2579invoke$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final List m2579invoke$lambda1(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (List) function1.invoke(list);
    }
}
