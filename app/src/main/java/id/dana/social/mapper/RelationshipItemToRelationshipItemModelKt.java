package id.dana.social.mapper;

import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import id.dana.feeds.ui.model.RelationshipItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/relationship/model/RelationshipItem;)Lid/dana/feeds/ui/model/RelationshipItemModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipItemToRelationshipItemModelKt {
    public static final RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2(RelationshipItem relationshipItem) {
        Intrinsics.checkNotNullParameter(relationshipItem, "");
        return new RelationshipItemModel(relationshipItem.getUserId(), PhoneNumberUtilKt.replaceIndoRegionDashWithPlusSixTwo(relationshipItem.getLoginId()), relationshipItem.getNickName(), relationshipItem.getStatus(), relationshipItem.getAvatar(), relationshipItem.getUsername(), relationshipItem.isNonReciprocal(), relationshipItem.getFriendCount(), null, false, 0, false, false, 7936, null);
    }
}
