package id.dana.social.v2.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.v2.view.ActivityWidgetView;
import id.dana.social.v2.view.DealsVoucherView;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B{\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010!R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\t\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015"}, d2 = {"Lid/dana/social/v2/viewholder/FeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lkotlin/Triple;", "", "getAuthRequestContext", "Lkotlin/Triple;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "moveToNextValue", "scheduleImpl", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;ZZZZZZLkotlin/Triple;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class FeedViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final boolean getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Triple<FeedViewHolderModel, FeedViewHolderModel, Integer> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final boolean moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final SocialFeedClickListener scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final boolean lookAheadTest;

    public /* synthetic */ FeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Triple triple, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, socialFeedClickListener, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? true : z3, (i2 & 32) != 0 ? true : z4, (i2 & 64) != 0 ? true : z5, (i2 & 128) != 0 ? true : z6, (i2 & 256) != 0 ? null : triple, (i2 & 512) != 0 ? R.layout.viewholder_feed_v2 : i);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        ActivityFeedView activityFeedView;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 == null || (activityFeedView = (ActivityFeedView) this.itemView.findViewById(R.id.setMapper)) == null) {
            return;
        }
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
        activityFeedView.setShowAddCommentIcon(this.MyBillsEntityDataFactory);
        activityFeedView.setShowAddSaymojiIcon(this.getAuthRequestContext);
        activityFeedView.setShowLatestComment(this.getErrorConfigVersion);
        activityFeedView.setShowResponseCount(this.lookAheadTest);
        activityFeedView.setShowReactionSection(this.moveToNextValue);
        activityFeedView.setShowActivityInfoView(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Triple<FeedViewHolderModel, FeedViewHolderModel, Integer> triple = this.BuiltInFictitiousFunctionClassFactory;
        if (triple != null) {
            activityFeedView.showLineConnector(triple, feedViewHolderModel2);
        }
        activityFeedView.setOnActivityWidgetClicked(new FeedViewHolder$bindData$1$2(this.scheduleImpl));
        activityFeedView.setOnUniqueDealsWidgetClicked(new FeedViewHolder$bindData$1$3(this.scheduleImpl));
        FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
        activityFeedView.setAvatar(FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(feedViewHolderModel2));
        Context context = activityFeedView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        activityFeedView.setContent(feedViewHolderModel2.getAuthRequestContext(context, this.scheduleImpl));
        FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
        String authRequestContext = FeedsContentUtils.getAuthRequestContext(feedViewHolderModel2);
        FeedsContentUtils feedsContentUtils3 = FeedsContentUtils.MyBillsEntityDataFactory;
        activityFeedView.setName(authRequestContext, FeedsContentUtils.PlaceComponentResult(feedViewHolderModel2));
        activityFeedView.setContent(feedViewHolderModel2.MyBillsEntityDataFactory);
        activityFeedView.setAvatarClickAction(new Function0<Unit>() { // from class: id.dana.social.v2.viewholder.FeedViewHolder$bindData$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (FeedViewHolder.this.getBindingAdapterPosition() >= 0) {
                    FeedViewHolder.this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolder.this.getBindingAdapterPosition());
                }
            }
        });
        activityFeedView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedViewHolder.PlaceComponentResult(FeedViewHolder.this);
            }
        });
        activityFeedView.setRetryAndDeleteAction(new Function0<Unit>() { // from class: id.dana.social.v2.viewholder.FeedViewHolder$bindData$1$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (FeedViewHolder.this.getBindingAdapterPosition() >= 0) {
                    FeedViewHolder.this.scheduleImpl.PlaceComponentResult(FeedViewHolder.this.getBindingAdapterPosition());
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.social.v2.viewholder.FeedViewHolder$bindData$1$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (FeedViewHolder.this.getBindingAdapterPosition() >= 0) {
                    FeedViewHolder.this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(FeedViewHolder.this.getBindingAdapterPosition());
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private FeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Triple<FeedViewHolderModel, FeedViewHolderModel, Integer> triple, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.PlaceComponentResult = viewGroup;
        this.scheduleImpl = socialFeedClickListener;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = z2;
        this.getErrorConfigVersion = z3;
        this.lookAheadTest = z4;
        this.moveToNextValue = z5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z6;
        this.BuiltInFictitiousFunctionClassFactory = triple;
    }

    public static /* synthetic */ void PlaceComponentResult(FeedViewHolder feedViewHolder) {
        Intrinsics.checkNotNullParameter(feedViewHolder, "");
        if (feedViewHolder.getBindingAdapterPosition() >= 0) {
            feedViewHolder.scheduleImpl.MyBillsEntityDataFactory(feedViewHolder.getBindingAdapterPosition());
        }
    }
}
