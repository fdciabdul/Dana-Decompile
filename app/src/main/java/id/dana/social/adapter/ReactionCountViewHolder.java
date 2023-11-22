package id.dana.social.adapter;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.social.view.ReactionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010"}, d2 = {"Lid/dana/social/adapter/ReactionCountViewHolder;", "Lid/dana/social/adapter/BaseReactionCountViewHolder;", "Lid/dana/social/view/ReactionView;", "PlaceComponentResult", "()Lid/dana/social/view/ReactionView;", "Lid/dana/social/adapter/FeedReactionClickListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/adapter/FeedReactionClickListener;", "", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lid/dana/social/adapter/SocialFeedClickListener;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;Lid/dana/social/adapter/FeedReactionClickListener;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionCountViewHolder extends BaseReactionCountViewHolder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private FeedReactionClickListener PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ViewGroup getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SocialFeedClickListener BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionCountViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, FeedReactionClickListener feedReactionClickListener, boolean z) {
        super(viewGroup, socialFeedClickListener, feedReactionClickListener, z, R.layout.viewholder_reaction);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(feedReactionClickListener, "");
        this.getAuthRequestContext = viewGroup;
        this.BuiltInFictitiousFunctionClassFactory = socialFeedClickListener;
        this.PlaceComponentResult = feedReactionClickListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // id.dana.social.adapter.BaseReactionCountViewHolder
    public final ReactionView PlaceComponentResult() {
        ReactionView reactionView = (ReactionView) this.itemView.findViewById(R.id.AutoValue_TokenResult);
        Intrinsics.checkNotNullExpressionValue(reactionView, "");
        return reactionView;
    }
}
