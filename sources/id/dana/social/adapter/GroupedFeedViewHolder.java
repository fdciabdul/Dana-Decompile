package id.dana.social.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.view.BubbleFeedView;
import id.dana.social.view.GroupedFeedsView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/social/adapter/GroupedFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class GroupedFeedViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        String nickName;
        String str;
        GroupedFeedsView groupedFeedsView;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        Intrinsics.checkNotNullParameter(feedViewHolderModel2, "");
        GroupedFeedModel groupedFeedModel = feedViewHolderModel2.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel != null) {
            List<? extends HashMap<String, String>> list = groupedFeedModel.getErrorConfigVersion;
            if (list.size() > 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(ExtendInfoUtilKt.getNickName(list.get(0)));
                sb.append(", ");
                sb.append(ExtendInfoUtilKt.getNickName(list.get(1)));
                sb.append(InputCardNumberView.DIVIDER);
                String string = getContext().getString(R.string.and_predicate);
                Intrinsics.checkNotNullExpressionValue(string, "");
                sb.append(string);
                sb.append(InputCardNumberView.DIVIDER);
                String string2 = getContext().getString(R.string.other_predicate);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                sb.append(string2);
                nickName = sb.toString();
            } else if (list.size() > 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ExtendInfoUtilKt.getNickName(list.get(0)));
                sb2.append(", ");
                sb2.append(ExtendInfoUtilKt.getNickName(list.get(1)));
                sb2.append(InputCardNumberView.DIVIDER);
                String string3 = getContext().getString(R.string.and_predicate);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                sb2.append(string3);
                sb2.append(InputCardNumberView.DIVIDER);
                sb2.append(ExtendInfoUtilKt.getNickName(list.get(2)));
                nickName = sb2.toString();
            } else if (list.size() > 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ExtendInfoUtilKt.getNickName(list.get(0)));
                sb3.append(InputCardNumberView.DIVIDER);
                String string4 = getContext().getString(R.string.and_predicate);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                sb3.append(string4);
                sb3.append(InputCardNumberView.DIVIDER);
                sb3.append(ExtendInfoUtilKt.getNickName(list.get(1)));
                nickName = sb3.toString();
            } else {
                nickName = ExtendInfoUtilKt.getNickName(list.get(0));
            }
            ExtendInfoUtilKt.setActorNickname(groupedFeedModel.PlaceComponentResult, nickName);
            ExtendInfoUtilKt.setDisplayName(groupedFeedModel.PlaceComponentResult, nickName);
            GroupedFeedsView groupedFeedsView2 = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
            if (groupedFeedsView2 != null) {
                FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
                groupedFeedsView2.setProfileAvatar(FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(groupedFeedModel.BuiltInFictitiousFunctionClassFactory));
            }
            GroupedFeedsView groupedFeedsView3 = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
            if (groupedFeedsView3 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                groupedFeedsView3.setDesc(feedViewHolderModel2.getAuthRequestContext(context, this.KClassImpl$Data$declaredNonStaticMembers$2));
            }
            FeedModel feedModel = (FeedModel) CollectionsKt.firstOrNull((List) groupedFeedModel.BuiltInFictitiousFunctionClassFactory);
            if (feedModel != null && (str = feedModel.moveToNextValue) != null && (groupedFeedsView = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment)) != null) {
                groupedFeedsView.setDate(str);
            }
            BubbleFeedView bubbleFeedView = (BubbleFeedView) this.itemView.findViewById(R.id.view_bubble_feed);
            if (bubbleFeedView != null) {
                bubbleFeedView.setDescriptionConstraint(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupedFeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.viewholder_grouped_feed, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedClickListener;
        GroupedFeedsView groupedFeedsView = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
        if (groupedFeedsView != null) {
            groupedFeedsView.hideCaptionSection();
        }
        GroupedFeedsView groupedFeedsView2 = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
        if (groupedFeedsView2 != null) {
            groupedFeedsView2.setSocialFeedClickListener(socialFeedClickListener);
        }
        GroupedFeedsView groupedFeedsView3 = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
        if (groupedFeedsView3 != null) {
            groupedFeedsView3.setBubbleFeedOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.GroupedFeedViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupedFeedViewHolder.getAuthRequestContext(GroupedFeedViewHolder.this);
                }
            });
        }
        GroupedFeedsView groupedFeedsView4 = (GroupedFeedsView) this.itemView.findViewById(R.id.PaymentResultFragment);
        if (groupedFeedsView4 != null) {
            groupedFeedsView4.setProfileImageClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.GroupedFeedViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupedFeedViewHolder.PlaceComponentResult(GroupedFeedViewHolder.this);
                }
            });
        }
    }

    public static /* synthetic */ void getAuthRequestContext(GroupedFeedViewHolder groupedFeedViewHolder) {
        Intrinsics.checkNotNullParameter(groupedFeedViewHolder, "");
        if (groupedFeedViewHolder.getBindingAdapterPosition() >= 0) {
            groupedFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(groupedFeedViewHolder.getBindingAdapterPosition());
        }
    }

    public static /* synthetic */ void PlaceComponentResult(GroupedFeedViewHolder groupedFeedViewHolder) {
        Intrinsics.checkNotNullParameter(groupedFeedViewHolder, "");
        if (groupedFeedViewHolder.getBindingAdapterPosition() >= 0) {
            groupedFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(groupedFeedViewHolder.getBindingAdapterPosition());
        }
    }
}
