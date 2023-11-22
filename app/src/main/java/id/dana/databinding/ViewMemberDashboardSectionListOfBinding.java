package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewMemberDashboardSectionListOfBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView scheduleImpl;

    private ViewMemberDashboardSectionListOfBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.scheduleImpl = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static ViewMemberDashboardSectionListOfBinding getAuthRequestContext(View view) {
        int i = R.id.clLeftCell;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clLeftCell);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clRightCell);
            if (constraintLayout2 != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.imgRightCell);
                if (appCompatImageView != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llSectionCell);
                    if (linearLayout != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvFamilyName);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvLeftTitle);
                            if (textView2 != null) {
                                return new ViewMemberDashboardSectionListOfBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, appCompatImageView, linearLayout, textView, textView2);
                            }
                            i = R.id.tvLeftTitle;
                        } else {
                            i = R.id.tvFamilyName;
                        }
                    } else {
                        i = R.id.llSectionCell;
                    }
                } else {
                    i = R.id.imgRightCell;
                }
            } else {
                i = R.id.clRightCell;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
