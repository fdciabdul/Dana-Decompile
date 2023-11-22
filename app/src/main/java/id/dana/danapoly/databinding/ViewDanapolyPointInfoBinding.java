package id.dana.danapoly.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewDanapolyPointInfoBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final LottieAnimationView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView scheduleImpl;

    private ViewDanapolyPointInfoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.PlaceComponentResult = lottieAnimationView;
        this.scheduleImpl = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewDanapolyPointInfoBinding PlaceComponentResult(View view) {
        int i = R.id.cl_info;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (constraintLayout != null) {
            i = R.id.z;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (shapeableImageView != null) {
                i = R.id.checkRegisteredUserAndSendOtp_res_0x7f0a0ae6;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatImageView != null) {
                    i = R.id.res_0x7f0a0afb_apistatus_availablesince;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatImageView2 != null) {
                        i = R.id.lottie_dana_point;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (lottieAnimationView != null) {
                            i = R.id.res_0x7f0a1687_standardrowsortedtable_1;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView != null) {
                                i = R.id.tv_dice_count;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView2 != null) {
                                    return new ViewDanapolyPointInfoBinding((ConstraintLayout) view, constraintLayout, shapeableImageView, appCompatImageView, appCompatImageView2, lottieAnimationView, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
