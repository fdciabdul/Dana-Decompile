package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.component.formcomponent.DanaRadioButtonView;

/* loaded from: classes4.dex */
public final class ItemExpiryTimeBinding implements ViewBinding {
    public final DanaDividerView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView PlaceComponentResult;
    public final DanaRadioButtonView getAuthRequestContext;

    private ItemExpiryTimeBinding(ConstraintLayout constraintLayout, DanaDividerView danaDividerView, DanaRadioButtonView danaRadioButtonView, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaDividerView;
        this.getAuthRequestContext = danaRadioButtonView;
        this.PlaceComponentResult = textView;
    }

    public static ItemExpiryTimeBinding PlaceComponentResult(View view) {
        int i = R.id.divider;
        DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
        if (danaDividerView != null) {
            DanaRadioButtonView danaRadioButtonView = (DanaRadioButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.drbExpiryTime);
            if (danaRadioButtonView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvExpiryTime);
                if (textView != null) {
                    return new ItemExpiryTimeBinding((ConstraintLayout) view, danaDividerView, danaRadioButtonView, textView);
                }
                i = R.id.tvExpiryTime;
            } else {
                i = R.id.drbExpiryTime;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
