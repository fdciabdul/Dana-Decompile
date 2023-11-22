package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountManageLimitBinding implements ViewBinding {
    public final NestedScrollView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;
    public final MaterialCardView scheduleImpl;

    private ActivityFamilyAccountManageLimitBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LayoutToolbarBinding layoutToolbarBinding, NestedScrollView nestedScrollView, RecyclerView recyclerView, TextView textView, MaterialCardView materialCardView) {
        this.moveToNextValue = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = nestedScrollView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.getAuthRequestContext = textView;
        this.scheduleImpl = materialCardView;
    }

    public static ActivityFamilyAccountManageLimitBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_manage_limit, (ViewGroup) null, false);
        int i = R.id.clMemberLimitContent;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clMemberLimitContent);
        if (constraintLayout != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.manageLimitScrollView);
                if (nestedScrollView != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvMemberLimit);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMemberLimitTitle);
                        if (textView != null) {
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vg_profile_completion_container);
                            if (materialCardView != null) {
                                return new ActivityFamilyAccountManageLimitBinding((ConstraintLayout) inflate, constraintLayout, MyBillsEntityDataFactory, nestedScrollView, recyclerView, textView, materialCardView);
                            }
                            i = R.id.vg_profile_completion_container;
                        } else {
                            i = R.id.tvMemberLimitTitle;
                        }
                    } else {
                        i = R.id.rvMemberLimit;
                    }
                } else {
                    i = R.id.manageLimitScrollView;
                }
            } else {
                i = R.id.layoutToolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
