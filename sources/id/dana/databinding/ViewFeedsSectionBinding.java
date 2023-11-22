package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewFeedsSectionBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final ConstraintLayout getAuthRequestContext;

    private ViewFeedsSectionBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewFeedsSectionBinding PlaceComponentResult(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.cl_see_all;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_see_all);
        if (constraintLayout2 != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4499res_0x7f0a18bd_getstaticqrpresenter_getdynamicprofileqr_2_1);
            if (textView != null) {
                return new ViewFeedsSectionBinding(constraintLayout, constraintLayout, constraintLayout2, textView);
            }
            i = R.id.f4499res_0x7f0a18bd_getstaticqrpresenter_getdynamicprofileqr_2_1;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
