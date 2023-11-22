package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes4.dex */
public final class ItemSectionMemberListBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final CircleImageSelectionView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final View moveToNextValue;

    private ItemSectionMemberListBinding(ConstraintLayout constraintLayout, CircleImageSelectionView circleImageSelectionView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, TextView textView, TextView textView2, View view) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = circleImageSelectionView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.MyBillsEntityDataFactory = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getErrorConfigVersion = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.moveToNextValue = view;
    }

    public static ItemSectionMemberListBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_section_member_list, viewGroup, false);
        int i = R.id.cisvDisplayPhoto;
        CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cisvDisplayPhoto);
        if (circleImageSelectionView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clLeftCell);
            if (constraintLayout2 != null) {
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llSectionCell);
                if (linearLayout != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDisplayName);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvRoles);
                        if (textView2 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewDivider);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new ItemSectionMemberListBinding(constraintLayout, circleImageSelectionView, constraintLayout, constraintLayout2, linearLayout, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                            }
                            i = R.id.viewDivider;
                        } else {
                            i = R.id.tvRoles;
                        }
                    } else {
                        i = R.id.tvDisplayName;
                    }
                } else {
                    i = R.id.llSectionCell;
                }
            } else {
                i = R.id.clLeftCell;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
