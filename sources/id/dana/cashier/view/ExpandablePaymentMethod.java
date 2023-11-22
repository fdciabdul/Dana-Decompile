package id.dana.cashier.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.cardview.widget.CardView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.extension.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u001b\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0013\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R*\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u0006R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\"\u0010\u0017"}, d2 = {"Lid/dana/cashier/view/ExpandablePaymentMethod;", "Landroidx/cardview/widget/CardView;", "", "isExpand", "", "expandView", "(Z)V", "isExpanded", "()Z", "onFinishInflate", "()V", "Lkotlin/Function1;", "l", "setExpandablePayMethodClickListener", "(Lkotlin/jvm/functions/Function1;)V", "PlaceComponentResult", "MyBillsEntityDataFactory", "Z", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "BuiltInFictitiousFunctionClassFactory", "value", "lookAheadTest", "isExpandable", "setExpandable", "moveToNextValue", "Lkotlin/jvm/functions/Function1;", "getErrorConfigVersion", "scheduleImpl", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpandablePaymentMethod extends CardView {
    public static final long EXPAND_DURATION = 100;
    public static final float STATIC_HEIGHT_PAYMENT_METHOD_LIST = 200.0f;
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private View getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ValueAnimator KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private ViewGroup MyBillsEntityDataFactory;
    private View getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean isExpandable;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ViewGroup moveToNextValue;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExpandablePaymentMethod(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.ExpandablePaymentMethod.<init>(android.content.Context):void");
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
    public ExpandablePaymentMethod(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.lookAheadTest = new Function1<Boolean, Unit>() { // from class: id.dana.cashier.view.ExpandablePaymentMethod$payMethodClickListener$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.cashier.view.ExpandablePaymentMethod$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandablePaymentMethod.$r8$lambda$pJjBFHXGzwlQfbBdqFrLNv7hZG8(ExpandablePaymentMethod.this, valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: id.dana.cashier.view.ExpandablePaymentMethod$expandAnimator$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onAnimationStart(p0);
                ExpandablePaymentMethod.this.PlaceComponentResult = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onAnimationEnd(p0);
                ExpandablePaymentMethod.this.PlaceComponentResult = false;
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ofFloat;
    }

    public /* synthetic */ ExpandablePaymentMethod(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "isExpandable")
    /* renamed from: isExpandable  reason: from getter */
    public final boolean getIsExpandable() {
        return this.isExpandable;
    }

    @JvmName(name = "setExpandable")
    public final void setExpandable(boolean z) {
        this.isExpandable = z;
        View view = this.getAuthRequestContext;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        view.setVisibility(this.isExpandable ? 0 : 4);
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        if (childAt == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) childAt;
        View childAt2 = viewGroup.getChildAt(0);
        if (childAt2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.moveToNextValue = (ViewGroup) childAt2;
        View childAt3 = viewGroup.getChildAt(2);
        Intrinsics.checkNotNullExpressionValue(childAt3, "");
        this.getErrorConfigVersion = childAt3;
        View childAt4 = viewGroup.getChildAt(3);
        if (childAt4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.MyBillsEntityDataFactory = (ViewGroup) childAt4;
        ViewGroup viewGroup2 = this.moveToNextValue;
        ViewGroup viewGroup3 = null;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup2 = null;
        }
        View childAt5 = viewGroup2.getChildAt(0);
        if (childAt5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        View findViewById = ((ViewGroup) childAt5).getChildAt(3).findViewById(R.id.ivExpand);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.getAuthRequestContext = findViewById;
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            ViewGroup viewGroup4 = this.MyBillsEntityDataFactory;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                viewGroup4 = null;
            }
            ViewGroup viewGroup5 = viewGroup4;
            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = 0;
                viewGroup5.setLayoutParams(layoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        ViewGroup viewGroup6 = this.moveToNextValue;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            viewGroup3 = viewGroup6;
        }
        viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.ExpandablePaymentMethod$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandablePaymentMethod.$r8$lambda$Rzqe2Q76N_kiOHVKIqOaxSCMPpU(ExpandablePaymentMethod.this, view);
            }
        });
    }

    /* renamed from: isExpanded  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void setExpandablePayMethodClickListener(Function1<? super Boolean, Unit> l) {
        Intrinsics.checkNotNullParameter(l, "");
        this.lookAheadTest = l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r3.BuiltInFictitiousFunctionClassFactory == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void expandView(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.isExpandable
            if (r0 != 0) goto L5
            return
        L5:
            boolean r0 = r3.BuiltInFictitiousFunctionClassFactory
            if (r0 == r4) goto L32
            boolean r0 = r3.PlaceComponentResult
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            r3.PlaceComponentResult()
            boolean r4 = r3.BuiltInFictitiousFunctionClassFactory
            if (r4 != 0) goto L2f
            goto L30
        L17:
            if (r4 == 0) goto L2c
            android.animation.ValueAnimator r4 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r4.start()
            android.view.View r4 = r3.getErrorConfigVersion
            if (r4 != 0) goto L28
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = 0
        L28:
            r4.setVisibility(r2)
            goto L30
        L2c:
            r3.PlaceComponentResult()
        L2f:
            r1 = 0
        L30:
            r3.BuiltInFictitiousFunctionClassFactory = r1
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.ExpandablePaymentMethod.expandView(boolean):void");
    }

    private final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.reverse();
        View view = this.getErrorConfigVersion;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        view.setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$Rzqe2Q76N_kiOHVKIqOaxSCMPpU(ExpandablePaymentMethod expandablePaymentMethod, View view) {
        Intrinsics.checkNotNullParameter(expandablePaymentMethod, "");
        expandablePaymentMethod.lookAheadTest.invoke(Boolean.valueOf(expandablePaymentMethod.BuiltInFictitiousFunctionClassFactory));
    }

    public static /* synthetic */ void $r8$lambda$pJjBFHXGzwlQfbBdqFrLNv7hZG8(ExpandablePaymentMethod expandablePaymentMethod, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(expandablePaymentMethod, "");
        Intrinsics.checkNotNullParameter(valueAnimator, "");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup viewGroup = expandablePaymentMethod.MyBillsEntityDataFactory;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        ViewParent parent = viewGroup.getParent();
        if (parent != null) {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(((View) parent).getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ViewExtKt.getAuthRequestContext(200.0f), Integer.MIN_VALUE));
            int measuredHeight = viewGroup.getMeasuredHeight();
            ViewGroup viewGroup3 = expandablePaymentMethod.MyBillsEntityDataFactory;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                viewGroup2 = viewGroup3;
            }
            ViewGroup viewGroup4 = viewGroup2;
            ViewGroup.LayoutParams layoutParams = viewGroup4.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = (int) (measuredHeight * floatValue);
                viewGroup4.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
