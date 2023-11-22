package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewDiscreteSliderBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatSeekBar MyBillsEntityDataFactory;
    public final TextView getAuthRequestContext;

    private ViewDiscreteSliderBinding(ConstraintLayout constraintLayout, AppCompatSeekBar appCompatSeekBar, TextView textView, TextView textView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatSeekBar;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ViewDiscreteSliderBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_discrete_slider, (ViewGroup) null, false);
        int i = R.id.discreteSlider;
        AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.discreteSlider);
        if (appCompatSeekBar != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvEndLabelBelow);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvStartLabelBelow);
                if (textView2 != null) {
                    return new ViewDiscreteSliderBinding((ConstraintLayout) inflate, appCompatSeekBar, textView, textView2);
                }
                i = R.id.tvStartLabelBelow;
            } else {
                i = R.id.tvEndLabelBelow;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
