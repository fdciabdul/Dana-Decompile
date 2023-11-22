package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewArrowSeeMoreBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView MyBillsEntityDataFactory;
    public final CardView PlaceComponentResult;

    private ViewArrowSeeMoreBinding(CardView cardView, AppCompatImageView appCompatImageView, TextView textView) {
        this.PlaceComponentResult = cardView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewArrowSeeMoreBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.ivDown;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivDown);
        if (appCompatImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4319res_0x7f0a155b_longcounterbuilder_cc);
            if (textView != null) {
                return new ViewArrowSeeMoreBinding((CardView) view, appCompatImageView, textView);
            }
            i = R.id.f4319res_0x7f0a155b_longcounterbuilder_cc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
