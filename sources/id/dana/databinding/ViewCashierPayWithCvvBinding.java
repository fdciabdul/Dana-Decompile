package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierPayWithCvvBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatEditText PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ViewCashierPayWithCvvBinding(ConstraintLayout constraintLayout, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, FrameLayout frameLayout, AppCompatTextView appCompatTextView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = appCompatEditText;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
    }

    public static ViewCashierPayWithCvvBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_cashier_pay_with_cvv, (ViewGroup) null, false);
        int i = R.id.etCvvInput;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etCvvInput);
        if (appCompatEditText != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivCvvInfo);
            if (appCompatImageView != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llInputCard);
                if (frameLayout != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                    if (appCompatTextView != null) {
                        return new ViewCashierPayWithCvvBinding((ConstraintLayout) inflate, appCompatEditText, appCompatImageView, frameLayout, appCompatTextView);
                    }
                    i = R.id.tvTitle;
                } else {
                    i = R.id.llInputCard;
                }
            } else {
                i = R.id.ivCvvInfo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
