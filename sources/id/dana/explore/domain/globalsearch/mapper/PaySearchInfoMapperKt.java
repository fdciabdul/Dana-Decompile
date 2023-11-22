package id.dana.explore.domain.globalsearch.mapper;

import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/explore/domain/globalsearch/model/PaySearchInfo;", "Lid/dana/explore/domain/globalsearch/model/PopularPlaceInfo;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaySearchInfoMapperKt {
    public static final List<PopularPlaceInfo> getAuthRequestContext(List<PaySearchInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PaySearchInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PaySearchInfo paySearchInfo : list2) {
            Intrinsics.checkNotNullParameter(paySearchInfo, "");
            String str = paySearchInfo.getInfo().get("merchantId");
            arrayList.add(new PopularPlaceInfo(str == null ? "" : str, paySearchInfo.getName(), paySearchInfo.getLogo(), false, 8, null));
        }
        return arrayList;
    }
}
