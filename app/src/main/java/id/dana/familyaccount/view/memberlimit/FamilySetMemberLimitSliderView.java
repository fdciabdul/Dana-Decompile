package id.dana.familyaccount.view.memberlimit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.slider.Slider;
import id.dana.R;
import id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitSliderView;", "Lcom/google/android/material/slider/Slider;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitSliderView$OnSliderChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitSliderView$OnSliderChangeListener;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitSliderView$OnSliderChangeListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnSliderChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilySetMemberLimitSliderView extends Slider {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;
    private OnSliderChangeListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitSliderView$OnSliderChangeListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnSliderChangeListener {
        void BuiltInFictitiousFunctionClassFactory(long p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitSliderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitSliderView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitSliderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        addOnSliderTouchListener(new Slider.OnSliderTouchListener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView$initSliderListener$1
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public final /* synthetic */ void onStartTrackingTouch(Slider slider) {
                FamilySetMemberLimitSliderView.OnSliderChangeListener onSliderChangeListener;
                Slider slider2 = slider;
                Intrinsics.checkNotNullParameter(slider2, "");
                int access$calculateAmount = FamilySetMemberLimitSliderView.access$calculateAmount(FamilySetMemberLimitSliderView.this, slider2.getValue());
                onSliderChangeListener = FamilySetMemberLimitSliderView.this.getAuthRequestContext;
                if (onSliderChangeListener != null) {
                    onSliderChangeListener.BuiltInFictitiousFunctionClassFactory(access$calculateAmount);
                }
                FamilySetMemberLimitSliderView.this.MyBillsEntityDataFactory = true;
            }

            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public final /* synthetic */ void onStopTrackingTouch(Slider slider) {
                Intrinsics.checkNotNullParameter(slider, "");
                FamilySetMemberLimitSliderView.this.MyBillsEntityDataFactory = false;
            }
        });
        addOnChangeListener(new Slider.OnChangeListener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView$$ExternalSyntheticLambda0
            @Override // com.google.android.material.slider.BaseOnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                FamilySetMemberLimitSliderView.$r8$lambda$LqY0khKYlW3xamm1zzREDUdJKTQ(FamilySetMemberLimitSliderView.this, slider, f, z);
            }
        });
    }

    public /* synthetic */ FamilySetMemberLimitSliderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setListener(OnSliderChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    public static /* synthetic */ void $r8$lambda$LqY0khKYlW3xamm1zzREDUdJKTQ(FamilySetMemberLimitSliderView familySetMemberLimitSliderView, Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(familySetMemberLimitSliderView, "");
        Intrinsics.checkNotNullParameter(slider, "");
        if (!familySetMemberLimitSliderView.MyBillsEntityDataFactory) {
            OnSliderChangeListener onSliderChangeListener = familySetMemberLimitSliderView.getAuthRequestContext;
            if (onSliderChangeListener != null) {
                onSliderChangeListener.BuiltInFictitiousFunctionClassFactory(f);
                return;
            }
            return;
        }
        int i = (int) f;
        if (f % 200000.0f >= 100000.0f) {
            i += 100000;
        }
        int i2 = (i / 200000) * 200000;
        OnSliderChangeListener onSliderChangeListener2 = familySetMemberLimitSliderView.getAuthRequestContext;
        if (onSliderChangeListener2 != null) {
            onSliderChangeListener2.BuiltInFictitiousFunctionClassFactory(i2);
        }
    }

    public static final /* synthetic */ int access$calculateAmount(FamilySetMemberLimitSliderView familySetMemberLimitSliderView, float f) {
        int i = (int) f;
        if (f % 200000.0f >= 100000.0f) {
            i += 100000;
        }
        return (i / 200000) * 200000;
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "");
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.tickmark);
        float valueTo = (getValueTo() - getValueFrom()) / getTrackWidth();
        if (PlaceComponentResult != null) {
            int intrinsicWidth = PlaceComponentResult.getIntrinsicWidth();
            int intrinsicHeight = PlaceComponentResult.getIntrinsicHeight();
            int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
            int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
            PlaceComponentResult.setBounds(-i, -i2, i, i2);
            float trackWidth = getTrackWidth() / 10.0f;
            int save = canvas.save();
            canvas.translate(getTrackSidePadding(), getHeight() / 2);
            for (int i3 = 0; i3 < 11; i3++) {
                if (i3 != 0 && i3 != 10) {
                    if (i3 * trackWidth >= getValue() / valueTo) {
                        PlaceComponentResult.setAlpha(40);
                    }
                    PlaceComponentResult.draw(canvas);
                }
                canvas.translate(trackWidth, 0.0f);
            }
            canvas.restoreToCount(save);
        }
        super.onDraw(canvas);
    }
}
