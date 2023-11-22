package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewPaylaterAgreementBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatCheckBox PlaceComponentResult;

    private ViewPaylaterAgreementBinding(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = appCompatCheckBox;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
    }

    public static ViewPaylaterAgreementBinding PlaceComponentResult(View view) {
        int i = R.id.f3559cb_paylater_agreement_tnc;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3559cb_paylater_agreement_tnc);
        if (appCompatCheckBox != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4460tv_paylater_agreement_desc);
            if (appCompatTextView != null) {
                return new ViewPaylaterAgreementBinding(constraintLayout, appCompatCheckBox, constraintLayout, appCompatTextView);
            }
            i = R.id.f4460tv_paylater_agreement_desc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
