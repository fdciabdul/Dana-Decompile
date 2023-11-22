package id.dana.social.mapper;

import id.dana.feeds.domain.relationship.model.RelationshipItem;
import id.dana.feeds.ui.model.RelationshipItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipItemListToRelationshipItemModelListKt {
    public static final List<RelationshipItemModel> KClassImpl$Data$declaredNonStaticMembers$2(List<RelationshipItem> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RelationshipItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(RelationshipItemToRelationshipItemModelKt.KClassImpl$Data$declaredNonStaticMembers$2((RelationshipItem) it.next()));
        }
        return arrayList;
    }
}
