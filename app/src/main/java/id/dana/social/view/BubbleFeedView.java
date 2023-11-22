package id.dana.social.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.databinding.ViewBubbleFeedBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.social.model.FeedModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.view.ClickableMovementMethod;
import id.dana.utils.SizeUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\bU\u0010VB\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bU\u0010\u0016J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001e¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010\u0005J\u0015\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010$J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u001e¢\u0006\u0004\b-\u0010$J\u0015\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b3\u0010\u001bJ\u0015\u00104\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u001e¢\u0006\u0004\b4\u0010$J\r\u00105\u001a\u00020\u0003¢\u0006\u0004\b5\u0010\u0005J\u0015\u00106\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u001e¢\u0006\u0004\b6\u0010$J\u0015\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001e¢\u0006\u0004\b8\u0010$J\r\u00109\u001a\u00020\u0003¢\u0006\u0004\b9\u0010\u0005J\u0015\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u001e¢\u0006\u0004\b:\u0010$J\u0015\u0010;\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b;\u0010+R\u0011\u0010?\u001a\u00020<8G¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010C\u001a\u00020@8G¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010E\u001a\u00020@8G¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0011\u0010G\u001a\u00020@8G¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0011\u0010K\u001a\u00020H8G¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010L\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0011\u0010R\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010T\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\bS\u0010Q"}, d2 = {"Lid/dana/social/view/BubbleFeedView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewBubbleFeedBinding;", "", "addPaddingBottom", "()V", "", "getCaptionLinesCount", "()I", "getLayout", "hideCommentButton", "hideSaymojiButton", "hideSpace", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewBubbleFeedBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "removeCaptionConstraint", "", MaintenanceBroadcastResult.KEY_DATE, "setDate", "(Ljava/lang/String;)V", "Lid/dana/social/utils/FeedRegexData;", "feedRegexData", "", "actorTextBold", "setDesc", "(Lid/dana/social/utils/FeedRegexData;Z)V", "isUsingDefaultConstraint", "setDescriptionConstraint", "(Z)V", "setDescriptionMinLines", MaintenanceBroadcastResult.KEY_VISIBLE, "setFeedReactionVisibility", "Lid/dana/social/model/FeedModel;", "feedModel", "setFeedReactions", "(Lid/dana/social/model/FeedModel;)V", "isVisible", "setSaymojiReactionSectionView", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "feedState", "setSharingMessage", "(Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)V", "caption", "showCaption", "showCaptionSection", "showCommentButton", "showDateSection", ContainerUIProvider.KEY_SHOW, "showRetryButton", "showSaymojiButton", "showSharingMessage", "triggerAddNewReactions", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClFeed", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "clFeed", "Landroid/widget/ImageButton;", "getIbBubbleFeedAddComment", "()Landroid/widget/ImageButton;", "ibBubbleFeedAddComment", "getIbBubbleFeedAddSaymoji", "ibBubbleFeedAddSaymoji", "getIbBubbleFeedRetry", "ibBubbleFeedRetry", "Landroid/widget/ImageView;", "getIvTopLeftBubble", "()Landroid/widget/ImageView;", "ivTopLeftBubble", "PlaceComponentResult", "I", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "getTriangleSpacer", "()Landroid/view/View;", "triangleSpacer", "getViewBubbleFeedBg", "viewBubbleFeedBg", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BubbleFeedView extends ViewBindingRichView<ViewBubbleFeedBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private View PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FeedActivityState.values().length];
            iArr[FeedActivityState.INIT.ordinal()] = 1;
            iArr[FeedActivityState.ERROR.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

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
        return R.layout.view_bubble_feed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleFeedView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewBubbleFeedBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewBubbleFeedBinding PlaceComponentResult = ViewBubbleFeedBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @JvmName(name = "getViewBubbleFeedBg")
    public final View getViewBubbleFeedBg() {
        View view = getBinding().PrepareContext;
        Intrinsics.checkNotNullExpressionValue(view, "");
        return view;
    }

    @JvmName(name = "getIvTopLeftBubble")
    public final ImageView getIvTopLeftBubble() {
        ImageView imageView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        return imageView;
    }

    @JvmName(name = "getTriangleSpacer")
    public final View getTriangleSpacer() {
        View view = getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(view, "");
        return view;
    }

    @JvmName(name = "getClFeed")
    public final ConstraintLayout getClFeed() {
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @JvmName(name = "getIbBubbleFeedRetry")
    public final ImageButton getIbBubbleFeedRetry() {
        ImageButton imageButton = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        return imageButton;
    }

    @JvmName(name = "getIbBubbleFeedAddSaymoji")
    public final ImageButton getIbBubbleFeedAddSaymoji() {
        ImageButton imageButton = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        return imageButton;
    }

    @JvmName(name = "getIbBubbleFeedAddComment")
    public final ImageButton getIbBubbleFeedAddComment() {
        ImageButton imageButton = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        return imageButton;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        super.parseAttrs(context, attrs);
        if (attrs == null || context == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.B);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            boolean z = obtainStyledAttributes.getBoolean(0, false);
            ReactionSectionView reactionSectionView = getBinding().lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(reactionSectionView, "");
            reactionSectionView.setVisibility(!(z ^ true) ? 8 : 0);
            if (z) {
                setSaymojiReactionSectionView(false);
                hideSaymojiButton();
                hideCommentButton();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void hideCommentButton() {
        getBinding().MyBillsEntityDataFactory.setVisibility(8);
        getBinding().lookAheadTest.setShowCommentCount(false);
    }

    public final void showCommentButton() {
        getBinding().MyBillsEntityDataFactory.setVisibility(0);
        getBinding().lookAheadTest.setShowCommentCount(true);
    }

    public final void showSaymojiButton() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(0);
    }

    public final void hideSaymojiButton() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(8);
    }

    public final void setSaymojiReactionSectionView(boolean isVisible) {
        ReactionSectionView reactionSectionView = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(reactionSectionView, "");
        reactionSectionView.setVisibility(isVisible ? 0 : 8);
    }

    public static /* synthetic */ void setDesc$default(BubbleFeedView bubbleFeedView, FeedRegexData feedRegexData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bubbleFeedView.setDesc(feedRegexData, z);
    }

    public final void setDesc(FeedRegexData feedRegexData, boolean actorTextBold) {
        Spannable PlaceComponentResult;
        Intrinsics.checkNotNullParameter(feedRegexData, "");
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
        PlaceComponentResult = FeedsContentUtils.PlaceComponentResult(feedRegexData, actorTextBold, true);
        textView.setText(PlaceComponentResult);
        ClickableMovementMethod.Companion companion = ClickableMovementMethod.INSTANCE;
        textView.setMovementMethod(ClickableMovementMethod.Companion.MyBillsEntityDataFactory());
        textView.setClickable(false);
        textView.setLongClickable(false);
    }

    public final void setDate(String date) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setText(date);
    }

    public final void setFeedReactions(final FeedModel feedModel) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(feedModel, "");
        if (this.PlaceComponentResult != null) {
            getBinding().lookAheadTest.setReactionsContentView(feedModel, this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        final View findViewById = getBinding().lookAheadTest.findViewById(R.id.view_reaction_section_rv_ruler);
        this.PlaceComponentResult = findViewById;
        if (findViewById == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.social.view.BubbleFeedView$calculateReactionContainerThenSetContent$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ViewBubbleFeedBinding binding;
                int i;
                BubbleFeedView.this.BuiltInFictitiousFunctionClassFactory = MathKt.roundToInt(SizeUtil.PlaceComponentResult(findViewById.getMeasuredWidth()) / 78.0f);
                binding = BubbleFeedView.this.getBinding();
                ReactionSectionView reactionSectionView = binding.lookAheadTest;
                FeedModel feedModel2 = feedModel;
                i = BubbleFeedView.this.BuiltInFictitiousFunctionClassFactory;
                reactionSectionView.setReactionsContentView(feedModel2, i);
                findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public final void setFeedReactionVisibility(boolean visible) {
        ReactionSectionView reactionSectionView = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(reactionSectionView, "");
        reactionSectionView.setVisibility(visible ? 0 : 8);
    }

    public final void setDescriptionConstraint(boolean isUsingDefaultConstraint) {
        if (isUsingDefaultConstraint) {
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(getBinding().getAuthRequestContext);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1.getId(), 4, getBinding().PlaceComponentResult.getId(), 3);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().getAuthRequestContext);
    }

    public final void triggerAddNewReactions(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        getBinding().lookAheadTest.addNewReaction(feedModel);
    }

    public final void hideSpace() {
        Space space = getBinding().initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(space, "");
        space.setVisibility(8);
    }

    public final void showCaption(String caption) {
        String str = caption;
        if (str == null || str.length() == 0) {
            ConstraintLayout constraintLayout = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(8);
            return;
        }
        ConstraintLayout constraintLayout2 = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(0);
        TextView textView = getBinding().DatabaseTableConfigUtil;
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.quote);
        sb.append(caption);
        sb.append(Typography.quote);
        textView.setText(sb.toString());
    }

    public final void addPaddingBottom() {
        ConstraintLayout constraintLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, null, null, null, Integer.valueOf(getContext().getResources().getDimensionPixelSize(R.dimen.f28032131165270)), 7);
    }

    public final void showRetryButton(boolean show) {
        ImageButton imageButton = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageButton, "");
        imageButton.setVisibility(show ? 0 : 8);
    }

    public final void showSharingMessage(boolean show) {
        TextView textView = getBinding().isLayoutRequested;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(show ? 0 : 8);
        TextView textView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(show ? 4 : 0);
    }

    public final void setSharingMessage(FeedActivityState feedState) {
        Intrinsics.checkNotNullParameter(feedState, "");
        int i = WhenMappings.getAuthRequestContext[feedState.ordinal()];
        if (i == 1) {
            getBinding().isLayoutRequested.setText(getContext().getString(R.string.share_feed_loading_description));
            getBinding().isLayoutRequested.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23982131099995));
        } else if (i == 2) {
            getBinding().isLayoutRequested.setText(getContext().getString(R.string.share_feed_error_description));
            getBinding().isLayoutRequested.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f26712131100373));
        }
    }

    public final void showCaptionSection(boolean isVisible) {
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(isVisible ? 0 : 8);
    }

    public final void showDateSection(boolean isVisible) {
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    public final int getCaptionLinesCount() {
        return getBinding().DatabaseTableConfigUtil.getLineCount();
    }

    public final void removeCaptionConstraint() {
        ViewGroup.LayoutParams layoutParams = getBinding().PlaceComponentResult.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.lookAheadTest = -1;
        getBinding().PlaceComponentResult.setLayoutParams(layoutParams2);
    }

    public final void setDescriptionMinLines() {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1.setMinLines(3);
    }
}
