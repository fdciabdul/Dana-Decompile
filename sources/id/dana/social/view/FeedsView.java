package id.dana.social.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.databinding.ViewFeedBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.constant.FeedContentType;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.FeedModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bZ\u0010[B\u001d\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bZ\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010 \u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0013¢\u0006\u0004\b#\u0010\u0016J\u001b\u0010%\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\bJ\u0015\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0013¢\u0006\u0004\b5\u0010\u0016J\u0015\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020+¢\u0006\u0004\b7\u0010.J\u0015\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u00020+¢\u0006\u0004\b8\u0010.R\"\u0010;\u001a\u00020+8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010.R*\u0010B\u001a\u00020+2\u0006\u0010>\u001a\u00020+8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010.R*\u0010F\u001a\u00020+2\u0006\u0010>\u001a\u00020+8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010:\u001a\u0004\bD\u0010<\"\u0004\bE\u0010.R*\u0010J\u001a\u00020+2\u0006\u0010>\u001a\u00020+8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010:\u001a\u0004\bH\u0010<\"\u0004\bI\u0010.R*\u0010N\u001a\u00020+2\u0006\u0010>\u001a\u00020+8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010:\u001a\u0004\bL\u0010<\"\u0004\bM\u0010.R*\u0010R\u001a\u00020+2\u0006\u0010>\u001a\u00020+8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010:\u001a\u0004\bP\u0010<\"\u0004\bQ\u0010.R\"\u0010T\u001a\u00020S8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y"}, d2 = {"Lid/dana/social/view/FeedsView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedBinding;", "", "getLayout", "()I", "", "hideRetryAndSharingMessage", "()V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "caption", "setCaption", "(Ljava/lang/String;)V", MaintenanceBroadcastResult.KEY_DATE, "setDate", "Lid/dana/social/utils/FeedRegexData;", "data", "setDesc", "(Lid/dana/social/utils/FeedRegexData;)V", "Lkotlin/Function0;", "onDeleteActivity", "onRetryActivity", "setOnRetryClickListener", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "url", "setProfileAvatar", "avatarClick", "setProfileImageClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lid/dana/social/model/FeedModel;", "feedModel", "setReaction", "(Lid/dana/social/model/FeedModel;)V", "", MaintenanceBroadcastResult.KEY_VISIBLE, "setReactionVisibility", "(Z)V", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "feedState", "setState", "(Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)V", "setup", "contentType", "setupNotificationTypeBadge", "read", "showUnreadBadge", "toggleUnreadNotificationBadge", "PlaceComponentResult", "Z", "isReplyCommentEnabled", "()Z", "setReplyCommentEnabled", "value", "KClassImpl$Data$declaredNonStaticMembers$2", "getNotificationMode", "setNotificationMode", "notificationMode", "BuiltInFictitiousFunctionClassFactory", "getShowCaptionSection", "setShowCaptionSection", "showCaptionSection", "MyBillsEntityDataFactory", "getShowCommentButton", "setShowCommentButton", "showCommentButton", "getAuthRequestContext", "getShowSaymojiButton", "setShowSaymojiButton", "showSaymojiButton", "scheduleImpl", "getShowSaymojiReactionSectionView", "setShowSaymojiReactionSectionView", "showSaymojiReactionSectionView", "Lid/dana/social/adapter/SocialFeedClickListener;", "socialFeedClickListener", "Lid/dana/social/adapter/SocialFeedClickListener;", "getSocialFeedClickListener", "()Lid/dana/social/adapter/SocialFeedClickListener;", "setSocialFeedClickListener", "(Lid/dana/social/adapter/SocialFeedClickListener;)V", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsView extends ViewBindingRichView<ViewFeedBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean showCaptionSection;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean notificationMode;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean showCommentButton;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean isReplyCommentEnabled;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean showSaymojiButton;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean showSaymojiReactionSectionView;
    public SocialFeedClickListener socialFeedClickListener;

    public static void __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(CircleImageView circleImageView, int i) {
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, i);
        } else {
            circleImageView.setImageResource(i);
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
        return R.layout.view_feed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.showSaymojiReactionSectionView = true;
        this.showSaymojiButton = true;
        this.showCommentButton = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.showSaymojiReactionSectionView = true;
        this.showSaymojiButton = true;
        this.showCommentButton = true;
    }

    public /* synthetic */ FeedsView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getSocialFeedClickListener")
    public final SocialFeedClickListener getSocialFeedClickListener() {
        SocialFeedClickListener socialFeedClickListener = this.socialFeedClickListener;
        if (socialFeedClickListener != null) {
            return socialFeedClickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSocialFeedClickListener")
    public final void setSocialFeedClickListener(SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.socialFeedClickListener = socialFeedClickListener;
    }

    @JvmName(name = "isReplyCommentEnabled")
    /* renamed from: isReplyCommentEnabled  reason: from getter */
    public final boolean getIsReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    @JvmName(name = "setReplyCommentEnabled")
    public final void setReplyCommentEnabled(boolean z) {
        this.isReplyCommentEnabled = z;
    }

    @JvmName(name = "getShowSaymojiReactionSectionView")
    public final boolean getShowSaymojiReactionSectionView() {
        return this.showSaymojiReactionSectionView;
    }

    @JvmName(name = "setShowSaymojiReactionSectionView")
    public final void setShowSaymojiReactionSectionView(boolean z) {
        this.showSaymojiReactionSectionView = z;
        getBinding().MyBillsEntityDataFactory.setSaymojiReactionSectionView(z);
    }

    @JvmName(name = "getShowSaymojiButton")
    public final boolean getShowSaymojiButton() {
        return this.showSaymojiButton;
    }

    @JvmName(name = "setShowSaymojiButton")
    public final void setShowSaymojiButton(boolean z) {
        this.showSaymojiButton = z;
        if (z) {
            getBinding().MyBillsEntityDataFactory.showSaymojiButton();
        } else {
            getBinding().MyBillsEntityDataFactory.hideSaymojiButton();
        }
    }

    @JvmName(name = "getShowCommentButton")
    public final boolean getShowCommentButton() {
        return this.showCommentButton;
    }

    @JvmName(name = "setShowCommentButton")
    public final void setShowCommentButton(boolean z) {
        this.showCommentButton = z;
        if (z) {
            getBinding().MyBillsEntityDataFactory.showCommentButton();
        } else {
            getBinding().MyBillsEntityDataFactory.hideCommentButton();
        }
    }

    @JvmName(name = "getNotificationMode")
    public final boolean getNotificationMode() {
        return this.notificationMode;
    }

    @JvmName(name = "setNotificationMode")
    public final void setNotificationMode(boolean z) {
        this.notificationMode = z;
        CircleImageView circleImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        circleImageView.setVisibility(z ? 0 : 8);
        setShowCommentButton(false);
        setShowSaymojiButton(false);
        setShowSaymojiReactionSectionView(false);
    }

    @JvmName(name = "getShowCaptionSection")
    public final boolean getShowCaptionSection() {
        return this.showCaptionSection;
    }

    @JvmName(name = "setShowCaptionSection")
    public final void setShowCaptionSection(boolean z) {
        this.showCaptionSection = z;
        getBinding().MyBillsEntityDataFactory.showCaptionSection(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFeedBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewFeedBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.RequestMoneyQrContract$View);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            setShowCommentButton(obtainStyledAttributes.getBoolean(0, true));
            setShowSaymojiButton(obtainStyledAttributes.getBoolean(1, true));
            setShowSaymojiReactionSectionView(obtainStyledAttributes.getBoolean(2, true));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setProfileAvatar(String url) {
        Intrinsics.checkNotNullParameter(url, "");
        CircleImageView circleImageView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView, url, R.drawable.avatar_placeholder);
    }

    public final void setDesc(FeedRegexData data) {
        Intrinsics.checkNotNullParameter(data, "");
        BubbleFeedView bubbleFeedView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(bubbleFeedView, "");
        BubbleFeedView.setDesc$default(bubbleFeedView, data, false, 2, null);
    }

    public final void setDate(String date) {
        if (date != null) {
            getBinding().MyBillsEntityDataFactory.setDate(date);
        }
    }

    public final void showUnreadBadge(boolean read) {
        ImageView imageView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(read ^ true ? 0 : 8);
    }

    public final void toggleUnreadNotificationBadge(boolean read) {
        ImageView imageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(read ^ true ? 0 : 8);
    }

    public final void setupNotificationTypeBadge(String contentType) {
        Intrinsics.checkNotNullParameter(contentType, "");
        CircleImageView circleImageView = getBinding().getAuthRequestContext;
        FeedContentType.Companion companion = FeedContentType.INSTANCE;
        __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView, FeedContentType.Companion.MyBillsEntityDataFactory(contentType));
    }

    public final void setProfileImageClickListener(final Function0<Unit> avatarClick) {
        Intrinsics.checkNotNullParameter(avatarClick, "");
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedsView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsView.$r8$lambda$pG0Z3TJZKqSTYtX1qYwZm1JMq7Q(Function0.this, view);
            }
        });
    }

    public final void setOnRetryClickListener(final Function0<Unit> onDeleteActivity, final Function0<Unit> onRetryActivity) {
        Intrinsics.checkNotNullParameter(onDeleteActivity, "");
        Intrinsics.checkNotNullParameter(onRetryActivity, "");
        getBinding().MyBillsEntityDataFactory.getIbBubbleFeedRetry().setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedsView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsView.$r8$lambda$Q5U623WjzHfHrBmO31yGKV5qp5U(FeedsView.this, onDeleteActivity, onRetryActivity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(Function0 function0, Function0 function02, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.option_delete) {
            function02.invoke();
            return true;
        } else if (itemId == R.id.option_retry) {
            function0.invoke();
            return true;
        } else {
            return true;
        }
    }

    public final void setReaction(final FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        getBinding().MyBillsEntityDataFactory.setFeedReactions(feedModel);
        getBinding().MyBillsEntityDataFactory.getIbBubbleFeedAddSaymoji().setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsView.$r8$lambda$JnymOyn7fPJ3ntmY3bJiPDqtBHE(FeedsView.this, feedModel, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.getIbBubbleFeedAddComment().setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedsView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsView.$r8$lambda$cBglyWZz0wo2bHUx4dGumGEEw44(FeedsView.this, feedModel, view);
            }
        });
    }

    public final void setReactionVisibility(boolean visible) {
        getBinding().MyBillsEntityDataFactory.setFeedReactionVisibility(visible);
    }

    public final void setCaption(String caption) {
        getBinding().MyBillsEntityDataFactory.showCaption(caption);
    }

    public final void setState(FeedActivityState feedState) {
        Intrinsics.checkNotNullParameter(feedState, "");
        BubbleFeedView bubbleFeedView = getBinding().MyBillsEntityDataFactory;
        setShowSaymojiReactionSectionView(!this.notificationMode && feedState == FeedActivityState.SUCCESS);
        setShowCommentButton(!this.notificationMode && feedState == FeedActivityState.SUCCESS && this.showCommentButton);
        setShowSaymojiButton(!this.notificationMode && feedState == FeedActivityState.SUCCESS);
        bubbleFeedView.showRetryButton(feedState == FeedActivityState.ERROR);
        bubbleFeedView.showSharingMessage(feedState != FeedActivityState.SUCCESS);
        bubbleFeedView.setSharingMessage(feedState);
    }

    public final void hideRetryAndSharingMessage() {
        BubbleFeedView bubbleFeedView = getBinding().MyBillsEntityDataFactory;
        bubbleFeedView.showRetryButton(false);
        bubbleFeedView.showSharingMessage(false);
    }

    public static /* synthetic */ void $r8$lambda$JnymOyn7fPJ3ntmY3bJiPDqtBHE(FeedsView feedsView, FeedModel feedModel, View view) {
        Intrinsics.checkNotNullParameter(feedsView, "");
        Intrinsics.checkNotNullParameter(feedModel, "");
        feedsView.getBinding().MyBillsEntityDataFactory.triggerAddNewReactions(feedModel);
    }

    public static /* synthetic */ void $r8$lambda$Q5U623WjzHfHrBmO31yGKV5qp5U(FeedsView feedsView, final Function0 function0, final Function0 function02, View view) {
        Intrinsics.checkNotNullParameter(feedsView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Context context = feedsView.getContext();
        Intrinsics.checkNotNull(context);
        PopupMenu popupMenu = new PopupMenu(context, feedsView.getBinding().MyBillsEntityDataFactory.getIbBubbleFeedRetry(), 8388613, 0, R.style.f53992132017893);
        new SupportMenuInflater(popupMenu.BuiltInFictitiousFunctionClassFactory).inflate(R.menu.f46572131623942, popupMenu.PlaceComponentResult);
        popupMenu.KClassImpl$Data$declaredNonStaticMembers$2 = new PopupMenu.OnMenuItemClickListener() { // from class: id.dana.social.view.FeedsView$$ExternalSyntheticLambda4
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean getAuthRequestContext(MenuItem menuItem) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = FeedsView.MyBillsEntityDataFactory(Function0.this, function0, menuItem);
                return MyBillsEntityDataFactory;
            }
        };
        if (!popupMenu.mPopup.MyBillsEntityDataFactory()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public static /* synthetic */ void $r8$lambda$cBglyWZz0wo2bHUx4dGumGEEw44(FeedsView feedsView, FeedModel feedModel, View view) {
        Intrinsics.checkNotNullParameter(feedsView, "");
        Intrinsics.checkNotNullParameter(feedModel, "");
        SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
        Context context = feedsView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        SocialActivityDetail.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, feedModel, false);
    }

    public static /* synthetic */ void $r8$lambda$pG0Z3TJZKqSTYtX1qYwZm1JMq7Q(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ViewExtKt.PlaceComponentResult(getBinding().MyBillsEntityDataFactory.getViewBubbleFeedBg(), 4.0f);
        ViewExtKt.PlaceComponentResult(getBinding().MyBillsEntityDataFactory.getIvTopLeftBubble(), 4.1f);
        ViewExtKt.PlaceComponentResult(getBinding().MyBillsEntityDataFactory.getIbBubbleFeedAddSaymoji(), 5.0f);
        ViewExtKt.PlaceComponentResult(getBinding().MyBillsEntityDataFactory.getIbBubbleFeedAddComment(), 5.0f);
        ViewExtKt.PlaceComponentResult(getBinding().MyBillsEntityDataFactory.getIbBubbleFeedRetry(), 5.0f);
        View triangleSpacer = getBinding().MyBillsEntityDataFactory.getTriangleSpacer();
        if (OSUtil.scheduleImpl()) {
            triangleSpacer.setOutlineProvider(new ViewOutlineProvider() { // from class: id.dana.social.view.FeedsView$setDropShadow$1$1
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View p0, Outline p1) {
                    if (p1 != null) {
                        p1.setRect(0, 0, 0, 0);
                    }
                }
            });
        }
        ViewExtKt.PlaceComponentResult(triangleSpacer, 4.1f);
        ConstraintLayout clFeed = getBinding().MyBillsEntityDataFactory.getClFeed();
        if (OSUtil.scheduleImpl()) {
            clFeed.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        ViewExtKt.PlaceComponentResult(clFeed, 4.1f);
    }
}
