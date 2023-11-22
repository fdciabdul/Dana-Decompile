package id.dana.riskChallenges.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class ViewToolbarBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final Toolbar KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewToolbarBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, Toolbar toolbar, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = toolbar;
        this.PlaceComponentResult = textView;
    }

    public static ViewToolbarBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.whenAvailable;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatImageView != null) {
            i = R.id.B;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.E;
                Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (toolbar != null) {
                    i = R.id.H;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (textView != null) {
                        return new ViewToolbarBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
