package id.dana.social.view.activity.detail;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.social.state.ViewHolderState;
import id.dana.social.view.FeedCommentView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B[\u0012\u0006\u0010\u0005\u001a\u00020\u0016\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011"}, d2 = {"Lid/dana/social/view/activity/detail/FeedCommentViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/state/ViewHolderState;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "Landroid/view/View;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/view/View;I)V", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "PlaceComponentResult", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "moveToNextValue", "Landroid/view/ViewGroup;", "p2", "p3", "p4", "p5", "p6", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lid/dana/social/view/activity/detail/FeedCommentInteraction;Lkotlin/jvm/functions/Function1;ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentViewHolder extends BaseRecyclerViewHolder<ViewHolderState<? extends FeedCommentModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final Function1<Integer, FeedCommentModel> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedCommentInteraction KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;
    private final Function1<Integer, Unit> moveToNextValue;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[FeedCommentModelState.values().length];
            iArr[FeedCommentModelState.SENDING.ordinal()] = 1;
            iArr[FeedCommentModelState.FAILED.ordinal()] = 2;
            iArr[FeedCommentModelState.SUCCESS.ordinal()] = 3;
            iArr[FeedCommentModelState.DEFAULT.ordinal()] = 4;
            iArr[FeedCommentModelState.DIM.ordinal()] = 5;
            PlaceComponentResult = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ViewHolderState<? extends FeedCommentModel> viewHolderState) {
        FeedCommentModel feedCommentModel;
        ViewHolderState<? extends FeedCommentModel> viewHolderState2 = viewHolderState;
        ViewHolderState.Item item = viewHolderState2 instanceof ViewHolderState.Item ? (ViewHolderState.Item) viewHolderState2 : null;
        if (item == null || (feedCommentModel = (FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        ((FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view)).setFeedCommentInteraction(this.KClassImpl$Data$declaredNonStaticMembers$2);
        ((FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view)).setReplyCommentEnabled(this.PlaceComponentResult);
        ((FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view)).bind(feedCommentModel);
        FeedCommentView feedCommentView = (FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view);
        if (feedCommentView != null) {
            int i = WhenMappings.PlaceComponentResult[feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda1.ordinal()];
            if (i == 1) {
                feedCommentView.renderSendingSubmitComment(feedCommentModel.MyBillsEntityDataFactory());
            } else if (i == 2) {
                feedCommentView.renderFailedSubmitComment(feedCommentModel.MyBillsEntityDataFactory());
            } else if (i == 3) {
                feedCommentView.renderSuccessSubmitComment();
            } else if (i == 4) {
                feedCommentView.renderDefaultComment();
            } else if (i == 5) {
                feedCommentView.showDim();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedCommentViewHolder(ViewGroup viewGroup, Function1<? super Integer, FeedCommentModel> function1, FeedCommentInteraction feedCommentInteraction, Function1<? super Integer, Unit> function12, boolean z, boolean z2, boolean z3) {
        super(viewGroup.getContext(), R.layout.item_feed_comment, viewGroup);
        AppCompatImageView appCompatImageView;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(feedCommentInteraction, "");
        Intrinsics.checkNotNullParameter(function12, "");
        this.MyBillsEntityDataFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedCommentInteraction;
        this.moveToNextValue = function12;
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.getAuthRequestContext = z2;
        this.PlaceComponentResult = z3;
        final FeedCommentView feedCommentView = (FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view);
        if (feedCommentView != null) {
            feedCommentView.setReplyCommentEnabled(z3);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) feedCommentView._$_findCachedViewById(R.id.ofFailure);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.detail.FeedCommentViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedCommentViewHolder.PlaceComponentResult(FeedCommentViewHolder.this, view);
                    }
                });
            }
            CircleImageView circleImageView = (CircleImageView) feedCommentView._$_findCachedViewById(R.id.civ_profile_avatar);
            if (circleImageView != null) {
                circleImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.detail.FeedCommentViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedCommentViewHolder.BuiltInFictitiousFunctionClassFactory(FeedCommentView.this, this);
                    }
                });
            }
            feedCommentView.setFeedRevamp(z2);
        }
        FeedCommentView feedCommentView2 = (FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view);
        if (feedCommentView2 != null && (appCompatImageView = (AppCompatImageView) feedCommentView2._$_findCachedViewById(R.id.getSearchKeyword)) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.activity.detail.FeedCommentViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedCommentViewHolder.MyBillsEntityDataFactory(FeedCommentViewHolder.this);
                }
            });
        }
        final FeedCommentView feedCommentView3 = (FeedCommentView) this.itemView.findViewById(R.id.feed_comment_view);
        if (feedCommentView3 != null) {
            feedCommentView3.renderReplyButton();
            feedCommentView3.setOnClickReply(new Function1<FeedCommentModel, Unit>() { // from class: id.dana.social.view.activity.detail.FeedCommentViewHolder$setupReplyCommentInteraction$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FeedCommentModel feedCommentModel) {
                    invoke2(feedCommentModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FeedCommentModel feedCommentModel) {
                    Intrinsics.checkNotNullParameter(feedCommentModel, "");
                    FeedCommentInteraction feedCommentInteraction2 = FeedCommentView.this.getFeedCommentInteraction();
                    if (feedCommentInteraction2 != null) {
                        feedCommentInteraction2.getAuthRequestContext(feedCommentModel);
                    }
                }
            });
        }
    }

    private final void getAuthRequestContext(View p0, int p1) {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        PopupMenu popupMenu = new PopupMenu(context, p0);
        new SupportMenuInflater(popupMenu.BuiltInFictitiousFunctionClassFactory).inflate(p1, popupMenu.PlaceComponentResult);
        popupMenu.KClassImpl$Data$declaredNonStaticMembers$2 = new PopupMenu.OnMenuItemClickListener() { // from class: id.dana.social.view.activity.detail.FeedCommentViewHolder$$ExternalSyntheticLambda1
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean getAuthRequestContext(MenuItem menuItem) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = FeedCommentViewHolder.BuiltInFictitiousFunctionClassFactory(FeedCommentViewHolder.this, menuItem);
                return BuiltInFictitiousFunctionClassFactory;
            }
        };
        if (!popupMenu.mPopup.MyBillsEntityDataFactory()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(FeedCommentViewHolder feedCommentViewHolder, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(feedCommentViewHolder, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        Integer valueOf = Integer.valueOf(feedCommentViewHolder.getAbsoluteAdapterPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            FeedCommentModel invoke = feedCommentViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(valueOf.intValue()));
            int itemId = menuItem.getItemId();
            if (itemId == R.id.option_delete) {
                feedCommentViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(feedCommentViewHolder.getAbsoluteAdapterPosition(), invoke);
            } else if (itemId == R.id.option_report) {
                feedCommentViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(feedCommentViewHolder.getAbsoluteAdapterPosition(), invoke);
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FeedCommentViewHolder feedCommentViewHolder) {
        Intrinsics.checkNotNullParameter(feedCommentViewHolder, "");
        Integer valueOf = Integer.valueOf(feedCommentViewHolder.getAbsoluteAdapterPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            feedCommentViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(feedCommentViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(valueOf.intValue())));
        }
    }

    public static /* synthetic */ void PlaceComponentResult(FeedCommentViewHolder feedCommentViewHolder, View view) {
        Intrinsics.checkNotNullParameter(feedCommentViewHolder, "");
        FeedCommentModel invoke = feedCommentViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(feedCommentViewHolder.getAbsoluteAdapterPosition()));
        if (feedCommentViewHolder.BuiltInFictitiousFunctionClassFactory) {
            if (invoke.getGetErrorConfigVersion()) {
                Intrinsics.checkNotNullExpressionValue(view, "");
                feedCommentViewHolder.getAuthRequestContext(view, R.menu.f46522131623936);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(view, "");
            feedCommentViewHolder.getAuthRequestContext(view, R.menu.f46562131623941);
        } else if (invoke.getGetErrorConfigVersion()) {
            Intrinsics.checkNotNullExpressionValue(view, "");
            feedCommentViewHolder.getAuthRequestContext(view, R.menu.f46522131623936);
        } else {
            Intrinsics.checkNotNullExpressionValue(view, "");
            feedCommentViewHolder.getAuthRequestContext(view, R.menu.f46552131623940);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedCommentView feedCommentView, FeedCommentViewHolder feedCommentViewHolder) {
        Intrinsics.checkNotNullParameter(feedCommentView, "");
        Intrinsics.checkNotNullParameter(feedCommentViewHolder, "");
        FeedCommentInteraction feedCommentInteraction = feedCommentView.getFeedCommentInteraction();
        if (feedCommentInteraction != null) {
            feedCommentInteraction.PlaceComponentResult(feedCommentViewHolder.MyBillsEntityDataFactory.invoke(Integer.valueOf(feedCommentViewHolder.getAbsoluteAdapterPosition())));
        }
    }
}
