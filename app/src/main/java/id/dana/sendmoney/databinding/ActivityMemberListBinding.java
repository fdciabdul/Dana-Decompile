package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ActivityMemberListBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;
    public final ViewToolbarBinding getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ActivityMemberListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ViewToolbarBinding viewToolbarBinding, TextView textView, View view) {
        this.scheduleImpl = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = recyclerView;
        this.getAuthRequestContext = viewToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.MyBillsEntityDataFactory = view;
    }

    public static ActivityMemberListBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.activity_member_list, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a03e3_summaryvoucherview_externalsyntheticlambda0;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.GetTopUpUserConsult_res_0x7f0a1101;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (recyclerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a135d_access_getserviceitemdecorator_p))) != null) {
                ViewToolbarBinding authRequestContext = ViewToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                i = R.id.tvTitleMembers;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.clearName))) != null) {
                    return new ActivityMemberListBinding((ConstraintLayout) inflate, constraintLayout, recyclerView, authRequestContext, textView, BuiltInFictitiousFunctionClassFactory2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
