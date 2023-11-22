package id.dana.social.onboarding;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager2.widget.ViewPager2;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.base.NestedScrollableHost;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.social.common.FeedOnboardingListener;
import id.dana.social.onboarding.adapter.FeedOnboardingAdapter;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aB+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007R.\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/social/onboarding/FeedOnboardingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "renderButtonDisabled", "()V", "renderButtonEnabled", "renderButtonError", "setup", "Lid/dana/social/common/FeedOnboardingListener;", "value", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/common/FeedOnboardingListener;", "getListener", "()Lid/dana/social/common/FeedOnboardingListener;", "setListener", "(Lid/dana/social/common/FeedOnboardingListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedOnboardingView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private FeedOnboardingListener listener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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
        return R.layout.view_feed_onboarding;
    }

    @JvmName(name = "getListener")
    public final FeedOnboardingListener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(final FeedOnboardingListener feedOnboardingListener) {
        this.listener = feedOnboardingListener;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_activate);
        if (danaButtonPrimaryView != null) {
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(danaButtonPrimaryView, new Function1<View, Unit>() { // from class: id.dana.social.onboarding.FeedOnboardingView$listener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    FeedOnboardingListener feedOnboardingListener2 = FeedOnboardingListener.this;
                    if (feedOnboardingListener2 != null) {
                        feedOnboardingListener2.BuiltInFictitiousFunctionClassFactory();
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FeedOnboardingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedOnboardingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void renderButtonDisabled() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_failed);
        if (textView != null) {
            textView.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_activate);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(false);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.social_feeds_loading) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(0, string, "", null);
        }
    }

    public final void renderButtonError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_failed);
        if (textView != null) {
            textView.setVisibility(0);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_activate);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(true);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.try_again) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
        }
    }

    public final void renderButtonEnabled() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_failed);
        if (textView != null) {
            textView.setVisibility(8);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_activate);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(true);
            Context context = danaButtonPrimaryView.getContext();
            String string = context != null ? context.getString(R.string.feed_onboarding_activate) : null;
            if (string == null) {
                string = "";
            }
            danaButtonPrimaryView.setDanaButtonView(1, string, "", null);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
        if (viewPager2 != null) {
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            viewPager2.setAdapter(new FeedOnboardingAdapter(context, false));
        }
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.tl_indicator);
        if (tabLayout != null) {
            ViewPager2 viewPager22 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(tabLayout, viewPager22);
            Unit unit = Unit.INSTANCE;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MissingMainCoroutineDispatcher);
        if (appCompatTextView != null) {
            String string = getContext().getString(R.string.tnc);
            Intrinsics.checkNotNullExpressionValue(string, "");
            InputExtKt.PlaceComponentResult(appCompatTextView, string, false, new Function0<Unit>() { // from class: id.dana.social.onboarding.FeedOnboardingView$setupTnc$1
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    DanaH5.startContainerFullUrl(authRequestContext);
                }
            }, 4);
            Unit unit2 = Unit.INSTANCE;
        }
        ((NestedScrollableHost) _$_findCachedViewById(R.id.scrollable_host)).setScrollParent(false);
    }
}
