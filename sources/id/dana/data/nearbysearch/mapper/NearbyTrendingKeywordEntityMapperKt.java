package id.dana.data.nearbysearch.mapper;

import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/data/config/model/NearbyTrendingKeywordEntity;", "Lid/dana/domain/nearbysearch/model/NearbyTrendingKeyword;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NearbyTrendingKeywordEntityMapperKt {
    public static final List<NearbyTrendingKeyword> BuiltInFictitiousFunctionClassFactory(List<NearbyTrendingKeywordEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NearbyTrendingKeywordEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NearbyTrendingKeywordEntity nearbyTrendingKeywordEntity : list2) {
            arrayList.add(new NearbyTrendingKeyword(nearbyTrendingKeywordEntity.getName(), nearbyTrendingKeywordEntity.getTag()));
        }
        return arrayList;
    }
}
