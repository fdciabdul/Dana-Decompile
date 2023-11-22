package id.dana.promodiscovery.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.promodiscovery.model.FourKingModel;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0007J\u0015\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/promodiscovery/richview/FourKingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideSkeleton", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "showSkeleton", "Lid/dana/promodiscovery/model/FourKingModel;", H5GetLogInfoBridge.RESULT_MODEL, "updateData", "(Lid/dana/promodiscovery/model/FourKingModel;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeleton", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getSkeleton", "()Lcom/ethanhua/skeleton/SkeletonScreen;", "setSkeleton", "(Lcom/ethanhua/skeleton/SkeletonScreen;)V", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FourKingView extends BaseRichView {
    public static final String EMPTY = "0";
    public Map<Integer, View> _$_findViewCache;
    public SkeletonScreen skeleton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FourKingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FourKingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
        return R.layout.four_king_item_layout;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FourKingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FourKingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FourKingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getSkeleton")
    public final SkeletonScreen getSkeleton() {
        SkeletonScreen skeletonScreen = this.skeleton;
        if (skeletonScreen != null) {
            return skeletonScreen;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSkeleton")
    public final void setSkeleton(SkeletonScreen skeletonScreen) {
        Intrinsics.checkNotNullParameter(skeletonScreen, "");
        this.skeleton = skeletonScreen;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r3, AttributeSet attrs) {
        if (r3 == null || attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = r3.obtainStyledAttributes(attrs, R.styleable.secondaryHash);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        setStyledAttributes(r3, attrs, R.styleable.secondaryHash);
        try {
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ConfirmUpdateBalanceEmoney);
            if (appCompatImageView != null) {
                __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, getStyledAttributes().getResourceId(0, 0));
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.fourKingTitle);
            if (appCompatTextView != null) {
                appCompatTextView.setText(getStyledAttributes().getText(2));
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a0782_completablecache_innercompletablecache);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(getStyledAttributes().getText(1));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void showSkeleton() {
        getSkeleton().MyBillsEntityDataFactory();
    }

    public final void hideSkeleton() {
        getSkeleton().PlaceComponentResult();
    }

    public final void updateData(FourKingModel r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a0782_completablecache_innercompletablecache);
        if (appCompatTextView != null) {
            appCompatTextView.setText(r3.getAuthRequestContext);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.addAllCpuMetricReadings);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(r3.getMyBillsEntityDataFactory() ? 0 : 8);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ViewSkeletonScreen PlaceComponentResult = ShimmeringUtil.PlaceComponentResult((AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a0782_completablecache_innercompletablecache), R.layout.four_king_skeleton_layout);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        setSkeleton(PlaceComponentResult);
    }
}
