package id.dana.social.adapter;

import android.view.View;
import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.view.ReactionView;
import id.dana.utils.showcase.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013"}, d2 = {"Lid/dana/social/adapter/BaseReactionCountViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/ReactionCountModel;", "Lid/dana/social/view/ReactionView;", "PlaceComponentResult", "()Lid/dana/social/view/ReactionView;", "Lid/dana/social/adapter/FeedReactionClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/FeedReactionClickListener;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "", "BuiltInFictitiousFunctionClassFactory", "I", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;Lid/dana/social/adapter/FeedReactionClickListener;ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseReactionCountViewHolder extends BaseRecyclerViewHolder<ReactionCountModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private FeedReactionClickListener getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    public abstract ReactionView PlaceComponentResult();

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ReactionCountModel reactionCountModel) {
        final ReactionCountModel reactionCountModel2 = reactionCountModel;
        if (reactionCountModel2 != null) {
            final ReactionView PlaceComponentResult = PlaceComponentResult();
            PlaceComponentResult.setSaymojiStyle(this.PlaceComponentResult);
            PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.BaseReactionCountViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseReactionCountViewHolder.getAuthRequestContext(BaseReactionCountViewHolder.this, reactionCountModel2);
                }
            });
            PlaceComponentResult.setOnLongClickListener(new View.OnLongClickListener() { // from class: id.dana.social.adapter.BaseReactionCountViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean PlaceComponentResult2;
                    PlaceComponentResult2 = BaseReactionCountViewHolder.PlaceComponentResult(ReactionView.this, this, reactionCountModel2);
                    return PlaceComponentResult2;
                }
            });
            PlaceComponentResult.setEmoji(reactionCountModel2.PlaceComponentResult);
            PlaceComponentResult().setReactionActive(reactionCountModel2.getKClassImpl$Data$declaredNonStaticMembers$2());
            PlaceComponentResult().setReactionCount(Integer.valueOf(reactionCountModel2.getAuthRequestContext));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseReactionCountViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, FeedReactionClickListener feedReactionClickListener, boolean z, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(feedReactionClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedClickListener;
        this.getAuthRequestContext = feedReactionClickListener;
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(ReactionView reactionView, BaseReactionCountViewHolder baseReactionCountViewHolder, ReactionCountModel reactionCountModel) {
        Intrinsics.checkNotNullParameter(reactionView, "");
        Intrinsics.checkNotNullParameter(baseReactionCountViewHolder, "");
        Utils.getAuthRequestContext(reactionView.getContext(), 100L);
        baseReactionCountViewHolder.getAuthRequestContext.MyBillsEntityDataFactory(reactionCountModel.PlaceComponentResult);
        return true;
    }

    public static /* synthetic */ void getAuthRequestContext(BaseReactionCountViewHolder baseReactionCountViewHolder, ReactionCountModel reactionCountModel) {
        Intrinsics.checkNotNullParameter(baseReactionCountViewHolder, "");
        Intrinsics.checkNotNullParameter(reactionCountModel, "");
        baseReactionCountViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(reactionCountModel);
    }
}
