package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class FragmentCitcallIntroductionBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;

    private FragmentCitcallIntroductionBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.getAuthRequestContext = lottieAnimationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
    }

    public static FragmentCitcallIntroductionBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_request_citcall;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_request_citcall);
        if (danaButtonSecondaryView != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0ab8_networkuserentitydata_externalsyntheticlambda6);
            if (lottieAnimationView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_citcall_desc);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_citcall_title);
                    if (appCompatTextView2 != null) {
                        return new FragmentCitcallIntroductionBinding((ConstraintLayout) view, danaButtonSecondaryView, lottieAnimationView, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tv_citcall_title;
                } else {
                    i = R.id.tv_citcall_desc;
                }
            } else {
                i = R.id.res_0x7f0a0ab8_networkuserentitydata_externalsyntheticlambda6;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
