package id.dana.social.model.mapper;

import id.dana.feeds.domain.timeline.model.OwnReaction;
import id.dana.feeds.domain.timeline.model.ReactionCount;
import id.dana.social.model.ReactionCountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/model/mapper/ReactionCountModelMapper;", "", "Lid/dana/feeds/domain/timeline/model/ReactionCount;", "p0", "", "Lid/dana/feeds/domain/timeline/model/OwnReaction;", "p1", "Lid/dana/social/model/ReactionCountModel;", "getAuthRequestContext", "(Lid/dana/feeds/domain/timeline/model/ReactionCount;Ljava/util/List;)Lid/dana/social/model/ReactionCountModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionCountModelMapper {
    @Inject
    public ReactionCountModelMapper() {
    }

    public static ReactionCountModel getAuthRequestContext(ReactionCount p0, List<OwnReaction> p1) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String kind = p0.getKind();
        int count = p0.getCount();
        List<OwnReaction> list = p1;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OwnReaction) it.next()).getKind());
        }
        boolean contains = arrayList.contains(p0.getKind());
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(((OwnReaction) obj).getKind(), p0.getKind())) {
                break;
            }
        }
        OwnReaction ownReaction = (OwnReaction) obj;
        return new ReactionCountModel(kind, count, contains, ownReaction != null ? ownReaction.getId() : null);
    }
}
