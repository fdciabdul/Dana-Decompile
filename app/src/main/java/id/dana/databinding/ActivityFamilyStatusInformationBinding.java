package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;

/* loaded from: classes4.dex */
public final class ActivityFamilyStatusInformationBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final StatusInformationView PlaceComponentResult;

    private ActivityFamilyStatusInformationBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, StatusInformationView statusInformationView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.PlaceComponentResult = statusInformationView;
    }

    public static ActivityFamilyStatusInformationBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_status_information, (ViewGroup) null, false);
        int i = R.id.layoutToolbar;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            StatusInformationView statusInformationView = (StatusInformationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewFamilyStatusInformation);
            if (statusInformationView != null) {
                return new ActivityFamilyStatusInformationBinding((ConstraintLayout) inflate, MyBillsEntityDataFactory, statusInformationView);
            }
            i = R.id.viewFamilyStatusInformation;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
