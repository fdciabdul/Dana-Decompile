package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewTopUpAndPayMethodBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final AppCompatTextView moveToNextValue;

    private ViewTopUpAndPayMethodBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.getErrorConfigVersion = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.getAuthRequestContext = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
    }

    public static ViewTopUpAndPayMethodBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_top_up_and_pay_method, (ViewGroup) null, false);
        int i = R.id.ivExpand;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivExpand);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.otherMethodContainer);
            if (constraintLayout != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvTopUpAndPayMethod);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOtherMethodDescription);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvOtherMethodTitle);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTopUpAndPayMethodTitle);
                            if (appCompatTextView3 != null) {
                                return new ViewTopUpAndPayMethodBinding((ConstraintLayout) inflate, appCompatImageView, constraintLayout, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                            }
                            i = R.id.tvTopUpAndPayMethodTitle;
                        } else {
                            i = R.id.tvOtherMethodTitle;
                        }
                    } else {
                        i = R.id.tvOtherMethodDescription;
                    }
                } else {
                    i = R.id.rvTopUpAndPayMethod;
                }
            } else {
                i = R.id.otherMethodContainer;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
