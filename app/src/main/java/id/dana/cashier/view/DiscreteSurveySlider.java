package id.dana.cashier.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewDiscreteSliderBinding;
import id.dana.utils.SizeUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB+\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001fJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/cashier/view/DiscreteSurveySlider;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewDiscreteSliderBinding;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "getDiscreetSlider", "()Landroidx/appcompat/widget/AppCompatSeekBar;", "inflateViewBinding", "()Lid/dana/databinding/ViewDiscreteSliderBinding;", "", "setup", "()V", "", "isActive", "setupSliderThumb", "(Z)V", "Lid/dana/cashier/view/DiscreteSurveySlider$OnSliderChangeListener;", "sliderChangeListener", "Lid/dana/cashier/view/DiscreteSurveySlider$OnSliderChangeListener;", "getSliderChangeListener", "()Lid/dana/cashier/view/DiscreteSurveySlider$OnSliderChangeListener;", "setSliderChangeListener", "(Lid/dana/cashier/view/DiscreteSurveySlider$OnSliderChangeListener;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnSliderChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DiscreteSurveySlider extends BaseViewBindingRichView<ViewDiscreteSliderBinding> {
    public Map<Integer, View> _$_findViewCache;
    public OnSliderChangeListener sliderChangeListener;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/view/DiscreteSurveySlider$OnSliderChangeListener;", "", "Landroid/widget/SeekBar;", "p0", "", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnSliderChangeListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscreteSurveySlider(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscreteSurveySlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    @JvmName(name = "getSliderChangeListener")
    public final OnSliderChangeListener getSliderChangeListener() {
        OnSliderChangeListener onSliderChangeListener = this.sliderChangeListener;
        if (onSliderChangeListener != null) {
            return onSliderChangeListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSliderChangeListener")
    public final void setSliderChangeListener(OnSliderChangeListener onSliderChangeListener) {
        Intrinsics.checkNotNullParameter(onSliderChangeListener, "");
        this.sliderChangeListener = onSliderChangeListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscreteSurveySlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ DiscreteSurveySlider(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscreteSurveySlider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDiscreteSliderBinding inflateViewBinding() {
        ViewDiscreteSliderBinding PlaceComponentResult = ViewDiscreteSliderBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        super.setup();
        getBinding().MyBillsEntityDataFactory.setProgressDrawable(new LayerDrawable(new VectorDrawableCompat[]{VectorDrawableCompat.MyBillsEntityDataFactory(getResources(), (int) R.drawable.ic_slider_bar, (Resources.Theme) null)}));
        getBinding().MyBillsEntityDataFactory.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: id.dana.cashier.view.DiscreteSurveySlider$initSliderListener$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStartTrackingTouch(SeekBar p0) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onStopTrackingTouch(SeekBar p0) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public final void onProgressChanged(SeekBar p0, int p1, boolean p2) {
                DiscreteSurveySlider.this.getSliderChangeListener().KClassImpl$Data$declaredNonStaticMembers$2(p1);
            }
        });
        setupSliderThumb(false);
    }

    public final void setupSliderThumb(boolean isActive) {
        int authRequestContext = SizeUtil.getAuthRequestContext(30);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setSize(authRequestContext, authRequestContext);
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(SizeUtil.getAuthRequestContext(1), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157));
        getTop();
        getBinding().MyBillsEntityDataFactory.setThumb(new LayerDrawable(new Drawable[]{gradientDrawable, VectorDrawableCompat.MyBillsEntityDataFactory(getResources(), isActive ? R.drawable.ic_thumb_slider_survey_active : R.drawable.ic_thumb_slider_survey_inactive, (Resources.Theme) null)}));
    }

    public final AppCompatSeekBar getDiscreetSlider() {
        AppCompatSeekBar appCompatSeekBar = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatSeekBar, "");
        return appCompatSeekBar;
    }
}
