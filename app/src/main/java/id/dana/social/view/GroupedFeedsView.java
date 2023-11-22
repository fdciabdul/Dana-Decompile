package id.dana.social.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.databinding.ViewGroupedFeedBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.constant.FeedContentType;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.utils.FeedRegexData;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b5\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b \u0010\u0014J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R*\u0010+\u001a\u00020!2\u0006\u0010%\u001a\u00020!8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010$R\"\u0010-\u001a\u00020,8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102"}, d2 = {"Lid/dana/social/view/GroupedFeedsView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewGroupedFeedBinding;", "", "getLayout", "()I", "", "hideCaptionSection", "()V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewGroupedFeedBinding;", "Landroid/view/View$OnClickListener;", "onClickListener", "setBubbleFeedOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", MaintenanceBroadcastResult.KEY_DATE, "setDate", "(Ljava/lang/String;)V", "Lid/dana/social/utils/FeedRegexData;", "data", "setDesc", "(Lid/dana/social/utils/FeedRegexData;)V", "", "listOfUrl", "setProfileAvatar", "(Ljava/util/List;)V", "setProfileImageClickListener", "setup", "contentType", "setupNotificationTypeBadge", "", "read", "toggleUnreadNotificationBadge", "(Z)V", "value", "BuiltInFictitiousFunctionClassFactory", "Z", "getNotificationMode", "()Z", "setNotificationMode", "notificationMode", "Lid/dana/social/adapter/SocialFeedClickListener;", "socialFeedClickListener", "Lid/dana/social/adapter/SocialFeedClickListener;", "getSocialFeedClickListener", "()Lid/dana/social/adapter/SocialFeedClickListener;", "setSocialFeedClickListener", "(Lid/dana/social/adapter/SocialFeedClickListener;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupedFeedsView extends ViewBindingRichView<ViewGroupedFeedBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean notificationMode;
    public Map<Integer, View> _$_findViewCache;
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
        return R.layout.view_grouped_feed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupedFeedsView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupedFeedsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
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

    @JvmName(name = "getNotificationMode")
    public final boolean getNotificationMode() {
        return this.notificationMode;
    }

    @JvmName(name = "setNotificationMode")
    public final void setNotificationMode(boolean z) {
        this.notificationMode = z;
        CircleImageView circleImageView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        circleImageView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewGroupedFeedBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewGroupedFeedBinding PlaceComponentResult = ViewGroupedFeedBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setProfileAvatar(List<String> listOfUrl) {
        Intrinsics.checkNotNullParameter(listOfUrl, "");
        if (listOfUrl.size() > 1) {
            CircleImageView circleImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView, listOfUrl.get(0), R.drawable.avatar_placeholder);
            CircleImageView circleImageView2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView2, listOfUrl.get(1), R.drawable.avatar_placeholder);
        } else if (listOfUrl.size() == 1) {
            CircleImageView circleImageView3 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView3, "");
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView3, listOfUrl.get(0), R.drawable.avatar_placeholder);
            CircleImageView circleImageView4 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(circleImageView4, "");
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView4, listOfUrl.get(0), R.drawable.avatar_placeholder);
        }
    }

    public final void setBubbleFeedOnClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        getBinding().scheduleImpl.setOnClickListener(onClickListener);
    }

    public final void setDesc(FeedRegexData data) {
        Intrinsics.checkNotNullParameter(data, "");
        BubbleFeedView bubbleFeedView = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(bubbleFeedView, "");
        BubbleFeedView.setDesc$default(bubbleFeedView, data, false, 2, null);
    }

    public final void setDate(String date) {
        if (date != null) {
            getBinding().scheduleImpl.setDate(date);
        }
    }

    public final void setProfileImageClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(onClickListener);
    }

    public final void setupNotificationTypeBadge(String contentType) {
        Intrinsics.checkNotNullParameter(contentType, "");
        CircleImageView circleImageView = getBinding().MyBillsEntityDataFactory;
        FeedContentType.Companion companion = FeedContentType.INSTANCE;
        __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView, FeedContentType.Companion.MyBillsEntityDataFactory(contentType));
    }

    public final void toggleUnreadNotificationBadge(boolean read) {
        ImageView imageView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(read ^ true ? 0 : 8);
    }

    public final void hideCaptionSection() {
        getBinding().scheduleImpl.showCaptionSection(false);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ViewExtKt.PlaceComponentResult(getBinding().scheduleImpl.getViewBubbleFeedBg(), 4.0f);
        ViewExtKt.PlaceComponentResult(getBinding().scheduleImpl.getIvTopLeftBubble(), 4.1f);
        View triangleSpacer = getBinding().scheduleImpl.getTriangleSpacer();
        if (OSUtil.scheduleImpl()) {
            triangleSpacer.setOutlineProvider(new ViewOutlineProvider() { // from class: id.dana.social.view.GroupedFeedsView$setDropShadow$1$1
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View p0, Outline p1) {
                    if (p1 != null) {
                        p1.setRect(0, 0, 0, 0);
                    }
                }
            });
        }
        ViewExtKt.PlaceComponentResult(triangleSpacer, 4.1f);
        ConstraintLayout clFeed = getBinding().scheduleImpl.getClFeed();
        if (OSUtil.scheduleImpl()) {
            clFeed.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        ViewExtKt.PlaceComponentResult(clFeed, 4.1f);
    }
}
