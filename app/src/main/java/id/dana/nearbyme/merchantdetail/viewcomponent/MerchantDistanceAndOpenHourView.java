package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R.\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R.\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001d"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDistanceAndOpenHourView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "showShimmer", "MyBillsEntityDataFactory", "Landroid/util/AttributeSet;", "getAuthRequestContext", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "", "value", "Ljava/lang/String;", "getDistanceText", "()Ljava/lang/String;", "setDistanceText", "(Ljava/lang/String;)V", "distanceText", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getOpenHoursText", "setOpenHoursText", "openHoursText", "attributeSet", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDistanceAndOpenHourView extends BaseRichView {
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AttributeSet getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String openHoursText;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String distanceText;

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
        return R.layout.view_distance_and_open_hour;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDistanceAndOpenHourView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = attributeSet;
        this.distanceText = "";
        this.openHoursText = "-";
    }

    @JvmName(name = "getDistanceText")
    public final String getDistanceText() {
        return this.distanceText;
    }

    @JvmName(name = "setDistanceText")
    public final void setDistanceText(String str) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_distance_value);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
        this.distanceText = str;
    }

    @JvmName(name = "getOpenHoursText")
    public final String getOpenHoursText() {
        return this.openHoursText;
    }

    @JvmName(name = "setOpenHoursText")
    public final void setOpenHoursText(String str) {
        AppCompatTextView appCompatTextView;
        String str2 = str;
        if (!(str2 == null || str2.length() == 0) && (appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MultiFieldValueClassRepresentation)) != null) {
            appCompatTextView.setText(str2);
        }
        this.openHoursText = str;
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult((AppCompatTextView) _$_findCachedViewById(R.id.tv_distance_value), R.layout.view_skeleton_distance_value);
        this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult((AppCompatTextView) _$_findCachedViewById(R.id.MultiFieldValueClassRepresentation), R.layout.view_skeleton_open_hour_value);
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
        SkeletonScreen skeletonScreen2 = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen2 != null) {
            skeletonScreen2.MyBillsEntityDataFactory();
        }
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        SkeletonScreen skeletonScreen2 = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        String str;
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.createJavaMethod) : null;
        if (obtainStyledAttributes != null) {
            try {
                str = obtainStyledAttributes.getString(0);
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        setDistanceText(str);
        String string = obtainStyledAttributes != null ? obtainStyledAttributes.getString(1) : null;
        if (string != null) {
            str2 = string;
        }
        setOpenHoursText(str2);
    }
}
