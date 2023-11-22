package id.dana.social.mapper;

import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/ui/model/FriendModel;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "PlaceComponentResult", "(Lid/dana/feeds/ui/model/FriendModel;)Lid/dana/feeds/ui/model/RelationshipItemModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendModelMapperKt {
    public static final RelationshipItemModel PlaceComponentResult(FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendModel, "");
        return new RelationshipItemModel(friendModel.NetworkUserEntityData$$ExternalSyntheticLambda0, "", friendModel.KClassImpl$Data$declaredNonStaticMembers$2, "ACTIVE", friendModel.getErrorConfigVersion, friendModel.lookAheadTest, false, 0, null, false, 0, false, false, 8128, null);
    }
}
