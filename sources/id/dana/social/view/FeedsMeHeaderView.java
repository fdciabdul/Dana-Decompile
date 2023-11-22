package id.dana.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewHeaderFeedsMeBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b8\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\u001fJ\u0015\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001c¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\u0015\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\r¢\u0006\u0004\b&\u0010\u0010R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R*\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0005\"\u0004\b/\u00100R\u0013\u0010,\u001a\u000202X\u0083\u0082\u0002¢\u0006\u0006\n\u0004\b*\u00103"}, d2 = {"Lid/dana/social/view/FeedsMeHeaderView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewHeaderFeedsMeBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewHeaderFeedsMeBinding;", "", "renderNotificationCount", "()V", "", "isEnable", "renderNotificationIcon", "(Z)V", "Lkotlin/Function0;", "onClick", "setOnFeedNotificationClicked", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnProfileNameSectionClicked", "(Landroid/view/View$OnClickListener;)V", "setOnSettingIconSectionClicked", "sharePrivacy", "setPrivacy", "", "url", "setProfileAvatar", "(Ljava/lang/String;)V", "text", "setProfileName", "username", "setUsername", "setup", ContainerUIProvider.KEY_SHOW, "showKycVerified", "Lcom/google/android/material/badge/BadgeDrawable;", "BuiltInFictitiousFunctionClassFactory", "Lcom/google/android/material/badge/BadgeDrawable;", "KClassImpl$Data$declaredNonStaticMembers$2", "value", "getAuthRequestContext", "I", "getFeedNotificationCount", "setFeedNotificationCount", "(I)V", "feedNotificationCount", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lkotlin/Lazy;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsMeHeaderView extends ViewBindingRichView<ViewHeaderFeedsMeBinding> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FeedsMeHeaderView.class, "profileNameSkeleton", "getProfileNameSkeleton()Lcom/ethanhua/skeleton/SkeletonScreen;", 0))};

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BadgeDrawable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int feedNotificationCount;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsMeHeaderView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.FeedsMeHeaderView.<init>(android.content.Context):void");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
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
        return R.layout.view_header_feeds_me;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsMeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.social.view.FeedsMeHeaderView$profileNameSkeleton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ViewHeaderFeedsMeBinding binding;
                binding = FeedsMeHeaderView.this.getBinding();
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding.lookAheadTest);
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_profile_name_skeleton;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                return viewSkeletonScreen;
            }
        });
    }

    public /* synthetic */ FeedsMeHeaderView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getFeedNotificationCount")
    public final int getFeedNotificationCount() {
        return this.feedNotificationCount;
    }

    @JvmName(name = "setFeedNotificationCount")
    public final void setFeedNotificationCount(int i) {
        this.feedNotificationCount = i;
        BadgeDrawable badgeDrawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (badgeDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            badgeDrawable = null;
        }
        badgeDrawable.setNumber(i);
        renderNotificationCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewHeaderFeedsMeBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewHeaderFeedsMeBinding MyBillsEntityDataFactory = ViewHeaderFeedsMeBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final void setProfileAvatar(String url) {
        Context context = getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(url).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) getBinding().getAuthRequestContext);
        }
    }

    public final void showKycVerified(boolean show) {
        getBinding().getErrorConfigVersion.setVisibility(show ? 0 : 8);
    }

    public final void setPrivacy(boolean sharePrivacy) {
        if (sharePrivacy) {
            TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
            CharSequence text = getContext().getText(R.string.my_feeds_header_share_unlocked);
            Intrinsics.checkNotNullExpressionValue(text, "");
            textView.setText(text);
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().moveToNextValue, R.drawable.ic_share_unlock);
            return;
        }
        TextView textView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        CharSequence text2 = getContext().getText(R.string.my_feeds_header_share_locked);
        Intrinsics.checkNotNullExpressionValue(text2, "");
        textView2.setText(text2);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().moveToNextValue, R.drawable.ic_share_lock);
    }

    public final void setUsername(String username) {
        Intrinsics.checkNotNullParameter(username, "");
        String str = username;
        if (str.length() > 0) {
            getBinding().DatabaseTableConfigUtil.setVisibility(0);
            getBinding().DatabaseTableConfigUtil.setText(str);
            return;
        }
        getBinding().DatabaseTableConfigUtil.setVisibility(8);
    }

    public final void setProfileName(String text) {
        if (Intrinsics.areEqual("%fetching%", text)) {
            Object value = this.getAuthRequestContext.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "");
            ((SkeletonScreen) value).MyBillsEntityDataFactory();
            getBinding().PlaceComponentResult.setClickable(false);
            return;
        }
        Object value2 = this.getAuthRequestContext.getValue();
        Intrinsics.checkNotNullExpressionValue(value2, "");
        ((SkeletonScreen) value2).PlaceComponentResult();
        getBinding().lookAheadTest.setText(text);
        getBinding().PlaceComponentResult.setClickable(true);
    }

    public final void setOnSettingIconSectionClicked(View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(clickListener);
    }

    public final void setOnProfileNameSectionClicked(View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "");
        getBinding().PlaceComponentResult.setOnClickListener(clickListener);
    }

    public final void setOnFeedNotificationClicked(final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedsMeHeaderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedsMeHeaderView.$r8$lambda$DloGe5C6No8oaXthVRmHUSRfW4E(Function0.this, view);
            }
        });
    }

    public final void renderNotificationCount() {
        BadgeDrawable badgeDrawable = null;
        if (this.feedNotificationCount > 0) {
            BadgeDrawable badgeDrawable2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (badgeDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                badgeDrawable = badgeDrawable2;
            }
            BadgeUtils.attachBadgeDrawable(badgeDrawable, getBinding().BuiltInFictitiousFunctionClassFactory, getBinding().MyBillsEntityDataFactory);
            return;
        }
        BadgeDrawable badgeDrawable3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (badgeDrawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            badgeDrawable = badgeDrawable3;
        }
        BadgeUtils.detachBadgeDrawable(badgeDrawable, getBinding().BuiltInFictitiousFunctionClassFactory);
    }

    public final void renderNotificationIcon(boolean isEnable) {
        FrameLayout frameLayout = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(isEnable ? 0 : 8);
    }

    public static /* synthetic */ void $r8$lambda$DloGe5C6No8oaXthVRmHUSRfW4E(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        BadgeDrawable create = BadgeDrawable.create(getContext());
        Intrinsics.checkNotNullExpressionValue(create, "");
        create.setMaxCharacterCount(2);
        create.setNumber(this.feedNotificationCount);
        create.setHorizontalOffset(18);
        create.setVerticalOffset(-4);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
    }
}
