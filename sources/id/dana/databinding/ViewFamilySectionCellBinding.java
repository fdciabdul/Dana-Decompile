package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewFamilySectionCellBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LinearLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewFamilySectionCellBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, LinearLayout linearLayout, View view, TextView textView, TextView textView2, TextView textView3) {
        this.getErrorConfigVersion = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout3;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = linearLayout;
        this.PlaceComponentResult = view;
        this.moveToNextValue = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.scheduleImpl = textView3;
    }

    public static ViewFamilySectionCellBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_family_section_cell, (ViewGroup) null, false);
        int i = R.id.clLeftCell;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clLeftCell);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clRightCell);
            if (constraintLayout2 != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.imgRightCell);
                if (appCompatImageView != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rlSectionCell);
                    if (linearLayout != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sectionDivider);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvLeftCellDesc);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvLeftCellTitle);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvRightCellDesc);
                                    if (textView3 != null) {
                                        return new ViewFamilySectionCellBinding((ConstraintLayout) inflate, constraintLayout, constraintLayout2, appCompatImageView, linearLayout, BuiltInFictitiousFunctionClassFactory, textView, textView2, textView3);
                                    }
                                    i = R.id.tvRightCellDesc;
                                } else {
                                    i = R.id.tvLeftCellTitle;
                                }
                            } else {
                                i = R.id.tvLeftCellDesc;
                            }
                        } else {
                            i = R.id.sectionDivider;
                        }
                    } else {
                        i = R.id.rlSectionCell;
                    }
                } else {
                    i = R.id.imgRightCell;
                }
            } else {
                i = R.id.clRightCell;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
