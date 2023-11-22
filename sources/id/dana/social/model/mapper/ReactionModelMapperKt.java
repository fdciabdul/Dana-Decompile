package id.dana.social.model.mapper;

import id.dana.feeds.domain.reactions.model.Reaction;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/feeds/domain/reactions/model/Reaction;", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionModelMapperKt {
    public static final List<ReactionModel> PlaceComponentResult(List<Reaction> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<Reaction> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Reaction reaction : list2) {
            Intrinsics.checkNotNullParameter(reaction, "");
            arrayList.add(new ReactionModel(reaction.getKind(), reaction.getName()));
        }
        return arrayList;
    }
}
