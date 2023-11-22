package id.dana.social.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFeedReactionSectionBinding;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.AddReactionBottomSheetDialog;
import id.dana.social.adapter.FeedReactionAdapter;
import id.dana.social.contract.reaction.ReactionsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.ReactionsModule;
import id.dana.social.model.FeedModel;
import id.dana.social.model.OwnReactionModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.model.ReactionResultModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TB\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\bR\u0010SB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bR\u0010!J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0018\u0010\u001bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0007J#\u0010 \u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0019J\u0015\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b)\u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010*J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010*J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010\u001bJ\u001f\u0010+\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\n\u0010\u001bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\n\u0010*J\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0-*\b\u0012\u0004\u0012\u00020\b0-H\u0002¢\u0006\u0004\b+\u0010.J\u001b\u0010\n\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\t\u001a\u00020\fH\u0002¢\u0006\u0004\b\n\u0010/J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0013*\b\u0012\u0004\u0012\u00020\b0-H\u0002¢\u0006\u0004\b\u0018\u0010.R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u00100R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u00108R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u00108R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u00109R7\u0010A\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b;\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020I0-8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bJ\u0010KR*\u0010Q\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bM\u00108\u001a\u0004\bN\u0010O\"\u0004\bP\u0010*"}, d2 = {"Lid/dana/social/view/ReactionSectionView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedReactionSectionBinding;", "Lid/dana/social/model/FeedModel;", "feedModel", "", "addNewReaction", "(Lid/dana/social/model/FeedModel;)V", "Lid/dana/social/model/ReactionCountModel;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/social/model/ReactionCountModel;)V", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedReactionSectionBinding;", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Lid/dana/social/model/ReactionCountModel;)Z", "PlaceComponentResult", "()V", "", "(Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lid/dana/social/adapter/FeedReactionAdapter;", "getAuthRequestContext", "(Lid/dana/social/adapter/FeedReactionAdapter;)V", "maxVisibleItem", "setReactionsContentView", "(Lid/dana/social/model/FeedModel;I)V", "setup", "setupDetailActivityView", "(Z)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/util/List;)Ljava/util/List;", "(Lid/dana/social/model/FeedModel;I)Z", "Lid/dana/social/model/FeedModel;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Z", "I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "getOnUpdateReactionCountAndInfo", "()Lkotlin/jvm/functions/Function1;", "setOnUpdateReactionCountAndInfo", "(Lkotlin/jvm/functions/Function1;)V", "onUpdateReactionCountAndInfo", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "presenter", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/reaction/ReactionsContract$Presenter;)V", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "lookAheadTest", "Ljava/util/List;", "value", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getShowCommentCount", "()Z", "setShowCommentCount", "showCommentCount", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionSectionView extends ViewBindingRichView<ViewFeedReactionSectionBinding> {
    public static final float MAX_REACTION_VIEW_WIDTH_IN_DP = 78.0f;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int PlaceComponentResult;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super FeedModel, Unit> onUpdateReactionCountAndInfo;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean showCommentCount;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedModel MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<ReactionModel> BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ReactionsContract.Presenter presenter;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_feed_reaction_section;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionSectionView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = 2;
        this.showCommentCount = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = 2;
        this.showCommentCount = true;
    }

    @JvmName(name = "getPresenter")
    public final ReactionsContract.Presenter getPresenter() {
        ReactionsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ReactionsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getFriendshipAnalyticTracker")
    public final FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker != null) {
            return friendshipAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
        this.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    @JvmName(name = "getOnUpdateReactionCountAndInfo")
    public final Function1<FeedModel, Unit> getOnUpdateReactionCountAndInfo() {
        return this.onUpdateReactionCountAndInfo;
    }

    @JvmName(name = "setOnUpdateReactionCountAndInfo")
    public final void setOnUpdateReactionCountAndInfo(Function1<? super FeedModel, Unit> function1) {
        this.onUpdateReactionCountAndInfo = function1;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFeedReactionSectionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedReactionSectionBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewFeedReactionSectionBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getShowCommentCount")
    public final boolean getShowCommentCount() {
        return this.showCommentCount;
    }

    @JvmName(name = "setShowCommentCount")
    public final void setShowCommentCount(boolean z) {
        this.showCommentCount = z;
        FeedModel feedModel = this.MyBillsEntityDataFactory;
        if (feedModel != null) {
            if (feedModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedModel = null;
            }
            PlaceComponentResult(feedModel);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r2, AttributeSet attrs) {
        if (attrs == null || r2 == null) {
            return;
        }
        TypedArray obtainStyledAttributes = r2.obtainStyledAttributes(attrs, R.styleable.CreateOrderTopUpFamilyBalance);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            this.getAuthRequestContext = obtainStyledAttributes.getBoolean(1, false);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ void setReactionsContentView$default(ReactionSectionView reactionSectionView, FeedModel feedModel, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 30;
        }
        reactionSectionView.setReactionsContentView(feedModel, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setReactionsContentView(id.dana.social.model.FeedModel r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r7.MyBillsEntityDataFactory = r8
            r1 = 0
            if (r8 != 0) goto Le
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r8 = r1
        Le:
            java.util.List<id.dana.social.model.ReactionCountModel> r8 = r8.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r2 = 1
            r8 = r8 ^ r2
            r3 = 0
            if (r8 != 0) goto L29
            id.dana.social.model.FeedModel r8 = r7.MyBillsEntityDataFactory
            if (r8 != 0) goto L23
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r8 = r1
        L23:
            int r8 = r8.getAuthRequestContext
            if (r8 > 0) goto L29
            r8 = 0
            goto L2a
        L29:
            r8 = 1
        L2a:
            r7.MyBillsEntityDataFactory(r8)
            id.dana.social.model.FeedModel r8 = r7.MyBillsEntityDataFactory
            if (r8 != 0) goto L35
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r8 = r1
        L35:
            java.util.List<id.dana.social.model.ReactionCountModel> r8 = r8.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            androidx.viewbinding.ViewBinding r4 = r7.getBinding()
            id.dana.databinding.ViewFeedReactionSectionBinding r4 = (id.dana.databinding.ViewFeedReactionSectionBinding) r4
            androidx.recyclerview.widget.RecyclerView r4 = r4.getAuthRequestContext
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            r8 = r8 ^ r2
            if (r8 != 0) goto L4f
            r3 = 8
        L4f:
            r4.setVisibility(r3)
            r7.PlaceComponentResult = r9
            id.dana.social.view.ReactionSectionView$getOnReactionClickListener$1 r8 = new id.dana.social.view.ReactionSectionView$getOnReactionClickListener$1
            r8.<init>()
            id.dana.social.adapter.SocialFeedClickListener r8 = (id.dana.social.adapter.SocialFeedClickListener) r8
            id.dana.social.model.FeedModel r3 = r7.MyBillsEntityDataFactory
            if (r3 != 0) goto L63
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r3 = r1
        L63:
            java.util.List<id.dana.social.model.ReactionCountModel> r3 = r3.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.util.List r3 = BuiltInFictitiousFunctionClassFactory(r3)
            java.util.List r3 = PlaceComponentResult(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.take(r3, r9)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.toMutableList(r3)
            id.dana.social.view.ReactionSectionView$getFeedReactionClickListener$1 r4 = new id.dana.social.view.ReactionSectionView$getFeedReactionClickListener$1
            r4.<init>()
            id.dana.social.adapter.FeedReactionClickListener r4 = (id.dana.social.adapter.FeedReactionClickListener) r4
            boolean r5 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.social.adapter.FeedReactionAdapter r6 = new id.dana.social.adapter.FeedReactionAdapter
            r6.<init>(r8, r3, r4, r5)
            r6.setHasStableIds(r2)
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            id.dana.databinding.ViewFeedReactionSectionBinding r8 = (id.dana.databinding.ViewFeedReactionSectionBinding) r8
            androidx.recyclerview.widget.RecyclerView r8 = r8.getAuthRequestContext
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = (androidx.recyclerview.widget.RecyclerView.Adapter) r6
            r8.setAdapter(r6)
            id.dana.social.model.FeedModel r8 = r7.MyBillsEntityDataFactory
            if (r8 != 0) goto L9f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r8 = r1
        L9f:
            boolean r8 = MyBillsEntityDataFactory(r8, r9)
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r8)
            id.dana.social.model.FeedModel r8 = r7.MyBillsEntityDataFactory
            if (r8 != 0) goto Lae
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto Laf
        Lae:
            r1 = r8
        Laf:
            r7.PlaceComponentResult(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.ReactionSectionView.setReactionsContentView(id.dana.social.model.FeedModel, int):void");
    }

    public final void setupDetailActivityView(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        this.MyBillsEntityDataFactory = feedModel;
        final FeedModel feedModel2 = null;
        if (feedModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedModel = null;
        }
        boolean isEmpty = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty();
        getBinding().PlaceComponentResult.setVisibility(8);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
        FeedModel feedModel3 = this.MyBillsEntityDataFactory;
        if (feedModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            feedModel2 = feedModel3;
        }
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(0);
        getBinding().MyBillsEntityDataFactory.setVisibility(4);
        ReactionView reactionView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        reactionView.setVisibility(0);
        reactionView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.ReactionSectionView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReactionSectionView.$r8$lambda$JpAN8RXlkfopY4y_GTGXXvBx9G0(ReactionSectionView.this, feedModel2, view);
            }
        });
        getAuthRequestContext(!isEmpty);
        getPresenter().getAuthRequestContext();
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        View view = getBinding().initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(p0 ? 0 : 8);
        LinearLayout linearLayout = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(p0 && !this.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : 8);
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(p0 ? 0 : 8);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            View view2 = getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(view2, "");
            view2.setVisibility(8);
            View view3 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullExpressionValue(view3, "");
            view3.setVisibility(8);
            ReactionView reactionView = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(reactionView, "");
            reactionView.setVisibility(8);
        }
    }

    private final void PlaceComponentResult() {
        Function1<? super FeedModel, Unit> function1 = this.onUpdateReactionCountAndInfo;
        if (function1 != null) {
            FeedModel feedModel = this.MyBillsEntityDataFactory;
            if (feedModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedModel = null;
            }
            function1.invoke(feedModel);
        }
    }

    private final void MyBillsEntityDataFactory(ReactionCountModel p0) {
        FeedModel feedModel = this.MyBillsEntityDataFactory;
        if (feedModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedModel = null;
        }
        List<OwnReactionModel> list = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        list.add(new OwnReactionModel(str != null ? str : "", p0.PlaceComponentResult));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ReactionView reactionView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(reactionView, "");
        reactionView.setVisibility(p0 ? 0 : 8);
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.ReactionSectionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReactionSectionView.$r8$lambda$FCBrQrZDrLueJTAl9zhCVgtuPuo(ReactionSectionView.this, view);
            }
        });
    }

    static /* synthetic */ void PlaceComponentResult$default(ReactionSectionView reactionSectionView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        reactionSectionView.PlaceComponentResult(str);
    }

    public final void PlaceComponentResult(String p0) {
        FeedModel feedModel = this.MyBillsEntityDataFactory;
        FeedModel feedModel2 = null;
        if (feedModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedModel = null;
        }
        List<ReactionCountModel> mutableList = CollectionsKt.toMutableList((Collection) BuiltInFictitiousFunctionClassFactory(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8));
        Intrinsics.checkNotNullParameter(mutableList, "");
        feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = mutableList;
        FeedModel feedModel3 = this.MyBillsEntityDataFactory;
        if (feedModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            feedModel2 = feedModel3;
        }
        ActivityReactionsBottomSheetDialog activityReactionsBottomSheetDialog = new ActivityReactionsBottomSheetDialog(feedModel2, p0);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            activityReactionsBottomSheetDialog.show(baseActivity.getSupportFragmentManager(), "");
        }
    }

    private final void MyBillsEntityDataFactory(FeedModel p0) {
        AddReactionBottomSheetDialog.Companion companion = AddReactionBottomSheetDialog.INSTANCE;
        AddReactionBottomSheetDialog KClassImpl$Data$declaredNonStaticMembers$2 = AddReactionBottomSheetDialog.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0, new Function1<ReactionResultModel, Unit>() { // from class: id.dana.social.view.ReactionSectionView$openAddReactionScreen$addReactionDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ReactionResultModel reactionResultModel) {
                invoke2(reactionResultModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReactionResultModel reactionResultModel) {
                Intrinsics.checkNotNullParameter(reactionResultModel, "");
                ReactionSectionView.access$onReactionAdded(ReactionSectionView.this, reactionResultModel);
            }
        });
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.show(baseActivity.getSupportFragmentManager(), "addReactionDialog");
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<ReactionCountModel> p0, ReactionCountModel p1) {
        int i = 0;
        for (Object obj : p0) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReactionCountModel reactionCountModel = (ReactionCountModel) obj;
            if (reactionCountModel.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                reactionCountModel.getAuthRequestContext--;
                reactionCountModel.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                if (reactionCountModel.getAuthRequestContext == 0) {
                    p0.remove(i);
                    p0.add(0, p1);
                    return true;
                }
            }
            i++;
        }
        int size = p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (Intrinsics.areEqual(p0.get(i2).PlaceComponentResult, p1.PlaceComponentResult)) {
                p0.get(i2).getAuthRequestContext++;
                p0.get(i2).KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return true;
            }
        }
        return false;
    }

    public final void getAuthRequestContext(FeedReactionAdapter p0) {
        FeedModel feedModel = this.MyBillsEntityDataFactory;
        if (feedModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedModel = null;
        }
        List<ReactionCountModel> PlaceComponentResult = PlaceComponentResult(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.setItems(CollectionsKt.toMutableList((Collection) CollectionsKt.take(PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(PlaceComponentResult)), this.PlaceComponentResult)));
    }

    private static List<ReactionCountModel> BuiltInFictitiousFunctionClassFactory(List<ReactionCountModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ReactionCountModel) obj).getAuthRequestContext > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static List<ReactionCountModel> PlaceComponentResult(List<ReactionCountModel> list) {
        List sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.social.view.ReactionSectionView$sortReactions$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ReactionCountModel) t2).getAuthRequestContext), Integer.valueOf(((ReactionCountModel) t).getAuthRequestContext));
            }
        });
        ArrayList arrayList = new ArrayList();
        for (Object obj : sortedWith) {
            if (((ReactionCountModel) obj).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                arrayList.add(obj);
            }
        }
        List sortedWith2 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.social.view.ReactionSectionView$sortReactions$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ReactionCountModel) t).getAuthRequestContext), Integer.valueOf(((ReactionCountModel) t2).getAuthRequestContext));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : sortedWith) {
            if (!((ReactionCountModel) obj2).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.toMutableList((Collection) CollectionsKt.plus((Collection) sortedWith2, (Iterable) arrayList2));
    }

    public final void addNewReaction(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        MyBillsEntityDataFactory(feedModel);
    }

    private final void getAuthRequestContext(boolean p0) {
        if (this.getAuthRequestContext) {
            TextView textView = getBinding().getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(p0 ^ true ? 0 : 8);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
        getBinding().PlaceComponentResult.setVisibility(0);
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(", ");
        textView.setText(sb.toString());
        getBinding().PlaceComponentResult.setText(p1);
    }

    private final void getAuthRequestContext(String p0) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
        getBinding().PlaceComponentResult.setVisibility(0);
        getBinding().PlaceComponentResult.setText(p0);
    }

    private final void MyBillsEntityDataFactory(String p0) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
        getBinding().PlaceComponentResult.setVisibility(8);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(p0);
    }

    public static /* synthetic */ void $r8$lambda$FCBrQrZDrLueJTAl9zhCVgtuPuo(ReactionSectionView reactionSectionView, View view) {
        Intrinsics.checkNotNullParameter(reactionSectionView, "");
        PlaceComponentResult$default(reactionSectionView, null, 1, null);
    }

    public static /* synthetic */ void $r8$lambda$JpAN8RXlkfopY4y_GTGXXvBx9G0(ReactionSectionView reactionSectionView, FeedModel feedModel, View view) {
        Intrinsics.checkNotNullParameter(reactionSectionView, "");
        Intrinsics.checkNotNullParameter(feedModel, "");
        reactionSectionView.MyBillsEntityDataFactory(feedModel);
    }

    public static final /* synthetic */ void access$onReactionAdded(ReactionSectionView reactionSectionView, ReactionResultModel reactionResultModel) {
        RecyclerView recyclerView = reactionSectionView.getBinding().getAuthRequestContext;
        if (recyclerView.getAdapter() instanceof FeedReactionAdapter) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.social.adapter.FeedReactionAdapter");
            }
            FeedReactionAdapter feedReactionAdapter = (FeedReactionAdapter) adapter;
            FeedModel feedModel = reactionSectionView.MyBillsEntityDataFactory;
            FeedModel feedModel2 = null;
            if (feedModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedModel = null;
            }
            String str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            List<ReactionCountModel> items = feedReactionAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            Iterator<ReactionCountModel> it = items.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                feedReactionAdapter.PlaceComponentResult(i, null);
                ReactionsContract.Presenter presenter = reactionSectionView.getPresenter();
                List<ReactionCountModel> items2 = feedReactionAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items2, "");
                ReactionCountModel reactionCountModel = (ReactionCountModel) CollectionsKt.getOrNull(items2, i);
                String str2 = reactionCountModel != null ? reactionCountModel.BuiltInFictitiousFunctionClassFactory : null;
                if (str2 == null) {
                    str2 = "";
                }
                presenter.BuiltInFictitiousFunctionClassFactory(str2, str);
            }
            ReactionCountModel reactionCountModel2 = new ReactionCountModel(reactionResultModel.getAuthRequestContext, 0, true, null, 10, null);
            FeedModel feedModel3 = reactionSectionView.MyBillsEntityDataFactory;
            if (feedModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedModel3 = null;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2(feedModel3.NetworkUserEntityData$$ExternalSyntheticLambda8, reactionCountModel2)) {
                reactionSectionView.getAuthRequestContext(feedReactionAdapter);
            } else {
                Intrinsics.checkNotNullExpressionValue(recyclerView, "");
                feedReactionAdapter.prependItem(reactionCountModel2);
                recyclerView.smoothScrollToPosition(0);
                FeedModel feedModel4 = reactionSectionView.MyBillsEntityDataFactory;
                if (feedModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    feedModel4 = null;
                }
                feedModel4.NetworkUserEntityData$$ExternalSyntheticLambda8.add(0, reactionCountModel2);
                if (feedReactionAdapter.getGetAuthRequestContext() > reactionSectionView.PlaceComponentResult) {
                    reactionSectionView.getAuthRequestContext(feedReactionAdapter);
                    FeedModel feedModel5 = reactionSectionView.MyBillsEntityDataFactory;
                    if (feedModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        feedModel5 = null;
                    }
                    reactionSectionView.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(feedModel5, reactionSectionView.PlaceComponentResult));
                }
            }
            reactionSectionView.MyBillsEntityDataFactory(reactionCountModel2);
            reactionSectionView.MyBillsEntityDataFactory(feedReactionAdapter.getGetAuthRequestContext() > 0);
            if (!reactionSectionView.getAuthRequestContext) {
                FeedModel feedModel6 = reactionSectionView.MyBillsEntityDataFactory;
                if (feedModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    feedModel6 = null;
                }
                reactionSectionView.PlaceComponentResult(feedModel6);
            }
            FeedModel feedModel7 = reactionSectionView.MyBillsEntityDataFactory;
            if (feedModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                feedModel2 = feedModel7;
            }
            reactionSectionView.getAuthRequestContext(!feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty());
            reactionSectionView.PlaceComponentResult();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:213:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void access$toggleReaction(id.dana.social.view.ReactionSectionView r12, id.dana.social.model.ReactionCountModel r13) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.ReactionSectionView.access$toggleReaction(id.dana.social.view.ReactionSectionView, id.dana.social.model.ReactionCountModel):void");
    }

    private static boolean MyBillsEntityDataFactory(FeedModel feedModel, int i) {
        return feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8.size() > i;
    }

    private final void PlaceComponentResult(FeedModel p0) {
        Iterator<T> it = p0.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((ReactionCountModel) it.next()).getAuthRequestContext;
        }
        String quantityString = getContext().getResources().getQuantityString(R.plurals.f46772131820563, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "");
        int i2 = p0.getAuthRequestContext;
        String quantityString2 = getContext().getResources().getQuantityString(R.plurals.f46762131820562, i2, Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(quantityString2, "");
        if (i > 0 && i2 > 0 && this.showCommentCount) {
            BuiltInFictitiousFunctionClassFactory(quantityString, quantityString2);
        } else if (i2 > 0 && this.showCommentCount) {
            getAuthRequestContext(quantityString2);
        } else if (i > 0) {
            MyBillsEntityDataFactory(quantityString);
        } else {
            getBinding().PlaceComponentResult.setVisibility(8);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText("-");
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        DanaApplication danaApplication;
        SocialCommonComponent socialCommonComponent;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (danaApplication = baseActivity.getDanaApplication()) == null || (socialCommonComponent = danaApplication.getSocialCommonComponent()) == null) {
            return;
        }
        socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(new ReactionsModule(new ReactionsContract.View() { // from class: id.dana.social.view.ReactionSectionView$getReactionModuleView$1
            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final String BuiltInFictitiousFunctionClassFactory() {
                return "Reaction";
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DeleteReactionResult deleteReactionResult) {
                Intrinsics.checkNotNullParameter(deleteReactionResult, "");
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                ReactionsContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                ReactionsContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final /* synthetic */ void getAuthRequestContext(ReactionResultModel reactionResultModel) {
                ReactionsContract.View.CC.getAuthRequestContext(reactionResultModel);
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ReactionModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ReactionSectionView.this.BuiltInFictitiousFunctionClassFactory = p0;
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final void PlaceComponentResult(List<ReactionModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ReactionSectionView.this.BuiltInFictitiousFunctionClassFactory = p0;
            }

            @Override // id.dana.social.contract.reaction.ReactionsContract.View
            public final String getShownErrorMessage() {
                String shownErrorMessage;
                shownErrorMessage = ReactionSectionView.this.getShownErrorMessage();
                return shownErrorMessage;
            }
        })).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }
}
