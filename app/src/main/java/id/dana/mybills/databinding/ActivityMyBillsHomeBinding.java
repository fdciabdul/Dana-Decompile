package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ActivityMyBillsHomeBinding implements ViewBinding {
    public final FragmentContainerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout getAuthRequestContext;

    private ActivityMyBillsHomeBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentContainerView;
    }

    public static ActivityMyBillsHomeBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_bills_home, (ViewGroup) null, false);
        int i = R.id.myBillsContainer;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (fragmentContainerView != null) {
            return new ActivityMyBillsHomeBinding((ConstraintLayout) inflate, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
