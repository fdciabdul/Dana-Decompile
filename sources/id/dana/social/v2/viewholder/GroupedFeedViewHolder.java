package id.dana.social.v2.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.v2.view.ActivityWidgetView;
import id.dana.social.v2.view.DealsVoucherView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/social/v2/viewholder/GroupedFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "p0", "p1", "", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupedFeedViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final SocialFeedClickListener getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ GroupedFeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, socialFeedClickListener, (i2 & 4) != 0 ? R.layout.viewholder_grouped_feed_v2 : i);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        GroupedFeedModel groupedFeedModel;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 == null || (groupedFeedModel = feedViewHolderModel2.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        FeedsContentUtils.MyBillsEntityDataFactory(context, groupedFeedModel);
        ActivityFeedView activityFeedView = (ActivityFeedView) this.itemView.findViewById(R.id.setDocumentationRootUrl);
        if (activityFeedView != null) {
            Intrinsics.checkNotNullExpressionValue(activityFeedView, "");
            ActivityWidgetView activityWidgetView = (ActivityWidgetView) activityFeedView._$_findCachedViewById(R.id.PlaceComponentResult_res_0x7f0a006a);
            if (activityWidgetView != null) {
                Intrinsics.checkNotNullExpressionValue(activityWidgetView, "");
                activityWidgetView.setVisibility(8);
            }
            DealsVoucherView dealsVoucherView = (DealsVoucherView) activityFeedView._$_findCachedViewById(R.id.dealsVoucherView);
            if (dealsVoucherView != null) {
                Intrinsics.checkNotNullExpressionValue(dealsVoucherView, "");
                dealsVoucherView.setVisibility(8);
            }
            activityFeedView.setShowAddSaymojiIcon(false);
            activityFeedView.setShowAddCommentIcon(false);
            activityFeedView.setShowLatestComment(false);
            activityFeedView.setShowResponseCount(false);
            activityFeedView.setShowReactionSection(false);
            activityFeedView.setOnActivityWidgetClicked(new GroupedFeedViewHolder$bindData$1$1$1(this.getAuthRequestContext));
            activityFeedView.setOnUniqueDealsWidgetClicked(new GroupedFeedViewHolder$bindData$1$1$2(this.getAuthRequestContext));
            FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
            activityFeedView.setAvatars(FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(groupedFeedModel.BuiltInFictitiousFunctionClassFactory));
            Context context2 = activityFeedView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            activityFeedView.setContent(feedViewHolderModel2.getAuthRequestContext(context2, this.getAuthRequestContext));
            activityFeedView.setGroupedName(groupedFeedModel.getErrorConfigVersion);
            activityFeedView.setContent((FeedModel) CollectionsKt.firstOrNull((List) groupedFeedModel.BuiltInFictitiousFunctionClassFactory));
            activityFeedView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.GroupedFeedViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupedFeedViewHolder.BuiltInFictitiousFunctionClassFactory(GroupedFeedViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private GroupedFeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        this.getAuthRequestContext = socialFeedClickListener;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GroupedFeedViewHolder groupedFeedViewHolder) {
        Intrinsics.checkNotNullParameter(groupedFeedViewHolder, "");
        if (groupedFeedViewHolder.getBindingAdapterPosition() >= 0) {
            groupedFeedViewHolder.getAuthRequestContext.getAuthRequestContext(groupedFeedViewHolder.getBindingAdapterPosition());
        }
    }
}
