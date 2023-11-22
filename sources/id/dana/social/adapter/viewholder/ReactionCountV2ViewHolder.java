package id.dana.social.adapter.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.social.adapter.BaseReactionCountViewHolder;
import id.dana.social.adapter.FeedReactionClickListener;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.view.ReactionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/adapter/viewholder/ReactionCountV2ViewHolder;", "Lid/dana/social/adapter/BaseReactionCountViewHolder;", "Lid/dana/social/view/ReactionView;", "PlaceComponentResult", "()Lid/dana/social/view/ReactionView;", "Lid/dana/social/adapter/FeedReactionClickListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/adapter/FeedReactionClickListener;", "", "getAuthRequestContext", "Z", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/SocialFeedClickListener;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;Lid/dana/social/adapter/FeedReactionClickListener;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionCountV2ViewHolder extends BaseReactionCountViewHolder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private FeedReactionClickListener PlaceComponentResult;
    private final SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final ViewGroup MyBillsEntityDataFactory;
    private final boolean getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionCountV2ViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, FeedReactionClickListener feedReactionClickListener, boolean z) {
        super(viewGroup, socialFeedClickListener, feedReactionClickListener, z, R.layout.viewholder_reaction_v2);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(feedReactionClickListener, "");
        this.MyBillsEntityDataFactory = viewGroup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedClickListener;
        this.PlaceComponentResult = feedReactionClickListener;
        this.getAuthRequestContext = z;
    }

    @Override // id.dana.social.adapter.BaseReactionCountViewHolder
    public final ReactionView PlaceComponentResult() {
        ReactionView reactionView = (ReactionView) this.itemView.findViewById(R.id.AutoValue_TokenResult);
        Intrinsics.checkNotNullExpressionValue(reactionView, "");
        return reactionView;
    }
}
