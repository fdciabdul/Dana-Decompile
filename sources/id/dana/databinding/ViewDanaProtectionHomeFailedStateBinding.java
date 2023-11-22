package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewDanaProtectionHomeFailedStateBinding implements ViewBinding {
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ViewDanaProtectionHomeFailedStateBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatTextView appCompatTextView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
    }

    public static ViewDanaProtectionHomeFailedStateBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btn_dana_protection_failed_action;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_dana_protection_failed_action);
        if (danaButtonPrimaryView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_protection_failed_desc);
            if (appCompatTextView != null) {
                return new ViewDanaProtectionHomeFailedStateBinding((ConstraintLayout) view, danaButtonPrimaryView, appCompatTextView);
            }
            i = R.id.tv_dana_protection_failed_desc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
