package id.dana.social.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.drawable.view.RatingStarView;
import id.dana.social.utils.FeedsContentUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cB+\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/social/v2/view/ActivityWidgetView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "action", "setWidgetClickListener", "(Lkotlin/jvm/functions/Function0;)V", "iconUrl", "widgetTitle", "rating", "setWidgetDataRating", "(Ljava/lang/String;Ljava/lang/String;I)V", "widgetSubtitle", "setWidgetDataText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityWidgetView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityWidgetView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityWidgetView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_activity_widget;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityWidgetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ActivityWidgetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityWidgetView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setWidgetDataText(String iconUrl, String widgetTitle, String widgetSubtitle) {
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(widgetTitle, "");
        Intrinsics.checkNotNullParameter(widgetSubtitle, "");
        RatingStarView ratingStarView = (RatingStarView) _$_findCachedViewById(R.id.res_0x7f0a1017_access_createsegment);
        if (ratingStarView != null) {
            ratingStarView.setVisibility(8);
        }
        getAuthRequestContext(iconUrl);
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15f9_grideditviewholder_externalsyntheticlambda0);
        if (textView != null) {
            textView.setText(widgetTitle);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.SdkLongCounter);
        if (textView2 != null) {
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(textView2, widgetSubtitle);
        }
    }

    public final void setWidgetDataRating(String iconUrl, String widgetTitle, int rating) {
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(widgetTitle, "");
        RatingStarView ratingStarView = (RatingStarView) _$_findCachedViewById(R.id.res_0x7f0a1017_access_createsegment);
        if (ratingStarView != null) {
            ratingStarView.setVisibility(0);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.SdkLongCounter);
        if (textView != null) {
            textView.setVisibility(8);
        }
        getAuthRequestContext(iconUrl);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a15f9_grideditviewholder_externalsyntheticlambda0);
        if (textView2 != null) {
            textView2.setText(widgetTitle);
        }
        RatingStarView ratingStarView2 = (RatingStarView) _$_findCachedViewById(R.id.res_0x7f0a1017_access_createsegment);
        if (ratingStarView2 != null) {
            ratingStarView2.setRating(rating);
        }
    }

    public final void setWidgetClickListener(final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityWidgetView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityWidgetView.m2958$r8$lambda$W_eQaSiBxAjg_Y9iKJ9zFuzEq4(Function0.this, view);
            }
        });
    }

    private final void getAuthRequestContext(String p0) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivWidgetIcon);
        if (appCompatImageView != null) {
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(p0).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
        }
    }

    /* renamed from: $r8$lambda$W_eQaSiBxAjg_Y9iKJ9-zFuzEq4 */
    public static /* synthetic */ void m2958$r8$lambda$W_eQaSiBxAjg_Y9iKJ9zFuzEq4(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
