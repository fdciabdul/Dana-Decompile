package id.dana.feeds.data.detail.source.network.response;

import id.dana.feeds.domain.detail.model.Comment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/feeds/data/detail/source/network/response/CommentResponse;", "Lid/dana/feeds/domain/detail/model/Comment;", "toComments", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchActivityCommentsResponseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Comment> toComments(List<CommentResponse> list) {
        List<CommentResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((CommentResponse) it.next()).toComment());
        }
        return arrayList;
    }
}
