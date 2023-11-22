package id.dana.danapoly.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewDanapolyBoardErrorBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatButton MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private ViewDanapolyBoardErrorBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView) {
        this.moveToNextValue = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
    }

    public static ViewDanapolyBoardErrorBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.whenAvailable;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.ivBoardErrorIcon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView != null) {
                i = R.id.ivBoardErrorShadow;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.res_0x7f0a13e7_playbackstatecompat_mediakeyaction;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatTextView != null) {
                        return new ViewDanapolyBoardErrorBinding(constraintLayout, appCompatButton, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
