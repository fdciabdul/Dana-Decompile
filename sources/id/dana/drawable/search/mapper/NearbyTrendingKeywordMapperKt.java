package id.dana.drawable.search.mapper;

import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import id.dana.drawable.search.model.NearbySearchItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/domain/nearbysearch/model/NearbyTrendingKeyword;", "Lid/dana/nearbyrevamp/search/model/NearbySearchItemModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyTrendingKeywordMapperKt {
    public static final List<NearbySearchItemModel> BuiltInFictitiousFunctionClassFactory(List<NearbyTrendingKeyword> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<NearbyTrendingKeyword> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (NearbyTrendingKeyword nearbyTrendingKeyword : list2) {
            String name = nearbyTrendingKeyword.getName();
            if (name == null) {
                name = "";
            }
            String tag = nearbyTrendingKeyword.getTag();
            if (tag == null) {
                tag = "";
            }
            arrayList.add(new NearbySearchItemModel(name, tag));
        }
        return arrayList;
    }
}
