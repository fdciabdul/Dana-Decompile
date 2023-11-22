package id.dana.social.view;

import id.dana.feeds.ui.model.RelationshipItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class FriendsFeedsHeaderView$createFriendsFeeds$2 extends FunctionReferenceImpl implements Function1<RelationshipItemModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FriendsFeedsHeaderView$createFriendsFeeds$2(Object obj) {
        super(1, obj, FriendsFeedsHeaderView.class, "openProfileActivity", "openProfileActivity(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(RelationshipItemModel relationshipItemModel) {
        invoke2(relationshipItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(RelationshipItemModel relationshipItemModel) {
        Intrinsics.checkNotNullParameter(relationshipItemModel, "");
        FriendsFeedsHeaderView.access$openProfileActivity((FriendsFeedsHeaderView) this.receiver, relationshipItemModel);
    }
}
