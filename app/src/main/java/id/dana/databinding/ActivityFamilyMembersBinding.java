package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityFamilyMembersBinding implements ViewBinding {
    public final MaterialCardView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ActivityFamilyMembersBinding(ConstraintLayout constraintLayout, LayoutToolbarBinding layoutToolbarBinding, MaterialCardView materialCardView, RecyclerView recyclerView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialCardView;
        this.MyBillsEntityDataFactory = recyclerView;
    }

    public static ActivityFamilyMembersBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_members, (ViewGroup) null, false);
        int i = R.id.layoutToolbar;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.mcvFamilyMember);
            if (materialCardView != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvListMember);
                if (recyclerView != null) {
                    return new ActivityFamilyMembersBinding((ConstraintLayout) inflate, MyBillsEntityDataFactory, materialCardView, recyclerView);
                }
                i = R.id.rvListMember;
            } else {
                i = R.id.mcvFamilyMember;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
