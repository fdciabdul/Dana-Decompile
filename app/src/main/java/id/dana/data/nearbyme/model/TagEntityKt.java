package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/data/nearbyme/model/TagEntity;", "Lid/dana/domain/nearbyme/model/Tag;", "toTag", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TagEntityKt {
    public static final List<Tag> toTag(List<TagEntity> list) {
        if (list != null) {
            List<TagEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TagEntity) it.next()).toTag());
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
