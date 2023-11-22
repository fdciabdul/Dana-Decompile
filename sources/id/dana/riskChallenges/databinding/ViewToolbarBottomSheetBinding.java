package id.dana.riskChallenges.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class ViewToolbarBottomSheetBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatImageView getAuthRequestContext;

    private ViewToolbarBottomSheetBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewToolbarBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.whenAvailable;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatImageView != null) {
            i = R.id.iv_right_button;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.H;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (textView != null) {
                    return new ViewToolbarBottomSheetBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
