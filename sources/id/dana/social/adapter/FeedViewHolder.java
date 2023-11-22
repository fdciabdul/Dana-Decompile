package id.dana.social.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.view.BubbleFeedView;
import id.dana.social.view.FeedsView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\f\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0012\u0010\t\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u0004\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u000fX\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/social/adapter/FeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Z", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/view/FeedsView;", "viewFeed", "Lid/dana/social/view/FeedsView;", "p0", "p1", "p2", "p3", "p4", "", "p5", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;ZZZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class FeedViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    boolean PlaceComponentResult;
    boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SocialFeedClickListener BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.PaymentResultFragment)
    public FeedsView viewFeed;

    public /* synthetic */ FeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, boolean z, boolean z2, boolean z3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, socialFeedClickListener, z, z2, z3, (i2 & 32) != 0 ? R.layout.viewholder_feed : i);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        List<FeedModel> list;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 != null) {
            if (feedViewHolderModel2.getPlaceComponentResult()) {
                this.itemView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f5022130772051));
                feedViewHolderModel2.PlaceComponentResult = false;
            }
            FeedsView feedsView = null;
            if (feedViewHolderModel2.MyBillsEntityDataFactory == null) {
                GroupedFeedModel groupedFeedModel = feedViewHolderModel2.BuiltInFictitiousFunctionClassFactory;
                FeedModel feedModel = (groupedFeedModel == null || (list = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : (FeedModel) CollectionsKt.firstOrNull((List) list);
                if (feedModel != null) {
                    FeedsView feedsView2 = this.viewFeed;
                    if (feedsView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView2 = null;
                    }
                    FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
                    feedsView2.setProfileAvatar(FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(feedViewHolderModel2));
                    FeedsView feedsView3 = this.viewFeed;
                    if (feedsView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView3 = null;
                    }
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    feedsView3.setDesc(feedViewHolderModel2.getAuthRequestContext(context, this.BuiltInFictitiousFunctionClassFactory));
                    FeedsView feedsView4 = this.viewFeed;
                    if (feedsView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView4 = null;
                    }
                    feedsView4.setShowCaptionSection(false);
                    FeedsView feedsView5 = this.viewFeed;
                    if (feedsView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView5 = null;
                    }
                    feedsView5.setDate(feedModel.moveToNextValue);
                    FeedsView feedsView6 = this.viewFeed;
                    if (feedsView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView6 = null;
                    }
                    feedsView6.setReaction(feedModel);
                    if (feedViewHolderModel2.getErrorConfigVersion == 5) {
                        FeedsView feedsView7 = this.viewFeed;
                        if (feedsView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            feedsView7 = null;
                        }
                        feedsView7.showUnreadBadge(feedModel.getNewProxyInstance());
                    } else if (feedViewHolderModel2.getErrorConfigVersion == 9) {
                        FeedsView feedsView8 = this.viewFeed;
                        if (feedsView8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            feedsView8 = null;
                        }
                        feedsView8.hideRetryAndSharingMessage();
                    }
                }
            } else {
                FeedModel feedModel2 = feedViewHolderModel2.MyBillsEntityDataFactory;
                if (feedModel2 != null) {
                    FeedsView feedsView9 = this.viewFeed;
                    if (feedsView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView9 = null;
                    }
                    FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
                    feedsView9.setProfileAvatar(FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(feedViewHolderModel2));
                    FeedsView feedsView10 = this.viewFeed;
                    if (feedsView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView10 = null;
                    }
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "");
                    feedsView10.setDesc(feedViewHolderModel2.getAuthRequestContext(context2, this.BuiltInFictitiousFunctionClassFactory));
                    FeedsView feedsView11 = this.viewFeed;
                    if (feedsView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView11 = null;
                    }
                    feedsView11.setDate(feedModel2.moveToNextValue);
                    FeedsView feedsView12 = this.viewFeed;
                    if (feedsView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView12 = null;
                    }
                    feedsView12.setReaction(feedModel2);
                    FeedsView feedsView13 = this.viewFeed;
                    if (feedsView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedsView13 = null;
                    }
                    feedsView13.setOnRetryClickListener(new Function0<Unit>() { // from class: id.dana.social.adapter.FeedViewHolder$bindViewFromFeedModel$1$1
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
                            FeedViewHolder.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(FeedViewHolder.this.getBindingAdapterPosition());
                        }
                    }, new Function0<Unit>() { // from class: id.dana.social.adapter.FeedViewHolder$bindViewFromFeedModel$1$2
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
                            FeedViewHolder.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(FeedViewHolder.this.getBindingAdapterPosition());
                        }
                    });
                    if (this.getAuthRequestContext) {
                        FeedsView feedsView14 = this.viewFeed;
                        if (feedsView14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            feedsView14 = null;
                        }
                        feedsView14.setCaption(feedModel2.MyBillsEntityDataFactory);
                    }
                    if (feedViewHolderModel2.getErrorConfigVersion == 5) {
                        FeedsView feedsView15 = this.viewFeed;
                        if (feedsView15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            feedsView15 = null;
                        }
                        feedsView15.showUnreadBadge(feedModel2.getNewProxyInstance());
                    } else if (feedViewHolderModel2.getErrorConfigVersion == 9) {
                        FeedsView feedsView16 = this.viewFeed;
                        if (feedsView16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            feedsView16 = null;
                        }
                        feedsView16.setState(feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    }
                }
            }
            FeedModel feedModel3 = feedViewHolderModel2.MyBillsEntityDataFactory;
            if ((feedModel3 != null ? feedModel3.NetworkUserEntityData$$ExternalSyntheticLambda6 : null) == FeedActivityState.INIT) {
                FeedsView feedsView17 = this.viewFeed;
                if (feedsView17 != null) {
                    feedsView = feedsView17;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                BubbleFeedView bubbleFeedView = (BubbleFeedView) feedsView._$_findCachedViewById(R.id.view_bubble_feed);
                if (bubbleFeedView != null) {
                    bubbleFeedView.setDescriptionConstraint(false);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener, boolean z, boolean z2, boolean z3, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.BuiltInFictitiousFunctionClassFactory = socialFeedClickListener;
        FeedsView feedsView = this.viewFeed;
        FeedsView feedsView2 = null;
        if (feedsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView = null;
        }
        feedsView.setShowCommentButton(z);
        FeedsView feedsView3 = this.viewFeed;
        if (feedsView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView3 = null;
        }
        feedsView3.setShowSaymojiButton(z2);
        this.getAuthRequestContext = z3;
        FeedsView feedsView4 = this.viewFeed;
        if (feedsView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView4 = null;
        }
        feedsView4.setShowCaptionSection(z3);
        FeedsView feedsView5 = this.viewFeed;
        if (feedsView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView5 = null;
        }
        feedsView5.setSocialFeedClickListener(socialFeedClickListener);
        FeedsView feedsView6 = this.viewFeed;
        if (feedsView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView6 = null;
        }
        BubbleFeedView bubbleFeedView = (BubbleFeedView) feedsView6._$_findCachedViewById(R.id.view_bubble_feed);
        if (bubbleFeedView != null) {
            bubbleFeedView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.FeedViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedViewHolder.getAuthRequestContext(FeedViewHolder.this);
                }
            });
        }
        FeedsView feedsView7 = this.viewFeed;
        if (feedsView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView7 = null;
        }
        feedsView7.setProfileImageClickListener(new Function0<Unit>() { // from class: id.dana.social.adapter.FeedViewHolder.2
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
                    FeedViewHolder.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolder.this.getBindingAdapterPosition());
                }
            }
        });
        FeedsView feedsView8 = this.viewFeed;
        if (feedsView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView8 = null;
        }
        feedsView8.setReactionVisibility(BuiltInFictitiousFunctionClassFactory());
        FeedsView feedsView9 = this.viewFeed;
        if (feedsView9 != null) {
            feedsView2 = feedsView9;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        BubbleFeedView bubbleFeedView2 = (BubbleFeedView) feedsView2._$_findCachedViewById(R.id.view_bubble_feed);
        if (bubbleFeedView2 != null) {
            bubbleFeedView2.setDescriptionConstraint(BuiltInFictitiousFunctionClassFactory());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FeedViewHolder feedViewHolder) {
        Intrinsics.checkNotNullParameter(feedViewHolder, "");
        if (feedViewHolder.getBindingAdapterPosition() >= 0) {
            feedViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(feedViewHolder.getBindingAdapterPosition());
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        FeedsView feedsView = this.viewFeed;
        FeedsView feedsView2 = null;
        if (feedsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsView = null;
        }
        if (!feedsView.getShowCommentButton()) {
            FeedsView feedsView3 = this.viewFeed;
            if (feedsView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedsView3 = null;
            }
            if (!feedsView3.getShowSaymojiButton()) {
                FeedsView feedsView4 = this.viewFeed;
                if (feedsView4 != null) {
                    feedsView2 = feedsView4;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                if (!feedsView2.getShowCaptionSection()) {
                    return false;
                }
            }
        }
        return true;
    }
}
