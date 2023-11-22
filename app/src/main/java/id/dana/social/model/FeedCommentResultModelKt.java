package id.dana.social.model;

import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.social.state.ViewHolderState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/feeds/domain/detail/model/Comment;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentResultModelKt {
    public static final List<FeedCommentModel> MyBillsEntityDataFactory(List<Comment> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Comment> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Comment comment : list2) {
            FeedCommentModel.Companion companion = FeedCommentModel.INSTANCE;
            arrayList.add(FeedCommentModel.Companion.getAuthRequestContext(comment, FeedCommentModelState.DEFAULT));
        }
        return arrayList;
    }

    public static final /* synthetic */ List PlaceComponentResult(List list) {
        List<Comment> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Comment comment : list2) {
            FeedCommentModel.Companion companion = FeedCommentModel.INSTANCE;
            arrayList.add(new ViewHolderState.Item(FeedCommentModel.Companion.getAuthRequestContext(comment, FeedCommentModelState.DEFAULT)));
        }
        return arrayList;
    }
}
