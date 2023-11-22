package id.dana.databinding;

import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierAddNewCardBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final RadioButton getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;

    private ItemCashierAddNewCardBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RadioButton radioButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = radioButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static ItemCashierAddNewCardBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivIconAsset;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconAsset);
        if (appCompatImageView != null) {
            RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rgPaymentMethod);
            if (radioButton != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountSource);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                    if (appCompatTextView2 != null) {
                        return new ItemCashierAddNewCardBinding(constraintLayout, constraintLayout, appCompatImageView, radioButton, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tvTitle;
                } else {
                    i = R.id.tvAccountSource;
                }
            } else {
                i = R.id.rgPaymentMethod;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
