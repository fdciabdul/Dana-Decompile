package id.dana.social.mapper;

import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.model.FeedModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/model/FeedModel;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/model/FeedModel;)Lid/dana/feeds/ui/model/RelationshipItemModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedViewModelMapperKt {
    public static final RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        HashMap<String, String> hashMap = feedModel.lookAheadTest;
        if (hashMap != null) {
            return new RelationshipItemModel(ExtendInfoUtilKt.getUserId(hashMap), "", ExtendInfoUtilKt.getNickName(hashMap), "", ExtendInfoUtilKt.getProfileAvatar(hashMap), feedModel.getAuthRequestContext(), false, 0, null, false, 0, false, false, 8128, null);
        }
        return new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 0, false, false, 8191, null);
    }
}
