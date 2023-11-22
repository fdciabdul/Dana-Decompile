package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.ShimmeringUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R.\u0010\u001c\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantRatingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "showShimmer", "getAuthRequestContext", "Landroid/util/AttributeSet;", "PlaceComponentResult", "", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Double;", "getNumberOfReviews", "()Ljava/lang/Double;", "setNumberOfReviews", "(Ljava/lang/Double;)V", "numberOfReviews", "MyBillsEntityDataFactory", "getRating", "setRating", "rating", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ethanhua/skeleton/SkeletonScreen;", "attributeSet", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantRatingView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Double numberOfReviews;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Double rating;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AttributeSet PlaceComponentResult;

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
        return R.layout.view_merchant_rating;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantRatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = attributeSet;
        Double valueOf = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.rating = valueOf;
        this.numberOfReviews = valueOf;
    }

    @JvmName(name = "getRating")
    public final Double getRating() {
        return this.rating;
    }

    @JvmName(name = "setRating")
    public final void setRating(Double d) {
        if (d != null) {
            double doubleValue = d.doubleValue();
            if (!(doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_rating_star);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                TextView textView = (TextView) _$_findCachedViewById(R.id.tv_rating);
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    textView.setText(format);
                }
            } else {
                ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.iv_rating_star);
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
        }
        this.rating = d;
    }

    @JvmName(name = "getNumberOfReviews")
    public final Double getNumberOfReviews() {
        return this.numberOfReviews;
    }

    @JvmName(name = "setNumberOfReviews")
    public final void setNumberOfReviews(Double d) {
        TextView textView;
        if (!Intrinsics.areEqual(d, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) && (textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1803_r8_lambda_bz3pxigslnoepxjsarblztaebgk)) != null) {
            Resources resources = getResources();
            int doubleValue = d != null ? (int) d.doubleValue() : 0;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(d != null ? (int) d.doubleValue() : 0);
            textView.setText(resources.getQuantityString(R.plurals.f46702131820556, doubleValue, objArr));
        }
        this.numberOfReviews = d;
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult((LinearLayout) _$_findCachedViewById(R.id.checkAppxSupportCrossVersionSnapshot), R.layout.view_skeleton_merchant_rating);
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.TypeToken$TypeSet) : null;
        if (obtainStyledAttributes != null) {
            try {
                setRating(Double.valueOf(obtainStyledAttributes.getFloat(1, 0.0f)));
                setNumberOfReviews(Double.valueOf(obtainStyledAttributes.getFloat(0, 0.0f)));
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }
}
