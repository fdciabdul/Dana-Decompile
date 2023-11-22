package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewCashierPaymentResultAnimationBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B+\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/view/CashierPaymentResultAnimationView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewCashierPaymentResultAnimationBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewCashierPaymentResultAnimationBinding;", "", "status", "", "setStatus", "(Ljava/lang/String;)V", "setup", "()V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPaymentResultAnimationView extends BaseViewBindingRichView<ViewCashierPaymentResultAnimationBinding> {
    public static final float START_SPRINKLE_ANIMATION_PROGRESS = 0.3f;
    private String MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPaymentResultAnimationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPaymentResultAnimationView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierPaymentResultAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
    }

    public /* synthetic */ CashierPaymentResultAnimationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierPaymentResultAnimationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCashierPaymentResultAnimationBinding inflateViewBinding() {
        ViewCashierPaymentResultAnimationBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCashierPaymentResultAnimationBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        if (r3.equals("redirect") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        r2.MyBillsEntityDataFactory = "json/lottie/cashier_result_pending.lottie";
        getBinding().BuiltInFictitiousFunctionClassFactory.setRepeatCount(-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r3.equals(id.dana.cashier.model.ProcessingStatus.INNER_REDIRECT_STATUS) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        if (r3.equals("success") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        r2.MyBillsEntityDataFactory = "json/lottie/cashier_result_success_v3.lottie";
        r3 = getBinding().MyBillsEntityDataFactory;
        r3.removeAllAnimatorListeners();
        r3.addAnimatorListener(new id.dana.cashier.view.CashierPaymentResultAnimationView$setStatus$1$1(r2));
        r3.playAnimation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r3.equals(id.dana.cashier.model.ProcessingStatus.PROCESSING) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setStatus(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            int r0 = r3.hashCode()
            switch(r0) {
                case -1867169789: goto L4e;
                case -861234267: goto L45;
                case -776144932: goto L2c;
                case 3135262: goto L1f;
                case 422194963: goto L16;
                default: goto L15;
            }
        L15:
            goto L72
        L16:
            java.lang.String r0 = "processing"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L34
            goto L72
        L1f:
            java.lang.String r0 = "fail"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L72
            java.lang.String r3 = "json/lottie/cashier_result_failed.lottie"
            r2.MyBillsEntityDataFactory = r3
            goto L72
        L2c:
            java.lang.String r0 = "redirect"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L72
        L34:
            java.lang.String r3 = "json/lottie/cashier_result_pending.lottie"
            r2.MyBillsEntityDataFactory = r3
            androidx.viewbinding.ViewBinding r3 = r2.getBinding()
            id.dana.databinding.ViewCashierPaymentResultAnimationBinding r3 = (id.dana.databinding.ViewCashierPaymentResultAnimationBinding) r3
            com.airbnb.lottie.LottieAnimationView r3 = r3.BuiltInFictitiousFunctionClassFactory
            r0 = -1
            r3.setRepeatCount(r0)
            goto L72
        L45:
            java.lang.String r0 = "inner_redirect"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L72
            goto L56
        L4e:
            java.lang.String r0 = "success"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L72
        L56:
            java.lang.String r3 = "json/lottie/cashier_result_success_v3.lottie"
            r2.MyBillsEntityDataFactory = r3
            androidx.viewbinding.ViewBinding r3 = r2.getBinding()
            id.dana.databinding.ViewCashierPaymentResultAnimationBinding r3 = (id.dana.databinding.ViewCashierPaymentResultAnimationBinding) r3
            com.airbnb.lottie.LottieAnimationView r3 = r3.MyBillsEntityDataFactory
            r3.removeAllAnimatorListeners()
            id.dana.cashier.view.CashierPaymentResultAnimationView$setStatus$1$1 r0 = new id.dana.cashier.view.CashierPaymentResultAnimationView$setStatus$1$1
            r0.<init>()
            android.animation.Animator$AnimatorListener r0 = (android.animation.Animator.AnimatorListener) r0
            r3.addAnimatorListener(r0)
            r3.playAnimation()
        L72:
            androidx.viewbinding.ViewBinding r3 = r2.getBinding()
            id.dana.databinding.ViewCashierPaymentResultAnimationBinding r3 = (id.dana.databinding.ViewCashierPaymentResultAnimationBinding) r3
            com.airbnb.lottie.LottieAnimationView r3 = r3.BuiltInFictitiousFunctionClassFactory
            java.lang.String r0 = r2.MyBillsEntityDataFactory
            r3.setAnimation(r0)
            r3.playAnimation()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.CashierPaymentResultAnimationView.setStatus(java.lang.String):void");
    }
}
