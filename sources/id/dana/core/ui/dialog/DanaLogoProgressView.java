package id.dana.core.ui.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.R;
import id.dana.core.ui.databinding.ViewDanaLogoProgressBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/core/ui/dialog/DanaLogoProgressView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewDanaLogoProgressBinding;", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewDanaLogoProgressBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "()V", "startRefresh", "stopRefresh", "Landroid/view/animation/Animation;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/animation/Animation;", "", "PlaceComponentResult", "I", "getAuthRequestContext", "Landroid/content/res/TypedArray;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/res/TypedArray;", "MyBillsEntityDataFactory", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaLogoProgressView extends BaseViewBindingRichView<ViewDanaLogoProgressBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private TypedArray MyBillsEntityDataFactory;
    private Animation KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaLogoProgressView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaLogoProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaLogoProgressView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaLogoProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ DanaLogoProgressView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanaLogoProgressBinding inflateViewBinding() {
        ViewDanaLogoProgressBinding BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = ViewDanaLogoProgressBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()).inflate(R.layout.res_0x7f0d04f1_networkuserentitydata_externalsyntheticlambda0, (ViewGroup) null, false));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.S;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (context != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.MyBillsEntityDataFactory = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.MyBillsEntityDataFactory;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                float dimension = typedArray2.getDimension(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2, 0.0f);
                TypedArray typedArray3 = this.MyBillsEntityDataFactory;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray3 = null;
                }
                float dimension2 = typedArray3.getDimension(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1, 0.0f);
                this.PlaceComponentResult = MathKt.roundToInt(dimension);
                this.getAuthRequestContext = MathKt.roundToInt(dimension2);
            } finally {
                TypedArray typedArray4 = this.MyBillsEntityDataFactory;
                if (typedArray4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray4;
                }
                typedArray.recycle();
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        if (this.PlaceComponentResult > 0) {
            AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            int i = this.PlaceComponentResult;
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i;
            }
            if (layoutParams != null) {
                layoutParams.height = i;
            }
        }
        if (this.getAuthRequestContext > 0) {
            AppCompatImageView appCompatImageView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            int i2 = this.getAuthRequestContext;
            ViewGroup.LayoutParams layoutParams2 = appCompatImageView2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
            }
            if (layoutParams2 != null) {
                layoutParams2.height = i2;
            }
        }
    }

    public final void startRefresh() {
        stopRefresh();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadAnimation;
        if (loadAnimation != null) {
            loadAnimation.setInterpolator(new LinearInterpolator());
        }
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.startAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final void stopRefresh() {
        Animation animation = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (animation != null) {
            if (animation != null) {
                animation.cancel();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }
}
