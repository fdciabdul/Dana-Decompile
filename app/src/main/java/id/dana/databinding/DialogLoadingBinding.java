package id.dana.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class DialogLoadingBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final ProgressBar KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout PlaceComponentResult;

    private DialogLoadingBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = progressBar;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static DialogLoadingBinding PlaceComponentResult(View view) {
        int i = R.id.f4080progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4080progress_bar);
        if (progressBar != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
            if (textView != null) {
                return new DialogLoadingBinding((ConstraintLayout) view, progressBar, textView);
            }
            i = R.id.tv_title;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
