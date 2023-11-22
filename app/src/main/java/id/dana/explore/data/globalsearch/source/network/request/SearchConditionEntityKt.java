package id.dana.explore.data.globalsearch.source.network.request;

import id.dana.explore.domain.globalsearch.model.SearchCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0002\u0010\u0005"}, d2 = {"Lid/dana/explore/domain/globalsearch/model/SearchCondition;", "Lid/dana/explore/data/globalsearch/source/network/request/SearchConditionEntity;", "toSearchConditionEntity", "(Lid/dana/explore/domain/globalsearch/model/SearchCondition;)Lid/dana/explore/data/globalsearch/source/network/request/SearchConditionEntity;", "", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchConditionEntityKt {
    public static final List<SearchConditionEntity> toSearchConditionEntity(List<SearchCondition> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<SearchCondition> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSearchConditionEntity((SearchCondition) it.next()));
        }
        return arrayList;
    }

    public static final SearchConditionEntity toSearchConditionEntity(SearchCondition searchCondition) {
        Intrinsics.checkNotNullParameter(searchCondition, "");
        return new SearchConditionEntity(searchCondition.getSearchType(), searchCondition.getKeyword());
    }
}
