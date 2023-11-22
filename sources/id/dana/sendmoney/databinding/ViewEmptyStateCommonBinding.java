package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ViewEmptyStateCommonBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final MaterialButton MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ViewEmptyStateCommonBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, MaterialButton materialButton, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.lookAheadTest = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = materialButton;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
    }

    public static ViewEmptyStateCommonBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_empty_state_common, (ViewGroup) null, false);
        int i = R.id.getAuthRequestContext;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0139_kclassimpl_data_declarednonstaticmembers_2;
            MaterialButton materialButton = (MaterialButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (materialButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                i = R.id.FlowableConcatMapEagerPublisher;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null) {
                    i = R.id.TrustRiskLogin$Params;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatTextView != null) {
                        i = R.id.setValue;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatTextView2 != null) {
                            return new ViewEmptyStateCommonBinding(constraintLayout, danaButtonPrimaryView, materialButton, constraintLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
