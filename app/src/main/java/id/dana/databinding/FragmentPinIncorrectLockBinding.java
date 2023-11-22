package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class FragmentPinIncorrectLockBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView scheduleImpl;

    private FragmentPinIncorrectLockBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, LayoutToolbarBinding layoutToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.lookAheadTest = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
    }

    public static FragmentPinIncorrectLockBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pin_incorrect_lock, viewGroup, false);
        int i = R.id.btn_confirm;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_confirm);
        if (danaButtonSecondaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_info_wrapper);
            if (constraintLayout != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_hourglass_illustration);
                if (appCompatImageView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_desc);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                            if (appCompatTextView2 != null) {
                                return new FragmentPinIncorrectLockBinding((ConstraintLayout) inflate, danaButtonSecondaryView, constraintLayout, appCompatImageView, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.tv_desc;
                        }
                    } else {
                        i = R.id.SecurityGuardProfileProvider;
                    }
                } else {
                    i = R.id.iv_hourglass_illustration;
                }
            } else {
                i = R.id.cl_info_wrapper;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
